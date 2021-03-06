package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().HomePage();
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                            .withFirstname("Oleg")
                            .withSecondname("Nevoyt")
                            .withGroup("test1"),
                    true);
        }
    }

    @Test//(enabled = false)
    public void testContactModification() {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData()
                .withFirstname("Olebas")
                .withSecondname("Nevoyt13");
        app.contact().modify(index, contact);
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
