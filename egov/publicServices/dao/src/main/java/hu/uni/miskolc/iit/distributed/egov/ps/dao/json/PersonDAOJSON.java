package hu.uni.miskolc.iit.distributed.egov.ps.dao.json;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.egov.ps.service.dao.PersonDAO;

import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
public class PersonDAOJSON implements PersonDAO{


    public void createPerson(Person person) {

    }

    public Collection<Person> readAllPeople() {
        return null;
    }

    public Collection<Person> readPeopleByGender(Gender gender) {
        return null;
    }

    public Collection<Person> readPeopleByName(String firstName, String lastName) {
        return null;
    }

    public void updatePersonDeath(Person person) {

    }
}
