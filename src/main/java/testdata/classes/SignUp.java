package testdata.classes;

import utils.Reader;

public class SignUp {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public  SignUp(String filename) {
        this.firstName = Reader.json(filename).get("firstName").toString();
        this.lastName = Reader.json(filename).get("lastName").toString();
        this.email = Reader.json(filename).get("email").toString();
        this.password = Reader.json(filename).get("password").toString();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
