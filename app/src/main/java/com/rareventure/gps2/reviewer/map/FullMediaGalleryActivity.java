package com.rareventure.gps2.reviewer.map;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

import com.rareventure.gps2.GTGActivity;
import com.rareventure.gps2.R;
import com.rareventure.android.Util;
import com.rareventure.gps2.GTG;
import com.rareventure.gps2.database.cache.MediaLocTime;

public class FullMediaGalleryActivity extends GTGActivity
{

	private static ArrayList<MediaLocTime> mlts;
	private static int mltIndex;
	
	public static void setFullMediaGalleryActivityData(ArrayList<MediaLocTime> mlts, int mltIndex)
	{
		FullMediaGalleryActivity.mlts = mlts;
		FullMediaGalleryActivity.mltIndex = mltIndex;
	}
	
	private FragmentActivity gtum;
	private Gallery gallery;
	private MltAdapter adapter;

	public FullMediaGalleryActivity() {
	}

	@Override
	public void doOnCreate(Bundle savedInstanceState) {
		super.doOnCreate(savedInstanceState);

		setContentView(R.layout.full_media_gallery);
		
        // Reference the Gallery view
        gallery = (Gallery) findViewById(R.id.gallery);
        
        //remove the alphaness
        gallery.setUnselectedAlpha(1.0f);
        
        gallery.setSpacing((int) Util.convertDpToPixel(10, this));
        
        // Set a item click listener, and just Toast the clicked position
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
            	MediaLocTime mlt = mlts.get((int)id);
            	
            	if(!mlt.isClean(gtum))
            		return;
            	
            	if(mlt.getType() == MediaLocTime.TYPE_IMAGE)
            		Util.viewMediaInGallery(gtum, mlt.getFilename(getContentResolver()), true);
            	else
            		Util.viewMediaInGallery(gtum, mlt.getFilename(getContentResolver()), false //video
            				);
            }
        });
        
       gallery.setAdapter(adapter = new MltAdapter(this, mlts));
	}
	
	
	
//	public void setMlts(ArrayList<MediaLocTime> mltArray)
//	{
//		this.mlts = mltArray;
//		
