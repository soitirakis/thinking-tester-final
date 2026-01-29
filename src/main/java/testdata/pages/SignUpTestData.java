package testdata.pages;

public class SignUpTestData {
    //messages
    public final static String SIGN_UP_HEADER = "Add User";

    //error
    public final static String INVALID = "User validation failed: ";
    public final static String INVALID_FIRST_NAME = "firstName: Path `firstName` is required.";
    public final static String INVALID_LAST_NAME = "lastName: Path `lastName` is required.";
    public final static String INVALID_EMAIL = "email: Email is invalid";
    public final static String INVALID_EMAIL_ALREADY_IN_USE = "Email address is already in use";
    public final static String INVALID_PASSWORD = "User validation failed: email: Email is invalid, password: Path `password` is required.";
    public final static String INVALID_PASSWORD_MIN_LENGTH = "User validation failed: password: Path `password` (`123`) is shorter than the minimum allowed length (7).";
}
