package com.example.lab2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> lst;
    private Context context;
    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
        this.context = context;
        lst = objects;
    }
    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return lst.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lst.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null)
        {
            v = LayoutInflater.from(context).inflate(R.layout.contact_item,parent,false);
        }

        Contact contact = (Contact) getItem(position);
        v.setClickable(true);
        TextView phone = v.findViewById(R.id.txtSdt), name = v.findViewById(R.id.txtTen);
        CheckBox checkBox = v.findViewById(R.id.checkBox);
        checkBox.setChecked(contact.isStatus());
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            contact.setStatus(isChecked);
        });

        phone.setText(contact.getPhone());
        name.setText(contact.getName());
        return v;
    }
}
