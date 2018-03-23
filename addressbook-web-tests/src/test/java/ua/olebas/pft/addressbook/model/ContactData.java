package ua.olebas.pft.addressbook.model;


public class ContactData {

    private String firstname;
    private String secondname;
    private String group;

    public ContactData(String firstname, String secondname, String group) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.group = group;
    }


    public String getFirstname() {
        return firstname;
    }


    public String getLastname() {
        return secondname;
    }

    public String getGroup() {
        return group;
    }
}
