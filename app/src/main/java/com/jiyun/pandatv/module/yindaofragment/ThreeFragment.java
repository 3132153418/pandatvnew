package com.jiyun.pandatv.module.yindaofragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jiyun.pandatv.MainActivity;
import com.jiyun.pandatv.R;

/**
 * Created by Administrator on 2017/6/14.
 */

public class ThreeFragment extends Fragment {
    private LinearLayout linearLayout;
    private SharedPreferences preferences;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_three,container,false);

        preferences = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = preferences.edit();
        linearLayout = (LinearLayout) view.findViewById(R.id.image_LinearLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("have","1");
                editor.commit();
                Intent intent = new Intent(getContext(), MainActivity.class);
                getActivity().startActivity(intent);
            }
        });
        return view;

    }
}
