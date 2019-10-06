package com.example.hp.noticeboard.m_DetailActivity;


/**
 * Created by saurav on 10/28/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.hp.noticeboard.R;
import com.example.hp.noticeboard.m_UI.PicassoClient;

public class Image extends AppCompatActivity {
    ImageView Dimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Dimg= (ImageView) findViewById(R.id.detailImage);
        Intent i=this.getIntent();
        final String imageurl=i.getExtras().getString("Imageurl");


       // downlaod image to detail
      PicassoClient.downloadImage(this,imageurl,Dimg);
    }
}
