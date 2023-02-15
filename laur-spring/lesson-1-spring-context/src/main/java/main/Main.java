package main;

import beans.MyBean;
import beans.MySecondBean;
import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
//            putem face diferentierea prin nume sau tip
//            by name
//            var 1 - cu @Bean
            MyBean b1 = context.getBean("bean1", MyBean.class);
//            MyBean b2 = context.getBean("bean2", MyBean.class);
            System.out.println(b1.getText());

            //var 2 - cu @Component si @ComponentScan (pe clasa de @Configuration)
            MySecondBean b2 = context.getBean(MySecondBean.class);
            System.out.println(b2.getText());
        }
    }
}
