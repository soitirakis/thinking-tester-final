import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactListPage;
import pages.EditContactPage;
import testdata.classes.EditContact;

import java.util.List;

import static testdata.pages.ContactDetailsTestData.CONTACT_DETAILS_HEADER;
import static testdata.pages.ContactListTestData.CONTACT_LIST_HEADER;

public class EditContactTests extends BaseTests{
    ContactDetailsPage contactDetailsPage;
    EditContactPage editContactPage;
    EditContact editUser = new EditContact("editNewContact");
    String nameToEdit = "name1";

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();

        loginPage.authenticate(mainUser);
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), CONTACT_LIST_HEADER);

        contactDetailsPage = new ContactDetailsPage(driver);
        contactListPage.clickNameCellValue(nameToEdit);
    }
    @Test
    public void onCorrectContact() {
        Assert.assertEquals(contactDetailsPage.getHeaderText(), CONTACT_DETAILS_HEADER);
        Assert.assertEquals(contactDetailsPage.getFirstNameValue(), nameToEdit);
    }
    @Test
    public void editContact() {
        editContactPage = new EditContactPage(driver);
        contactDetailsPage.editContactDetails();

        Assert.assertEquals(editContactPage.getHeaderText(), "Edit Contact");
        List<String> inputValues = editContactPage.getInputValues();
        System.out.println(inputValues);
        Assert.assertTrue(inputValues.contains(nameToEdit));

        editContactPage.editContact(editUser);
        Assert.assertEquals(contactDetailsPage.getHeaderText(), CONTACT_DETAILS_HEADER );

        //check values to have the same names etc
        //return to contactlistpage
        //check name present on page.
    }
}
