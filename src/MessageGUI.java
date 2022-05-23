import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class MessageGUI extends JFrame{
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private final JFileChooser jFileChooser = new JFileChooser(new File("."));
    public JFrame gui = this;
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
        selectImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //開啟檔案選擇器對話方塊
                int status = jFileChooser.showOpenDialog(selectImage);
                //沒有選開啟按鈕結果提示
                if (status != JFileChooser.APPROVE_OPTION) {
                    //#沒有選中檔案
                } else {
                    try { //被選中的檔案儲存為檔案物件
                        File file = jFileChooser.getSelectedFile();
                        ImageIcon imageIcon = new ImageIcon ( file.getCanonicalPath() );
                        Image image = imageIcon.getImage();
                        //縮小圖片 法一
                        Image resized_image = image.getScaledInstance(100,100,Image.SCALE_SMOOTH);
                        //縮小圖片 法二
//                        BufferedImage bi = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
//                        Graphics g = bi.createGraphics();
//                        g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
                        //bi 為最終結果
                        //
                        type.insertIcon(new ImageIcon(resized_image));
                    } catch (FileNotFoundException e1) {
//                        System.out.println("系統沒有找到此檔案");
                        e1.printStackTrace();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        container.add(selectImage);

        JButton send = new JButton("傳送");
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StyledDocument doc = type.getStyledDocument();
                content.setStyledDocument(doc);
//                content.setText(content.getText()+type.getText()+"\r\n");
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
