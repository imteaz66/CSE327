package com.example.doctornearus;

public class PatientUsers {
    String FullName, EmailAddress, PhoneNumber, PresentAddress, Password;
    public PatientUsers() {
    }

    public PatientUsers(String fullName, String emailAddress, String phoneNumber, String presentAddress, String password) {
        FullName = fullName;
        EmailAddress = emailAddress;
        PhoneNumber = phoneNumber;
        PresentAddress = presentAddress;
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
