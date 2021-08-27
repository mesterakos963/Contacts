package codeyard.contacts.model;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import codeyard.contacts.adapters.ApiClient;
import codeyard.contacts.adapters.ContactsResponse;
import codeyard.contacts.interfaces.ContactsInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@EBean(scope = EBean.Scope.Singleton)
public class ContactRepository {

    @Bean
    ApiClient apiClient;

    ContactsInterface contactsInterface;

    public void getData(Callback<ContactsResponse> callback) {

        if (contactsInterface == null) {
            contactsInterface = apiClient.getClient().create(ContactsInterface.class);
        }
        Call<ContactsResponse> call = contactsInterface.listContact(20);
        call.enqueue(new Callback<ContactsResponse>() {
            @Override
            public void onResponse(Call<ContactsResponse> call, Response<ContactsResponse> response) {
                if (response.body() != null) {
                    callback.onResponse(call, response);
                }
            }

            @Override
            public void onFailure(Call<ContactsResponse> call, Throwable t) {
                call.cancel();
                callback.onFailure(call, t);
            }
        });

    }
}