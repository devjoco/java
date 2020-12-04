import javax.swing.JOptionPane;

/**
 * Checkpoints 2.35 & 2.26
 *
 * Practice with JOptionPane class
 *
 * Deals with showMessageDialog and showInputDialog as well as converting 
 * String type input into integers.
 */
public class Dialogs {
    /**
     * This is the main function, which will actually run the dialog boxes
     */
    public static void main(String[] args){
        JOptionPane.showMessageDialog(null, "Greetings Earthling.");
        int num = Integer.parseInt(
                JOptionPane.showInputDialog("Enter a number.")
                );
        System.out.println("You entered " + num + "!");

        int age = Integer.parseInt(
                JOptionPane.showInputDialog("Enter your age!")
                );
        System.out.println("Damn, you old af at "+ age +" years old.");
    }
}
