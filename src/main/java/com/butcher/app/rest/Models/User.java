package com.butcher.app.rest.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;


    @ JsonIgnoreProperties("users")
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_course",
            joinColumns = {
                    @JoinColumn(name = "user_id" , referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "course_id",referencedColumnName = "id")
            }
    )
    private Set<Course> courses = new HashSet<>();

    @JsonIgnoreProperties("users")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private Department department;

    @JsonIgnoreProperties("user")
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomId",referencedColumnName = "id")
    private Room room;




    public
    User(long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
