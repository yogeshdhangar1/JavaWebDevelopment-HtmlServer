package JavaWebApp;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
public class SimpleHttpServer {
    public static int DEFAULT_PORT = 8082;
    public static int port;
    private HttpServer httpServer;
     private void start(int port){
         try{
             httpServer = HttpServer.create(new InetSocketAddress(port),0);
             System.out.println("Server Started :"+port);
             httpServer.createContext("/", new Handlers.RootHandler());
             httpServer.createContext("/echoHeader",new Handlers.EchoHeaderHandler());
             httpServer.createContext("/echoHeader",new Handlers.EchoGetHandler());
             httpServer.createContext("/echoHeader",new Handlers.EchoPostHandler());
             httpServer.setExecutor(null);
             httpServer.start();
         }catch (IOException e){
             e.printStackTrace();
         }
     }
    public static void main(String[] args) {
        SimpleHttpServer simpleHttpServer = new SimpleHttpServer();
        simpleHttpServer.start(DEFAULT_PORT);
    }
}
