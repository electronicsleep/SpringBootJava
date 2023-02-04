package com.imgidea.springbootjava;

import static com.imgidea.springbootjava.Constants.*;

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

    @RequestMapping("/status")
    public String status() {
        logger.info("StatusPage Endpoint");
        Status status = new Status();
        String statusPage = status.Status();
        return statusPage;
    }

    @RequestMapping("/date")
    public String date() {
        logger.info("Date Endpoint");
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateString = "DATE: ";
        return dateString + dateFormat.format(date);
    }

    @RequestMapping(value="/health", method=RequestMethod.GET, produces="application/json")
    public String health() {
        logger.info("Health Endpoint");
        return HEALTH;
    }

    @RequestMapping(value = "/api/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getApiId(
            @PathVariable("id") long id) {
        return "Get row with id=" + id;
    }

    @RequestMapping("/page")
    public String Page(@RequestParam(value="content", required=false, defaultValue="") String content, Model model) {
        logger.info("Page Endpoint");

        content = HTML_HEADER + ABOUT + HTML_FOOTER;
        return content;
    }
}
