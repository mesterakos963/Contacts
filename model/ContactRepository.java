package codeyard.contacts.model;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import codeyard.contacts.adapters.ApiClient;
import codeyard.contacts.adapters.ContactsResponse;
import codeyard.contacts.interfaces.ContactService;
import retrofit2.Call;
import retrofit2.Callback;

@EBean(scope = EBean.Scope.Singleton)
public class ContactRepository {

    @Bean
    ApiClient apiClient;

    ContactService contactService;

    public void getData(Callback<ContactsResponse> callback) {
        if (contactService == null) {
            contactService = apiClient.getClient().create(ContactService.class);
        }
        Call<ContactsResponse> call = contactService.listContact(20);
        call.enqueue(callback);
    }
}