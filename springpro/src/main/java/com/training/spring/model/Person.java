package com.training.spring.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.training.spring.validation.StartWith;

@Entity
@NamedQueries({
                @NamedQuery(name = "Person.findAllByName", query = "select p from Person p where p.name=?1"),
                @NamedQuery(name = "Person.findAllByNameAndSurname",
                            query = "select p from Person p where p.name=?1 and p.surname=?2")
})
@Table(name = "operson")
@TableGenerator(name = "gen_person",
                table = "id_gen",
                pkColumnName = "obj",
                pkColumnValue = "person",
                initialValue = 0,
                allocationSize = 1)
public class Person {

    @Id
    @GeneratedValue(generator = "gen_person", strategy = GenerationType.TABLE)
    private long          personId;

    @NotEmpty
    @Column(nullable = false, length = 100)
    private String        name;
    @Size(min = 2, max = 20)
    @StartWith("sur:")
    private String        surname;
    @Max(200)
    @Min(18)
    private int           age;

    @Version
    private long          personVersion;

    @Embedded
    private PersonDetails personDetails;

    // @Fetch(FetchMode.SELECT)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    private Address address;

    // @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "person")
    private Set<Phone> phones;

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

    public int getAge() {
        return this.age;
    }

    public void setAge(final int ageParam) {
        this.age = ageParam;
    }

    @Override
    public String toString() {
        return "Person [name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + "]";
    }

    public long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final long personIdParam) {
        this.personId = personIdParam;
    }

    public PersonDetails getPersonDetails() {
        return this.personDetails;
    }

    public void setPersonDetails(final PersonDetails personDetailsParam) {
        this.personDetails = personDetailsParam;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(final Address addressParam) {
        this.address = addressParam;
    }

    public Set<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final Set<Phone> phonesParam) {
        this.phones = phonesParam;
    }

    public long getPersonVersion() {
        return this.personVersion;
    }

    public void setPersonVersion(final long personVersionParam) {
        this.personVersion = personVersionParam;
    }


}
