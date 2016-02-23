package myFirstProject;

import org.restlet.resource.ServerResource;

/**
 * Created by root on 9/29/15.
 */
public class RestApiServerResource extends ServerResource{

    @Override
    protected void doInit() {
            initParams();
    }

    protected Long getParam(final String param) {
        String attribute = getAttribute(param);
        if (attribute != null) {
            return Long.parseLong(attribute);
        } else {
            return null;
        }
    }

    protected void initParams() {

    }

}
