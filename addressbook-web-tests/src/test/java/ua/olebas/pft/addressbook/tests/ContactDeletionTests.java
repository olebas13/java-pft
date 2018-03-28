package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Oleg", "Nevoyt", "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before - 1);
        app.getContactHelper().deleteSelectedContacts();
        int after = app.getContactHelper().getContactCount();

        Assert.assertEquals(after, before - 1);
    }
}
