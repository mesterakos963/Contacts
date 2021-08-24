package codeyard.contacts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import codeyard.contacts.fragments.ContactListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
