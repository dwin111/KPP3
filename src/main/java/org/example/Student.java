package org.example;

import java.io.Serializable;

public class Student implements Serializable {
    public String name;
    public transient int room; // поле, яке не буде серіалізовано
    public double payment;
    public Address address;
    private boolean hasDiscount;
    public Student(String name, int room, double payment, Address address,boolean hasDiscount) {
        this.name = name;
        this.room = room;
        this.payment = payment;
        this.address = address;
        this.hasDiscount = hasDiscount;
    }
    public Student()
    {
        this.name = "Name";
        this.room = 0;
        this.payment = 0.0;
        this.address = new Address();
    }

    public int getRoom() {
        return room;
    }

    public String getName()
    {
        return this.name;
    }
    public Address getAddress()
    {
        return this.address;
    }
    public double getPayment()
    {
        return this.payment;
    }

    public boolean getDiscount()
    {
        return this.hasDiscount;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public  void setRoom(int room)
    {
        this.room = room;
    }
    public void setAddress(Address address)
    {
        this.address = address;
    }

    public void setPayment(double payment)
    {
        this.payment = payment;
    }
    @Override
    public String toString() {
        return "Student{" + "name='" + name + "', room=" + room + ", payment=" + payment + ", address=" + address + '}';
    }
}