import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        Professor p = new Professor();
        p.setName("Prof 1");

        ProfessorDetails pd1 = new ProfessorDetails();
        pd1.setProfessors(Arrays.asList(p));

        Student s1 = new Student();
        s1.setName("Stud 1");
        s1.setProfessorDetails(pd1);

        em.persist(p);
        em.persist(s1);

        em.getTransaction().commit();
        em.close();
    }
}
