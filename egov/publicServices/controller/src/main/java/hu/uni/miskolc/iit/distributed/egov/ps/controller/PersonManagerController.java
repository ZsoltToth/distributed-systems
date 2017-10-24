package hu.uni.miskolc.iit.distributed.egov.ps.controller;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonManagerService;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
@Controller
public class PersonManagerController {

    private PersonManagerService managerService;
    private PersonSearchService searchService;



    public PersonManagerController(PersonManagerService managerService, PersonSearchService searchService) {
        this.managerService = managerService;
        this.searchService = searchService;

    }


    @RequestMapping(value = {"/people/all","/resources/people"})
    @ResponseBody
    public Collection<Person> listAllPeople(){
        return searchService.listAllPeople();
    }


    @RequestMapping(value = "/person/register")
    @ResponseBody
    public void registrar(@RequestParam("fn") String firstName, @RequestParam(value = "ln") String lastName, @RequestParam("gender") Gender gender, @RequestParam("birth") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthDate){
        Person person = new Person(firstName, lastName,gender, birthDate, null,null,null);
        managerService.register(person);
    }
}
