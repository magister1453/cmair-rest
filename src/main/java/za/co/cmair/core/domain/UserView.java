package za.co.cmair.core.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;

/**
 * Created by marc.marais on 2017/05/10.
 */
@Entity
@Immutable
public class UserView extends ResourceSupport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long userViewid;
    @Column(nullable = false, name="first_name")
    private String firstName;
    @Column(nullable = false, name="surname")
    private String surname;
    @Column(nullable = false, name="user_name")
    private String userName;
    @JsonIgnore
    @Column(nullable = false, name="password")
    private String password;
    private Address address;
    private ContactDetails contactDetails;

    public UserView() {
    }

    @JsonCreator
    public UserView(String firstName, String surname, String userName, String password, Address address, ContactDetails contactDetails) {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.contactDetails = contactDetails;
    }

    public Long getUserViewid() {
        return userViewid;
    }

    public void setUserViewid(Long userViewid) {
        this.userViewid = userViewid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}
