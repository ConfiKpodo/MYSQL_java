/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cd_collections;

/**
 *
 * @author confi
 */
public class Genre {
    private int id;
    private String name;
    //constructor
    public Genre(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Genre(){
        
    }
    public int getID(){
        return this.id;
    }
    public void setID(int ID){
        this.id = ID;
    }
    
    public String getName(){
       return this.name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
}
