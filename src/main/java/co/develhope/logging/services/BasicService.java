package co.develhope.logging.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;



@Service
public class BasicService {

    @Autowired
    private Environment environment;

    Logger logger = LoggerFactory.getLogger(BasicService.class);

    public Double getPower(){
        try {
            logger.debug("Starting power calculation");
            return Math.pow(Double.parseDouble(environment.getProperty("customEnvs.n1")),
                    Double.parseDouble(environment.getProperty("customEnvs.n2")));
        }finally{
            logger.debug("Ending power calculation");
        }
    }

}
