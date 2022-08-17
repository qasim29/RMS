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
public class Employee extends Person{
    protected int totalNoOrder = 0;
    protected float salary;
    protected String password;
    protected float bonus;
    
    public Employee(){
        
    }

    public Employee(int totalNoOrder, float salary, float bonus) {
        this.totalNoOrder = totalNoOrder;
        this.salary = salary;
        this.bonus = bonus;
    }

    public Employee( int p_id, String name, String gender, String address, String phoneNo, String email,int totalNoOrder, float bonus,float salary,String password) {
        super(p_id, name, gender, address, phoneNo, email);
        this.totalNoOrder = totalNoOrder;
        this.salary = salary;
        this.bonus = bonus;
        this.password = password;
    }
    
    public Employee(int totalNoOrder, float salary, String password, float bonus) {
        this.totalNoOrder = totalNoOrder;
        this.salary = salary;
        this.password = password;
        this.bonus = bonus;
    }

    public Employee(int totalNoOrder, float salary, String password, float bonus, int p_id, String name, String gender, String address, String phoneNo, String email) {
        super(p_id, name, gender, address, phoneNo, email);
        this.totalNoOrder = totalNoOrder;
        this.salary = salary;
        this.password = password;
        this.bonus = bonus;
    }
    public Employee(String name, String gender, String address, String phoneNo, String email, String password,float salary) {
        super(name, gender, address, phoneNo, email);
        this.password = password;
        this.salary = salary;
    }

    public int getTotalNoOrder() {
        return totalNoOrder;
    }

    public void setTotalNoOrder(int totalNoOrder) {
        this.totalNoOrder = totalNoOrder;
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

    public float getBonus() {
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }
    
    
    
}
