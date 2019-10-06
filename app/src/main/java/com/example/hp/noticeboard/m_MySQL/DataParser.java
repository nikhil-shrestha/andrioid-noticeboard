package com.example.hp.noticeboard.m_MySQL;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hp.noticeboard.m_DataObject.Spacecraft;
import com.example.hp.noticeboard.m_UI.CustomAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by saurav on 10/28/2016.
 */
public class DataParser extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    ListView lv;

    ProgressDialog pd;
    ArrayList<Spacecraft> spacecrafts=new ArrayList<>();

    public DataParser(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Pasring..Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean parsed) {
        super.onPostExecute(parsed);

        pd.dismiss();

        if(parsed)
        {
            //BIND
            CustomAdapter adapter=new CustomAdapter(c,spacecrafts);
            lv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"Unable To Parse",Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parseData()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            spacecrafts.clear();
            Spacecraft spacecraft;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                int id=jo.getInt("id");
                String name=jo.getString("notice_title");
                String propellant=jo.getString("post_date");
                String desc=jo.getString("description");
                String imageUrl=jo.getString("notice_image");

                spacecraft=new Spacecraft();

                spacecraft.setId(id);
                spacecraft.setName(name);
                spacecraft.setPropellant(propellant);
                spacecraft.setDescription(desc);
                spacecraft.setImageUrl(imageUrl);

                spacecrafts.add(spacecraft);
            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return false;
    }


}

