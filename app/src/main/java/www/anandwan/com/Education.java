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

public class Education <adapter> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    TextView b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b1show,b2show;
    ImageView img1,img2,img3,L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12,L13;
    TextView txt1,txt2,txt3;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_education);

        b1show=(Button)findViewById(R.id.btnlearnmore1);
        b2show=(Button)findViewById(R.id.btnlearnmore2);

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
                        startActivity(new Intent(getApplicationContext(),MapsActivity.class));
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

        L1 = (ImageView) findViewById(R.id.line1);
        L2 = (ImageView) findViewById(R.id.line11);
        L3 = (ImageView) findViewById(R.id.line12);
        L4 = (ImageView) findViewById(R.id.line13);
        L5 = (ImageView) findViewById(R.id.line14);
        L6 = (ImageView) findViewById(R.id.line15);
        L7 = (ImageView) findViewById(R.id.line16);
        L8 = (ImageView) findViewById(R.id.line01);
        L9 = (ImageView) findViewById(R.id.line02);
        L10 = (ImageView) findViewById(R.id.line03);
        L11 = (ImageView) findViewById(R.id.line111);
        L12 = (ImageView) findViewById(R.id.line112);
        L13 = (ImageView) findViewById(R.id.line113);

        b1=(TextView) findViewById(R.id.btnmuktangan);
        b2=(TextView)findViewById(R.id.btnzilla);
        b3=(TextView)findViewById(R.id.btnlbaashram);
        b4=(TextView) findViewById(R.id.btnlbasadhana);
        b5=(TextView)findViewById(R.id.btnaanandan);
        b6=(TextView)findViewById(R.id.btnagricollege);
        b7=(TextView) findViewById(R.id.btnagripoly);
        b8=(TextView)findViewById(R.id.btnanandblind);
        b9=(TextView)findViewById(R.id.btnananddeaf);
        b10=(TextView) findViewById(R.id.btnSandhiniketan);
        b11=(TextView)findViewById(R.id.btnconstruction);
        b12=(TextView)findViewById(R.id.btnscrapbank);
        b13=(TextView) findViewById(R.id.btnminimarket);

        img1=(ImageView)findViewById(R.id.imgmuktangana);
        img2=(ImageView)findViewById(R.id.imganadblind);
        img3=(ImageView)findViewById(R.id.imgconstruction);
        txt1=(TextView)findViewById(R.id.txtmuktangan);
        txt2=(TextView)findViewById(R.id.txtanandblind);
        txt3=(TextView)findViewById(R.id.txtconstruction);

        txt1.setMaxLines(4);
        txt2.setMaxLines(4);

        L1.setBackgroundColor(Color.parseColor("#5caeff"));
        L8.setBackgroundColor(Color.parseColor("#5caeff"));
        L11.setBackgroundColor(Color.parseColor("#5caeff"));
        L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L12.setBackgroundColor(Color.parseColor("#f2f2f2"));
        L13.setBackgroundColor(Color.parseColor("#f2f2f2"));

        b1show.setText(R.string.LearnMore);
        b2show.setText(R.string.LearnMore);

        b1show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1show.getText().toString().equalsIgnoreCase("Learn More")||
                        b1show.getText().toString().equalsIgnoreCase("और जानें")||
                        b1show.getText().toString().equalsIgnoreCase("अधिक शिका"))
                {
                    txt1.setMaxLines(Integer.MAX_VALUE);
                    b1show.setText(R.string.LearnLess);
                }
                else
                {   txt1.setMaxLines(4);
                    txt1.getParent().requestChildFocus(txt1,txt1);
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
                    txt2.setMaxLines(Integer.MAX_VALUE);
                    b2show.setText(R.string.LearnLess);
                }
                else
                {   txt2.setMaxLines(4);
                    txt2.getParent().requestChildFocus(txt2,txt2);
                    b2show.setText(R.string.LearnMore);
                }
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.muktangan);
                txt1.setText(R.string.muktangan);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L2.setBackgroundColor(Color.parseColor("#5caeff"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.zillaparishadschool);
                txt1.setText(R.string.zilla);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L3.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.lbpashram);
                txt1.setText(R.string.lbpashramshala);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L4.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.lbpsandhanvidyalaya);
                txt1.setText(R.string.lbpsadhana);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L5.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.anandniketan);
                txt1.setText(R.string.anandanniketan);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L6.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L7.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.agricollege);
                txt1.setText(R.string.agricollege);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L7.setBackgroundColor(Color.parseColor("#5caeff"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L3.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L4.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L5.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L6.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L1.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img1.setImageResource(R.drawable.agripoly);
                txt1.setText(R.string.agripolytechnic);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L8.setBackgroundColor(Color.parseColor("#5caeff"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img2.setImageResource(R.drawable.anandblindschool);
                txt2.setText(R.string.anandblindschool);
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L9.setBackgroundColor(Color.parseColor("#5caeff"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L10.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img2.setImageResource(R.drawable.ananddeafandmute);
                txt2.setText(R.string.ananddeafandmute);
            }
        });

        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L10.setBackgroundColor(Color.parseColor("#5caeff"));
                L9.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L8.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img2.setImageResource(R.drawable.sandhiniketanedu);
                txt2.setText(R.string.sandhiniketan);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L11.setBackgroundColor(Color.parseColor("#5caeff"));
                L12.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L13.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img3.setImageResource(R.drawable.constructiontraining);
                txt3.setText(R.string.construction);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L12.setBackgroundColor(Color.parseColor("#5caeff"));
                L11.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L13.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img3.setImageResource(R.drawable.scrapbank);
                txt3.setText(R.string.scarpbank);
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L13.setBackgroundColor(Color.parseColor("#5caeff"));
                L12.setBackgroundColor(Color.parseColor("#f2f2f2"));
                L11.setBackgroundColor(Color.parseColor("#f2f2f2"));
                img3.setImageResource(R.drawable.minimarket);
                txt3.setText(R.string.minimarket);
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
