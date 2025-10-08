package require4test.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@RequestScoped
@Named("testbean")
public class Testbean implements Serializable {

    private static final long serialVersionUID = -1359009739188815168L;

    private String message = "Hello World!";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
