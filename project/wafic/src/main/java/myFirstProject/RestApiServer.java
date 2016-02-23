package myFirstProject;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 * Created by root on 9/29/15.
 */
public class RestApiServer extends Application{

    public static void main(String[] args) {
        Component comp = new Component();
        comp.getServers().add(Protocol.HTTP, 8080);
        Application app = new RestApiServer();
        comp.getDefaultHost().attach(app);
        try {
            comp.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        router.attach("/resource1", Resource1.class);
        router.attach("/resource1/{id}", Resource1.class);
        router.attach("/resource2", Resource2.class);
        //router.attach("/user", UserEntityServer.class);
        router.attach("/user/{id}", UserEntityServer.class);
        return router;
    }

}
