package za.co.cmair.core.domain;

import javax.persistence.*;

/**
 * Created by marc.marais on 2017/05/10.
 */
@Embeddable
public class Address {
    @Column(nullable = false, name="address")
    private String address;
    @Column(nullable = false, name="city")
    private String city;
    @Column(nullable = false, name="country")
    private String country;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
