import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

//      @OneToOne example - unidirectional
        Product p = new Product();
        p.setName("Vodka");
        p.setPrice(10);
//        * (1)
//        em.persist(p);

        Detail d = new Detail();
        d.setKcal(200);
        em.persist(d);
        d.setProduct(p);

//        p.setDetail(d);
//        em.persist(d);


        em.getTransaction().commit();
        em.close();
    }
}
