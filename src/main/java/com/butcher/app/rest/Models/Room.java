package com.butcher.app.rest.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String roomNumber;
    @Column
    private String roomType ;
    @Column
    private double nightCost;

    @JsonIgnoreProperties("room")
    @OneToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;

    public Room(long id, String roomNumber, String roomType, double nightCost, boolean clean, boolean empty) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightCost = nightCost;
    }

    public Room() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getNightCost() {
        return nightCost;
    }

    public void setNightCost(double nightCost) {
        this.nightCost = nightCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
