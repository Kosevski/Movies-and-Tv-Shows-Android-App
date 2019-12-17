package com.example.watchio.images;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoaderImpl implements ImageLoader {
    @Override
    public void loadImage(String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
