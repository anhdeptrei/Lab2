package com.example.lab2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ArrayList<Contact> contacts ;
    private Adapter contactAdapter;
    private Button btnThem;
    private Button btnXoa;
    private ListView listView;
    public int id=4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem=findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        listView = findViewById(R.id.listView);
        initData();
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Contact> deletecontact = new ArrayList<>();
                for (Contact c:contacts){
                    if (c.isStatus()){
                        deletecontact.add(c);
                    }
                }
            contacts.removeAll(deletecontact);
            contactAdapter.notifyDataSetChanged();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddContactActivity.class);
                startActivityForResult(intent,100);

            }
        });
    }
    private void initData(){
        contacts=new ArrayList<>();
        contacts.add(new Contact(1,"Mot","34567"));
        contacts.add(new Contact(2,"Hai","0987"));
        contacts.add(new Contact(3,"Ba","56789"));
        contactAdapter = new Adapter(contacts,this);
        listView.setAdapter(contactAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        String name = bundle.getString("hoten");
        String phone = bundle.getString("sdt");
        Contact contact = new Contact(id++,name,phone);
        if(requestCode==100 && resultCode==150){
            contacts.add(contact);
            contactAdapter.notifyDataSetChanged();
        }
    }
}