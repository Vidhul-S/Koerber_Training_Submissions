package day3_4LabAssignment.serialisation;

import java.io.Serializable;

public class Address implements Serializable {
    private String address;
    public Address(String address){

        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
