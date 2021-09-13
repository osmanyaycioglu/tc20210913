package com.training.spring;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.training.spring.validation.StartWith;

public class Person {

    @NotEmpty
    private String name;
    @Size(min = 2, max = 20)
    @StartWith("sur:")
    private String surname;
    @Max(200)
    @Min(18)
    private int    age;

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


}
