package myFirstProject;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


/**
 * Created by root on 9/11/15.  throws UnknownHostException
 */
public class App{

    HttpServer server;
    private static boolean isRunning = true;

    public App() {
    }

    private void startServer() {
        try {
            InetSocketAddress address = new InetSocketAddress(InetAddress.getByName("192.168.56.101"), 2500);
            server = HttpServer.create(address,0);
            server.createContext("/", new requestHandler());
            server.setExecutor(null);
            server.start();
        } catch (IOException e) {
            System.out.println("Exception thrown  :" + e);
        }
    }

    private void stopServer() {
        server.stop(0);
    }

    class requestHandler implements HttpHandler {

        public void handle(HttpExchange httpExchange) throws IOException {

            String body = "Hello World";
            httpExchange.sendResponseHeaders(200, body.length());
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(body.getBytes());
            outputStream.close();

        }

    }

    public static void main(String[] args) throws InterruptedException, IOException {

        App calc = new App();

            try {
                calc.startServer();
                //HttpClientBuilder builder = HttpClientBuilder.create();
                //CloseableHttpClient httpclient = builder.build();

                //HttpGet httpGet = new HttpGet("http://192.168.56.101:2500/homepage");
                //HttpResponse response = httpclient.execute(httpGet);

                //System.out.println(response.getStatusLine());
                //System.out.println(response.getEntity().getContent().toString());

            } finally {

                //calc.stopServer();
            }

        while(isRunning) {

        }
    }

}

