package com.training.spring.model;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class PersonDetails {

    @Enumerated(EnumType.STRING)
    private EGender gender;

    private String  detail;

    public EGender getGender() {
        return this.gender;
    }

    public void setGender(final EGender genderParam) {
        this.gender = genderParam;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(final String detailParam) {
        this.detail = detailParam;
    }

}
