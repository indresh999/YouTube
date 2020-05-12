package com.teetask.youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements  OnAdapterItemClickListener {

    public static final String defalult_link = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
    private  int[] images = {
            R.drawable.globe, R.drawable.bugs, R.drawable.rocks, R.drawable.water,
            R.drawable.globe
    };
    ProgressBar progressBar = null;
    VideoView videoView;
    private String[] title = {"Earth Happiness","My Earth", "Minee More", "Shinee Shyne", "Home Mady"};
    private String[] channel = {"Earth Heros","Marsh Man", "Honey Comb", "Sunday sore", "Eotmet"};

    private String[] links = {  "https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_640_3MG.mp4",
                                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                                "https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_640_3MG.mp4",
                                "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                                "https://file-examples.com/wp-content/uploads/2017/04/file_example_MP4_640_3MG.mp4"
                             };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter(title,channel,links,images, this));
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath(defalult_link);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        DisplayMetrics metrics = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        videoView.setLayoutParams(new FrameLayout.LayoutParams(metrics.widthPixels, metrics.heightPixels));
        videoView.start();


      /*  videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.start();
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int arg1,
                                                   int arg2) {
                        // TODO Auto-generated method stub
                        progressBar.setVisibility(View.GONE);
                        mp.start();
                    }
                });
            }
        });*/
    }



    @Override
    public void onAdapterItemClickListener(int position) {

        videoView.setVideoPath(links[position]);
        if(videoView.isPlaying())
        videoView.stopPlayback();

        videoView.start();

    }

}
interface OnAdapterItemClickListener {
    void onAdapterItemClickListener(int position);
}