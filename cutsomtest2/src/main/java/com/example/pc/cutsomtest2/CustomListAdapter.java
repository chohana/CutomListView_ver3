package com.example.pc.cutsomtest2;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by letscombine_hana on 2016-03-10.
 */
public class CustomListAdapter extends BaseAdapter{
    Context context;
    ArrayList<String> Items = null;
    ArrayList<String> copyItems;


    CustomListAdapter(Context context, ArrayList<String> Items){
        this.context = context;
        //원본 데이터
        this.Items = Items;
        // 사본 데이터
        this.copyItems = new ArrayList<>();
        this.copyItems.addAll(Items); // 사본 데이터
    }

    @Override
    public int getCount() {
        return Items.size();
    }

    @Override
    public Object getItem(int position) {
        return Items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
        }

        ImageView img = (ImageView)convertView.findViewById(R.id.icon);
        img.setImageResource(R.mipmap.ic_launcher);

        TextView listText = (TextView)convertView.findViewById(R.id.listText);
        listText.setText(Items.get(position));
        String msg = Items.get(position); // 추가

        return convertView;
    }


    //filter 불러주는거
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Items.clear();
        if (charText.length() == 0) {
            Items.addAll(copyItems);
        }
        else {
            for (String data : copyItems) {
                if (data.toLowerCase(Locale.getDefault()).contains(charText)) {
                    Items.add(data);
                }
            }
        }
        notifyDataSetChanged();
    }





}


