// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends javax.swing.JFrame implements ActionListener {

// Window has 4 radio buttons (+, -, *, /)
    private JRadioButton jRadioButtonPlus, jRadioButtonSub, jRadioButtonMulti, jRadioButtonDiv;
    private ButtonGroup buttonGroup;
    private JTextField field1, field2, field3;
    JLabel equalsign;
    int a, b, c;

    public static void main(String[] args) {
        Main inst = new Main();
        inst.initGUI();
            }
    
    // UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

    public void initGUI() {
        setSize(400,300);
        Container calc = getContentPane();
        calc.setLayout(null);

        // Creating text fields + Equals sign Label
        field1 = new JTextField();
        field1.setBounds(30, 75, 70, 25);

        field2 = new JTextField();
        field2.setBounds(140, 75, 70, 25);

        equalsign = new JLabel("=");
        equalsign.setBounds(220, 75, 70, 25);

        field3 = new JTextField();
        field3.setBounds(240, 75, 70, 25);

        calc.add(field1);
        calc.add(field2);
        calc.add(equalsign);
        calc.add(field3);

        // Create Radio Buttons
        jRadioButtonPlus = new JRadioButton("+");
        jRadioButtonPlus.setBounds(100, 35, 35, 50);
        calc.add(jRadioButtonPlus);

        jRadioButtonSub = new JRadioButton("-");
        jRadioButtonSub.setBounds(100, 65, 35, 50);
        calc.add(jRadioButtonSub);

        jRadioButtonMulti = new JRadioButton("*");
        jRadioButtonMulti.setBounds(100, 95, 35, 50);
        calc.add(jRadioButtonMulti);

        jRadioButtonDiv = new JRadioButton("/");
        jRadioButtonDiv.setBounds(100, 125, 35, 50);
        calc.add(jRadioButtonDiv);

        jRadioButtonPlus.addActionListener(this);
        jRadioButtonSub.addActionListener(this);
        jRadioButtonMulti.addActionListener(this);
        jRadioButtonDiv.addActionListener(this);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonPlus);
        buttonGroup.add(jRadioButtonSub);
        buttonGroup.add(jRadioButtonMulti);
        buttonGroup.add(jRadioButtonDiv);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            a = Integer.parseInt(field1.getText());
            b = Integer.parseInt(field2.getText());
            if (jRadioButtonPlus.isSelected()) {
                c = a + b;
                field3.setText(String.valueOf(c));
            }
            else if (jRadioButtonSub.isSelected()) {
                c = a - b;
                field3.setText(String.valueOf(c));
            }
            else if (jRadioButtonMulti.isSelected()) {
                c = a * b;
                field3.setText(String.valueOf(c));
            }
            else if (jRadioButtonDiv.isSelected()) {
                if (b==0) {
                    JOptionPane.showMessageDialog(null, "Sorry, unfortunately you can not divide by 0!");
                }
                else {
                    float divc = ((float)a/b);
                    field3.setText(String.valueOf(divc));
                }
            }
        }

        catch (IllegalArgumentException exception) {
            JOptionPane.showMessageDialog(null, "You must enter 2 numbers to run the program.");
        }
    }
}