package org.example;
import java.io.Serializable;
public class Address implements Serializable {
    public String city;
    public String street;
    public Address(String city, String street) {
        this.city = city;
        this.street = street;
    }
    public Address()
    {
        this.city = "city";
        this.street = "street";
    }
    public String getCity()
    {
        return this.city;
    }
    public String getStreet()
    {
        return this.street;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setStreet(String street)
    {
        this.street = street;
    }
    @Override
    public String toString() {
        return "Address{" + "city='" + city + "', street='" + street + "'}";
    }
}