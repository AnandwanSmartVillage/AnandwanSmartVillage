package www.anandwan.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Places <adapter> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    public TextView textView;
    public ImageView imageView;
    ViewPager ViewPagerP;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_places);

        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nDrawerLayout = findViewById(R.id.drawerLayout);
        nDrawerToggle = new ActionBarDrawerToggle(this, nDrawerLayout, toolbar, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nDrawerToggle);
        nDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);


        ViewPagerP = (ViewPager) findViewById(R.id.viewPagerPlaces);

        navigationView.bringToFront();
        //toolbar
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.products:
                        startActivity(new Intent(getApplicationContext(), ActivityProducts.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.journey:
                        startActivity(new Intent(getApplicationContext(), ActivityJourney.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.ourwork:
                        startActivity(new Intent(getApplicationContext(), ourwork.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.gallery:
                        startActivity(new Intent(getApplicationContext(), ActivityGallery.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.volunteer:
                        startActivity(new Intent(getApplicationContext(), ActivityVolunteer.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.articles:
                        startActivity(new Intent(getApplicationContext(), ActivityArticles.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.ssc:
                        startActivity(new Intent(getApplicationContext(), ActivitySsc.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.visitus:
                        startActivity(new Intent(getApplicationContext(), Visitus.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.donate:
                        startActivity(new Intent(getApplicationContext(), ActivityDonate.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.awards:
                        startActivity(new Intent(getApplicationContext(), ActivityAwards.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.contactus:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        menuItem.setChecked(true);

                        nDrawerLayout.closeDrawers();
                        return true;
                }


                return false;
            }
        });



        BottomNavigationView bottomNavigationView =findViewById(R.id.botton_navigation);

        bottomNavigationView.setSelectedItemId(R.id.places);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.places:
                        return true;

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

                }
                return false;
            }
        });


        imageView=(ImageView) findViewById(R.id.HealthCare);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Healthcare.class);
                startActivity(intent);
            }
        });

        imageView=(ImageView) findViewById(R.id.Education);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Education.class);
                startActivity(intent);
            }
        });

        imageView=(ImageView) findViewById(R.id.Livelihood);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Livelihood.class);
                startActivity(intent);
            }
        });

        imageView=(ImageView) findViewById(R.id.Agriculture);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Agriculture.class);
                startActivity(intent);
            }
        });

        imageView=(ImageView) findViewById(R.id.Rehabilitation);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Rehabilitation.class);
                startActivity(intent);
            }
        });

        imageView=(ImageView) findViewById(R.id.Environment);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(Places.this,Environment.class);
                startActivity(intent);
            }
        });

        final ImageAdapterP imageAdapterp = new ImageAdapterP(this);
        ViewPagerP.setAdapter(imageAdapterp);

        //Auto timer for slideshow
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 2000,2000);


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

            case R.id.don :
                startActivity(new Intent(getApplicationContext(), ActivityDonate.class));
                break;
            case R.id.pro :
                startActivity(new Intent(getApplicationContext(),drive.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displayMessage (String message)
    {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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



    @Override
    public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
        return false;
    }


    private class Configuration {
        public Locale locale;
    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Places.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if(ViewPagerP.getCurrentItem() == 0){
                        ViewPagerP.setCurrentItem(1);

                    }else if (ViewPagerP.getCurrentItem() == 1) {
                        ViewPagerP.setCurrentItem(2);

                    }else if (ViewPagerP.getCurrentItem() == 2){
                        ViewPagerP.setCurrentItem(3);

                    }else {
                        ViewPagerP.setCurrentItem(0);

                    }
                }
            });

        }
    }

}