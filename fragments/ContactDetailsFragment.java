package codeyard.contacts.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import codeyard.contacts.R;
import codeyard.contacts.data.contact.Contact;

public class ContactDetailsFragment extends Fragment {
    Contact contact;
    ImageView image;
    TextView name;
    TextView phoneNumber;
    TextView cellPhoneNumber;
    TextView email;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            contact = ContactDetailsFragmentArgs.fromBundle(getArguments()).getContact();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_details, null);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceStat) {
        if(view != null) {
            image = requireActivity().findViewById(R.id.userImage);
            name = requireActivity().findViewById(R.id.userName);
            phoneNumber = requireActivity().findViewById(R.id.mobilephoneNumber);
            cellPhoneNumber = requireActivity().findViewById(R.id.workNumber);
            email = requireActivity().findViewById(R.id.emailLabel);
        }
        name.setText(contact.getName().getFullName());
        phoneNumber.setText(contact.getPhone());
        cellPhoneNumber.setText(contact.getCell());
        email.setText(contact.getEmail());
        Glide.with(image.getContext())
                .load(contact.getPicture().getLarge())
                .into(image);
    }
}

