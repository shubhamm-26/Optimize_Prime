package com.example.placementcellapp;

public class students {
    String Name, instituteEmail, Mobile;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInstituteEmail() {
        return instituteEmail;
    }

    public void setInstituteEmail(String instituteEmail) {
        this.instituteEmail = instituteEmail;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public students(String name, String instituteEmail, String mobile) {
        this.Name = name;
        this.instituteEmail = instituteEmail;
        this.Mobile = mobile;
    }
}
