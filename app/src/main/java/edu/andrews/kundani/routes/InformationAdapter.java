package edu.andrews.kundani.routes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by resident_bluejay on 12/6/17.
 */


public class InformationAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Information> mInformation;

    public InformationAdapter(Context mContext, ArrayList<Information> mInformation) {
        this.mContext = mContext;
        this.mInformation = mInformation;
    }

    @Override
    public int getCount() {
        return mInformation.size();
    }

    @Override
    public Object getItem(int position) {
        return mInformation.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.info_list_item,
                    parent, false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTextView);
        TextView phoneTxt= (TextView) convertView.findViewById(R.id.numberTextView);
        TextView locationTxt= (TextView) convertView.findViewById(R.id.adressTextView);
        final Information s= (Information) this.getItem(position);
        nameTxt.setText(s.getName());
        phoneTxt.setText(s.getPhoneNumber());
        locationTxt.setText(s.getLocation());
        //ONITECLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,s.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
