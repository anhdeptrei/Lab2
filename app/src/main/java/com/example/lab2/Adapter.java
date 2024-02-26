package com.example.lab2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adapter extends BaseAdapter implements Filterable {
    private ArrayList<Contact> data;
    private ArrayList<Contact>databackup;
    private Activity context;
    private LayoutInflater inflater;

    public Adapter(ArrayList<Contact> data, Activity activity) {
        this.data = data;
        this.inflater = (LayoutInflater) activity.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return data.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(v==null){
            v=inflater.inflate(R.layout.contact_item,null);
        }
        Contact contact =(Contact) getItem(position);
        v.setClickable(true);
        TextView tvName = v.findViewById(R.id.txtName);
        TextView tvPhone = v.findViewById(R.id.txtPhone);
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhonenumber());
        CheckBox cb = v.findViewById(R.id.checkBox);
        cb.setChecked(contact.isStatus());
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                contact.setStatus(isChecked);
            }
        });
        return v;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
