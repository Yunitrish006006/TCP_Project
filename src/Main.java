import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {
    public static void style(JTextPane jTextPane){//设置jTextPane的字体样式

        SimpleAttributeSet aSet = new SimpleAttributeSet();
        StyleConstants.setForeground(aSet, Color.DARK_GRAY);
        StyleConstants.setBackground(aSet, Color.lightGray);
        StyleConstants.setFontFamily(aSet, "lucida bright italic");//zi
        StyleConstants.setFontSize(aSet, 20);
        StyleConstants.setAlignment(aSet, StyleConstants.ALIGN_LEFT);

        StyledDocument doc = jTextPane.getStyledDocument();
        doc.setCharacterAttributes(105, doc.getLength()-105, aSet, false);
        doc.setParagraphAttributes(0, 104, aSet, false);
    }
    public static void main(String[] args) throws IOException {
        ServerEntity serverEntity = new ServerEntity(5500);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            serverEntity.send(scanner.next());
        }
//        window window = new window("JTextPane");
//        Container container = window.getContentPane();
//        JTextPane jTextPane = new JTextPane();
//        jTextPane.setAutoscrolls(true);
//        jTextPane.setSize(window.getSize());
//        jTextPane.setLocation(window.getLocation());
//        style(jTextPane);
//        container.add(jTextPane);
    }
}