package www.anandwan.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class Rehabilitation extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    ImageView iv1,iv2,iv3,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10;
    TextView txt1,txt2,txt3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_rehabilitation);

        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nDrawerLayout = findViewById(R.id.drawerLayout);
        nDrawerToggle = new ActionBarDrawerToggle(this, nDrawerLayout, toolbar, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nDrawerToggle);
        nDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

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


        //BottomNav
        BottomNavigationView bottomNavigationView =findViewById(R.id.botton_navigation);
        bottomNavigationView.setSelectedItemId(R.id.places);


        b1=(TextView)findViewById(R.id.btnsneh);
        b2=(TextView) findViewById(R.id.btnapulki);
        b3=(TextView) findViewById(R.id.btnuttarayan);
        b4=(TextView) findViewById(R.id.btnkrishi);
        b5=(TextView) findViewById(R.id.btnsukh);
        b6=(TextView) findViewById(R.id.btnmukti);
        b7=(TextView) findViewById(R.id.btnmitrangan);
        b8=(TextView) findViewById(R.id.btngokul);
        b9=(TextView) findViewById(R.id.btnyuvagram);
        b10=(TextView) findViewById(R.id.btnSandhiniketan);
        iv3=(ImageView)findViewById(R.id.imggokul);
        txt3=(TextView)findViewById(R.id.txtgokul);
        iv1=(ImageView)findViewById(R.id.imgsneh);
        txt1=(TextView)findViewById(R.id.txtsneh);
        iv2=(ImageView)findViewById(R.id.imguttarayan);
        txt2=(TextView)findViewById(R.id.txtuttarayan) ;


        L1 = (ImageView) findViewById(R.id.line1);
        L2 = (ImageView) findViewById(R.id.line2);

        L3 = (ImageView) findViewById(R.id.line11);
        L4 = (ImageView) findViewById(R.id.line12);
        L5 = (ImageView) findViewById(R.id.line13);
        L6 = (ImageView) findViewById(R.id.line14);
        L7 = (ImageView) findViewById(R.id.line15);

        L8 = (ImageView) findViewById(R.id.line111);
        L9 = (ImageView) findViewById(R.id.line112);
        L10 = (ImageView) findViewById(R.id.line113);

        L1.setBackgroundColor(Color.parseColor("#e14c27"));
        L2.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L3.setBackgroundColor(Color.parseColor("#e14c27"));
        L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L7.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L8.setBackgroundColor(Color.parseColor("#e14c27"));
        L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L10.setBackgroundColor(Color.parseColor("#f2f2f2"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#e14c27"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv1.setImageResource(R.drawable.snehsavali);
                txt1.setText(R.string.snehsavali);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                L2.setBackgroundColor(Color.parseColor("#e14c27"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv1.setImageResource(R.drawable.apulki);
                txt1.setText(R.string.apulki);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L3.setBackgroundColor(Color.parseColor("#e14c27"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv2.setImageResource(R.drawable.uttarayan);
                txt2.setText(R.string.uttarayan);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L4.setBackgroundColor(Color.parseColor("#e14c27"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv2.setImageResource(R.drawable.krishiniketan);
                txt2.setText(R.string.krishiniketan);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L5.setBackgroundColor(Color.parseColor("#e14c27"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv2.setImageResource(R.drawable.sukhsadan);
                txt2.setText(R.string.sukhsadan);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L6.setBackgroundColor(Color.parseColor("#e14c27"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv2.setImageResource(R.drawable.muktisadan);
                txt2.setText(R.string.muktisadan);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L7.setBackgroundColor(Color.parseColor("#e14c27"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv2.setImageResource(R.drawable.mitrangan);
                txt2.setText(R.string.mitangana);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L8.setBackgroundColor(Color.parseColor("#e14c27"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv3.setImageResource(R.drawable.gokul);
                txt3.setText(R.string.gokul);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L9.setBackgroundColor(Color.parseColor("#e14c27"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv3.setImageResource(R.drawable.yuvagram);
                txt3.setText(R.string.yuvagram);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L10.setBackgroundColor(Color.parseColor("#e14c27"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                iv3.setImageResource(R.drawable.sandhiniketan);
                txt3.setText(R.string.sandhiinketan);
            }
        });


        //BottomNavListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.places:
                        startActivity(new Intent(getApplicationContext(),Places.class));
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

}