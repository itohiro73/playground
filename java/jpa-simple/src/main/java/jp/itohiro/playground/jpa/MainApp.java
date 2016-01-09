package jp.itohiro.playground.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class MainApp {

    private static final String PERSISTENCE_UNIT_NAME = "jpaTest";
    private static EntityManagerFactory factory;

    public static void main(String[] args) throws ClassNotFoundException {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // create new user
        em.getTransaction().begin();
        User hiroshi = new User();
        hiroshi.setUserId("itohiro73");
        hiroshi.setFirstName("Hiroshi");
        hiroshi.setLastName("Ito");
        hiroshi.setBirthDate(LocalDate.of(1980, 7, 3));
        em.persist(hiroshi);
        em.getTransaction().commit();

        Query q = em.createQuery("select u from User u");
        List<User> userList = q.getResultList();
        for (User user : userList) {
            System.out.println(user.getUserId() + ":" + user.getFirstName() + " " + user.getLastName() + ", born in " + user.getBirthDate());
        }
        System.out.println("Size: " + userList.size());

        em.close();
    }
}
