package myFirstProject;

import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 * Created by root on 11/21/15.
 */
public class Resource2 extends RestApiServerResource{

    @Get
    public String getResource2(){
        return "Resource2";
    }

    @Post("json")
    public JacksonRepresentation createResource2(JacksonRepresentation autoStackRep) {
        return autoStackRep;
    }

    @Put("json")
    public JacksonRepresentation updateResource2(JacksonRepresentation autoStackRep) {
        return autoStackRep;
    }

    @Delete()
    public String deleteResource2() {
        return "Delete Resource2";
    }

}
