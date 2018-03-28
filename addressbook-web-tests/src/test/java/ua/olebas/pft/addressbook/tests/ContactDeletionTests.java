package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Oleg", "Nevoyt", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);
    }
}
