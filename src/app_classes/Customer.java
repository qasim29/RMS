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
public class Customer extends Person{
    public Customer(){
        
    }

    public Customer(String name, String gender, String address, String phoneNo, String email) {
        super(name, gender, address, phoneNo, email);
    }
    
    public Customer(int p_id, String name, String gender, String address, String phoneNo, String email){
        super(p_id,name,gender,address,phoneNo,email);
    }   
    
}
