import javax.swing.*;

public class Assessed {
    public static void main(String[] args){
        String name = JOptionPane.showInputDialog("What is your name?");
        JOptionPane.showMessageDialog(null, name, "I'm saying Hello...", JOptionPane.INFORMATION_MESSAGE);
    }
}
