package com.example.hp.noticeboard.m_UI;

/**
 * Created by Saurav on 11/8/2016.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.noticeboard.R;
import com.example.hp.noticeboard.m_DataObject.Spacecraft;
import com.example.hp.noticeboard.m_DetailActivity.DetailActivity;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Spacecraft> spacecrafts;


    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.spacecraftImage);


        final Spacecraft s= (Spacecraft) this.getItem(position);

        nameTxt.setText(s.getName());

        PicassoClient.downloadImage(c,s.getImageUrl(),img);


        //  final View finalConvertView = convertView;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAIL ACTIVITY

                //  Toast.makeText(c,s.getName(),Toast.LENGTH_LONG).show();
                // c.startActivity(new Intent(c, DetailActivity.class));


                //    fragmentManager.beginTransaction().add(R.id.containerView,new MeroFragment()).commit();
                //((Activity)c).setTitle("savstha");


                openDetailActivity(s.getName(),s.getPropellant(),s.getDescription(),s.getImageUrl());
            }
        });

        return convertView;
    }

    //OPEN DETAIL ACTIVITY
    private void openDetailActivity(String name,String propellant,String desc,String imageUrl)
    {
        Intent i=new Intent(c, DetailActivity.class);

        //DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("PROPELLANT_KEY",propellant);
        i.putExtra("DESCRIPTION_KEY",desc);
        i.putExtra("IMAGEURL_KEY",imageUrl);

        c.startActivity(i);

    }
}


