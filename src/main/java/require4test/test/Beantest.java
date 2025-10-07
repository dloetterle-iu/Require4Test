package require4test.test;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@RequestScoped
@Named("beantest")
public class Beantest implements Serializable {

    private static final long serialVersionUID = -1359009739188815168L;

    private String message = "Hello World!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
