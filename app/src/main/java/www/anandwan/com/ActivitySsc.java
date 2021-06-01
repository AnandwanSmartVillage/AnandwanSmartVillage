package www.anandwan.com;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;

public class ActivitySsc extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    TextView button;
    DownloadManager downloadManager;

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;



    public Button bt2;

    private ViewFlipper viewFlipper;

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_ssc);
        viewFlipper = findViewById(R.id.vf);

        Resources res = getResources();

        TextView textView = findViewById(R.id.ssc1);
        String text = getResources().getString(R.string.ssq);
        SpannableString ss= new SpannableString(text);


        TextView textView1 = findViewById(R.id.theme);
        String text1 = getResources().getString(R.string.ss1);
        SpannableString ss1= new SpannableString(text1);

        StyleSpan bold1 = new StyleSpan(Typeface.BOLD);

        ss1.setSpan(bold1,0 , 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView1.setText(ss1);


        TextView textView2 = findViewById(R.id.org);
        String text2 = getResources().getString(R.string.ss2);
        SpannableString ss2= new SpannableString(text2);

        StyleSpan bold2 = new StyleSpan(Typeface.BOLD);

        ss2.setSpan(bold2,0 , 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView2.setText(ss2);

        TextView textView3 = findViewById(R.id.age);
        String text3 = getResources().getString(R.string.ss3);
        SpannableString ss3= new SpannableString(text3);

        StyleSpan bold3 = new StyleSpan(Typeface.BOLD);

        ss3.setSpan(bold3,0 , 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView3.setText(ss3);

        TextView textView4 = findViewById(R.id.part);
        String text4 = getResources().getString(R.string.ss4);
        SpannableString ss4= new SpannableString(text4);

        StyleSpan bold4 = new StyleSpan(Typeface.BOLD);

        ss4.setSpan(bold4,0 , 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView4.setText(ss4);

        TextView textView5 = findViewById(R.id.register);
        String tex5t = getResources().getString(R.string.ss5);
        SpannableString ss5= new SpannableString(tex5t);

        StyleSpan bold5 = new StyleSpan(Typeface.BOLD);

        ss5.setSpan(bold5,0 , 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView5.setText(ss5);


        TextView textView6 = findViewById(R.id.ssc2);
        String text6 = getResources().getString(R.string.ss6);
        SpannableString ss6= new SpannableString(text6);

        StyleSpan bold6 = new StyleSpan(Typeface.BOLD);



        TextView textView7 = findViewById(R.id.ssc3);
        String text7 = getResources().getString(R.string.ss7);
        SpannableString ss7= new SpannableString(text7);

        StyleSpan bold7 = new StyleSpan(Typeface.BOLD);


        TextView textView8 = findViewById(R.id.camp);
        String text8 = getResources().getString(R.string.ss8);
        SpannableString ss8= new SpannableString(text8);

        StyleSpan bold8 = new StyleSpan(Typeface.BOLD);

        ss8.setSpan(bold8,0 , 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView8.setText(ss8);






        bt2 = (Button) findViewById(R.id.ss1);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivitySsc.this, ActivityAwards.class);
                startActivity(intent);
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


        button = (TextView) findViewById(R.id.download1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://anandwan.in/pdf/Baba%20Amte's%2052nd_Shram%20Sanskaar%20Chhavani%202019.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference  = downloadManager.enqueue(request);
            }
        });


        button = (TextView) findViewById(R.id.download2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse("https://anandwan.in/pdf/Shram%20Sanskaar%20Chhavani%20%20-%20Photo%20Gallery.pdf");
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                Long reference  = downloadManager.enqueue(request);
            }
        });




    }

    public void prev(View v) {
        viewFlipper.showPrevious();

    }

    public void next(View v) {
        viewFlipper.showNext();

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