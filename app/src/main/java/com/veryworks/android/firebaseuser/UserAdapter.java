package com.veryworks.android.firebaseuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.veryworks.android.firebaseuser.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<User> data = new ArrayList<>();
    LayoutInflater inflater;

    public UserAdapter(Context context){
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<User> data) {
        this.data = data;
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
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_activity_main, null);
        }
        User user = data.get(position);
        TextView textName  = (TextView) convertView.findViewById(R.id.textName);
        TextView textEmail = (TextView) convertView.findViewById(R.id.textEmail);

        textName.setText(user.username);
        textEmail.setText(user.email);
        return convertView;
    }
}
