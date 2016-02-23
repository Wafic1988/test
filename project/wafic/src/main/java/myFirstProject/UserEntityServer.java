package myFirstProject;

import myFirstProject.DatabaseMapper.CompanyEntity;
import myFirstProject.DatabaseMapper.EmployeeEntity;
import myFirstProject.DatabaseMapper.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

/**
 * Created by root on 11/21/15.
 */
public class UserEntityServer extends RestApiServerResource{

    protected Long id;

    @Override
    protected void initParams(){
        id = getParam("id");
    }

    @Get
    public UserEntity getResource1(){


        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Criteria criteria = session.createCriteria(UserEntity.class);

        //UserEntity user = criteria.add(Restrictions.eq("username", username)).uniqueResult();


        if(id != null) {

            UserEntity user = session.get(UserEntity.class, id);
            session.close();

            return user;

        }

        session.close();

        UserEntity holo = new UserEntity();
        holo.setUsername("holo");
        holo.setId(2L);
        holo.setPassword("holo");
        return holo;

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
