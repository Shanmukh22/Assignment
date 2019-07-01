package com.matrix.medical.appointment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "dob")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class dob {


    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    @Column
    int year;

    @Column
    int month;

    @Column
    int day;

    public dob(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public dob() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
