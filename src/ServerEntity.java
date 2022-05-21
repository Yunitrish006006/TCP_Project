import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

//sender
public class ServerEntity {

    public int port;
    public ServerEntity(int port) {
        this.port = port;
    }

    public void send(String msg) throws IOException {
        System.out.println("To Send : ");
        ServerSocket ss = new ServerSocket(port);     // 建立 TCP 伺服器。
        while (true){                                // 不斷的接收處理輸入訊息。
            Socket sc = ss.accept();                // 接收輸入訊息。當有人要跟你建立socket,就有accept動作
            OutputStream os = sc.getOutputStream();    // 取得輸出串流。
            os.write(msg.getBytes(StandardCharsets.UTF_8));// 送訊息到 Client 端。
            System.out.printf("你輸入的是:" + msg);          // 標準輸出
            os.close();                                // 關閉輸出串流。
            sc.close();                                // 關閉 TCP 伺服器。
        }
    }
}
