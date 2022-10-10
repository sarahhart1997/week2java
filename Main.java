// Imports
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
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
// Design a window interface
// Light shade as a background color 

// Window has 4 radio buttons (+, -, *, /)
    private JRadioButton jRadioButtonPlus;
    private JRadioButton jRadioButtonSub;
    private JRadioButton jRadioButtonMulti;
    private JRadioButton jRadioButtonDiv;
    private JButton jButton1;
    private ButtonGroup buttonGroup;

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
            JTextField field1 = new JTextField();
            field1.setBounds(10, 60, 25, 21);
            add(field1);

            // Window has 3 text fields
    JTextField field2 = new JTextField();
    JTextField field3 = new JTextField();

    // When mouse clicks after text field immediately convert from string to Int.
    // public void field1MouseClicked(java.awt.event.MouseEvent evt) {
    //    String text = field1.getText();
    //    int a = Integer.parseInt(text);
    // }

    // private void field2MouseClicked(java.awt.event.MouseEvent evt) {
    //     String text = field2.getText();
    //     int b = Integer.parseInt(text);
    // }

            {
                jRadioButtonPlus = new JRadioButton();
                getContentPane().add(jRadioButtonPlus);
                jRadioButtonPlus.setText("+");
                // x, y, weight, height
                jRadioButtonPlus.setBounds(60, 26, 135, 20);
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
                jRadioButtonSub.setBounds(60, 61, 135, 20);
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
                jRadioButtonMulti.setBounds(60, 96, 135, 20);
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
                jRadioButtonDiv.setBounds(60, 131, 144, 20);
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
                jButton1.setBounds(60, 260, 173, 23);
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
            // Error handling here
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
        Scanner key = new Scanner(System.in);
        try{
            int a = key.nextInt();
            int b = key.nextInt();
            System.out.println(a + "+" + b + "=" + (a+b));
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Addition has been completed"+evt);
    }

    private void jRadioButtonSubActionPerformed(ActionEvent evt) {
        Scanner key = new Scanner(System.in);
        try{
            int a = key.nextInt();
            int b = key.nextInt();
            System.out.println(a + "-" + b + "=" + (a-b));
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Subtraction has been completed"+evt);
    }

    private void jRadioButtonMultiActionPerformed(ActionEvent evt) {
        Scanner key = new Scanner(System.in);
        try{
            int a = key.nextInt();
            int b = key.nextInt();
            System.out.println(a + "*" + b + "=" + (a*b));
        } catch (InputMismatchException e) {
            System.out.println("You must enter two numbers.");
        }
        System.out.println("Multiplication has been completed"+evt);
    }

    private void jRadioButtonDivActionPerformed(ActionEvent evt) {
        Scanner key = new Scanner(System.in);
        try{
            int a = key.nextInt();
            int b = key.nextInt();
            System.out.println(a + "/" + b + "=" + (a/b));
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
