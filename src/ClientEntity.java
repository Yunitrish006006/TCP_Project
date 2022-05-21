import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

public class ClientEntity {
    private List<String> message_db;
    private int port;
    private InetAddress ipAddress;
    private String operation = "none";
    private String record_name = "none";

    public ClientEntity(List<String> message_db, int port, InetAddress addr) {
        this.message_db = message_db;
        this.port = port;
        this.ipAddress = addr;
    }

    public void taskManager() {
        switch (operation) {
            case "clear" -> {
                message_db.clear();
            }
            case "delete" -> {
                for(int i=0;i<message_db.size();i++) {
                    if(message_db.get(i).equalsIgnoreCase(record_name)) message_db.remove(i);
                }
            }
            default -> {

            }
        }
    }

    public void receiveMSG () {
        Socket socket = new Socket();

    }
}
