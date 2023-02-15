package beans;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Service
//@Repository
public class MySecondBean {

    private String text;

    @PostConstruct
//    @PreDestroy
    private void init(){
        this.text = "World";
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
