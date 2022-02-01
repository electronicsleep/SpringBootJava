package springbootjava;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

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
        return "Spring Boot";
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

    @RequestMapping(value="/health", method=RequestMethod.GET, produces="application/json")
    public String return_health() {
        logger.info("Health Endpoint");
        return "{\"Health\": \"Ok\"}";
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("id") long id) {
        return "Get a specific row with id=" + id;
    }

    @RequestMapping("/page")
    public String Page(@RequestParam(value="content", required=false, defaultValue="") String content, Model model) {
        logger.info("Page Endpoint");
        content = "this is some test content";

        //content = "Hello Page";
        model.addAttribute("content", content);
        return content;
    }

    /*
    @RequestMapping(value = "/api", method.RequestMethod.GET, produces = "application/json")
    public @ResponseBody Json apiGet(@RequestParam(value="name", required=false, defaultValue="JSON:") String name) {
        logger.info("API Endpoint");
        return new Json(counter.incrementAndGet(), String.format(template, name));
    }
    */
}
