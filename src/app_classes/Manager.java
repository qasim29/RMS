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
public class Manager extends Person{
    protected float salary;
    protected String password;
    
    public Manager(){
        
    }
    
    public Manager(int p_id, String name, String gender, String address, String phoneNo, String email){
        super(p_id,name,gender,address,phoneNo,email);
    }
    public Manager(int p_id, String name, String gender, String address, String phoneNo, String email,float salary,String password){
        super(p_id,name,gender,address,phoneNo,email);
        this.salary = salary;
        this.password= password;
    }
    public Manager( String name, String gender, String address, String phoneNo, String email,String password,float salary){
        super(name,gender,address,phoneNo,email);
        this.salary = salary;
        this.password= password;
    }

    public Manager(float salary) {
        this.salary = salary;
    }

    public Manager(int p_id, String name, String gender, String address, String phoneNo, String email,float salary) {
        super(p_id, name, gender, address, phoneNo, email);
        this.salary = salary;
    }
    
    
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
