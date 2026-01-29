package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.classes.SignUp;

import static testdata.pages.AddNewContactTestData.ADD_NEW_CONTACT_HEADER;
import static testdata.pages.SignUpTestData.SIGN_UP_HEADER;

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    //elements
    private By errorMessage = By.id("error");
    private By header = By.xpath("//h1");
    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");

    //actions
    public String getHeaderText() {
        WaitUtils.textToBePresentInElementLocated(header, SIGN_UP_HEADER);
        return driver.findElement(header).getText();
    }
    public String getErrorMessage() throws InterruptedException {
        Thread.sleep(1000);
        return driver.findElement(errorMessage).getText();
    }
    public void addFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }
    public void addLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }
    public void addEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public void createNewAccount(String firstName, String lastName, String email, String password) {
        addFirstName(firstName);
        addLastName(lastName);
        addEmail(email);
        enterPassword(password);
        clickSubmitButton();
    }
    public void createNewAccount(SignUp signUp) {
        addFirstName(signUp.getFirstName());
        addLastName(signUp.getLastName());
        addEmail(signUp.getEmail());
        enterPassword(signUp.getPassword());
        clickSubmitButton();
    }

}
