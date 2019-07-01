package com.matrix.medical.appointment.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
public class User implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long userId;

    @Column
    private String firstName;

    @Column
    private String confirmationCode;

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @Column
    private String lastName;

    @Column
    private String emailId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private dob dob;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private TimeSlot time;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private appointment appointment;

    public User(String firstName, String lastName, String emailId, String confirmationCode, appointment appointment, TimeSlot time, dob dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.appointment = appointment;
        this.time = time;
        this.dob=dob;
        this.confirmationCode=confirmationCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return firstName;
    }

    public void setUserName(String userName) {
        this.firstName = userName;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(appointment appointment) {
        this.appointment = appointment;
    }

    public TimeSlot getTime() {
        return time;
    }

    public void setTime(TimeSlot time) {
        this.time = time;
    }

    public dob getDob() {
        return dob;
    }

    public void setDob(dob dob) {
        this.dob = dob;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", confirmationCode=" + confirmationCode +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dob=" + dob +
                ", time=" + time +
                ", selectedDate=" + appointment +
                '}';
    }
}
