package com.example.doctornearus;

public class DoctorUsers {
    String fullName, emailAddress, PhoneNumber, PresentAddress,speciality,bmdc,password;


    public DoctorUsers(){

    }


    public DoctorUsers(String fullName, String emailAddress, String phoneNumber, String presentAddress, String speciality, String bmdc, String password) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        PhoneNumber = phoneNumber;
        PresentAddress = presentAddress;
        this.speciality = speciality;
        this.bmdc = bmdc;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPresentAddress() {
        return PresentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        PresentAddress = presentAddress;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getBmdc() {
        return bmdc;
    }

    public void setBmdc(String bmdc) {
        this.bmdc = bmdc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getdis()
//    {
//
//    }

    public String toString(){
        return "Doctors Name:  "+this.fullName+", Speciality:  "+this.speciality+", Address:  "+PresentAddress+", Phone:  "+PhoneNumber;
    }
}
