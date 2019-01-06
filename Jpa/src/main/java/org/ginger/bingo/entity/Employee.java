package org.ginger.bingo.entity;

import javax.persistence.*;

@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String name;

    private double salary;

    private String deg;

    public Employee() {

    }

    public Employee(int id, String name, double salary, String deg) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.deg = deg;
    }

    public int getEid() {
        return id;
    }

    public void setEid(int eid) {
        this.id = eid;
    }

    public String getEname() {
        return name;
    }

    public void setEname(String ename) {
        this.name = ename;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + id +
                ", ename='" + name + '\'' +
                ", salary=" + salary +
                ", deg='" + deg + '\'' +
                '}';
    }
}
