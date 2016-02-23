package myFirstProject;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 * Created by root on 11/21/15.
 */
public class Resource1 extends RestApiServerResource{

    protected Long id;

    @Override
    protected void initParams(){
        id = getParam("id");
    }

    @Get
    public String getResource1(){
        if(id == null) {
            return "Get Resources: ";
        } else {
            return id.toString();
        }
    }

    @Post("json")
    public JacksonRepresentation createResource1(JacksonRepresentation autoStackRep) {
        return autoStackRep;
    }

    @Put("json")
    public JacksonRepresentation updateResource1(JacksonRepresentation autoStackRep) {
        return autoStackRep;
    }

    @Delete()
    public String deleteResource1() {
        return "Delete Resource1";
    }

}
