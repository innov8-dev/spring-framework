package dev.innov8.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class DemoService {

    private static final Logger logger = LoggerFactory.getLogger(DemoService.class);

    private MessageSource messageSource;

    public DemoService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public void demo() {

        String esNoParamMsg = messageSource.getMessage("no-param", null, new Locale("es", "ES"));
        String enNoParamMsg = messageSource.getMessage("no-param", null, Locale.ENGLISH);
        logger.info("ES message without parameters: {}", esNoParamMsg);
        logger.info("EN message without parameters: {}", enNoParamMsg);


        String esParamMsg = messageSource.getMessage("param", new Object[] {"Alicia Alvarez"}, new Locale("es", "ES"));
        String enParamMsg = messageSource.getMessage("param", new Object[] {"Bryan Bailey"}, Locale.ENGLISH);
        logger.info("ES messages with parameters: {}", esParamMsg);
        logger.info("EN messages with parameters: {}", enParamMsg);

    }
}
