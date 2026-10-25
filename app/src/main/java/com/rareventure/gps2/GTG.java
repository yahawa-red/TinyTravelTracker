package com.rareventure.gps2;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

import org.acra.ACRA;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import androidx.core.content.ContextCompat;
import android.util.Log;

import com.rareventure.android.AndroidPreferenceSet;
import com.rareventure.android.AndroidPreferenceSet.AndroidPreferences;
import com.rareventure.android.Util;
import com.rareventure.android.database.DbDatastoreAccessor;
import com.rareventure.android.database.timmy.RollBackTimmyDatastoreAccessor;
import com.rareventure.android.database.timmy.TimmyDatabase;
import com.rareventure.android.database.timmy.TimmyTable;
import com.rareventure.gps2.database.GpsLocationCache;
import com.rareventure.gps2.database.GpsLocationRow;
import com.rareventure.gps2.database.TAssert;
import com.rareventure.gps2.database.TimeZoneTimeSet;
import com.rareventure.gps2.database.UserLocationCache;
import com.rareventure.gps2.database.cache.AreaPanel;
import com.rareventure.gps2.database.cache.AreaPanelCache;
import com.rareventure.gps2.database.cache.TimeTree;
import com.rareventure.gps2.database.cache.TimeTreeCache;
import com.rareventure.gps2.database.cachecreator.GpsTrailerCacheCreator;
import com.rareventure.gps2.reviewer.map.MediaLocTimeMap;
import com.rareventure.gps2.reviewer.map.OsmMapGpsTrailerReviewerMapActivity;
import com.rareventure.gps2.reviewer.map.OsmMapView;
import com.rareventure.util.BackgroundRunner;
import com.rareventure.util.ReadWriteThreadManager;

/**
 * Gps Trailer Globals... The reason we stick everything
 * here is 1) to make it easy to find, and 2) we might
 * have generic things like AndroidPreferenceSet which we
 * need to stick somewhere. 3) We have different apps using
 * the same globals but initialize them in different parts of
 * code
 */
public class GTG {
