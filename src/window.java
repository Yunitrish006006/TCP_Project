import javax.swing.*;
import java.awt.*;

public class window extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public window(String Title) {
        super.setSize(screenSize.width/3, screenSize.height/5*3);
        super.setLocation(screenSize.width/6,screenSize.height/5);
        super.setVisible(true);
        super.setTitle(Title);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
