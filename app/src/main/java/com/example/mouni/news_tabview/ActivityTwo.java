package com.example.mouni.news_tabview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.mouni.news_tabview.CardAdapters.CardAdapter;
import com.example.mouni.news_tabview.ObjectClasses.Object11;


import java.util.List;

/**
 * Created by MOUNI on 01-Sep-16.
 */
public class ActivityTwo extends Activity {
    NetworkImageView image;
    TextView t;
    public  static ImageLoader img_loader;
    public static int position;
    Object11 it;
    //List<Object11> list= CardAdapter.img_list;
    //List<Object11> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);
        Intent i=getIntent();
        Bundle args=i.getBundleExtra("BUNDLE");
        List<Object11> list=(List<Object11>) args.getSerializable("LIST");
        //t=(TextView)findViewById(R.id.tv);

       // t.setMovementMethod(new ScrollingMovementMethod());





        position=i.getIntExtra("position",0);
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPager);
        img_loader = CustomVolleyRequest.getInstance(this).getImageLoader();
        // Create instance of PagerAdapter
        CustomPagerAdapter adapter = new CustomPagerAdapter(this, list);

        // Binds the Adapter to the ViewPager
        viewPager.setAdapter(adapter);



        /*String content=i.getStringExtra("content");
        String imageString=i.getStringExtra("imgurl");
        int position=i.getIntExtra("position",0);


        image=(NetworkImageView)findViewById(R.id.img);

        img_loader = CustomVolleyRequest.getInstance(this).getImageLoader();
        image.setImageUrl(list.get(position).getImageUrl(), img_loader);

        t.setText(content);*/

    }
}

