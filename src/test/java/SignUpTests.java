import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignUpPage;
import testdata.classes.SignUp;

import static testdata.pages.ContactListTestData.CONTACT_LIST_HEADER;
import static testdata.pages.LoginTestData.HEADER_TITLE;
import static testdata.pages.SignUpTestData.*;

public class SignUpTests extends BaseTests{
    static SignUpPage signUpPage;

    static SignUp signUpFile;

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();

        signUpPage = new SignUpPage(driver);
        Assert.assertEquals(loginPage.getHeaderText(), HEADER_TITLE);
        loginPage.clickSignUp();

        Assert.assertEquals(signUpPage.getHeaderText(), SIGN_UP_HEADER);
    }
    @Test
    public void testValidSignUp(){
        String userEmail = signUpFile.getEmail();
        String userPassword = signUpFile.getPassword();

        signUpFile = new SignUp("signUpValidUser");
        signUpPage.createNewAccount(signUpFile);
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), CONTACT_LIST_HEADER);
    }
    @Test
    public void testEmailAlreadyExist() throws InterruptedException{
        signUpFile = new SignUp("signUpValidUser");
        signUpPage.createNewAccount(signUpFile);

        Assert.assertEquals(signUpPage.getErrorMessage(), INVALID_EMAIL_ALREADY_IN_USE);
    }
    @Test
    public void testEmailAlreadyInUse() throws InterruptedException{
        signUpFile = new SignUp("signUpValidUser");

        signUpPage.createNewAccount(signUpFile);
        Assert.assertEquals(signUpPage.getErrorMessage(), INVALID_EMAIL_ALREADY_IN_USE);
    }
    @Test
    public void testPasswordInvalidLength() throws InterruptedException{
        signUpFile = new SignUp("signUpInvalidPasswordMinLength");

        signUpPage.createNewAccount(signUpFile);
        Assert.assertEquals(signUpPage.getErrorMessage(), INVALID_PASSWORD_MIN_LENGTH);
    }
    @Test
    public void testMissingData() throws InterruptedException{
        signUpFile = new SignUp("signUpEmptyData");

        signUpPage.createNewAccount(signUpFile);
        Assert.assertEquals(signUpPage.getErrorMessage(), INVALID_FIRST_NAME);
    }
}
