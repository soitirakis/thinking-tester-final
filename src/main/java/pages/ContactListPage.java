package pages;

import driver.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static testdata.pages.ContactListTestData.CONTACT_LIST_HEADER;

public class ContactListPage extends BasePage {

    public ContactListPage(WebDriver driver) {
        super(driver);
    }

    //elements
    private By header = By.xpath("//h1");
    private By logoutButton = By.id("logout");
    private By addNewContactButton = By.id("add-contact");

    //table locators
    private By nameColumn = By.xpath("//tr/td[2]");
    private By nameCellValue(String name) {
        return By.xpath("//tr/td[contains(., \""+name+"\")]");
    }
    private By emailCell(String name) {
        return By.xpath("//tr/td[contains(.,\""+name+"\")]/following-sibling::td[2]");
    }
    private By rowElements(String name) {
        return By.xpath("//tr[contains(.,\""+name+"\")]");
    }

    //actions
    public boolean isLogoutDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }
    public String getHeaderText() {
        WaitUtils.textToBePresentInElementLocated(header, CONTACT_LIST_HEADER);
        return driver.findElement(header).getText();
    }
    public void  clickAddNewContactButton() {
        driver.findElement(addNewContactButton).click();
    }

    //table actions
    public List<String> getNameColumnValues(){
        List<WebElement> nameElements = driver.findElements(nameColumn);
        List<String> nameColumnValues = new ArrayList<>();
        for (WebElement element : nameElements){
            nameColumnValues.add(element.getText());
        }
        return nameColumnValues;
    }
    public void clickNameCellValue(String name){
        driver.findElement(nameCellValue(name)).click();
    }
    public String getEmailCellValue(String name){
        return driver.findElement(emailCell(name)).getText();
    }
    public void clickOnRowElements(String name){
        driver.findElement(rowElements(name)).click();
    }
}
