package VirtualProxy;

public class Company {

    private String name;
    private String address;
    private IContactList contactList;

    public Company(String name, String address, IContactList contactList)
    {
        this.name = name;
        this.address = address;
        this.contactList = contactList;
    }

    public String GetName() { return name; }

    public String GetAddress() { return address; }

    public IContactList GetContactList() { return contactList; }

}
