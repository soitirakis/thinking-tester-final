package testdata.classes;

import utils.Reader;

public class EditContact {
    private String firstName;
    private String lastName;
    private String dob;
    private String email;
    private String phone;
    private String street1;
    private String street2;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String country;

    public EditContact(String filename) {
        this.firstName = Reader.json(filename).get("firstName").toString();
        this.lastName = Reader.json(filename).get("lastName").toString();
        this.dob = Reader.json(filename).get("dob").toString();
        this.email = Reader.json(filename).get("email").toString();
        this.phone = Reader.json(filename).get("phone").toString();
        this.street1 = Reader.json(filename).get("street1").toString();
        this.street2 = Reader.json(filename).get("street2").toString();
        this.postalCode = Reader.json(filename).get("postalCode").toString();
        this.city = Reader.json(filename).get("city").toString();
        this.stateProvince = Reader.json(filename).get("stateProvince").toString();
        this.country = Reader.json(filename).get("country").toString();
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
