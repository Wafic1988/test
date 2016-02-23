package myFirstProject.DatabaseMapper;

    import junit.framework.TestCase;

    import org.hibernate.Session;
    import org.hibernate.SessionFactory;
    import org.hibernate.cfg.Configuration;

/**
 * Unit test for simple App.
 */
public class TestDbMapper extends TestCase {

    public void testApp() {
        SessionFactory sessionFactory = new Configuration().configure()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("username");
        userEntity.setPassword("password");
        session.save(userEntity);

        PersonnelInformationEntity personnelInformationEntity = new PersonnelInformationEntity();
        personnelInformationEntity.setUserEntity(userEntity);
        personnelInformationEntity.setFirstName("wafic");
        personnelInformationEntity.setLastName("alameddine");
        personnelInformationEntity.setGender("male");
        session.save(personnelInformationEntity);

        CompanyEntity company = new CompanyEntity();
        session.save(company);

        EmployeeEntity employee = new EmployeeEntity();
        employee.setCompanyEntity(company);
        session.save(employee);

        session.getTransaction().commit();
        session.close();
    }
}