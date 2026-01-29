import org.junit.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddNewContactPage;
import pages.BasePage;
import testdata.classes.NewContact;

import java.util.List;

import static testdata.pages.AddNewContactTestData.ADD_NEW_CONTACT_HEADER;
import static testdata.pages.AddNewContactTestData.MISSING_MANDATORY_FIELDS;
import static testdata.pages.ContactListTestData.CONTACT_LIST_HEADER;
import static testdata.pages.LoginTestData.HEADER_TITLE;

public class AddNewContactTests extends BaseTests {
    static AddNewContactPage addNewContactPage;

    NewContact newContact;


    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        addNewContactPage = new AddNewContactPage(driver);
        Assert.assertEquals(loginPage.getHeaderText(), HEADER_TITLE);

        loginPage.authenticate(mainUser);
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), CONTACT_LIST_HEADER);

        contactListPage.clickAddNewContactButton();
        Assert.assertEquals(addNewContactPage.getHeaderText(), ADD_NEW_CONTACT_HEADER);
    }
    @Test
    public void testAddNewContactAllData() {
        newContact = new NewContact("newAccount1");
        addNewContactPage.addNewContact(newContact);
        String firstName = newContact.getFirstName();
        String lastName = newContact.getLastName();

        List<String> names = contactListPage.getNameColumnValues();
        System.out.println(names.toString());
        Assert.assertTrue(names.contains(firstName+" "+lastName));
    }
    @Test
    public void testAddNewContactRequiredData() {
        newContact = new NewContact("newAccountMandatoryFields");
        addNewContactPage.addNewContact(newContact);
        String firstName = newContact.getFirstName();
        String lastName = newContact.getLastName();

        List<String> names = contactListPage.getNameColumnValues();
        Assert.assertTrue(names.contains(firstName+" "+lastName));
    }
    @Test
    public void testMissingRequiredFields() throws InterruptedException {
        newContact = new NewContact("newAccountMissingRequiredFields");
        addNewContactPage.addNewContact(newContact);

        Assert.assertEquals(addNewContactPage.getErrorMessage(), MISSING_MANDATORY_FIELDS);
    }

}
