import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class MessageGUI extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public MessageGUI(String Title) {
        super.setLocation(0,0);
        super.setVisible(true);
        super.setResizable(false);
        super.setTitle(Title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void style(JTextPane jTextPane) throws BadLocationException {
        //文字的style
        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setForeground(aSet, Color.DARK_GRAY);
        StyleConstants.setBackground(aSet, Color.RED);
        StyleConstants.setFontFamily(aSet, "lucida bright italic");
        StyleConstants.setFontSize(aSet, 20);
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_LEFT);
        jTextPane.setCharacterAttributes(aSet,true);
    }

    public void setMessageGUI() {
        Container container = super.getContentPane();
        container.setLayout(null);

        JTextPane textPane = new JTextPane();
        textPane.setBounds(10, 69, 325, 242);
        container.add(textPane);

        JButton btnNewButton = new JButton("圖片");
        btnNewButton.setBounds(10, 321, 85, 23);
        container.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("傳送");
        btnNewButton_1.setBounds(120, 321, 85, 23);
        container.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("結束");
        btnNewButton_2.setBounds(229, 321, 85, 23);
        container.add(btnNewButton_2);

        JTextPane textPane_2 = new JTextPane();
        textPane_2.setBounds(10, 354, 325, 101);
        container.add(textPane_2);

        JLabel lblNewLabel_1 = new JLabel("IP");
        lblNewLabel_1.setBounds(10, 32, 85, 15);
        container.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Port");
        lblNewLabel_2.setBounds(181, 32, 85, 15);
        container.add(lblNewLabel_2);

        JTextField textField = new JTextField();
        textField.setBounds(62, 29, 112, 21);
        getContentPane().add(textField);
        textField.setColumns(10);

        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(239, 29, 96, 21);
        getContentPane().add(textField_1);
        super.setContentPane(container);
        super.setSize(360,506);
    }
}
