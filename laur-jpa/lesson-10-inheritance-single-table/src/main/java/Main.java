import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        Animal a = new Animal();
        a.setName("A");

        Cat c = new Cat();
        c.setName("B");
        c.setColor("Black");

        em.persist(a);
        em.persist(c);

        em.getTransaction().commit();
        em.close();
    }
}
