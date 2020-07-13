package dev.innov8;


import dev.innov8.config.AppConfig;
import dev.innov8.services.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppDriver {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        DemoService service = container.getBean("demoService", DemoService.class);
        service.demo();

        container.registerShutdownHook();

    }


}
