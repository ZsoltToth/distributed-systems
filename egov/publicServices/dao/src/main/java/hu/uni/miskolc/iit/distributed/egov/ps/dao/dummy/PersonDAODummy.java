package hu.uni.miskolc.iit.distributed.egov.ps.dao.dummy;

import hu.uni.miskolc.iit.distributed.egov.ps.model.Gender;
import hu.uni.miskolc.iit.distributed.egov.ps.model.Person;
import hu.uni.miskolc.iit.distributed.egov.ps.service.dao.PersonDAO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by tothzs on 2017.10.03..
 */
public class PersonDAODummy implements PersonDAO {

    private Collection<Person> people;

    public PersonDAODummy() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        people = new HashSet<Person>();
        try {
            people.add(new Person("Johnny", "Walker", Gender.MALE, df.parse("2000-01-01"), null, null));
            people.add(new Person("Jim", "Beam", Gender.MALE, df.parse("2000-01-01"), null, null));
            people.add(new Person("Jack", "Daniel", Gender.MALE, df.parse("2000-01-01"), null, null));
            people.add(new Person("Dia", "Finlan", Gender.FEMALE, df.parse("2000-01-01"), null, null));
        }catch(ParseException ex){}
    }

    public void createPerson(Person person) {

    }

    public Collection<Person> readAllPeople() {
        return new ArrayList<Person>(people);
    }

    public Collection<Person> readPeopleByGender(Gender gender) {
        Collection<Person> result = new HashSet<Person>();
        for(Person person : people){
            if(person.getSex() == gender){
                result.add(person);
            }
        }
        return result;
    }

    public Collection<Person> readPeopleByName(String firstName, String lastName) {
        Collection<Person> result = new HashSet<Person>();
        for(Person person : people){
            if(person.getFirstName().equals(firstName) || person.getLastName().equals(lastName)){
                result.add(person);
            }
        }
        return result;
    }

    public void updatePersonDeath(Person person) {
        for(Person p : people){
            if(p.equals(person))
                p.die();
        }
    }
}
