package addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactGroup> {
    private Set<ContactGroup> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactGroup>(contacts.delegate);
    }

    public Contacts() {
    this.delegate = new HashSet<ContactGroup>();
    }

    @Override
    protected Set<ContactGroup> delegate() {
        return delegate;
    }
    public Contacts withAdded(ContactGroup group){
        Contacts contacts = new Contacts(this);
        contacts.add(group);
        return contacts;
    }
    public Contacts withoutAdded(ContactGroup group){
        Contacts contacts = new Contacts(this);
        contacts.remove(group);
        return contacts;
    }
}
