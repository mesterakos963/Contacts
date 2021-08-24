package codeyard.contacts.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import codeyard.contacts.R;
import codeyard.contacts.data.Picture;
import codeyard.contacts.data.contact.Contact;

public class ContactDetailsActivity extends Activity {

    Contact contact;
    ImageView image;
    TextView name;
    TextView phoneNumber;
    TextView cellPhoneNumber;
    TextView email;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);
        if(getIntent().hasExtra(MainActivity.CONTACT_EXTRA)) {
            contact = (Contact) getIntent().getSerializableExtra(MainActivity.CONTACT_EXTRA);
            image = findViewById(R.id.userImage);
            name = findViewById(R.id.userName);
            phoneNumber = findViewById(R.id.mobilephoneNumber);
            cellPhoneNumber = findViewById(R.id.workNumber);
            email = findViewById(R.id.email);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(getIntent().hasExtra(MainActivity.CONTACT_EXTRA)) {
            contact = (Contact) getIntent().getSerializableExtra(MainActivity.CONTACT_EXTRA);
            name.setText(contact.getName().getFullName());
            phoneNumber.setText(contact.getPhone());
            cellPhoneNumber.setText(contact.getCell());
            email.setText(contact.getEmail());
            Glide.with(image.getContext())
                    .load(contact.getPicture().getLarge())
                    .into(image);
        }
    }
}
