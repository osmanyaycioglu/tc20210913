package com.training.micro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;

@Entity
//@Table(schema = "sema1")
public class Person {

    @Id
    @GeneratedValue
    private Long   personId;
    private String name;
    private String surname;
    @Max(300)
    private int    weight;
    private int    height;

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
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

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(final int weightParam) {
        this.weight = weightParam;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(final int heightParam) {
        this.height = heightParam;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + this.height;
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.personId == null) ? 0 : this.personId.hashCode());
        result = (prime * result) + ((this.surname == null) ? 0 : this.surname.hashCode());
        result = (prime * result) + this.weight;
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
        Person other = (Person) obj;
        if (this.height != other.height) {
            return false;
        }
        if (this.name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!this.name.equals(other.name)) {
            return false;
        }
        if (this.personId == null) {
            if (other.personId != null) {
                return false;
            }
        } else if (!this.personId.equals(other.personId)) {
            return false;
        }
        if (this.surname == null) {
            if (other.surname != null) {
                return false;
            }
        } else if (!this.surname.equals(other.surname)) {
            return false;
        }
        if (this.weight != other.weight) {
            return false;
        }
        return true;
    }


}

