package com.training.spring.employeep;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

@Entity
@TableGenerator(name = "gen_employee",
                table = "id_gen",
                pkColumnName = "obj",
                pkColumnValue = "employee",
                initialValue = 0,
                allocationSize = 1)
public class Employee {

    @Id
    @GeneratedValue(generator = "gen_employee", strategy = GenerationType.TABLE)
    private long   personId;

    private String name;
    private String surname;

    @Version
    private long   vers;


    public long getPersonId() {
        return this.personId;
    }


    public void setPersonId(final long personIdParam) {
        this.personId = personIdParam;
    }


    public String getName() {
        return this.name;
    }


    public void setName(final String nameParam) {
        this.name = nameParam;
    }


    public String getSurname() {
        return this.surname;
    }


    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }


    public long getVers() {
        return this.vers;
    }


    public void setVers(final long versParam) {
        this.vers = versParam;
    }


    @Override
    public String toString() {
        return "Employee [personId="
               + this.personId
               + ", name="
               + this.name
               + ", surname="
               + this.surname
               + ", vers="
               + this.vers
               + "]";
    }


}
