package VirtualProxy;

import java.util.ArrayList;
import java.util.List;

public class ContactListProxy implements IContactList
{
    //this ContactList object is null until you are asking for the Employee List for the first time.
    private ContactList contactList;

    @Override
    public ArrayList<Employee> GetEmployeeList()
    {
        //if this is the first time asking for the employee list
        if(contactList == null)
        {
            System.out.println("Fetching list of employees.");
            contactList = new ContactList();
        }
        //return the already fetched employee list
        return contactList.GetEmployeeList();
    }
}
