import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class MessageGUI extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public MessageGUI(String Title) {
        super.setLocation(0,0);
        super.setVisible(true);
        super.setResizable(false);
        super.setTitle(Title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void myStyle(JTextPane jTextPane) throws BadLocationException {
        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setForeground(aSet, Color.DARK_GRAY);
        StyleConstants.setBackground(aSet, Color.RED);
        StyleConstants.setFontFamily(aSet, "lucida bright italic");
        StyleConstants.setFontSize(aSet, 20);
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_LEFT);
        jTextPane.setCharacterAttributes(aSet,true);
    }
    public void theirStyle(JTextPane jTextPane) throws BadLocationException {
        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setForeground(aSet, Color.DARK_GRAY);
        StyleConstants.setBackground(aSet, Color.RED);
        StyleConstants.setFontFamily(aSet, "lucida bright italic");
        StyleConstants.setFontSize(aSet, 20);
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_LEFT);
        jTextPane.setCharacterAttributes(aSet,true);
    }


    private JTextArea ta;
    private JFileChooser jfc = new JFileChooser(new File("."));
    private JButton bOpen;
    public void fileGetter() {
        ta = new JTextArea(10, 20);
        bOpen = new JButton("選擇檔案");
        bOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //開啟檔案選擇器對話方塊
                int status = jfc.showOpenDialog(bOpen);
                //沒有選開啟按鈕結果提示
                if (status != JFileChooser.APPROVE_OPTION) {
                    ta.setText("沒有選中檔案");
                } else {
                    try { //被選中的檔案儲存為檔案物件
                        File file = jfc.getSelectedFile();
                        Scanner scanner = new Scanner(file);
                        String info = "";
                        while (scanner.hasNextLine()) {
                            String str = scanner.nextLine();
                            info += str + "/r/n";
                        }
                        //把讀取的資料存到文字框中
                        ta.setText(info);
                    } catch (FileNotFoundException e1) {
                        System.out.println("系統沒有找到此檔案");
                        e1.printStackTrace();
                    }
                }
            }
        });
        this.add(bOpen);
        this.setTitle("檔案選擇器的使用");
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void setMessageGUI() {
        Container container = super.getContentPane();
        container.setLayout(null);

        JTextPane content = new JTextPane();
        content.setBounds(10, 69, 325, 242);
        content.setEditable(false);
        container.add(content);

        JTextPane type = new JTextPane();
        type.setBounds(10, 354, 325, 101);
        container.add(type);

        JButton selectImage = new JButton("圖片");
        selectImage.setBounds(10, 321, 85, 23);
        container.add(selectImage);

        JButton send = new JButton("傳送");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                content.setText(content.getText()+type.getText()+"\r\n");
                type.setText("");
            }
        });
        send.setBounds(120, 321, 85, 23);
        container.add(send);

        JButton Exit = new JButton("結束");
        Exit.setBounds(229, 321, 85, 23);
        container.add(Exit);

        JLabel IPLabel = new JLabel("IP");
        IPLabel.setBounds(10, 32, 85, 15);
        container.add(IPLabel);

        JLabel PortLabel = new JLabel("Port");
        PortLabel.setBounds(181, 32, 85, 15);
        container.add(PortLabel);

        JTextField IPText = new JTextField();
        IPText.setBounds(62, 29, 112, 21);
        getContentPane().add(IPText);
        IPText.setColumns(10);

        JTextField PortText = new JTextField();
        PortText.setColumns(10);
        PortText.setBounds(239, 29, 96, 21);
        getContentPane().add(PortText);
        super.setContentPane(container);
        super.setSize(360,506);
    }
}
