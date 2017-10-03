package hu.uni.miskolc.iit.distributed.egov.ps.service.dao;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;

import java.util.Collection;
import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
public interface PersonDAO {

    void createPerson(Person person);


    Collection<Person> readAllPeople();
    Collection<Person> readPeopleByGender(Gender gender);
    Collection<Person> readPeopleByName(String firstName, String lastName);

    void updatePersonDeath(Person person);
}
