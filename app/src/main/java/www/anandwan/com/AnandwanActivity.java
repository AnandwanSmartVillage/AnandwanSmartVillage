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

public class AnandwanActivity <adapter> extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    ViewPager viewPagerA1,viewPagerA2;
    ImageView leftNavA1,rightNavA1,leftNavA2,rightNavA2;
    int A1pos,A2pos;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_anandwan);

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
        bottomNavigationView.setSelectedItemId(R.id.home);


        viewPagerA1 = (ViewPager) findViewById(R.id.viewPagerA1);
        viewPagerA2 = (ViewPager) findViewById(R.id.viewPagerA2);

        leftNavA1 = (ImageView) findViewById(R.id.left_navA1);
        leftNavA2 = (ImageView) findViewById(R.id.left_navA2);
        rightNavA1 = (ImageView) findViewById(R.id.right_navA1);
        rightNavA2 = (ImageView) findViewById(R.id.right_navA2);

        final ViewpagerAdapterA1 viewpagerAdapterA1 = new ViewpagerAdapterA1(this);
        viewPagerA1.setAdapter(viewpagerAdapterA1);

        final ViewpagerAdapterA2 viewpagerAdapterA2 = new ViewpagerAdapterA2(this);
        viewPagerA2.setAdapter(viewpagerAdapterA2);

        A1pos = viewPagerA1.getCurrentItem();
        A2pos = viewPagerA2.getCurrentItem();

        leftNavA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (A1pos == 0){
                    viewPagerA1.setCurrentItem(6);
                }else if (A1pos == 1){
                    viewPagerA1.setCurrentItem(0);
                }else if (A1pos == 2){
                    viewPagerA1.setCurrentItem(1);
                }else if (A1pos == 3){
                    viewPagerA1.setCurrentItem(2);
                }else if (A1pos == 4){
                    viewPagerA1.setCurrentItem(3);
                }else if (A1pos == 5){
                    viewPagerA1.setCurrentItem(4);
                }else if (A1pos == 6){
                    viewPagerA1.setCurrentItem(5);
                }

            }
        });


        rightNavA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (A1pos == 0) {
                    viewPagerA1.setCurrentItem(1);
                } else if (A1pos == 1) {
                    viewPagerA1.setCurrentItem(2);
                } else if (A1pos == 2) {
                    viewPagerA1.setCurrentItem(3);
                } else if (A1pos == 3) {
                    viewPagerA1.setCurrentItem(4);
                } else if (A1pos == 4) {
                    viewPagerA1.setCurrentItem(5);
                } else if (A1pos == 5) {
                    viewPagerA1.setCurrentItem(6);
                } else if (A1pos == 6) {
                    viewPagerA1.setCurrentItem(0);
                }
            }
        });

        leftNavA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (A2pos == 0){
                    viewPagerA2.setCurrentItem(6);
                }else if (A2pos == 1){
                    viewPagerA2.setCurrentItem(0);
                }else if (A2pos == 2){
                    viewPagerA2.setCurrentItem(1);
                }else if (A2pos == 3){
                    viewPagerA2.setCurrentItem(2);
                }else if (A2pos == 4){
                    viewPagerA2.setCurrentItem(3);
                }else if (A2pos == 5){
                    viewPagerA2.setCurrentItem(4);
                }else if (A2pos == 6){
                    viewPagerA2.setCurrentItem(5);
                }

            }
        });


        rightNavA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (A2pos == 0) {
                    viewPagerA2.setCurrentItem(1);
                } else if (A2pos == 1) {
                    viewPagerA2.setCurrentItem(2);
                } else if (A2pos == 2) {
                    viewPagerA2.setCurrentItem(3);
                } else if (A2pos == 3) {
                    viewPagerA2.setCurrentItem(4);
                } else if (A2pos == 4) {
                    viewPagerA2.setCurrentItem(5);
                } else if (A2pos == 5) {
                    viewPagerA2.setCurrentItem(6);
                } else if (A2pos == 6) {
                    viewPagerA2.setCurrentItem(0);
                }

            }
        });





        viewPagerA1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                leftNavA1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerA1.setCurrentItem(6);
                        }else if (position == 1){
                            viewPagerA1.setCurrentItem(0);
                        }else if (position == 2){
                            viewPagerA1.setCurrentItem(1);
                        }else if (position == 3){
                            viewPagerA1.setCurrentItem(2);
                        }else if (position == 4){
                            viewPagerA1.setCurrentItem(3);
                        }else if (position == 5){
                            viewPagerA1.setCurrentItem(4);
                        }else if (position == 6){
                            viewPagerA1.setCurrentItem(5);
                        }

                    }
                });


                rightNavA1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if (position == 0){
                            viewPagerA1.setCurrentItem(1);
                        }else if (position == 1){
                            viewPagerA1.setCurrentItem(2);
                        }else if (position == 2){
                            viewPagerA1.setCurrentItem(3);
                        }else if (position == 3){
                            viewPagerA1.setCurrentItem(4);
                        }else if (position == 4){
                            viewPagerA1.setCurrentItem(5);
                        }else if (position == 5){
                            viewPagerA1.setCurrentItem(6);
                        }else if (position == 6){
                            viewPagerA1.setCurrentItem(0);
                        }


                    }
                });

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        viewPagerA2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                leftNavA2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerA2.setCurrentItem(4);
                        }else if (position == 1){
                            viewPagerA2.setCurrentItem(0);
                        }else if (position == 2){
                            viewPagerA2.setCurrentItem(1);
                        }else if (position == 3){
                            viewPagerA2.setCurrentItem(2);
                        }else if (position == 4){
                            viewPagerA2.setCurrentItem(3);
                        }

                    }
                });


                rightNavA2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (position == 0){
                            viewPagerA2.setCurrentItem(1);
                        }else if (position == 1){
                            viewPagerA2.setCurrentItem(2);
                        }else if (position == 2){
                            viewPagerA2.setCurrentItem(3);
                        }else if (position == 3){
                            viewPagerA2.setCurrentItem(4);
                        }else if (position == 4){
                            viewPagerA2.setCurrentItem(0);
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
        Intent intent = new Intent(AnandwanActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
