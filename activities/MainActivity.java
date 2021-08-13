package codeyard.contacts.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import codeyard.contacts.R;
import codeyard.contacts.adapters.ContactAdapter;
import codeyard.contacts.data.Location;
import codeyard.contacts.data.Name;
import codeyard.contacts.data.Picture;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.interfaces.ItemClickListener;

public class MainActivity extends Activity implements ItemClickListener {

    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemClickListener itemClickListener;

    ContactAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_activity);
        populateList();
        adapter = new ContactAdapter(this, contactList, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void populateList() {
        Name name = new Name(null, "Ross", "Reynolds");
        Location location = new Location("Kilcoole", "New Road");
        Picture picture = new Picture("https://randomuser.me/api/portraits/men/37.jpg");

        Contact contact1 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact2 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact3 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact4 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact5 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact6 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact7 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact8 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact9 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact10 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact11 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact12 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact13 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact14 = new Contact(name, "ross.reynold@random.com", location, picture);
        Contact contact15 = new Contact(name, "ross.reynold@random.com", location, picture);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);
        contactList.add(contact7);
        contactList.add(contact8);
        contactList.add(contact9);
        contactList.add(contact10);
        contactList.add(contact11);
        contactList.add(contact12);
        contactList.add(contact13);
        contactList.add(contact14);
        contactList.add(contact15);
    }

    @Override
    public void onItemClick(Contact contact) {
        Intent intent = new Intent(this, )
    }
}
