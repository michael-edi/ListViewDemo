package mo.org.cpttm.cm386.listviewdemo;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class MusicActivity extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();
    String musicFilename;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        Bundle bundle = this.getIntent().getExtras();
        musicFilename = bundle.getString("musicFile");
        path= bundle.getString("path");
        setTitle(musicFilename);
        Log.d("Music File", musicFilename);


        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        Button btnPause = (Button) findViewById(R.id.btnPause);
        Button btnStop = (Button) findViewById(R.id.btnStop);


        btnPlay.setOnClickListener( new View.OnClickListener() {
          public void onClick(View v) {
             playSong(path +"/"+ musicFilename);
          }});
        btnPause.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                mp.pause();
            }});
        btnStop.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                mp.stop();
            }});
    }

    private void playSong(String filepath) {
        final AppCompatActivity that=this;
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(that,"Song Completed",Toast.LENGTH_LONG).show();
            }

        });
        //Toast.makeText(this,"here:"+filepath,Toast.LENGTH_LONG).show();
        try {
            mp.reset();
            mp.setDataSource(filepath);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
