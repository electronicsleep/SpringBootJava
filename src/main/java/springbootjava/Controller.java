package springbootjava;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
public class Controller {

    private static final Logger logger = LogManager.getLogger("springbootjava");

    @RequestMapping("/")
    public String index() {
        logger.info("Root Endpoint");
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/java")
    public String java() {
        logger.info("Java Endpoint");
        return "Greetings from JAVA!";
    }

    @RequestMapping("/date")
    public String return_date() {
        logger.info("Date Endpoint");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String RetString = "DATE: ";
        return RetString + dateFormat.format(date);
    }

}
