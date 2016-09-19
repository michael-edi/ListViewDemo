package mo.org.cpttm.cm386.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_video);

        Bundle bundle = this.getIntent().getExtras();
        String videoFilename = bundle.getString("videoFile");
        String path= bundle.getString("path");
        setTitle(videoFilename);
        Log.d("Video File", videoFilename);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        MediaController mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);

        videoView.setVideoPath(path+"/"+ videoFilename);
        videoView.start();

    }
}
