import javax.swing.text.Document;
import java.io.IOException;
import java.util.Arrays;

public class ThreadServer extends java.lang.Thread {
    boolean started = false;
    boolean send = false;
    MessageGUI messageGUI;
    public void run() {
        if(!started) {
            messageGUI = new MessageGUI("Messenger");
            try {
                messageGUI.setUpUI();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            started = true;
        }
        else {
            if(messageGUI.is_send) {
                try {
                    messageGUI.server.send(messageGUI.type.getDocument().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                messageGUI.UpToWindow(messageGUI.type.getDocument(),messageGUI.content.getDocument());
                try {
                    messageGUI.server.send(messageGUI.type.getDocument().toString());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                messageGUI.type.setText("");
            }
            ClientEntity client = new ClientEntity(5555,"127.0.0.1");
            try {
                byte[] x = client.receive().getBytes();
                String p = Arrays.toString(x);
//                MessageGUI.UpToWindow((Document) (p),messageGUI.content.getDocument());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
