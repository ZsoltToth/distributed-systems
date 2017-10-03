package hu.uni.miskolc.iit.distributed.egov.ps.service;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;

import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
public interface PersonManagerService {

    void register(Person person);
    void register(Person father, Person mother, String firstName, String lastName, Gender gender, Date birthDate);

    void registerDeath(Person person);

}
