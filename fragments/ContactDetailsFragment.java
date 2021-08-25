package codeyard.contacts.fragments;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import codeyard.contacts.R;
import codeyard.contacts.data.contact.Contact;

@EFragment(R.layout.fragment_contact_details)
public class ContactDetailsFragment extends Fragment {

    Contact contact;

    @ViewById
    ImageView userImage;

    @ViewById
    TextView userName;

    @ViewById
    TextView mobilephoneNumber;

    @ViewById
    TextView workNumber;

    @ViewById
    TextView emailLabel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            contact = ContactDetailsFragment_Args.fromBundle(getArguments()).getContact();
        }
    }

    @AfterViews
    void init() {
        userName.setText(contact.getName().getFullName());
        mobilephoneNumber.setText(contact.getPhone());
        workNumber.setText(contact.getCell());
        emailLabel.setText(contact.getEmail());
        Glide.with(userImage.getContext())
                .load(contact.getPicture().getLarge())
                .into(userImage);
    }
}

