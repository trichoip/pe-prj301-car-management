/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe;

/**
 *
 * @author hd
 */
public class CarDTO {
    // kiem tra type
    private String id;
    private String name;
    private String description;
    private double price;
    private int speed;
    private boolean status;

    public CarDTO() {
    }

    public CarDTO(String id, String name, String description, double price, int speed, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.speed = speed;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
   
    
    
    
    
}
