package hu.uni.miskolc.iit.distributed.egov.ps.web.config;

import hu.uni.miskolc.iit.distributed.egov.ps.controller.PersonManagerController;
import hu.uni.miskolc.iit.distributed.egov.ps.dao.dummy.PersonDAODummy;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonManagerService;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonSearchService;
import hu.uni.miskolc.iit.distributed.egov.ps.service.dao.PersonDAO;
import hu.uni.miskolc.iit.distributed.egov.ps.service.impl.PersonManagerServiceImpl;
import hu.uni.miskolc.iit.distributed.egov.ps.service.impl.PersonSearchServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by tothzs on 2017.10.10..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "hu.uni.miskolc.iit.distributed.egov.ps.web.config")
public class WebConfig {

    @Bean
    public PersonDAO personDAO(){
        return new PersonDAODummy();
    }

    @Bean
    public PersonManagerService personManagerService(){
        return new PersonManagerServiceImpl(personDAO());
    }

    @Bean
    public PersonSearchService personSearchService(){
        return new PersonSearchServiceImpl(personDAO());
    }

    @Bean
    public PersonManagerController personManagerController(){
        return new PersonManagerController(personManagerService(),personSearchService());
    }


    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
}
