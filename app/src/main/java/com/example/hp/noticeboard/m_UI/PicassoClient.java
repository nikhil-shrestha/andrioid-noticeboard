package com.example.hp.noticeboard.m_UI;

/**
 * Created by saurav on 10/28/2016.
 */


import android.content.Context;
import android.widget.ImageView;

import com.example.hp.noticeboard.R;
import com.squareup.picasso.Picasso;


public class PicassoClient {

    public static void downloadImage(Context c,String imagUrl,ImageView img)
    {
        if(imagUrl != null && imagUrl.length()>0)
        {
            Picasso.with(c).load(imagUrl).placeholder(R.drawable.placeholder).into(img);
        }else {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }
}
