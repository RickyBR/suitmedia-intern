package com.example.suitmedia_intent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;


public class DataAdapter extends ArrayAdapter<Data> {
     Context context;
     List<Data> arrayListData;
    public DataAdapter(@NonNull Context context, List<Data> arrayListData) {
        super(context, R.layout.list_user, arrayListData);
        this.context = context;
        this.arrayListData = arrayListData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, null,true);

        TextView id = view.findViewById(R.id.tv_id);
        TextView first_name = view.findViewById(R.id.tv_firstN);
        TextView last_name = view.findViewById(R.id.tv_lastN);
        ImageView img_user = view.findViewById(R.id.img_user);

        id.setText(arrayListData.get(position).getId());
        first_name.setText(arrayListData.get(position).getFirst_name());
        last_name.setText(arrayListData.get(position).getLast_name());

        Glide.with(context).load(arrayListData.get(position).getAvatar()).into(img_user);
        return view;
    }
}
