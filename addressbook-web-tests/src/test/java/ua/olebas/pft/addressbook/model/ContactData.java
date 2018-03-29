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

    @Override
    public String toString() {
        return "ContactData{" +
                "secondname='" + secondname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return secondname != null ? secondname.equals(that.secondname) : that.secondname == null;
    }

    @Override
    public int hashCode() {
        return secondname != null ? secondname.hashCode() : 0;
    }
}
