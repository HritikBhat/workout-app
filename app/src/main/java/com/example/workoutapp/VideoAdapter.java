package com.example.workoutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<YouTubeVideos> youTubeVideosList;
    Context context;
    public VideoAdapter(){}
    public VideoAdapter(List<YouTubeVideos>youTubeVideosList,Context context){
        this.youTubeVideosList=youTubeVideosList;
        this.context=context;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.videos_frag,parent,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
        holder.videoWeb.loadData(youTubeVideosList.get(position).getVideoUrl(),"text/html","utf-8");
        //IMPORTANT NOTE::::: uncomment kar neeche ke code ko
        //Intent intent = new Intent(abhika_Activity,dusra_Activity);
        //context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return youTubeVideosList.size();}

        public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

    public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient( new WebChromeClient(){

        });

        }

    }
}
