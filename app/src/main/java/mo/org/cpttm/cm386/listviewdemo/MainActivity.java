package mo.org.cpttm.cm386.listviewdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ListActivity {

    List<String> data;
    //final static String storageLocaiton="/mnt/sdcard/extStorages/SdCard";  //OK for Samsung Galaxy Tab 7.7
    //final static String storageLocaiton= "/storage/emulated/0"; //sdcard";
    final static String storageLocaiton= "/storage/extSdCard"; //OK for Samsung Galaxy Tab S
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = updateSongList();

        //Toast.makeText(this,"extStor:"+Environment.getExternalStorageDirectory(),Toast.LENGTH_LONG).show();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.listview_item, data);
        setListAdapter(adapter);

    }

    private List<String> updateSongList() {
        List<String> result = new ArrayList<String>();

        File home = new File(storageLocaiton);
        for (File file : home.listFiles(new MediaFilter())){
            result.add(file.getName());
        }
/*
        result.add("recording.mp3");
        result.add("only-love.mp3");
        result.add("chitong.mp4");*/
        return result;
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        String currentFilename = data.get(position);

        if (currentFilename.endsWith(".mp3")) {
            Intent musicActivity = new Intent(this, MusicActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("path", storageLocaiton);
            bundle.putString("musicFile", currentFilename);
            musicActivity.putExtras(bundle);
            startActivity(musicActivity);

        }else if (currentFilename.endsWith(".mp4")){
            Intent videoActivity = new Intent(this, VideoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("path", storageLocaiton);
            bundle.putString("videoFile", currentFilename);
            videoActivity.putExtras(bundle);
            startActivity(videoActivity);
        }
    }

}
