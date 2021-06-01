package www.anandwan.com;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ZoomControls;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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

public class Maps_fullscreen extends FragmentActivity implements OnMapReadyCallback ,LocationListener {
    final static int PERMISSION_ALL=1;
    ZoomControls zoomControls;
    final static String[] PERMISSIONS={Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION};
    private GoogleMap mMap;
    MarkerOptions mo;
    LatLng myCoordinates;
    Marker marker;
    ImageView button;


    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_fullscreen);



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

        bottomNavigationView.setSelectedItemId(R.id.navigate);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigate:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.places:
                        startActivity(new Intent(getApplicationContext(),Places.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.scanner:
                        startActivity(new Intent(getApplicationContext(),Scanner.class));
                        overridePendingTransition(0,0);
                        return true;


                }
                return false;
            }
        });


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


        LatLng Anandniketan= new LatLng(20.251926,79.018337);
        mMap.addMarker(new MarkerOptions().position(Anandniketan).title("Anand Niketan College").snippet("Click on bottom right corner for direction"));

        LatLng Agri= new LatLng(20.252238,79.020373);
        mMap.addMarker(new MarkerOptions().position(Agri).title("Anand Niketan Agriculture College").snippet("Click on bottom right corner for directions"));

        LatLng Poly= new LatLng(20.248860,79.028669);
        mMap.addMarker(new MarkerOptions().position(Poly).title("Anandwan Agriculture Polytechnic College").snippet("Click on bottom right corner for directions"));

        LatLng Zp= new LatLng(20.254208,79.020000);
        mMap.addMarker(new MarkerOptions().position(Zp).title("Zilla Parishad Primary School").snippet("Click on bottom right corner for directions"));

        LatLng Zph= new LatLng(20.254779,79.020267);
        mMap.addMarker(new MarkerOptions().position(Zph).title("Zilla Parishad High School").snippet("Click on bottom right corner for directions"));

        LatLng Canteen= new LatLng(20.258359,79.020629);
        mMap.addMarker(new MarkerOptions().position(Canteen).title("Canteen & Dairy").snippet("Click on bottom right corner for directions"));

        LatLng Exhibit= new LatLng(20.258900,79.020812);
        mMap.addMarker(new MarkerOptions().position(Exhibit).title("Exhibition Center").snippet("Click on bottom right corner for directions"));

        LatLng Enquiry= new LatLng(20.259087,79.020968);
        mMap.addMarker(new MarkerOptions().position(Enquiry).title("Enquiry office").snippet("Click on bottom right corner for directions"));

        LatLng Main= new LatLng(20.259285,79.021103);
        mMap.addMarker(new MarkerOptions().position(Main).title("Main Office").snippet("Click on bottom right corner for directions"));

        LatLng Abhya= new LatLng(20.257042,79.024989);
        mMap.addMarker(new MarkerOptions().position(Abhya).title("Abhayaranya MainGate").snippet("Click on bottom right corner for directions"));

        LatLng Abhya2= new LatLng(20.260041,79.025664);
        mMap.addMarker(new MarkerOptions().position(Abhya2).title("Abhayaranya Gate2").snippet("Click on bottom right corner for directions"));

        LatLng Sukhsadan= new LatLng(20.254730,79.021766);
        mMap.addMarker(new MarkerOptions().position(Sukhsadan).title("Sukhsadan(Phase1)").snippet("Click on bottom right corner for directions"));

        LatLng Snehasavali= new LatLng(20.254968,79.021420);
        mMap.addMarker(new MarkerOptions().position(Snehasavali).title("Sneha Savali").snippet("Click on bottom right corner for directions"));

        LatLng Library= new LatLng(20.253537,79.022291);
        mMap.addMarker(new MarkerOptions().position(Library).title("Agriculture College Library").snippet("Click on bottom right corner for directions"));

        LatLng Blindschool= new LatLng(20.259134,79.021583);
        mMap.addMarker(new MarkerOptions().position(Blindschool).title("Anandwan Blind School").snippet("Click on bottom right corner for directions"));

        LatLng DM= new LatLng(20.260511,79.022373);
        mMap.addMarker(new MarkerOptions().position(DM).title("Deaf and Mute School").snippet("Click on bottom right corner for directions"));

        LatLng Handloom= new LatLng(20.261330,79.021639);
        mMap.addMarker(new MarkerOptions().position(Handloom).title("Bag and Handloom").snippet("Click on bottom right corner for directions"));

        LatLng Biogas= new LatLng(20.256366,79.021373);
        mMap.addMarker(new MarkerOptions().position(Biogas).title("Biogas Plant & Solar Panel").snippet("Click on bottom right corner for directions"));

        LatLng Megakitchen= new LatLng(20.256662,79.021459);
        mMap.addMarker(new MarkerOptions().position(Megakitchen).title("Mega Kitchen").snippet("Click on bottom right corner for directions"));

        LatLng Carpentry= new LatLng(20.257386,79.021468);
        mMap.addMarker(new MarkerOptions().position(Carpentry).title("Carpentry Department").snippet("Click on bottom right corner for directions"));

        LatLng Footwear= new LatLng(20.261085,79.022090);
        mMap.addMarker(new MarkerOptions().position(Footwear).title("Footwear Department").snippet("Click on bottom right corner for directions"));

        LatLng Gokul= new LatLng(20.259760,79.021310);
        mMap.addMarker(new MarkerOptions().position(Gokul).title("Gokul").snippet("Click on bottom right corner for directions"));

        LatLng Handicraft= new LatLng(20.261756,79.021142);
        mMap.addMarker(new MarkerOptions().position(Handicraft).title("Handicrafts Greeting").snippet("Click on bottom right corner for directions"));

        LatLng Poster= new LatLng(20.261744,79.021308);
        mMap.addMarker(new MarkerOptions().position(Poster).title("Handicrafts Posters").snippet("Click on bottom right corner for directions"));

        LatLng Metal= new LatLng(20.261849,79.021540);
        mMap.addMarker(new MarkerOptions().position(Metal).title("Metal Fabrication").snippet("Click on bottom right corner for directions"));

        LatLng Miyawaki= new LatLng(20.261025,79.020877);
        mMap.addMarker(new MarkerOptions().position(Miyawaki).title("Miyawaki Forest").snippet("Click on bottom right corner for directions"));

        LatLng Muktangan= new LatLng(20.257753,79.021824);
        mMap.addMarker(new MarkerOptions().position(Muktangan).title("Muktangan Anganwadi").snippet("Click on bottom right corner for directions"));

        LatLng Powerloom= new LatLng(20.261385,79.022171);
        mMap.addMarker(new MarkerOptions().position(Powerloom).title("Powerloom").snippet("Click on bottom right corner for directions"));

        LatLng Press= new LatLng(20.261399,79.022352);
        mMap.addMarker(new MarkerOptions().position(Press).title("Printing Press").snippet("Click on bottom right corner for directions"));

        LatLng Sandhiniketan= new LatLng(20.261248,79.021254);
        mMap.addMarker(new MarkerOptions().position(Sandhiniketan).title("Sandhi Niketan").snippet("Click on bottom right corner for directions"));

        LatLng Carpet= new LatLng(20.256844,79.021497);
        mMap.addMarker(new MarkerOptions().position(Carpet).title("Carpet Department").snippet("Click on bottom right corner for directions"));

        LatLng Sitaratan= new LatLng(20.256602,79.020127);
        mMap.addMarker(new MarkerOptions().position(Sitaratan).title("Sita Ratan Leprosy Hospital").snippet("Click on bottom right corner for directions"));

        LatLng Saibaba= new LatLng(20.260764,79.021165);
        mMap.addMarker(new MarkerOptions().position(Saibaba).title("Saibaba Hospital").snippet("Click on bottom right corner for directions"));

        LatLng Shradhawan= new LatLng(20.257246,79.024181);
        mMap.addMarker(new MarkerOptions().position(Shradhawan).title("Shraddhawan").snippet("Click on bottom right corner for directions"));

        LatLng Strishu= new LatLng(20.257658,79.021310);
        mMap.addMarker(new MarkerOptions().position(Strishu).title("Strissue").snippet("Click on bottom right corner for directions"));

        LatLng Swaranandwan= new LatLng(20.261029,79.021818);
        mMap.addMarker(new MarkerOptions().position(Swaranandwan).title("Swaranandwan").snippet("Click on bottom right corner for directions"));

        LatLng Woodart= new LatLng(20.261884,79.021567);
        mMap.addMarker(new MarkerOptions().position(Woodart).title("Woodart Department").snippet("Click on bottom right corner for directions"));

        LatLng Wool= new LatLng(20.261037,79.022036);
        mMap.addMarker(new MarkerOptions().position(Wool).title("Wool & Sweater Department").snippet("Click on bottom right corner for directions"));

        LatLng Aapulki= new LatLng(20.255761,79.020898);
        mMap.addMarker(new MarkerOptions().position(Aapulki).title("Aapulki").snippet("Click on bottom right corner for directions"));


        LatLng Bank= new LatLng(20.256555,79.020297);
        mMap.addMarker(new MarkerOptions().position(Bank).title("Bank & PostOffice").snippet("Click on bottom right corner for directions"));

        LatLng Ropwan= new LatLng(20.257643,79.025776);
        mMap.addMarker(new MarkerOptions().position(Ropwan).title("Ropwan").snippet("Click on bottom right corner for directions"));

        LatLng Nursery= new LatLng(20.258132,79.020711);
        mMap.addMarker(new MarkerOptions().position(Nursery).title("Nursery").snippet("Click on bottom right corner for directions"));

        LatLng Electric= new LatLng(20.261619,79.022089);
        mMap.addMarker(new MarkerOptions().position(Electric).title("Electric Department").snippet("Click on bottom right corner for directions"));

        LatLng Vihar= new LatLng(20.260680,79.024263);
        mMap.addMarker(new MarkerOptions().position(Vihar).title("Anand Vihar").snippet("Click on bottom right corner for directions"));

        LatLng Bhoj= new LatLng(20.259434,79.021400);
        mMap.addMarker(new MarkerOptions().position(Bhoj).title("Atithi Bhojnalaya").snippet("Click on bottom right corner for directions"));

        LatLng Aslake= new LatLng(20.260298,79.022663);
        mMap.addMarker(new MarkerOptions().position(Aslake).title("Anand Sagar Lake").snippet("Click on bottom right corner for directions"));


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


        AlertDialog.Builder builder=new AlertDialog.Builder(Maps_fullscreen.this);
        builder.setIcon(R.drawable.gr);
        builder.setTitle("Gives Your Current Location");
        builder.setIcon(R.drawable.gr);

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

        AlertDialog.Builder builder=new AlertDialog.Builder(Maps_fullscreen.this);
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


}

