package www.anandwan.com;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ZoomControls;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class Maps_zoom extends FragmentActivity implements OnMapReadyCallback ,LocationListener, NavigationView.OnNavigationItemSelectedListener  {
    final static int PERMISSION_ALL=1;
    ZoomControls zoomControls;
    final static String[] PERMISSIONS={Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private GoogleMap mMap;
    MarkerOptions mo;
    LatLng myCoordinates;
    Marker marker;
    ImageView button;
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    TextView mlink;



    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_zoom);






        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()

                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager=(LocationManager) getSystemService(LOCATION_SERVICE);
        mo=new MarkerOptions().position(new LatLng(0,0)).title("My Current Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));


        if(Build.VERSION.SDK_INT >= 23 && !isPermissionGranted()){
            requestPermissions(PERMISSIONS,PERMISSION_ALL);
        }
        else requestLocation();
        if(!isLocationEnabled())
            showAlert(1);

        BottomNavigationView bottomNavigationView =findViewById(R.id.botton_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){


                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navigate:
                        startActivity(new Intent(getApplicationContext(),Maps_fullscreen.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.scanner:
                        startActivity(new Intent(getApplicationContext(),Scanner.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.places:
                        startActivity(new Intent(getApplicationContext(),Places.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



    }

    //toolbar
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg=" ";
        switch (item.getItemId()){

        }

        return super.onOptionsItemSelected(item);
    }


    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }

    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);

    }






    private void setSupportActionBar(Toolbar toolbar) {


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        marker=mMap.addMarker(mo);

        LatLng Anandwan= new LatLng(20.252460,79.020072);
        mMap.addMarker(new MarkerOptions().position(Anandwan).title("Here is Anandwan").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mMap.addCircle(new CircleOptions().center(Anandwan).radius(5.0).strokeWidth(3f).strokeColor(Color.RED).fillColor(Color.RED));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Anandwan));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Anandwan, 17f));

        LatLng Anandniketan= new LatLng(19.421185,80.557706);
        mMap.addMarker(new MarkerOptions().position(Anandniketan).title("Hemalkasa").snippet("Click on bottom right corner for direction"));

        LatLng Agri= new LatLng(20.1275102547,79.6222809553);
        mMap.addMarker(new MarkerOptions().position(Agri).title("Somnath Prakalp").snippet("Click on bottom right corner for directions"));

        LatLng Mulgavan= new LatLng(19.552,78.3934);
        mMap.addMarker(new MarkerOptions().position(Mulgavan).title("Mulgavan").snippet("Click on bottom right corner for directions"));


    }


    @Override
    public void onLocationChanged(Location location) {
        LatLng myCoordinates=new LatLng(location.getLatitude(),location.getLongitude());
        marker.setPosition(myCoordinates);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
    @SuppressLint("MissingPermission")
    private void requestLocation(){
        Criteria criteria=new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setPowerRequirement(Criteria.POWER_HIGH);
        String provider = locationManager.getBestProvider(criteria,true);
        locationManager.requestLocationUpdates(provider,10000,10,this);
    }
    private boolean isLocationEnabled(){
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean isPermissionGranted(){
        if(checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)== PackageManager.PERMISSION_GRANTED||
                checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                        ==PackageManager.PERMISSION_GRANTED){
            Log.v("mylog","Permission is granted");
            return true;
        }else{
            Log.v("mylog","Permission not granted");
            return false;

        }
    }
    private void showAlert(final int status){
        String message,title,btnText;
        if(status==1){
            message="four Location Setting is set to 'off',\n Please enable Location to use this app";
            title="Enable Location";
            btnText="Location Settings";

        }
        else{
            message="Please allow this app to access Location";
            title="Permission Access";
            btnText="Grant";
        }
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        dialog.setTitle(title).setMessage(message)
                .setPositiveButton(btnText, new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        if (status == 1) {
                            Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(myIntent);
                        } else
                            requestPermissions(PERMISSIONS, PERMISSION_ALL);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                        finish();
                    }
                });
        dialog.show();
    }

    public void click(){


        ImageView image=new ImageView(this);
        image.setImageResource(R.drawable.gr);


        AlertDialog.Builder builder=new AlertDialog.Builder(Maps_zoom.this);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setIcon(R.drawable.gr);


        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

    public void click1(){

        ImageView imageView=new ImageView(this);
        imageView.setImageResource(R.drawable.red);

        AlertDialog.Builder builder=new AlertDialog.Builder(Maps_zoom.this);
        builder.setIcon(R.drawable.red);
        builder.setTitle("Gives Location Of Places");
        builder.setIcon(R.drawable.red);
        builder.setMessage("Click On the Red Marker to Get the Name & Direction of the Places ");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setIcon(R.drawable.red);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();

    }

    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
        return false;
    }


    static class Configuration {
        public Locale locale;
    }

}





