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

public class Livelihood  extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;


    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
    ImageView i1,i2,i3,i4,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11;
    TextView t1,t2,t3,t4;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_livelihood);

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

        b1=(TextView) findViewById(R.id.btnhandloom);
        b2=(TextView)findViewById(R.id.btnpowerloom);
        b3=(TextView)findViewById(R.id.btnsatranjicarpets);
        b4=(TextView) findViewById(R.id.btnbagcushion);
        i1=(ImageView)findViewById(R.id.imghan);
        t1=(TextView)findViewById(R.id.txthandloom);

        b5=(TextView)findViewById(R.id.btncarpentry);
        b6=(TextView)findViewById(R.id.btnwoodart);
        i2=(ImageView)findViewById(R.id.imgcarpentry);
        t2=(TextView)findViewById(R.id.txtcarpentry);

        b7=(TextView)findViewById(R.id.btnprintingpress);
        b8=(TextView)findViewById(R.id.btnshoemaking);
        b9=(TextView)findViewById(R.id.btnconstruction);
        i3=(ImageView)findViewById(R.id.imgprintingpress);
        t3=(TextView)findViewById(R.id.txtprintingpress);

        b10=(TextView)findViewById(R.id.btnpostermaking);
        b11=(TextView)findViewById(R.id.btngreetingcards);
        i4=(ImageView)findViewById(R.id.imgpostermaking);
        t4=(TextView)findViewById(R.id.txtpostermaking);


        L1 = (ImageView) findViewById(R.id.line1);
        L2 = (ImageView) findViewById(R.id.line2);
        L3 = (ImageView) findViewById(R.id.line3);
        L4 = (ImageView) findViewById(R.id.line4);

        L5 = (ImageView) findViewById(R.id.line01);
        L6 = (ImageView) findViewById(R.id.line02);

        L7 = (ImageView) findViewById(R.id.line001);
        L8 = (ImageView) findViewById(R.id.line002);
        L9 = (ImageView) findViewById(R.id.line003);

        L10 = (ImageView) findViewById(R.id.line11);
        L11 = (ImageView) findViewById(R.id.line112);


        L1.setBackgroundColor(Color.parseColor("#e42966"));
        L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L4.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L5.setBackgroundColor(Color.parseColor("#e42966"));
        L6.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L7.setBackgroundColor(Color.parseColor("#e42966"));
        L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L9.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L10.setBackgroundColor(Color.parseColor("#e42966"));
        L11.setBackgroundColor(Color.parseColor("#f2f2f2"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#e42966"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.handloom);
                t1.setText(R.string.handloom);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L2.setBackgroundColor(Color.parseColor("#e42966"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.powerloom);
                t1.setText(R.string.powerloom);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L3.setBackgroundColor(Color.parseColor("#e42966"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.satranjicarpets);
                t1.setText(R.string.satranjicarpents);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L4.setBackgroundColor(Color.parseColor("#e42966"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.bagandcushion);
                t1.setText(R.string.bagcushion);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L5.setBackgroundColor(Color.parseColor("#e42966"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i2.setImageResource(R.drawable.carpentry);
                t2.setText(R.string.carpentry);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L6.setBackgroundColor(Color.parseColor("#e42966"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i2.setImageResource(R.drawable.woodart);
                t2.setText(R.string.woodart);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L7.setBackgroundColor(Color.parseColor("#e42966"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i3.setImageResource(R.drawable.printingpress);
                t3.setText(R.string.printingpress);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L8.setBackgroundColor(Color.parseColor("#e42966"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i3.setImageResource(R.drawable.shoemaking);
                t3.setText(R.string.shoemaking);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L9.setBackgroundColor(Color.parseColor("#e42966"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i3.setImageResource(R.drawable.construction);
                t3.setText(R.string.livelihoodconstruction);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L10.setBackgroundColor(Color.parseColor("#e42966"));
                L11.setBackgroundColor(Color.parseColor("#f2f2f2"));

                i4.setImageResource(R.drawable.poster);
                t4.setText(R.string.postermaking);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L11.setBackgroundColor(Color.parseColor("#e42966"));
                L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i4.setImageResource(R.drawable.greeting);
                t4.setText(R.string.greetingcard);
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
