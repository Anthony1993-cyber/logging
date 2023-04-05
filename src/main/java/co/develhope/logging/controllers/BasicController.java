package co.develhope.logging.controllers;

import co.develhope.logging.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @Autowired
    private BasicService basicService;

    Logger logger = LoggerFactory.getLogger(BasicController.class);

    @GetMapping("/")
    public String getWelcomeMsg(){
        logger.info("It's a welcome message");
        return "Welcome, thanks for visiting us!";
    }

    @GetMapping("/exp")
    public Double getPower(){
        return basicService.getPower();
    }

    @GetMapping("/get-errors")
    public void getErrors(){
        Error error = new Error("error");
        logger.error("It's an error logging", error);
    }

}
