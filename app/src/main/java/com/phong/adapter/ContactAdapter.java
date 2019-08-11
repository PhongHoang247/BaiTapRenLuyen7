package com.phong.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.phong.baitaprenluyen7.R;
import com.phong.model.Contact;

public class ContactAdapter extends ArrayAdapter<Contact> {
    Activity context;
    int resource;
    public ContactAdapter(Activity context, int resource) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = this.context.getLayoutInflater().inflate(this.resource, null);

        TextView txtTen = (TextView) customView.findViewById(R.id.txtTen);
        TextView txtSdt = (TextView) customView.findViewById(R.id.txtSdt);
        ImageView imgCall = (ImageView) customView.findViewById(R.id.imgCall);
        ImageView imgSms = (ImageView) customView.findViewById(R.id.imgSms);
        ImageView imgDetail = (ImageView) customView.findViewById(R.id.imgDetail);

        final Contact contact = getItem(position);
        txtTen.setText(contact.getName());
        txtSdt.setText(contact.getSdt());

        imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //contact là biến local: 1 biến local khi đc truy suất trong 1 anomous thì phải khai báo final
                XuLyCall(contact);
            }
        });
        imgSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLySMS(contact);
            }
        });
        imgDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLyDetail(contact);
            }
        });
        return customView;
    }

    private void XuLyDetail(Contact contact) {
        Toast.makeText(this.context, "Bạn muốn xem chi tiết " + contact.getSdt(),Toast.LENGTH_SHORT).show();
    }

    private void XuLySMS(Contact contact) {
        Toast.makeText(this.context, "Bạn muốn nhắn tin cho " + contact.getSdt(),Toast.LENGTH_SHORT).show();
    }

    private void XuLyCall(Contact contact) {
        Toast.makeText(this.context, "Bạn muốn gọi cho " + contact.getSdt(),Toast.LENGTH_SHORT).show();
    }
}
