package com.rareventure.android;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.util.Log;

import com.rareventure.gps2.GpsTrailerService;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class GpsReader implements DataReader
{
