import java.io.IOException;
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

    public ClientEntity(int port, InetAddress addr) {
        this.port = port;
        this.ipAddress = addr;
    }

    public String receive() throws IOException {
        System.out.println("[Client start]");
        Socket client = new Socket("localhost", port);     // 根據 args[0] 的 TCP Socket.
        InputStream in = client.getInputStream();      // 取得輸入訊息的串流
        StringBuffer buf = new StringBuffer();        // 建立讀取字串。
        try {
            while (true) {            // 不斷讀取。
                int x = in.read();    // 讀取一個 byte。(read 傳回 -1 代表串流結束)
                if (x==-1) break;    // x = -1 代表串流結束，讀取完畢，用 break 跳開。
                byte b = (byte) x;    // 將 x 轉為 byte，放入變數 b.
                buf.append((char) b);// 假設傳送ASCII字元都是 ASCII。
            }
        } catch (Exception e) {
            in.close();                // 關閉輸入串流。
        }               // 印出接收到的訊息。
        client.close();
        return buf.toString();
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
