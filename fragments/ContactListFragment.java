package codeyard.contacts.fragments;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

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

@EFragment(R.layout.fragment_contact_list)
public class ContactListFragment extends Fragment implements ItemClickListener {

    private ContactsInterface contactsInterface;

    @ViewById
    RecyclerView recyclerView;

    ContactAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @AfterViews
    void init() {
        adapter = new ContactAdapter(requireContext(), new ArrayList<>(), this);
        contactsInterface = ApiClient.getClient().create(ContactsInterface.class);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        getData();
    }

    @Override
    public void onItemClick(Contact contact) {
        if (getActivity() != null) {
            NavDirections action =
                    ContactListFragment_Directions.actionContactListFragmentToContactDetailsFragment(contact);
            Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(action);
        }
    }

    public void getData() {
        Call<ContactsResponse> call = contactsInterface.listContact(20);
        call.enqueue(new Callback<ContactsResponse>() {

            @Override
            public void onResponse(Call<ContactsResponse> call, Response<ContactsResponse> response) {
                if (response.body() != null) {
                    List<Contact> contactList = response.body().getResults();
                    adapter.update(contactList);
                }
            }

            @Override
            public void onFailure(Call<ContactsResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
