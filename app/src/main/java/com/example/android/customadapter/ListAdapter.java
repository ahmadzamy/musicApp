package com.example.android.customadapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Ahmad Siafaddin on 10/10/2017.
 */


public class ListAdapter extends ArrayAdapter<ListData> {
    FloatingActionButton play;
    Context context;
    int resource;
    List<ListData> objects;
    MediaPlayer pp;


    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<ListData> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        pp = MediaPlayer.create(context , R.raw.swara);
    }

    public MediaPlayer getMediaPlayer(){
        return pp;
    }

    public void setCurrentPosition(int currentPosition){
        pp.seekTo(currentPosition);
    }


    @NonNull
    @Override
    public View getView( int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater myInflate = LayoutInflater.from(context);
            convertView = myInflate.inflate(resource, null);

        }

         play=  (FloatingActionButton) convertView.findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //Toast.makeText(context, position.getIndex, Toast.LENGTH_SHORT).show();
                if(pp.isPlaying()) {
                    pp.pause();
                }
                else { pp.start();}

            }
        });
        ImageView image = (ImageView) convertView.findViewById(R.id.profile_image);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView nameOfsong = (TextView) convertView.findViewById(R.id.nameOfSong);

        ListData myData = objects.get(position);

        image.setImageResource(myData.getImageResource());
        name.setText(myData.getNameOfArtists());
        nameOfsong.setText(myData.getNameOfSong());
        return convertView;
    }


}
