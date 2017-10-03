package hu.uni.miskolc.iit.distributed.egov.ps.service;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;

import java.util.Collection;

/**
 * Created by tothzs on 2017.10.03..
 */
public interface PersonSearchService {

    Collection<Person> listAllPeople();
    Collection<Person> listPeopleByGender(Gender gender);
    Collection<Person> listPeopleByName(String firstName, String lastName);



}
