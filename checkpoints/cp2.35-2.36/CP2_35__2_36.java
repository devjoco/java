import javax.swing.JOptionPane;

public class CP2_35__2_36 {
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
