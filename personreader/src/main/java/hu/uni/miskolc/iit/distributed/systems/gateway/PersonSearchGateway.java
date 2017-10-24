package hu.uni.miskolc.iit.distributed.systems.gateway;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import org.springframework.integration.annotation.Payload;

import java.util.Collection;

/**
 * Created by tothzs on 2017.10.24..
 */
public interface PersonSearchGateway {

    @Payload("new java.util.Date()")
    Collection<Person> listAllPeople();

    /**
     * fn,ln,gender, birth(yyyy-MM-dd)
     * @param person
     */
    void addPerson(@Payload Person person);
}
