package com.example.hp.noticeboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hp.noticeboard.m_MySQL.Downloader;

/**
 * Created by illusionist_nikhil on 10/16/2016.
 */
public class ComputerFragment extends Fragment {
    final static String urlAddress="http://10.0.2.2/android/app/computer.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.computer_layout,null);
        final ListView lv=(ListView) rootView.findViewById(R.id.lv);
        new Downloader(getActivity(),urlAddress,lv).execute();
        return rootView;
    }
}
