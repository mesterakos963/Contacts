package codeyard.contacts.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

import codeyard.contacts.R;
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
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
