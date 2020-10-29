package com.example.workoutapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.Vector;


public class videosfrag extends Fragment {
     private RecyclerView recyclerView;
    View v;
    Vector<YouTubeVideos>youTubeVideos=new Vector<>();
    RecyclerView.LayoutManager mLayoutManager;

    public videosfrag(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.videos_frag,container,false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        VideoAdapter videoAdapter =new VideoAdapter(youTubeVideos);
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/9tT8afUt7kM\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/n69-eVLtevc\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TcSM1_R0v8E\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/IurNji_wHIA\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/RarcD0Q50nU\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/BEj_IB9kreE\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/7HuB5lHlhpA\" frameborder=\"0\" allowfullscreen></iframe"));
        youTubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VecbXgWY0DI\" frameborder=\"0\" allowfullscreen></iframe"));
        recyclerView.setAdapter(videoAdapter);
        return v;


    }
}