package za.co.cmair.core.domain;

import javax.persistence.*;

/**
 * Created by marc.marais on 2017/05/10.
 */
@Embeddable
public class ContactDetails {
    @Column(nullable = false, name="tel_number")
    private String telNumber;
    @Column(nullable = false, name="cell_number")
    private String cellNumber;
    @Column(nullable = false, name="email")
    private String email;

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
