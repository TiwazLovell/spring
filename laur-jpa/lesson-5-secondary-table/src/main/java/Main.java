import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

//        @SecondaryTable example - relatie OneToOne reprezentata doar in baza de date, nu si intre entitati
        Company c1 = new Company();
        c1.setName("XYZ");
        c1.setStreet("Street 1");
        c1.setNumber("A1");
        c1.setDetails("DETAILS");
        em.persist(c1);

        em.getTransaction().commit();
        em.close();
    }
}
