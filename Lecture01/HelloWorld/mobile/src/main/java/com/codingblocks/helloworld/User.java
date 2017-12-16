package com.codingblocks.helloworld;

/**
 * Created by harshit on 09/12/17.
 */

public class User {
    private String fname;
    private String lName;
    private String address;
    private String course;
    private String batch;
    private String center;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (fname != null ? !fname.equals(user.fname) : user.fname != null) return false;
        if (lName != null ? !lName.equals(user.lName) : user.lName != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (course != null ? !course.equals(user.course) : user.course != null) return false;
        if (batch != null ? !batch.equals(user.batch) : user.batch != null) return false;
        if (center != null ? !center.equals(user.center) : user.center != null) return false;
        return age != null ? age.equals(user.age) : user.age == null;
    }

    @Override
    public int hashCode() {
        int result = fname != null ? fname.hashCode() : 0;
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (batch != null ? batch.hashCode() : 0);
        result = 31 * result + (center != null ? center.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
    }

    public User(String fname, String lName, String address, String course, String batch, String center, Integer age) {
        this.fname = fname;
        this.lName = lName;
        this.address = address;
        this.course = course;
        this.batch = batch;
        this.center = center;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
