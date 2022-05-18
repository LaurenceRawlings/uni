package controller;

import core.ImageProcessor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.CTData;

import java.io.File;

/**
 * FXML controller for the main window view.
 *
 * @author Laurence Rawlings (991368)
 * Declaration: I declare that this is my own code.
 */
public class MainController {
    private char axis;
    private boolean mip;
    private boolean he;
    private CTData data;
    private Stage stage;
    private WritableImage originalImage;
    @FXML
    private Slider sldr_value;
    @FXML
    private Slider sldr_zoom;
    @FXML
    private ImageView img_ct;
    @FXML
    private Label lbl_max;
    @FXML
    private Label lbl_value;
    @FXML
    private Label lbl_view;
    @FXML
    private TextField txt_file;
    @FXML
    private TextField txt_width;
    @FXML
    private TextField txt_height;
    @FXML
    private TextField txt_depth;
    @FXML
    private VBox box_view;
    @FXML
    private VBox box_image;
    @FXML
    private VBox box_scale;
    @FXML
    private VBox box_slice;
    @FXML
    private HBox box_thumbs;
    @FXML
    private ScrollPane scroll_thumbs;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        axis = 'x';
        mip = false;
        he = false;
    }

    public void onLoad() {
        sldr_value.valueProperty().addListener(
                (observable, oldValue, newValue) -> updateSlice(
                        newValue.intValue()));
        sldr_zoom.valueProperty().addListener((observable, oldValue,
                                               newValue) -> img_ct
                .setImage(zoom(originalImage, newValue.doubleValue())));

        toggleControls();

        txt_width.textProperty().addListener(
                (observable, oldValue, newValue) -> checkDigit(txt_width,
                        newValue));

        txt_height.textProperty().addListener(
                (observable, oldValue, newValue) -> checkDigit(txt_height,
                        newValue));

        txt_depth.textProperty().addListener(
                (observable, oldValue, newValue) -> checkDigit(txt_depth,
                        newValue));
    }

    private void checkDigit(TextField text, String newValue) {
        if (!newValue.matches("\\d*")) {
            text.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }

    @FXML
    void btnX(ActionEvent event) {
        axis = 'x';
        axisChange();
    }

    @FXML
    void btnY(ActionEvent event) {
        axis = 'y';
        axisChange();
    }

    @FXML
    void btnZ(ActionEvent event) {
        axis = 'z';
        axisChange();
    }

    @FXML
    void btnMip(ActionEvent event) {
        mip = !mip;
        axisChange();
        sldr_value.setDisable(mip);
        scroll_thumbs.setMouseTransparent(mip);
    }

    @FXML
    void btnHe(ActionEvent event) {
        he = !he;
        axisChange();
    }

    @FXML
    void btnOpen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open CT Data");
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            txt_file.setText(file.toString());
        }
    }

    @FXML
    void btnView(ActionEvent event) {
        try {
            data = new CTData(new File(txt_file.getText()),
                    Integer.parseInt(txt_width.getText()),
                    Integer.parseInt(txt_height.getText()),
                    Integer.parseInt(txt_depth.getText()));

            initialize();
            axisChange();
            toggleControls();
        } catch (NumberFormatException e) {
            MessageController.showMessage("Warning!", "Empty Dimension Values",
                    "Please fill all values for width, height and depth and " +
                            "try again.");
        }
    }

    private void updateSlice(int value) {
        WritableImage image = data.drawSlice(value, axis, he);
        originalImage = image;
        img_ct.setImage(zoom(originalImage, sldr_zoom.getValue()));
        lbl_value.setText(Integer.toString(value));
    }

    private void updateThumbs() {
        box_thumbs.getChildren().clear();
        int slices;

        switch (axis) {
            case 'x':
                slices = data.getX();
                break;
            case 'y':
                slices = data.getY();
                break;
            default:
                slices = data.getZ();
                break;
        }

        for (int i = 0; i < slices; i++) {
            ImageView view = new ImageView();
            int slice = i;
            view.setOnMouseClicked((mouseEvent) -> sldr_value.setValue(slice));
            view.setImage(
                    zoom(data.drawSlice(i, axis, he), 0.2));
            box_thumbs.getChildren().add(view);
        }
    }

    private WritableImage zoom(WritableImage originalImage, double scale) {
        double width = originalImage.getWidth();
        double height = originalImage.getRequestedHeight();
        double xScale = 1;
        double yScale = 1;

        if (width != height) {
            if (width > height) {
                yScale = width / height;
            } else {
                xScale = height / width;
            }
        }

        return ImageProcessor.resize(originalImage, xScale * scale,
                yScale * scale);
    }

    private void axisChange() {
        int x = data.getX() - 1;
        int y = data.getY() - 1;
        int z = data.getZ() - 1;

        updateSlice(0);
        sldr_value.setValue(0);

        switch (axis) {
            case 'x':
                sldr_value.setMax(x);
                lbl_max.setText(Integer.toString(x));
                lbl_view.setText("Side View");
                break;
            case 'y':
                sldr_value.setMax(y);
                lbl_max.setText(Integer.toString(y));
                lbl_view.setText("Front View");
                break;
            default:
                sldr_value.setMax(z);
                lbl_max.setText(Integer.toString(z));
                lbl_view.setText("Top View");
                break;
        }

        if (mip) {
            WritableImage image = data.drawMip(axis, he);
            originalImage = image;
            img_ct.setImage(zoom(originalImage, sldr_zoom.getValue()));
        } else {
            updateThumbs();
        }
    }

    private void toggleControls() {
        box_image.setVisible(!box_image.isVisible());
        box_scale.setVisible(!box_scale.isVisible());
        box_slice.setVisible(!box_slice.isVisible());
        box_view.setVisible(!box_view.isVisible());
    }
}
