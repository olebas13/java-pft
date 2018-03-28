package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("Olegtjytr", "Nevoyt", "test1"), true);
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
