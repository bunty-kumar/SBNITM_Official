package com.bunty.sbnitmofficial.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bunty.sbnitmofficial.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_home, container, false);

       sliderLayout = view.findViewById(R.id.imageSlider);
       sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
       sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
       sliderLayout.setScrollTimeInSec(1);

       setSliderViews();

       map = view.findViewById(R.id.map);

       map.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               openMap();
           }
       });

       return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q= shri bhawani niketan institute of technology sikar road jaipur");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i = 0; i<5; i++ ){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){

                case 0:
                    sliderView.setImageDrawable(R.drawable.galleryimage3);
                    break;

                case 1:
                    sliderView.setImageDrawable(R.drawable.galleryimage5);
                    break;

                case 2:
                    sliderView.setImageDrawable(R.drawable.galleryimage1);
                    break;

                case 3:
                    sliderView.setImageDrawable(R.drawable.galleryimage2);
                    break;

                case 4:
                    sliderView.setImageDrawable(R.drawable.galleryimage4);
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            sliderLayout.addSliderView(sliderView);
        }
    }
}