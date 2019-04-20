package com.example.wedding.loader;

import android.content.Context;
import android.widget.ImageView;

import com.example.wedding.GlideApp;
import com.youth.banner.loader.ImageLoader;

/**
 * @author

 */
public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        GlideApp.with(context).load(path).into(imageView);
    }
}
