import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main {

    /*
    SQL - SELECT * FROM product (native queries)
    JPQL - SELECT p from Product p
     */
    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

////        SELECT
//        String jpql = "SELECT p from Product p";
//        TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//
//        List<Product> list = q.getResultList();
//
//        list.forEach(System.out::println);

////        SELECT WHERE - QUERY PARAMETERS
//        String jpql = "SELECT p from Product p WHERE p.price > : price";
//        TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//        q.setParameter("price", 10.0);
//
//        List<Product> list = q.getResultList();
//
//        list.forEach(System.out::println);

////       SUM - using functions
//        String jpql = "SELECT SUM(p.price) from Product p WHERE p.price > : price";
//        TypedQuery<Double> q = em.createQuery(jpql, Double.class);
//        q.setParameter("price", 10.0);
//
//        double sum = q.getSingleResult();
//        System.out.println(sum);

////        NAMED QUERY
//        TypedQuery<Product> query =
//                em.createNamedQuery("Product.all", Product.class);
//
//////        NEVER DO SOMETHING LIKE THIS - BAD PRACTICE
////        query.getResultStream()
////                .filter(p -> p.getPrice() > 10)
////                .forEach(System.out::println);
//
//        List<Product> list = query.getResultList();
//        list.forEach(System.out::println);

//        JPQL example between two tables with relationship @ManyToOne
        String jpql = "SELECT e FROM Employee e, Department d WHERE e.department = d AND d.id = :id";
        TypedQuery<Employee> tq = em.createQuery(jpql, Employee.class);
        tq.setParameter("id", 1);

        List<Employee> list = tq.getResultList();

        list.forEach(System.out::println);

        em.getTransaction().commit();
        em.close();
    }
}
