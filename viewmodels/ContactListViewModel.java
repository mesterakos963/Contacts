package codeyard.contacts.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import codeyard.contacts.adapters.ContactsResponse;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.model.ContactRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EBean()
public class ContactListViewModel extends ViewModel {

    @Bean
    ContactRepository contactRepository;

    private final MutableLiveData<List<Contact>> contacts = new MutableLiveData<>();
    private final MutableLiveData<Throwable> error = new MutableLiveData<>();

    public LiveData<List<Contact>> getContacts() {
        return contacts;
    }

    public LiveData<Throwable> getError() {
        return error;
    }

    public void fetchContacts() {
        contactRepository.getData(new Callback<ContactsResponse>() {
            @Override
            public void onResponse(Call<ContactsResponse> call, Response<ContactsResponse> response) {
                contacts.postValue(response.body().getResults());
            }

            @Override
            public void onFailure(Call<ContactsResponse> call, Throwable t) {
                error.postValue(t);
            }
        });

    }
}
