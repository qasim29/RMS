/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_classes;

/**
 *
 * @author dell
 */
public class Person {
    protected int p_id;
    protected String name;
    protected String gender;
    protected String address;
    protected String phoneNo;
    protected String email;
    
    public Person(){
        
    }

    public Person(int p_id, String name, String gender, String address, String phoneNo, String email) {
        this.p_id = p_id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }
    public Person(String name, String gender, String address, String phoneNo, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
