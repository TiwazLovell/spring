import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

//      @OneToOne example - bidirectional
        Product p = new Product();
        p.setName("Wine");
        p.setPrice(20);
        em.persist(p);

        Detail d = new Detail();
        d.setKcal(250);
        d.setProduct(p);
        p.setDetail(d);

        em.persist(d);


        em.getTransaction().commit();
        em.close();
    }
}
