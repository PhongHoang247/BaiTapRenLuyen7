package com.phong.baitaprenluyen7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.phong.adapter.ContactAdapter;
import com.phong.model.Contact;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        fakeData();
    }

    private void fakeData() {
        Random rd = new Random();
        for (int i = 0; i < 500; i++)
        {
            Contact contact = new Contact();
            contact.setName("Tên " + i);
            String phone = "098";
            int x = rd.nextInt(3);
            if (x == 1)
            {
                phone = "090";
            }
            else if (x == 2)
            {
                phone = "094";
            }
            //Làm ngẫu nhiên sđt:
            for (int p = 0; p < 7; p++)
            {
                phone += rd.nextInt(10);
            }
            contact.setSdt(phone);
            //Đẩy contact vào Adapter:
            contactAdapter.add(contact);
        }
    }

    private void addControls() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.item);
        //Gán Adapter cho Contact:
        lvContact.setAdapter(contactAdapter);
    }
}
