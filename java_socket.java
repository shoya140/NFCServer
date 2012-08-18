import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;

public class JavaSocket {
 
    static final int PORT = 10000;
 
    public static void main(String[] args) {
 
        ServerSocket serverSocket = null;
 
        try {
            serverSocket = new ServerSocket(PORT);
            boolean runFlag = true;
            while(runFlag){
                Socket socket = serverSocket.accept();
                BufferedReader br =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                String str;
                while( (str = br.readLine()) != null ){
                    System.out.println(str);
                    Desktop desktop = Desktop.getDesktop();
            		String uriString = str;
            		try {
            			URI uri = new URI(uriString);
            			desktop.browse(uri);
            		} catch (URISyntaxException e) {
            			e.printStackTrace();
            		} catch (IOException e) {
            			e.printStackTrace();
            		}
                }
                if( socket != null){
                    socket.close();
                    socket = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if( serverSocket != null){
            try {
                serverSocket.close();
                serverSocket = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
