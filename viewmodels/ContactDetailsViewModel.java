package codeyard.contacts.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.androidannotations.annotations.EBean;

import codeyard.contacts.data.contact.Contact;

@EBean()
public class ContactDetailsViewModel extends ViewModel {

    private MutableLiveData<Contact> contactDetail = new MutableLiveData<>();

    public LiveData<Contact> getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(Contact contact) {
        contactDetail.setValue(contact);
    }
}
