package com.rareventure.gps2;

import com.rareventure.android.Util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.util.Log;

import pl.tajchert.nammu.Nammu;

/**
 * WARNING: this  code is duplicated in GTGActivity, GTGFragmentActivity and GTGPreferencesActiity. Be sure to also
 * change in there what is in here
 */
public abstract class GTGFragmentActivity extends FragmentActivity implements IGTGActivity
{
	GTGActivityHelper helper = new GTGActivityHelper(this, this.getRequirements());

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	protected final void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		helper.onCreate(bundle);
	}
	
	@Override
	protected final void onResume() {
		super.onResume();
		helper.onResume();
	}
	
	public void doOnResume()
	{
	}
	
	public void startInternalActivityForResult(Intent i, int s)
	{
		helper.startInternalActivityForResult(i, s);
	}

	public void doOnCreate(Bundle b)
	{
	}

	
	protected final void onPause()
	{
		super.onPause();
		helper.onPause();
	}
	
	public void doOnPause(boolean doOnResumeCalled)
	{
	}

	@Override
	public void onBackPressed() {
		helper.onBackPressed();
	}

	@Override
	public void  performCancel() {
		helper.performCancel();
	}

	public void finish()
	{
		helper.finish();
	}
	
	@Override
	public void superFinish()
	{
		super.finish();
	}
	

	/**
	 * Starts an internal activity and keeps password if already present
	 */
	public void startInternalActivity(Intent intent)
	{
		helper.startInternalActivity(intent);
	}
	
	/**
	 * Starts an internal activity and keeps password if already present
	 */
	public void startInternalActivity(Intent intent, boolean requireBackStack)
	{
		helper.startInternalActivity(intent, requireBackStack);
	}
	
	public void exitFromApp()
	{
		helper.exitFromApp();
	}
}
