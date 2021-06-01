package www.anandwan.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

import static www.anandwan.com.R.string.horticulture;

public class Agriculture <adapter> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    TextView b1,b2,b3,b4,b5,b6,b7,b8,txtagri;
    ImageView i1,i2,L1,L2,L3,L4,L5,L6,L7,L8;
    TextView t1,t2;
    Button b1show,b2show,b3show;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_agriculture);
        Resources res = getResources();
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


        b1show=(Button)findViewById(R.id.btnlearnmore);
        txtagri=(TextView)findViewById(R.id.txtagriculture);
        txtagri.setMaxLines(9);

        L1 = (ImageView) findViewById(R.id.line1);
        L2 = (ImageView) findViewById(R.id.line2);
        L3 = (ImageView) findViewById(R.id.line3);
        L4 = (ImageView) findViewById(R.id.line4);
        L5 = (ImageView) findViewById(R.id.line5);
        L6 = (ImageView) findViewById(R.id.line111);
        L7 = (ImageView) findViewById(R.id.line112);
        L8 = (ImageView) findViewById(R.id.line113);


        b1=(TextView) findViewById(R.id.btnfloriculture);
        b2=(TextView)findViewById(R.id.btnhorticulture);
        b3=(TextView)findViewById(R.id.btnfodder);
        b4=(TextView) findViewById(R.id.btngrains);
        b5=(TextView)findViewById(R.id.btncotton);
        i1=(ImageView)findViewById(R.id.imgfloriculture);
        t1=(TextView)findViewById(R.id.txtfloriculture);

        b6=(TextView)findViewById(R.id.btndairy);
        b7=(TextView)findViewById(R.id.btnaquaculture);
        b8=(TextView)findViewById(R.id.btnpoultry);
        i2=(ImageView)findViewById(R.id.imgdairy);
        t2=(TextView)findViewById(R.id.txtdairy);

        b2show=(Button)findViewById(R.id.btnlearnmore1);
        b3show=(Button)findViewById(R.id.btnlearnmore2);
        t2.setMaxLines(3);
        t1.setMaxLines(6);

        L1.setBackgroundColor(Color.parseColor("#c1c42d"));
        L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L5.setBackgroundColor(Color.parseColor("#f2f2f2"));

        L6.setBackgroundColor(Color.parseColor("#c1c42d"));
        L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L8.setBackgroundColor(Color.parseColor("#f2f2f2"));

        b1show.setText(R.string.LearnMore);
        b2show.setText(R.string.LearnMore);
        b3show.setText(R.string.LearnMore);

        b1show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1show.getText().toString().equalsIgnoreCase("Learn More")||
                        b1show.getText().toString().equalsIgnoreCase("और जानें")||
                        b1show.getText().toString().equalsIgnoreCase("अधिक शिका"))
                {
                    txtagri.setMaxLines(Integer.MAX_VALUE);
                    b1show.setText(R.string.LearnLess);
                }
                else
                {
                    txtagri.setMaxLines(9);
                    txtagri.getParent().requestChildFocus(txtagri,txtagri);
                    b1show.setText(R.string.LearnMore);
                }
            }
        });

        b2show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b2show.getText().toString().equalsIgnoreCase("Learn More")||
                        b2show.getText().toString().equalsIgnoreCase("और जानें")||
                        b2show.getText().toString().equalsIgnoreCase("अधिक शिका"))
                {
                    t1.setMaxLines(Integer.MAX_VALUE);
                    b2show.setText(R.string.LearnLess);
                }
                else
                {
                    t1.setMaxLines(6);
                    t1.getParent().requestChildFocus(t1,t1);
                    b2show.setText(R.string.LearnMore);
                }
            }
        });

        b3show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b3show.getText().toString().equalsIgnoreCase("Learn More")||
                        b3show.getText().toString().equalsIgnoreCase("और जानें")||
                        b3show.getText().toString().equalsIgnoreCase("अधिक शिका"))
                {
                    t2.setMaxLines(Integer.MAX_VALUE);
                    b3show.setText(R.string.LearnLess);
                }
                else
                {
                    t2.setMaxLines(3);
                    t2.getParent().requestChildFocus(t2,t2);
                    b3show.setText(R.string.LearnMore);
                }
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#c1c42d"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.floriculture);
                t1.setText(R.string.floriculture);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L2.setBackgroundColor(Color.parseColor("#c1c42d"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.horticulture);
                t1.setText(horticulture);
                @SuppressLint("ResourceType") TextView textView =findViewById(R.id.txtfloriculture);
                String text= getResources().getString(R.string.Vegies);
                SpannableString ss=new SpannableString(text);
                StyleSpan bold =new StyleSpan(Typeface.BOLD);
                StyleSpan bold1=new StyleSpan(Typeface.BOLD);
                ss.setSpan(bold,0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ss.setSpan(bold1,288,295,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                textView.setText(ss);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#c1c42d"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.fooder);
                t1.setText(R.string.fodder);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#c1c42d"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.grains);
                t1.setText(R.string.grains);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#c1c42d"));
                i1.setImageResource(R.drawable.cotton);
                t1.setText(R.string.cotton);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L6.setBackgroundColor(Color.parseColor("#c1c42d"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i2.setImageResource(R.drawable.dairy);
                t2.setText(R.string.dairy);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L7.setBackgroundColor(Color.parseColor("#c1c42d"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i2.setImageResource(R.drawable.aquaculture);
                t2.setText(R.string.aquacultureagri);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L8.setBackgroundColor(Color.parseColor("#c1c42d"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i2.setImageResource(R.drawable.poultry);
                t2.setText(R.string.poultry);
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