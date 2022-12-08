package com.example.placementcellapp;

public class students {
    String Name, instituteEmail, Mobile,arr,Skills,LinkedIn,Github;

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

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    public String getGithub() {
        return Github;
    }

    public void setGithub(String github) {
        Github = github;
    }

    public String getLinkedIn() {
        return LinkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        LinkedIn = linkedIn;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public students(String name, String instituteEmail, String mobile,String skills,String github,String linkedIn) {
        this.Name = name;
        this.instituteEmail = instituteEmail;
        this.Mobile = mobile;
        this.Skills = skills;
        this.LinkedIn = linkedIn;
        this.Github=github;
        this.arr=null;
    }
}
