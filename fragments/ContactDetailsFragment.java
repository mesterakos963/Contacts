package codeyard.contacts.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import codeyard.contacts.R;
import codeyard.contacts.data.contact.Contact;
import codeyard.contacts.viewmodels.ContactDetailsViewModel;
import views.MonogramView;

@EFragment(R.layout.fragment_contact_details)
public class ContactDetailsFragment extends Fragment {

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

    @ViewById
    MonogramView monogram;

    @ViewById
    ImageView emailIcon;

    @ViewById
    ImageView workSmsIcon;

    @ViewById
    ImageView smsIcon;

    @ViewById
    ImageView phoneIcon;

    @ViewById
    ImageView workPhoneIcon;

    @Bean
    ContactDetailsViewModel contactDetailsViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            contactDetailsViewModel.setContactDetail(ContactDetailsFragment_Args.fromBundle(getArguments()).getContact());
        }
    }

    @AfterViews
    void init() {
        Contact contact = contactDetailsViewModel.getContactDetail().getValue();
        emailIcon.setOnClickListener(v -> {
            composeEmail(new String[]{contact.getEmail()});
        });

        workSmsIcon.setOnClickListener(view -> composeSmsMessage(""));

        smsIcon.setOnClickListener(view -> composeSmsMessage(""));

        phoneIcon.setOnClickListener(view -> dialPhoneNumber(contact.getPhone()));

        workPhoneIcon.setOnClickListener(view -> dialPhoneNumber(contact.getCell()));

        if (contact != null) {
            userName.setText(contact.getName().getFullName());
            mobilephoneNumber.setText(contact.getPhone());
            workNumber.setText(contact.getCell());
            emailLabel.setText(contact.getEmail());
            Glide.with(userImage.getContext())
                    .load(contact.getPicture().getLarge())
                    .into(userImage);
            monogram.bind(contact);
        }
    }

    public void composeEmail(String[] addresses) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeSmsMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("smsto:"));
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}

