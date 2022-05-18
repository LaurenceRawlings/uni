import javax.swing.*;
import java.awt.BorderLayout;

import static java.lang.Float.parseFloat;

public class Task1 {



    final float G2L = 4.546f;

    float price, serviceCost, serviceInterval, mpg, fuelCost, mileage;
    float runningCost;
    boolean btnMessage = true;

    public static void main(String[] args){
        new Task1();
    }

    void Calculate(){
        runningCost = price + (mileage/serviceInterval)*(serviceCost) + (mileage/mpg)*(fuelCost/G2L);
    }



    public Task1()
    {
        JFrame guiFrame = new JFrame();

        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Car Cost Calculator");
        guiFrame.setSize(300,400);
        guiFrame.setLocationRelativeTo(null);

        final JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        JLabel lbl1 = new JLabel("Cost to Buy:");
        JTextField txtPrice = new JTextField();

        JLabel lbl2 = new JLabel("Cost to Service:");
        JTextField txtServiceCost = new JTextField();

        JLabel lbl3 = new JLabel("Service Interval:");
        JTextField txtServiceInterval = new JTextField();

        JLabel lbl4 = new JLabel("MPG:");
        JTextField txtMpg = new JTextField();

        JLabel lbl5 = new JLabel("Fuel Cost:");
        JTextField txtFuelCost = new JTextField();

        JLabel lbl6 = new JLabel("Yearly Mileage:");
        JTextField txtMileage = new JTextField();

        inputPanel.add(lbl1);
        inputPanel.add(txtPrice);
        inputPanel.add(lbl2);
        inputPanel.add(txtServiceCost);
        inputPanel.add(lbl3);
        inputPanel.add(txtServiceInterval);
        inputPanel.add(lbl4);
        inputPanel.add(txtMpg);
        inputPanel.add(lbl5);
        inputPanel.add(txtFuelCost);
        inputPanel.add(lbl6);
        inputPanel.add(txtMileage);




        final JPanel outputPanel = new JPanel();
        outputPanel.setVisible(false);
        JLabel lbl7 = new JLabel("Here's how much your car will cost per year:");

        JLabel lbl8 = new JLabel(Float.toString(runningCost));

        outputPanel.add(lbl7);
        outputPanel.add(lbl8);


        JButton btnCalculate = new JButton( "Calculate!");

        btnCalculate.addActionListener(event -> {
            outputPanel.setVisible(!outputPanel.isVisible());
            inputPanel.setVisible(!inputPanel.isVisible());
            btnMessage = !btnMessage;

            if(btnMessage){
                btnCalculate.setText("Calculate!");
            } else {
                btnCalculate.setText("Back");
            }

            price = parseFloat(txtPrice.getText());
            serviceCost = parseFloat(txtServiceCost.getText());
            serviceInterval = parseFloat(txtServiceInterval.getText());
            mpg = parseFloat(txtMpg.getText());
            mileage = parseFloat(txtMileage.getText());
            fuelCost = parseFloat(txtFuelCost.getText());

            Calculate();
            lbl8.setText("£" + String.format("%.2f", runningCost) );
        });

        guiFrame.add(inputPanel, BorderLayout.NORTH);
        guiFrame.add(outputPanel, BorderLayout.CENTER);
        guiFrame.add(btnCalculate,BorderLayout.SOUTH);

        guiFrame.setVisible(true);
    }
}