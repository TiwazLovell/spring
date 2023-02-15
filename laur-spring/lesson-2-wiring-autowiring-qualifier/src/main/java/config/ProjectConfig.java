package config;

import beans.Cat;
import beans.Owner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

//    @Bean("Cat")
//    public Cat cat () {
//        Cat c = new Cat();
//        c.setName("Tom");
//        return c;
//    }
//
//    @Bean
//    public Owner owner(Cat cat) {
//        Owner o = new Owner();
////        Spring verifica daca in context exista vreun bean cu numele Cat
////        si daca exista ia valoarea de-acolo
//        o.setCat(cat);
//        return o;
//    }

    @Bean("Cat")
    @Qualifier("cat1")
    public Cat cat() {
        Cat c = new Cat();
        c.setName("Tom");
        return c;
    }

    @Bean
    @Qualifier("cat2")
    public Cat cat2() {
        Cat c = new Cat();
        c.setName("Leo");
        return c;
    }
}
