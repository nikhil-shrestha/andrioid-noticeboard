package com.example.hp.noticeboard.m_DetailActivity;

/**
 * Created by saurav on 10/28/2016.
 */


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.noticeboard.R;
import com.example.hp.noticeboard.m_UI.PicassoClient;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt, propTxt, descTxt;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        nameTxt = (TextView) findViewById(R.id.nameTxtDetail);
        propTxt = (TextView) findViewById(R.id.propellantTxtDetail);
        descTxt = (TextView) findViewById(R.id.descDetailTxt);
        img = (ImageView) findViewById(R.id.spacecraftImageDetail);

        //RECEIVE DATA
        Intent i = this.getIntent();
        String name = i.getExtras().getString("NAME_KEY");
        String prop = i.getExtras().getString("PROPELLANT_KEY");
        String desc = i.getExtras().getString("DESCRIPTION_KEY");
        final String imageurl = i.getExtras().getString("IMAGEURL_KEY");

        //BIND
        nameTxt.setText(name);
        propTxt.setText(prop);
        descTxt.setText(desc);
        PicassoClient.downloadImage(this, imageurl, img);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageActivity(imageurl);
            }
        });
    }
    private void openImageActivity(String imageUrl)
    {
        Intent i=new Intent(this, Image.class);

        i.putExtra("Imageurl",imageUrl);

        startActivity(i);

    }

}

