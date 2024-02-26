package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listContact;

    private Button btnThem, btnXoa;

    private EditText hoten, sdt;

    private List<Contact> lst;

    private ContactAdapter adapter;

    private int staticInt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listContact = findViewById(R.id.lstContact);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        hoten = findViewById(R.id.eHoTen);
        sdt = findViewById(R.id.eSdt);
        lst = new ArrayList<Contact>();
        adapter = new ContactAdapter(this, lst);
        listContact.setAdapter(adapter);
        //String phonePattern = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
        //String phoneNumber = sdt.getText().toString().trim();
        listContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "true", Toast.LENGTH_SHORT).show();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lst.add(new Contact(staticInt++,hoten.getText().toString(), sdt.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                List<Contact> contactsToRemove = new ArrayList<>();
                for (Contact c : lst) {
                    if (c.isStatus()) {
                        contactsToRemove.add(c);
                    }
                }
                lst.removeAll(contactsToRemove);
                adapter.notifyDataSetChanged();
            }
        });
    }
}