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
import codeyard.contacts.adapters.ApiClient;
import codeyard.contacts.adapters.ContactAdapter;

import codeyard.contacts.adapters.ContactsResponse;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.interfaces.ContactsInterface;
import codeyard.contacts.interfaces.ItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements ItemClickListener {

    private List<Contact> contactList;
    private RecyclerView recyclerView;
    public static String CONTACT_EXTRA;
    private ContactsInterface contactsInterface;

    ContactAdapter adapter;

    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list_activity);
        contactsInterface = ApiClient.getClient().create(ContactsInterface.class);
        adapter = new ContactAdapter(this, new ArrayList<>(), this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Call<ContactsResponse> call = contactsInterface.listContact(20);
        call.enqueue(new Callback<ContactsResponse>() {
            @Override
            public void onResponse(Call<ContactsResponse> call, Response<ContactsResponse> response) {
                if (response.body() != null) {
                    contactList = response.body().getResults();
                    adapter.update(contactList);
                }
            }

            @Override
            public void onFailure(Call<ContactsResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }

    @Override
    public void onItemClick(Contact contact) {
        Intent intent = new Intent(this, ContactDetailsActivity.class);
        intent.putExtra(CONTACT_EXTRA, contact);
        startActivity(intent);
    }
}
