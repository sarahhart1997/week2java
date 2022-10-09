// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.Jbutton;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.SwingUtilities; 

// Design a window interface
// Light shade as a background color 

// Window has 3 text fields

// Window has 4 radio buttons (+, -, *, /)
public class RadioButtons extends javax.swing.JFrame {
    private JRadioButton jRadioButtonPlus;
    private JRadioButton jRadioButtonSub;
    private JRadioButton jRadioButtonMulti;
    private JRadioButton jRadioButtonDiv;
    private JButton jButtonPlus;
    private JButton jButtonSub;
    private JButton jButtonMulti;
    private JButton jButtonDiv;
    private ButtonGroup buttonGroup;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RadioButtons inst = new RadioButtons();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public RadioButtons(){
        super();
        initGUI();
    }

    
}
// A label for the equality sign

// User enters 2 integers in the text fields

// Click on any of the radio buttons

// Result appears in the 3rd text field 
// Result should be usually non-integer + handled correctly
// Try catch block for the following
// Non integer inputs in one or both text fields
// No input in one or both text fields
// Division by zerio 


// Notes convert both text fields to integer (integer class)
// Your program must issue an error message by a dialog box
