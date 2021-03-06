package com.example.splashes.Helpers;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splashes.R;

// This is where all the magic happens for the sliding splash screens on OnBoardingActivity.

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    // Instantiate images used in splash.
    int[] images ={
        R.drawable.splash1,
        R.drawable.splash2,
        R.drawable.splash3,
        R.drawable.splash4
    };

    //Instantiate all of the descriptions used in splash.
    int[] descriptions ={
        R.string.bluentry,
        R.string.ttsauto,
        R.string.bluetooth1,
        R.string.location
    };

    @Override
    public int getCount() {
        return descriptions.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slides_layout,container,false);

        ImageView imageView =  view.findViewById(R.id.slider_image);
        TextView textView = view.findViewById(R.id.slider_description);

        imageView.setImageResource(images[position]);
        textView.setText(descriptions[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
