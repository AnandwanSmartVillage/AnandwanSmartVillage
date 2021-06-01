package www.anandwan.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class ActivityDonate  extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    public Button button;
    TextView txt , tx , text, ttxt, texts, textv,t1,t2;
    TextView btn;
    TextView btna;
    View view1,view2,view3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_donate);

        Resources res = getResources();

        button = (Button) findViewById(R.id.fip);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityDonate.this, ActivityContact.class);
                startActivity(intent);
            }
        });


        txt = (TextView) findViewById(R.id.mytext);
        tx = (TextView)findViewById(R.id.mytex);
        text = (TextView)findViewById(R.id.myte);
        ttxt = (TextView)findViewById(R.id.myt);
        texts = (TextView) findViewById(R.id.sec);
        textv = (TextView)findViewById(R.id.txt);

        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView1);


        btn = (TextView) findViewById(R.id.butt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tx.setText(getResources().getString(R.string.AF));
                text.setText(getResources().getString(R.string.MF));
                textv.setVisibility(View.GONE);
                texts.setVisibility(View.GONE);

                ttxt.setText(getResources().getString(R.string.ADttxt));
                t1.setText(getResources().getString(R.string.donates));
                t2.setText(getResources().getString(R.string.donates));
                t1.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                tx.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);

                txt.setText(getResources().getString(R.string.ADtxt));

                view1.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
            }
        });

        txt = (TextView) findViewById(R.id.mytext);
        ttxt = (TextView)findViewById(R.id.myt);
        tx = (TextView)findViewById(R.id.mytex);
        text = (TextView)findViewById(R.id.myte);
        texts = (TextView) findViewById(R.id.sec);
        textv = (TextView)findViewById(R.id.txt);
        btna = (TextView) findViewById(R.id.butto);
        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView1);


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tx.setVisibility(View.GONE);
                text.setVisibility(View.GONE);
                textv.setVisibility(View.GONE);
                texts.setVisibility(View.GONE);

                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.VISIBLE);

                t1.setVisibility(View.GONE);
                t2.setVisibility(View.GONE);




                txt.setText(getResources().getString(R.string.adtxt));
                ttxt.setText(getResources().getString(R.string.DonateTXT));


            }
        });


        txt = (TextView) findViewById(R.id.mytext);
        tx = (TextView)findViewById(R.id.mytex);
        text = (TextView)findViewById(R.id.myte);
        ttxt = (TextView)findViewById(R.id.myt);
        texts = (TextView) findViewById(R.id.sec);
        textv = (TextView)findViewById(R.id.txt);
        btna = (TextView) findViewById(R.id.but);
        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        t1 = (TextView)findViewById(R.id.textView);
        t2 = (TextView)findViewById(R.id.textView1);


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tx.setText(getResources().getString(R.string.CDD));
                text.setText(getResources().getString(R.string.donate_111));
                tx.setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                texts.setVisibility(View.VISIBLE);
                textv.setVisibility(View.VISIBLE);
                ttxt.setText(getResources().getString(R.string.st));


                txt.setText(getResources().getString(R.string.indian));

                texts.setText(getResources().getString(R.string.donate_13));

                textv.setText(getResources().getString(R.string.address));

                view2.setVisibility(View.INVISIBLE);
                view3.setVisibility(View.INVISIBLE);
                view1.setVisibility(View.VISIBLE);

                t1.setVisibility(View.GONE);
                t2.setVisibility(View.GONE);


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