package www.anandwan.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
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

import static www.anandwan.com.R.layout.activity_healthcare;
import static www.anandwan.com.R.string.sitaratan;

public class Healthcare  extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    ImageView L1,L2;
    Dialog mydialog;
    Button b1show,b2show,b3show;
    TextView txthealth;
    TextView b1,b2;
    ImageView i1,i2;
    TextView t1,t2;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(activity_healthcare);

        mydialog=new Dialog(this);


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


        L1 = (ImageView) findViewById(R.id.line1) ;
        L2 = (ImageView) findViewById(R.id.line2);

        b1=(TextView) findViewById(R.id.btnsitaratan);
        b2=(TextView) findViewById(R.id.btnshri);
        i1=(ImageView)findViewById(R.id.imgsitaratan);
        i2=(ImageView)findViewById(R.id.imglokbiradari);
        t1=(TextView)findViewById(R.id.txtsita);
        t2=(TextView)findViewById(R.id.txtlok);


        b1show=(Button)findViewById(R.id.btnlearnmore);
        b2show=(Button)findViewById(R.id.btnlearnmore1);
        b3show=(Button)findViewById(R.id.btnlearnmore2);
        txthealth=(TextView)findViewById(R.id.txthealthcare);
        txthealth.setMaxLines(10);
        t1.setMaxLines(9);
        t2.setMaxLines(14);

        b1show.setText(R.string.LearnMore);
        b2show.setText(R.string.LearnMore);
        b3show.setText(R.string.LearnMore);

        L1.setBackgroundColor(Color.parseColor("#00f3b1"));
        L2.setBackgroundColor(Color.parseColor("#f2f2f2"));

        b1show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b1show.getText().toString().equalsIgnoreCase("Learn More")||
                        b1show.getText().toString().equalsIgnoreCase("और जानें")||
                        b1show.getText().toString().equalsIgnoreCase("अधिक शिका"))
                {
                    txthealth.setMaxLines(Integer.MAX_VALUE);
                    b1show.setText(R.string.LearnLess);
                }
                else
                {
                    txthealth.setMaxLines(10);
                    txthealth.getParent().requestChildFocus(txthealth,txthealth);
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
                    t1.setMaxLines(9);
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
                    t2.setMaxLines(14);
                    t2.getParent().requestChildFocus(t2,t2);
                    b3show.setText(R.string.LearnMore);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                L1.setBackgroundColor(Color.parseColor("#00f3b1"));
                L2.setBackgroundColor(Color.parseColor("#f2f2f2"));
                i1.setImageResource(R.drawable.sitaratan);
                t1.setText(sitaratan);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                L2.setBackgroundColor(Color.parseColor("#00f3b1"));
                L1.setBackgroundColor(Color.parseColor("#00000000"));
                i1.setImageResource(R.drawable.shrishirdi1);
                t1.setText(R.string.shirdi);
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


    @SuppressLint("ResourceType")
    public void ShowPopup1(View v){
        TextView cross;
        Button btnprev1;
        mydialog.setContentView(R.layout.custompopup1);
        btnprev1=(Button)mydialog.findViewById(R.id.btnprev1);
        cross=(TextView) mydialog.findViewById(R.id.cross);

        btnprev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup2(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup2);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup3(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup3);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup4(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup4);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup5(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup5);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup6(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup6);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup7(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup7);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup8(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup8);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup9(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup9);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup10(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup10);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup11(View v){
        TextView cross;
        mydialog.setContentView(R.layout.custompopup11);
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }
    public void ShowPopup12(View v){
        TextView cross;
        Button btnnext12;
        mydialog.setContentView(R.layout.custompopup12);
        btnnext12=(Button)mydialog.findViewById(R.id.btnnext12);
        btnnext12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        cross=(TextView) mydialog.findViewById(R.id.cross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mydialog.dismiss();
            }
        });
        mydialog.show();
    }

}
