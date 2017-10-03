package hu.uni.miskolc.iit.distributed.egov.ps.model;

import java.util.Date;

/**
 * Created by tothzs on 2017.10.03..
 */
public class Person {

    private String firstName;
    private String lastName;
    private Gender sex;
    private Date birthDate;
    private Date deathDate;

    private Person mother;
    private Person father;

    public Person(String firstName, String lastName, Gender sex, Date birthDate, Date deathDate, Person mother, Person father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
    }

    public Person(String firstName, String lastName, Gender sex, Date birthDate, Person mother, Person father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getSex() {
        return sex;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public  void die(){
        if(this.deathDate != null){
            return;
        }
        this.deathDate = new Date();
    }

    public boolean isAlive(){
        return this.deathDate == null;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  Person)){
            return false;
        }
        return firstName.equals(((Person)obj).firstName) && lastName.equals(((Person)obj).lastName);
    }
}
