package codeyard.contacts.interfaces;

import codeyard.contacts.adapters.ContactsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ContactsInterface {

    @GET("/api/")
    Call<ContactsResponse> listContact(@Query("results") Integer limit);

}
