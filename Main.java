// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Main extends javax.swing.JFrame {
// Light shade as a background color 

// Window has 4 radio buttons (+, -, *, /)
    private JRadioButton jRadioButtonPlus;
    private JRadioButton jRadioButtonSub;
    private JRadioButton jRadioButtonMulti;
    private JRadioButton jRadioButtonDiv;
    private JButton jButton1;
    private ButtonGroup buttonGroup;
    private JTextField field1, field2, field3;
    int a, b, c;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Main inst = new Main();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public Main(){
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(null);
            // Add field 1 to the window
            JTextField field1 = new JTextField();
            field1.setBounds(25, 60, 25, 30);
            add(field1);
            // Add field 2 to the window
            JTextField field2 = new JTextField();
            field2.setBounds(140, 60, 25, 30);
            add(field2);
            // Add = sign label to the window
            JLabel equalsign = new JLabel("=");
            equalsign.setBounds(200, 60, 30, 30);
            add(equalsign);
            // Add field 3
            JTextField field3 = new JTextField();
            field3.setBounds (260, 60, 25, 30);
            add(field3);

            // Create the radio buttons
            {
                jRadioButtonPlus = new JRadioButton();
                getContentPane().add(jRadioButtonPlus);
                jRadioButtonPlus.setText("+");
                // x, y, width, height
                jRadioButtonPlus.setBounds(80, 26, 135, 20);
                getButtonGroup().add(jRadioButtonPlus);
                jRadioButtonPlus.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonPlusActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonSub = new JRadioButton();
                getContentPane().add(jRadioButtonSub);
                jRadioButtonSub.setText("-");
                jRadioButtonSub.setBounds(80, 61, 135, 20);
                getButtonGroup().add(jRadioButtonSub);
                jRadioButtonSub.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonSubActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonMulti = new JRadioButton();
                getContentPane().add(jRadioButtonMulti);
                jRadioButtonMulti.setText("*");
                jRadioButtonMulti.setBounds(80, 96, 135, 20);
                getButtonGroup().add(jRadioButtonMulti);
                jRadioButtonMulti.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonMultiActionPerformed(evt);
                    }
                });
            }
            {
                jRadioButtonDiv = new JRadioButton();
                getContentPane().add(jRadioButtonDiv);
                jRadioButtonDiv.setText("/");
                jRadioButtonDiv.setBounds(80, 131, 144, 20);
                getButtonGroup().add(jRadioButtonDiv);
                jRadioButtonDiv.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        jRadioButtonDivActionPerformed(evt);
                    }
                });
            }
            {
                jButton1 = new JButton();
                getContentPane().add(jButton1);
                jButton1.setText("Click on a Radio Button");
                jButton1.setBounds(80, 260, 173, 23);
                jButton1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent evt) {
                        // jButton1ActionPerformed(evt);
                    }
                });
                jButton1.addAncestorListener(new AncestorListener()
                {
                    public void ancestorMoved(AncestorEvent evt) {
                        System.out.println("jButton1.ancestorMoved, event="+evt);
                    }
                    public void ancestorAdded(AncestorEvent evt) {
                        // jButton1AncestorAdded(evt);
                    }
                    public void ancestorRemoved(AncestorEvent evt) {
                        System.out.println("jButton1.ancestorRemoved, event="+evt);
                    }
                });
            }

                pack();
                setSize(400,300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ButtonGroup getButtonGroup() {
        if(buttonGroup == null) {
            buttonGroup = new ButtonGroup();
        }
        return buttonGroup;
    }

    private void jRadioButtonPlusActionPerformed(ActionEvent evt) {
        try{
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            if(jRadioButtonPlus.isSelected()){
                c = a + b;
                field3.setText(String.valueOf(c));
            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Addition has been completed"+evt);
    }

    private void jRadioButtonSubActionPerformed(ActionEvent evt) {
        try{
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            if(jRadioButtonSub.isSelected()){
                c = a - b;
                field3.setText(String.valueOf(c));
            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Subtraction has been completed"+evt);
    }

    private void jRadioButtonMultiActionPerformed(ActionEvent evt) {
        try{
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            if (jRadioButtonMulti.isSelected()){
                c = a * b;
                field3.setText(String.valueOf(c));
            }
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Multiplication has been completed"+evt);
    }

    private void jRadioButtonDivActionPerformed(ActionEvent evt) {
        try{
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            if (jRadioButtonDiv.isSelected()){
                c = a / b;
                field3.setText(String.valueOf(c));
            }
        } catch (ArithmeticException e) {
            System.out.println("You can not divide by 0.");
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Division has been completed."+evt);
    }
}

// Result appears in the 3rd text field 
// Result should be usually non-integer + handled correctly
// Try catch block for the following
// Non integer inputs in one or both text fields
// No input in one or both text fields
// Division by zero 


// Notes convert both text fields to integer (integer class)
// Your program must issue an error message by a dialog box
