import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        Person p = new Person();
        p.setName("Person 1");
        p.setPhoneNumbers(Arrays.asList("123", "2334", "333"));

        em.persist(p);

        em.getTransaction().commit();
        em.close();
    }
}
