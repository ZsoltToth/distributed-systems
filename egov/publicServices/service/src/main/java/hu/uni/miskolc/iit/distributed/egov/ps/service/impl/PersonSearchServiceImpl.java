package hu.uni.miskolc.iit.distributed.egov.ps.service.impl;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.egov.ps.service.PersonSearchService;
import hu.uni.miskolc.iit.distributed.egov.ps.service.dao.PersonDAO;

import java.util.Collection;

/**
 * Created by tothzs on 2017.10.03..
 */
public class PersonSearchServiceImpl implements PersonSearchService {

    private PersonDAO dao;

    public PersonSearchServiceImpl(PersonDAO dao) {
        this.dao = dao;
    }

    public Collection<Person> listAllPeople() {
        return dao.readAllPeople();
    }

    public Collection<Person> listPeopleByGender(Gender gender) {
        return dao.readPeopleByGender(gender);
    }

    public Collection<Person> listPeopleByName(String firstName, String lastName) {
        return dao.readPeopleByName(firstName,lastName);
    }
}
