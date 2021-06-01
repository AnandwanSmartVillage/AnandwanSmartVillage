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
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class ActivityVaform extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    ViewPager VolunteerViewPager;

    TextView pinfo,mcond,prof,aio,refer;
    View Progress1,Progress2,Progress3,Progress4,Progress5;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_vaform);
        VolunteerViewPager = (ViewPager) findViewById(R.id.viewpagerVolForm);


        pinfo = (TextView) findViewById(R.id.PInfo);
        mcond = (TextView) findViewById(R.id.MedCond);
        prof = (TextView) findViewById(R.id.professional);
        aio = (TextView) findViewById(R.id.Aio);
        refer = (TextView) findViewById(R.id.refer);

        Progress1 = (View) findViewById(R.id.YellowProgressBar1);
        Progress2 = (View) findViewById(R.id.YellowProgressBar2);
        Progress3 = (View) findViewById(R.id.YellowProgressBar3);
        Progress4 = (View) findViewById(R.id.YellowProgressBar4);
        Progress5 = (View) findViewById(R.id.YellowProgressBar5);

        final pinfoAdapter pinfoadapter = new pinfoAdapter(this);
        VolunteerViewPager.setAdapter(pinfoadapter);
        Progress1.setBackgroundColor(Color.parseColor("#ffb31a"));
        Progress2.setBackgroundColor(Color.parseColor("#8c8c8c"));
        Progress3.setBackgroundColor(Color.parseColor("#8c8c8c"));
        Progress4.setBackgroundColor(Color.parseColor("#8c8c8c"));
        Progress5.setBackgroundColor(Color.parseColor("#8c8c8c"));

        final MconditionAdapter mconditionAdapter = new MconditionAdapter(this);
        final professionalAdapter professionaladapter = new professionalAdapter(this);
        final aioAdapter aioadapter = new aioAdapter(this);
        final referAdapter referadapter = new referAdapter(this);


        pinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolunteerViewPager.setAdapter(pinfoadapter);
                Progress1.setBackgroundColor(Color.parseColor("#ffb31a"));
                Progress2.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress3.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress4.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress5.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Spinner myspinner = (Spinner) findViewById(R.id.country);
                ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.country_arrays));
                myAdapter.setDropDownViewResource(R.layout.custom_drp);
                myspinner.setAdapter(myAdapter);

                Spinner spinner = (Spinner) findViewById(R.id.blood);
                ArrayAdapter<String> Adapter = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.blood));
                Adapter.setDropDownViewResource(R.layout.custom_drp);
                spinner.setAdapter(Adapter);

                Spinner spinne = (Spinner) findViewById(R.id.spin);
                ArrayAdapter<String> Adapters = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.Gender));
                Adapters.setDropDownViewResource(R.layout.custom_drp);
                spinne.setAdapter(Adapters);

                Button button1;

                button1 = (Button) findViewById(R.id.ssc);

                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ActivityVaform.this,ActivityAwards.class);
                        startActivity(intent);
                    }
                });

            }
        });

        mcond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolunteerViewPager.setAdapter(mconditionAdapter);
                Progress2.setBackgroundColor(Color.parseColor("#ffb31a"));
                Progress1.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress3.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress4.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress5.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Spinner myspinner1 = (Spinner) findViewById(R.id.spin5);
                ArrayAdapter<String> myAdapter1 = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.array));
                myAdapter1.setDropDownViewResource(R.layout.custom_drp);
                myspinner1.setAdapter(myAdapter1);

                Spinner spinner2 = (Spinner) findViewById(R.id.spin6);
                ArrayAdapter<String> Adapter2 = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.arra));
                Adapter2.setDropDownViewResource(R.layout.custom_drp);
                spinner2.setAdapter(Adapter2);
                Button button2;

                button2 = (Button) findViewById(R.id.ssc1);

                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ActivityVaform.this,ActivityAwards.class);
                        startActivity(intent);
                    }
                });



            }
        });

        prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolunteerViewPager.setAdapter(professionaladapter);
                Progress3.setBackgroundColor(Color.parseColor("#ffb31a"));
                Progress1.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress2.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress4.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress5.setBackgroundColor(Color.parseColor("#8c8c8c"));

                Spinner myspinner3 = (Spinner) findViewById(R.id.spin7);
                ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.array1));
                myAdapter3.setDropDownViewResource(R.layout.custom_drp);
                myspinner3.setAdapter(myAdapter3);

                Spinner spinner4 = (Spinner) findViewById(R.id.spin8);
                ArrayAdapter<String> Adapter4 = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.array2));
                Adapter4.setDropDownViewResource(R.layout.custom_drp);
                spinner4.setAdapter(Adapter4);

                Spinner spinne5 = (Spinner) findViewById(R.id.spin9);
                ArrayAdapter<String> Adapters5 = new ArrayAdapter<String>(ActivityVaform.this,
                        R.layout.custom_spinner, getResources().getStringArray(R.array.array3));
                Adapters5.setDropDownViewResource(R.layout.custom_drp);
                spinne5.setAdapter(Adapters5);

                Button button3;

                button3 = (Button) findViewById(R.id.ssc4);

                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ActivityVaform.this,ActivityAwards.class);
                        startActivity(intent);
                    }
                });


            }
        });

        aio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolunteerViewPager.setAdapter(aioadapter);
                Progress4.setBackgroundColor(Color.parseColor("#ffb31a"));
                Progress1.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress2.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress3.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress5.setBackgroundColor(Color.parseColor("#8c8c8c"));

                Button button4;

                button4 = (Button) findViewById(R.id.ssc2);

                button4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ActivityVaform.this,ActivityAwards.class);
                        startActivity(intent);
                    }
                });

            }
        });

        refer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolunteerViewPager.setAdapter(referadapter);
                Progress5.setBackgroundColor(Color.parseColor("#ffb31a"));
                Progress1.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress2.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress3.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Progress4.setBackgroundColor(Color.parseColor("#8c8c8c"));
                Button button;

                button = (Button) findViewById(R.id.sub);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ActivityVaform.this,ActivityAwards.class);
                        startActivity(intent);
                    }
                });
            }
        });

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
                        displayMessage("home");
                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.products:
                        startActivity(new Intent(getApplicationContext(), ActivityProducts.class));
                        menuItem.setChecked(true);
                        displayMessage("products");
                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.journey:
                        startActivity(new Intent(getApplicationContext(), ActivityJourney.class));
                        menuItem.setChecked(true);
                        displayMessage("journey");
                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.ourwork:
                        startActivity(new Intent(getApplicationContext(), ourwork.class));
                        menuItem.setChecked(true);
                        displayMessage("Our Work");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.gallery:
                        startActivity(new Intent(getApplicationContext(), ActivityGallery.class));
                        menuItem.setChecked(true);
                        displayMessage("gallery");
                        nDrawerLayout.closeDrawers();
                        return true;

                    case R.id.volunteer:
                        startActivity(new Intent(getApplicationContext(), ActivityVolunteer.class));
                        menuItem.setChecked(true);
                        displayMessage("volunteer");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.articles:
                        startActivity(new Intent(getApplicationContext(), ActivityArticles.class));
                        menuItem.setChecked(true);
                        displayMessage("article");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.ssc:
                        startActivity(new Intent(getApplicationContext(), ActivitySsc.class));
                        menuItem.setChecked(true);
                        displayMessage("Shram Sanskar Chhavani");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.visitus:

                        menuItem.setChecked(true);
                        displayMessage("Visit Us");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.donate:
                        startActivity(new Intent(getApplicationContext(), ActivityDonate.class));
                        menuItem.setChecked(true);
                        displayMessage("Donate");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.awards:
                        startActivity(new Intent(getApplicationContext(), ActivityAwards.class));
                        menuItem.setChecked(true);
                        displayMessage("Awards and Recognitions");
                        nDrawerLayout.closeDrawers();
                        return true;


                    case R.id.contactus:
                        startActivity(new Intent(getApplicationContext(), MapsActivity.class));
                        menuItem.setChecked(true);
                        displayMessage("Contact Us");
                        nDrawerLayout.closeDrawers();
                        return true;
                }


                return false;
            }
        });


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

            case R.id.don :
                startActivity(new Intent(getApplicationContext(), ActivityDonate.class));
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