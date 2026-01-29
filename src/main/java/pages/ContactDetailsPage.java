package pages;

import driver.WaitUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static testdata.pages.ContactDetailsTestData.CONTACT_DETAILS_HEADER;

public class ContactDetailsPage extends BasePage{

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    //elements
    private By header = By.xpath("//h1");
    private By editButton = By.id("edit-contact");
    private By deleteButton = By.id("delete");
    private By returnToContactListButton = By.id("return");

    private By firstNameValue = By.id("firstName");
    private By lastNameValue = By.id("lastName");
    private By dateOfBirthValue = By.id("birthdate");
    private By emailValue = By.id("email");
    private By phoneValue = By.id("phone");
    private By street1Value = By.id("street1");
    private By street2Value = By.id("street2");
    private By cityValue = By.id("city");
    private By stateValue = By.id("stateProvince");
    private By postalCodeValue = By.id("postalCode");
    private By countryValue = By.id("country");


    //actions
    public String getHeaderText() {
        WaitUtils.textToBePresentInElementLocated(header, CONTACT_DETAILS_HEADER);
        WaitUtils.visibilityOfElementLocated(header);
        return driver.findElement(header).getText();
    }
    public void editContactDetails() {
        driver.findElement(editButton).click();
    }
    public void deleteContactDetails() {
        driver.findElement(deleteButton).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public void clickReturnToContactListButton() {
        driver.findElement(returnToContactListButton).click();
    }
    public String getFirstNameValue() {
        WaitUtils.visibilityOfElementLocated(firstNameValue);
        return  driver.findElement(firstNameValue).getText();
    }

}
