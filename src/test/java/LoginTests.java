import org.testng.Assert;
import org.testng.annotations.Test;
import testdata.classes.User;

import static testdata.pages.ContactListTestData.CONTACT_LIST_HEADER;
import static testdata.pages.LoginTestData.HEADER_TITLE;
import static testdata.pages.LoginTestData.INVALID_USERNAME_PASSWORD;

public class LoginTests extends BaseTests{
    @Test
    public void loginValidDataTest(){
        loginPage.authenticate(mainUser);

        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), CONTACT_LIST_HEADER);
    }
    @Test
    public void loginInvalidDataTest() throws InterruptedException{
        User invalidUser = new User("userInvalid");
        Assert.assertEquals(loginPage.getHeaderText(), HEADER_TITLE);

        loginPage.authenticate(invalidUser);
        Assert.assertEquals(loginPage.getError(), INVALID_USERNAME_PASSWORD);
    }
    @Test
    public void loginMissingDataTest() throws InterruptedException{
        User emptyUser = new User("userEmptyData");
        Assert.assertEquals(loginPage.getHeaderText(), HEADER_TITLE);

        loginPage.authenticate(emptyUser);
        Assert.assertEquals(loginPage.getError(), INVALID_USERNAME_PASSWORD);
    }
}
