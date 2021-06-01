package www.anandwan.com;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;
    //Button changeLang;
    TextView welcome;
    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    LinearLayout SlideInfoLayout;

    public String[] Years;

    public TextView heading;
    public TextView description;

    public String[] Headings;
    public String[] Descriptions;

    ViewPager viewPager1;

    ImageView LeftNav, RightNav;

    ViewPager viewPager2;

    ImageView LeftNavTime, RightNavTime;

    TextView yeartext,prevtext,nexttext,mrsswtxt,mrsshead;

    Button readMore,mrsswBtn,fstmstsbtn;

    ScrollView HScrollview;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);
        mTitle = mDrawerTitle = getTitle();
        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Anandwan Smart Village");
        nDrawerLayout = findViewById(R.id.drawerLayout);

        nDrawerToggle = new ActionBarDrawerToggle(this, nDrawerLayout, toolbar, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nDrawerToggle);

        nDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);

        Resources res = getResources();

        SlideInfoLayout = (LinearLayout) findViewById(R.id.SlideInfoLayout);

        Headings = res.getStringArray(R.array.imgHeadings);
        Descriptions = res.getStringArray(R.array.imgDescription);
        Years = res.getStringArray(R.array.Years);

        heading = (TextView) findViewById(R.id.textView);
        description = (TextView) findViewById(R.id.Description);

        HScrollview = findViewById(R.id.HomeScroll);

        viewPager1 = findViewById(R.id.viewPager);

        LeftNav = findViewById(R.id.left_nav);
        RightNav = findViewById(R.id.right_nav);

        viewPager2 = findViewById(R.id.viewPagerTimeline);

        LeftNavTime = findViewById(R.id.left_nav_timeline);
        RightNavTime = findViewById(R.id.right_nav_timeline);

        yeartext = findViewById(R.id.YearText);
        prevtext = findViewById(R.id.prevYear);
        nexttext = findViewById(R.id.nextYear);

        fstmstsbtn = (Button) findViewById(R.id.FMSTSSbtn);

        mrsshead = (TextView) findViewById(R.id.MRSSWhead);
        mrsswtxt = (TextView) findViewById(R.id.MRSSWtext);
        mrsswBtn = (Button) findViewById(R.id.MRSSWbtn);

        readMore = (Button) findViewById(R.id.button2);

        //changeLang = findViewById(R.id.button);
        welcome = findViewById(R.id.text);

       /*changeLang.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               showChangeLanguageDialog();

           }
       });*/
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

        HScrollview.isSmoothScrollingEnabled();

        final Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        mrsswtxt.setMaxLines(9);
        mrsswBtn.setText(R.string.ReadMore);
        mrsswBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mrsswBtn.getText().toString().equalsIgnoreCase("Read More")||
                        mrsswBtn.getText().toString().equalsIgnoreCase("अधिक पढ़ें")||
                        mrsswBtn.getText().toString().equalsIgnoreCase("पुढे वाचा"))
                {
                    mrsswtxt.setMaxLines(Integer.MAX_VALUE);//your TextView
                    mrsswBtn.setText(R.string.ReadLess);

                }
                else
                {
                    mrsswtxt.setMaxLines(9);//your TextView
                    mrsswtxt.getParent().requestChildFocus(mrsshead,mrsshead);
                    mrsswBtn.setText(R.string.ReadMore);

                }
            }
        });


        //ViewPager Adapter
        final ImageAdapter imageAdapter = new ImageAdapter(this);
        viewPager1.setAdapter(imageAdapter);

        final ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(this);
        viewPager2.setAdapter(viewpagerAdapter);

        final int pos = viewPager2.getCurrentItem();



        LeftNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager1.arrowScroll(ViewPager.FOCUS_LEFT);
            }
        });


        RightNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager1.arrowScroll(ViewPager.FOCUS_RIGHT);
            }
        });

        LeftNavTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.arrowScroll(ViewPager.FOCUS_LEFT);
            }
        });


        RightNavTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager2.arrowScroll(ViewPager.FOCUS_RIGHT);
            }
        });

        toggleArrowVisibility(true,false);
        toggleArrowVisibilityTimeline(true,false);

        //Viewpager1 readmore

        final int posA = viewPager1.getCurrentItem();
        heading.setText(Headings[posA]);
        description.setText(Descriptions[posA]);
        readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posA == 0){
                    openActivity0();
                }
            }
        });

        fstmstsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFS();
            }
        });


        //Year Text
        yeartext.setText(Years[pos]);

        if (pos > 0) {
            prevtext.setText(Years[pos - 1]);
        }
        if (pos < 7) {
            nexttext.setText(Years[pos + 1]);
        }


        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onPageSelected(final int position) {

                //Heading and description
                heading.setText(Headings[position]);
                description.setText(Descriptions[position]);


                //ViewPager1 readmore buttons
                readMore.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position == 0){
                            openActivity0();
                        }else if (position == 1){
                            openActivity1();
                        }else if (position == 2){
                            openActivity2();
                        }else if (position == 3){
                            openActivity3();
                        }

                    }
                });


                //Arrow visibility with respect to position for viewpager1
                if (position == 0){
                    toggleArrowVisibility(true,false);
                }else if (position == 1){
                    toggleArrowVisibility(false,false);
                }else if (position == 2){
                    toggleArrowVisibility(false,false);
                }else if (position == 3){
                    toggleArrowVisibility(false,true);
                }
                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                SlideInfoLayout.startAnimation(animFadeIn);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        nexttext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos!=7)
                    viewPager2.arrowScroll(ViewPager.FOCUS_RIGHT);
            }
        });

        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {

                prevtext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position!=0)
                            viewPager2.arrowScroll(ViewPager.FOCUS_LEFT);

                    }
                });

                nexttext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (position!=7)
                            viewPager2.arrowScroll(ViewPager.FOCUS_RIGHT);
                    }
                });

                yeartext.setText(Years[position]);

                if (position == 0){
                    prevtext.setText("Past");
                }
                if (position > 0) {
                    prevtext.setText(Years[position - 1]);
                }
                if (position < 8) {
                    nexttext.setText(Years[position + 1]);
                }
                //Arrow visibility with respect to position for viewpager2
                if (position == 0){
                    toggleArrowVisibilityTimeline(true,false);
                }else if (position == 1){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 2){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 3){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 4){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 5){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 6){
                    toggleArrowVisibilityTimeline(false,false);
                }else if (position == 7){
                    toggleArrowVisibilityTimeline(false,true);
                }

                Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                viewPager2.startAnimation(animFadeIn);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Auto timer for slideshow
        Timer timer = new Timer();
        timer.schedule(new MyTimerTask(), 9000,9000);



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
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        nDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
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
        Configuration config = new Configuration();
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



    public void onBackPressed(){

        AlertDialog.Builder alertdialoguebuilder = new AlertDialog.Builder(this);
        alertdialoguebuilder.setTitle("Exit Anandwan Smart Village")
                .setCancelable(false)
                .setPositiveButton(Html.fromHtml("<font color = '#e14c27'>Yes</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finishAffinity();
                        finish();

                    }
                })
                .setNegativeButton(Html.fromHtml("<font color = '#e14c27'>No</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertdialoguebuilder.create();
        alertDialog.show();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    //Timer for AutoImgSlider

    public class MyTimerTask extends TimerTask{

        @Override
        public void run() {

            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    if(viewPager1.getCurrentItem() == 0){
                        viewPager1.setCurrentItem(1);

                    }else if (viewPager1.getCurrentItem() == 1) {
                        viewPager1.setCurrentItem(2);

                    }else if (viewPager1.getCurrentItem() == 2){
                        viewPager1.setCurrentItem(3);

                    }else {
                        viewPager1.setCurrentItem(0);

                    }
                }
            });

        }
    }


    public void toggleArrowVisibility(boolean isAtZeroIndex, boolean isAtLastIndex) {
        if(isAtZeroIndex)
            LeftNav.setVisibility(View.INVISIBLE);
        else
            LeftNav.setVisibility(View.VISIBLE);

        if(isAtLastIndex)
            RightNav.setVisibility(View.INVISIBLE);
        else
            RightNav.setVisibility(View.VISIBLE);

    }

    public void toggleArrowVisibilityTimeline(boolean isAtZeroIndex, boolean isAtLastIndex) {
        if(isAtZeroIndex)
            LeftNavTime.setVisibility(View.INVISIBLE);
        else
            LeftNavTime.setVisibility(View.VISIBLE);
        if(isAtLastIndex)
            RightNavTime.setVisibility(View.INVISIBLE);
        else
            RightNavTime.setVisibility(View.VISIBLE);

    }

    //HomePage Inside pages

    public void openActivity0(){
        Intent intent0 = new Intent(this,AnandwanActivity.class);
        startActivity(intent0);
    }
    public void openActivity1(){
        Intent intent1 = new Intent(this,HemalkasaActivity.class);
        startActivity(intent1);
    }
    public void openActivity2(){
        Intent intent2 = new Intent(this,SomnathActivity.class);
        startActivity(intent2);
    }
    public void openActivity3(){
        Intent intent3 = new Intent(this,MulgavanActivity.class);
        startActivity(intent3);
    }
    public void openActivityFS(){
        Intent myIntentFs = new Intent( this,FromstonesActivity.class);
        startActivity(myIntentFs);
    }

    //Navigation drawer pages

}