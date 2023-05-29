package entity;

import java.util.Date;

public class Customer {
    private String cusId;
    private String cusName;
    private boolean gender;
    private Date birthday;
    private String address;
    private String email;
    private String telephone;

    public Customer() {
    }

    public Customer(String cusId, String cusName, boolean gender, Date birthday, String address, String email, String telephone) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
