import javax.persistence.Persistence;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        Department d1 = new Department();
        d1.setName("Dep 1");

        DepartmentDetails dd1 = new DepartmentDetails();
        dd1.setContractNo("ABC123");
        dd1.setDepartment(d1);

        Employee e1 = new Employee();
        e1.setName("Employee 1");
        e1.setDepartmentDetails(dd1);

        em.persist(e1);
        em.persist(d1);

        em.getTransaction().commit();
        em.close();
    }
}
