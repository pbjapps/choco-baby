package com.example.tacotruck.pokemonsimon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Raitei on 11/10/2015.
 */
public class ProgressAdapter extends BaseAdapter {


    private Context context;
    private BaseLevelActivity level;
    private int incompleteImageId = R.mipmap.empty_pokeball;
    private int completeImageId = R.mipmap.pokeball;
    private int progress = -1;

    public ProgressAdapter(Context c) {
        context = c;
        if (context instanceof BaseLevelActivity) {
            level = (BaseLevelActivity) context;
        }
    }

    @Override
    public int getCount() {
        return level.pkmnCount;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ImageView imageView;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(80, 80));
        } else {
            imageView = (ImageView) view;
        }

        int imageId = incompleteImageId;
        if (position + 1 <= progress) {
            imageId = completeImageId;
        }

        imageView.setImageResource(imageId);
        return imageView;
    }

    public void updateProgress(int size) {
        progress = size;
    }
}
