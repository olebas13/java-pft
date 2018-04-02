package ua.olebas.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.olebas.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test//(enabled = false)
    public void testContactCreation() {
        app.goTo().HomePage();
        List<ContactData> before = app.contact().list();
        File photo = new File("src\\test\\resources\\bart.png");
        ContactData contact = new ContactData().withFirstname("Oleg").withSecondname("Nevoyt").withGroup("test1").withPhoto(photo);
        app.contact().create(contact, true);
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
