import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

        Car c = new Car();
        c.setColor("Black");
        c.setGas("Diesel");

        Bicycle b = new Bicycle();
        b.setColor("Red");
        b.setModel("BMX");

        em.persist(c);
        em.persist(b);

        em.getTransaction().commit();
        em.close();
    }
}
