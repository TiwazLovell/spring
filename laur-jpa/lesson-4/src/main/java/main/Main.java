package main;

import thidExample.Building;
import thidExample.BuildingPK;

import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

////       firstExample - simple use case of @AttributeOverrides - @AttributeOverride
//        Company c = new Company();
//        c.setName("ABC");
//        c.setAddress(new Address());
//
//        c.getAddress().setNo("4");
//        c.getAddress().setStr("Some Street");
//        c.getAddress().setCity("London");
//
//        em.persist(c);

////        secondExample - composed primary key (prima varianta) using @IdClass
//        Department d = new Department();
//        d.setName("HR");
//        d.setCode("1");
//        d.setNo(10);
//        em.persist(d);

//        thirdExample - composed primary key (a doua varianta) using @EmbeddedId
        Building b = new Building();
        b.setName("B1");
        b.setId(new BuildingPK());
        b.getId().setCode("ABC");
        b.getId().setNo(20);
        em.persist(b);

//        Person p1 = new Person();
//        p1.setName("P1");
//        em.persist(p1);

        em.getTransaction().commit();
        em.close();
    }
}
