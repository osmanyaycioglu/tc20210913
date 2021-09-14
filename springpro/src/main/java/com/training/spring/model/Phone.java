package com.training.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@TableGenerator(name = "gen_phone",
                table = "id_gen",
                pkColumnName = "obj",
                pkColumnValue = "phone",
                initialValue = 0,
                allocationSize = 1)
public class Phone {

    @Id
    @GeneratedValue(generator = "gen_phone", strategy = GenerationType.TABLE)
    private Long   phoneId;
    private String number;
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false, name = "person_id")
    @JsonIgnore
    @XmlTransient
    private Person person;

    public Long getPhoneId() {
        return this.phoneId;
    }

    public void setPhoneId(final Long phoneIdParam) {
        this.phoneId = phoneIdParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.number == null) ? 0 : this.number.hashCode());
        result = (prime * result) + ((this.phoneId == null) ? 0 : this.phoneId.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Phone other = (Phone) obj;
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!this.number.equals(other.number)) {
            return false;
        }
        if (this.phoneId == null) {
            if (other.phoneId != null) {
                return false;
            }
        } else if (!this.phoneId.equals(other.phoneId)) {
            return false;
        }
        return true;
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(final Person personParam) {
        this.person = personParam;
    }


}
