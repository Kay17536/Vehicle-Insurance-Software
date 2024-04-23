package Policy;

import java.io.Serializable;

public class Customer implements Serializable {
    public static String name, city;
    public static int c_phone, nId;
    Policy policy;

    public Customer() {
    }

    public Customer(String name, int nId, String city, int c_phone, Policy policy) {
        this.name = name;
        this.nId = nId;
        this.city = city;
        this.c_phone = c_phone;
        this.policy = policy;
    }

    public static void setName(String name) {
        Customer.name = name;
    }

    public static void setCity(String city) {
        Customer.city = city;
    }

    public static void setC_phone(int c_phone) {
        Customer.c_phone = c_phone;
    }

    public static void setnId(int nId) {
        Customer.nId = nId;
    }

    public String getname() {
        return name;
    }

    public int getnId() { return nId;
    }

    public String getCity() {
        return city;
    }

    public int getC_phone() {
        return c_phone;
    }

    public Policy getPolicy() {
        return policy;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "ID: " + nId + '\n' +
                "City: " + city + '\n' +
                "Phone No: " + c_phone + '\n';

    }

}