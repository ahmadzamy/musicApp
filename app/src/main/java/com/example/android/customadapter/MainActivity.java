package com.example.android.customadapter;

import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.customadapter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer ;
    ActivityMainBinding binding;
    ArrayList<ListData> myList=new ArrayList<>();
    MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);





        myList.add(new ListData("Adnan Karim",R.drawable.adnan,"Saqya"));
        myList.add(new ListData("Bahjat Yahya",R.drawable.bahjat,"Kory am shaw"));
        myList.add(new ListData("Swara Mohamadd",R.drawable.swara,"Rozh w Shaw"));
        myList.add(new ListData("Mohammsd Mamle",R.drawable.mamle,"Saqya"));
        myList.add(new ListData("Hama Rauf",R.drawable.hama,"Kory am shaw"));
        myList.add(new ListData("Zakarya Abdullah",R.drawable.zakarya,"Rozh w Shaw"));

        ListAdapter myAdapter=new ListAdapter(this,R.layout.artistslist,myList);
        binding.listItem.setAdapter(myAdapter);

        mediaPlayer = myAdapter.getMediaPlayer();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        myAdapter.setCurrentPosition(preferences.getInt("CurrentPosition", 0));

    }



    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("CurrentPosition", mediaPlayer.getCurrentPosition());
        editor.apply();

       // player.pause();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
       //player.release();

    }
}
