import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ContactListPage;
import pages.LoginPage;
import testdata.URL;
import testdata.classes.User;

import static testdata.pages.LoginTestData.HEADER_TITLE;


public class BaseTests {
    static WebDriver driver;
    static LoginPage loginPage;
    static ContactListPage contactListPage;

    User mainUser = new User("user");

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver);
        contactListPage = new ContactListPage(driver);
        driver.get(URL.MAIN_URL);

        Assert.assertEquals(loginPage.getHeaderText(), HEADER_TITLE);
    }
  /*  @AfterMethod
    public void afterMethod() {
        DriverFactory.closeDriver();
    }*/
}
