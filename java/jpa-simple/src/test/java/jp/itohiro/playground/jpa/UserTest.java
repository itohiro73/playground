package jp.itohiro.playground.jpa;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

public class UserTest {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static IDatabaseConnection connection;
    private static IDataSet dataSet;

    @BeforeClass
    public static void initDbConfig() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpaTest");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        connection = new DatabaseConnection(entityManager.unwrap(java.sql.Connection.class));
        connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());

        InputStream insertData = UserTest.class.getClassLoader().getResourceAsStream("insert_data.xml");
        FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
        flatXmlDataSetBuilder.setColumnSensing(true);
        dataSet = flatXmlDataSetBuilder.build(insertData);
    }

    @Before
    public void initDb() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        entityManager.getTransaction().commit();
    }


    @Test
    public void user(){
        entityManager.getTransaction().begin();
        User hiroshi = new User();
        hiroshi.setUserId("katos");
        hiroshi.setFirstName("Satoru");
        hiroshi.setLastName("Kato");
        hiroshi.setBirthDate(LocalDate.of(1983, 6, 6));
        entityManager.persist(hiroshi);
        entityManager.getTransaction().commit();

        Query q = entityManager.createQuery("select u from User u");
        List<User> userList = q.getResultList();
        Assert.assertEquals(2, userList.size());
    }
}
