package springbootjava;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Controller {
    
    @RequestMapping("/")
    public String index() {
        System.out.println("Root Endpoint");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/java")
    public String java() {
        System.out.println("Java Endpoint");
        return "Greetings from JAVA!";
    }

    @RequestMapping("/date")
    public String return_date() {
        System.out.println("Date Endpoint");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String RetString = "DATE: ";
        return RetString + dateFormat.format(date);
    }
    
}
