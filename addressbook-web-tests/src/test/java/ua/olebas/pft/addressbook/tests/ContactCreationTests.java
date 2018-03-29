package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test//(enabled = false)
    public void testContactCreation() {
        app.goTo().HomePage();
        List<ContactData> before = app.contact().list();
        app.contact().create(new ContactData()
                .withFirstname("Oleg")
                .withSecondname("Nevoyt")
                .withGroup("test1"),
                true);
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
