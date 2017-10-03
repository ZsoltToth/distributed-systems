package hu.uni.miskolc.iit.distributed.egov.ps.service.impl;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonManagerService;
import hu.uni.miskolc.iit.distributed.egov.ps.service.dao.PersonDAO;

import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
public class PersonManagerServiceImpl implements PersonManagerService {

    private PersonDAO dao;


    public PersonManagerServiceImpl(PersonDAO dao) {
        this.dao = dao;
    }

    public void register(Person person) {
        dao.createPerson(person);
    }

    public void register(Person father, Person mother, String firstName, String lastName, Gender gender, Date birthDate) {
        Person person = new Person(firstName,lastName,gender,birthDate,father,mother);
        dao.createPerson(person);
    }

    public void registerDeath(Person person) {
        dao.updatePersonDeath(person);
    }
}
