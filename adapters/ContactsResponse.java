package codeyard.contacts.adapters;


import java.util.List;

import codeyard.contacts.data.contact.Contact;

public class ContactsResponse {
     private List<Contact> results;

     public List<Contact> getResults() {
         return this.results;
     }
}
