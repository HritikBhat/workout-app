package com.example.workoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class excersisefrag extends Fragment {
    int[] newArray;

    View v;

    public excersisefrag(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newArray=new int[]{
                R.id.chest,R.id.backbody,R.id.abs,R.id.lowerpart
        };

    }
    public void ImageButtonClicked(View view){
        int i=0;
        for(i=0;i<newArray.length;i++){
            int value =i+1;
            Intent intent=new Intent(getActivity().getApplication(), secexcersise.class);
            intent.putExtra("value",String.valueOf(value));
            startActivity(intent);

        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.excersise_frag,container,false);
        return v;
    }
}
