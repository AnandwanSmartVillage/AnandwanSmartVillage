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

public class HemalkasaActivity <adapter>  extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    ViewPager viewPagerH1,viewPagerH2;
    ImageView leftNavH1,rightNavH1,leftNavH2,rightNavH2;
    int H1pos,H2pos;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_hemalkasa);

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
                        startActivity(new Intent(getApplicationContext(), Visitus.class));
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

        //BottomNav
        BottomNavigationView bottomNavigationView =findViewById(R.id.botton_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);

        viewPagerH1 = (ViewPager) findViewById(R.id.viewPagerH1);
        viewPagerH2 = (ViewPager) findViewById(R.id.viewPagerH2);

        leftNavH1 = (ImageView) findViewById(R.id.left_navH1);
        leftNavH2 = (ImageView) findViewById(R.id.left_navH2);
        rightNavH1 = (ImageView) findViewById(R.id.right_navH1);
        rightNavH2 = (ImageView) findViewById(R.id.right_navH2);

        final ViewpagerAdapterH1 viewpagerAdapterH1 = new ViewpagerAdapterH1(this);
        viewPagerH1.setAdapter(viewpagerAdapterH1);

        final ViewpagerAdapterH2 viewpagerAdapterH2 = new ViewpagerAdapterH2(this);
        viewPagerH2.setAdapter(viewpagerAdapterH2);


        H1pos = viewPagerH1.getCurrentItem();
        H2pos = viewPagerH2.getCurrentItem();

        leftNavH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (H1pos == 0){
                    viewPagerH1.setCurrentItem(6);
                }else if (H1pos == 1){
                    viewPagerH1.setCurrentItem(0);
                }else if (H1pos == 2){
                    viewPagerH1.setCurrentItem(1);
                }else if (H1pos == 3){
                    viewPagerH1.setCurrentItem(2);
                }else if (H1pos == 4){
                    viewPagerH1.setCurrentItem(3);
                }else if (H1pos == 5){
                    viewPagerH1.setCurrentItem(4);
                }

            }
        });


        rightNavH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (H1pos == 0) {
                    viewPagerH1.setCurrentItem(1);
                } else if (H1pos == 1) {
                    viewPagerH1.setCurrentItem(2);
                } else if (H1pos == 2) {
                    viewPagerH1.setCurrentItem(3);
                } else if (H1pos == 3) {
                    viewPagerH1.setCurrentItem(4);
                } else if (H1pos == 4) {
                    viewPagerH1.setCurrentItem(5);
                } else if (H1pos == 5) {
                    viewPagerH1.setCurrentItem(0);
                }
            }
        });

        leftNavH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (H2pos == 0){
                    viewPagerH2.setCurrentItem(6);
                }else if (H2pos == 1){
                    viewPagerH2.setCurrentItem(0);
                }else if (H2pos == 2){
                    viewPagerH2.setCurrentItem(1);
                }else if (H2pos == 3){
                    viewPagerH2.setCurrentItem(2);
                }else if (H2pos == 4){
                    viewPagerH2.setCurrentItem(3);
                }

            }
        });


        rightNavH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (H2pos == 0) {
                    viewPagerH2.setCurrentItem(1);
                } else if (H2pos == 1) {
                    viewPagerH2.setCurrentItem(2);
                } else if (H2pos == 2) {
                    viewPagerH2.setCurrentItem(3);
                } else if (H2pos == 3) {
                    viewPagerH2.setCurrentItem(4);
                } else if (H2pos == 4) {
                    viewPagerH2.setCurrentItem(0);
                }

            }
        });



        viewPagerH1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                leftNavH1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerH1.setCurrentItem(5);
                        }else if (position == 1){
                            viewPagerH1.setCurrentItem(0);
                        }else if (position == 2){
                            viewPagerH1.setCurrentItem(1);
                        }else if (position == 3){
                            viewPagerH1.setCurrentItem(2);
                        }else if (position == 4){
                            viewPagerH1.setCurrentItem(3);
                        }else if (position == 5){
                            viewPagerH1.setCurrentItem(4);
                        }

                    }
                });


                rightNavH1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (position == 0){
                            viewPagerH1.setCurrentItem(1);
                        }else if (position == 1){
                            viewPagerH1.setCurrentItem(2);
                        }else if (position == 2){
                            viewPagerH1.setCurrentItem(3);
                        }else if (position == 3){
                            viewPagerH1.setCurrentItem(4);
                        }else if (position == 4){
                            viewPagerH1.setCurrentItem(5);
                        }else if (position == 5){
                            viewPagerH1.setCurrentItem(0);
                        }


                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPagerH2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {


                leftNavH2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerH2.setCurrentItem(4);
                        }else if (position == 1){
                            viewPagerH2.setCurrentItem(0);
                        }else if (position == 2){
                            viewPagerH2.setCurrentItem(1);
                        }else if (position == 3){
                            viewPagerH2.setCurrentItem(2);
                        }else if (position == 4){
                            viewPagerH2.setCurrentItem(3);
                        }

                    }
                });


                rightNavH2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerH2.setCurrentItem(1);
                        }else if (position == 1){
                            viewPagerH2.setCurrentItem(2);
                        }else if (position == 2){
                            viewPagerH2.setCurrentItem(3);
                        }else if (position == 3){
                            viewPagerH2.setCurrentItem(4);
                        }else if (position == 4){
                            viewPagerH2.setCurrentItem(0);
                        }

                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //BottomNavListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home:
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


    public void Backbtn(View view) {
        Intent intent = new Intent(HemalkasaActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
