package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddContactActivity extends AppCompatActivity {
    private Adapter contactAdapter;
    private Button btnThem;
    private EditText hoten, sdt;
//    ArrayList<Contact> contacts = (ArrayList<Contact>) getIntent().getExtras().get("contacts");
    Intent intent = new Intent();
    Contact contact;

//    Intent intent = new Intent(AddContactActivity.this,MainActivity.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        btnThem=findViewById(R.id.button);
        hoten = findViewById(R.id.hoten);
        sdt = findViewById(R.id.sdt);
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                contact = new Contact(4,hoten.getText().toString(),sdt.getText().toString());
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("newcontact",contact);
//                intent.putExtras(bundle);
                Bundle bundle = new Bundle();
                bundle.putString("hoten",hoten.getText().toString());
                bundle.putString("sdt",sdt.getText().toString());
                intent.putExtras(bundle);
                setResult(150,intent);
                finish();
            }
        });
    }
}