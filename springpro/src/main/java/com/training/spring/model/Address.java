package com.training.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@TableGenerator(name = "gen_address",
                table = "id_gen",
                pkColumnName = "obj",
                pkColumnValue = "address",
                initialValue = 0,
                allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(generator = "gen_address", strategy = GenerationType.TABLE)
    private Long   addId;
    private String city;
    private String street;

    @OneToOne
    @JoinColumn(nullable = false, name = "person_id")
    @JsonIgnore
    @XmlTransient
    private Person person;


    public String getCity() {
        return this.city;
    }

    public void setCity(final String cityParam) {
        this.city = cityParam;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(final String streetParam) {
        this.street = streetParam;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }


}
