import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

//        Product p = new Product();
//        p.setName("P");

        Chocolate c = new Chocolate();
        c.setName("Milka");
        c.setKcal(333);

//        em.persist(p);
        em.persist(c);

        em.getTransaction().commit();
        em.close();
    }
}
