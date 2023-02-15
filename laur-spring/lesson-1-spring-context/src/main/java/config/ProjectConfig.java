package config;

import beans.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

//    prima varianta de a adauga un bean in Context
    @Bean("bean1")
    public MyBean myBean1(){
        MyBean b =  new MyBean();
        b.setText("Hello");
        return b;
    }

////    is acelasi Bean, deoarece scope-ul default e singleton
//    @Bean("bean2")
//    public MyBean myBean2(){
//        MyBean b = new MyBean();
//        b.setText("World");
//        return b;
//    }
}
