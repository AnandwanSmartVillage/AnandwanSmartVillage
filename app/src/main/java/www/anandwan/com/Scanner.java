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
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Scanner extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;
    public TextView tvresult;
    private Timer timer;
    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_scanner);

        Button btn_scan = (Button) findViewById(R.id.scan_btn);
        final Activity activity = this;
        //toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nDrawerLayout = findViewById(R.id.drawerLayout);
        nDrawerToggle = new ActionBarDrawerToggle(this, nDrawerLayout, toolbar, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nDrawerToggle);
        nDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        //scanner
        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

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

        bottomNavigationView.setSelectedItemId(R.id.scanner);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.scanner:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.navigate:
                        startActivity(new Intent(getApplicationContext(),Maps_fullscreen.class));
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



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null)
        {
            /* Toast.makeText(this,result.getContents(),Toast.LENGTH_LONG) .show();*/
            if(result.getContents()==null)
            {
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG) .show();
            }
            else
            {
                /*Intent borrowerIntent = new Intent(Intent.ACTION_VIEW,Uri.parse(result.getContents()));
                startActivity(borrowerIntent);*/
                String aa = result.getContents();
                //result.getContents().toString();
                //tvresult.setText(result.getContents());
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG) .show();



               /* switch(result.getContents()) {
                    case "@string/ANANDWAN":

                }*/
                if (aa.equals("ABHAYARANYA")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Abhayaranya.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("BIOGAS PROJECT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Biogas.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("ANAND AGRICULTURE POLYTECHNIC")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, AgriculturePoly.class);
                            startActivity(intent);
                        }
                    }, 100);
                }

                else if (aa.equals("ANAND BLIND SCHOOL")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, BlindSchool.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("ANAND DEAF MUTE SCHOOL")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,DeafMuteSchool.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("ANAND NIKETAN AGRICULTURAL COLLAGE")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, AgricultureCollege.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("ANAND NIKETAN ARTS COMMERCE AND SCIENCE COLLAGE")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, AnandNitekanArtsCollege.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("BAG AND CUSHION SECTION")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,BagAndCushion.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("CARPENTRY DEPARTMENT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Carpentry.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("Dairy")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Dairy.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("FOOTWEAR DEPARTMENT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Footware.class);
                            startActivity(intent);
                        }
                    }, 100);
                }

                else if (aa.equals("Gokul")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Gokul.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("HANDICRAFTS - GREETING CARDS")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Greetings.class);
                            startActivity(intent);
                        }
                    }, 100);
                }

                else if (aa.equals("HANDICRAFTS - POSTERS")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Posters.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("METAL FABRICATION")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,MetalFabrication.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("MEGA KITCHEN")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,MegaKitchen.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("HandLooms")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Handloom.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("MUKTANGAN ANGANWADI")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,Muktangan.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("MIYAWAKI FOREST")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Miyavaki.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("PowerLooms")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, PowerLoom.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("PRINTING PRESS")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,PrintingPress.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SATRANJI DEPARTMENT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, SatranjiDepartment.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SANDHINIKETAN")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, SandhiNiketan.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SEETA RATAN HOSPITAL")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,SeetaRatanHospital.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SHIRDI SAIBABA HOSPITAL")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, SaibabaHospital.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SNEHSAVALI")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Snehsavali.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("STRISSUE")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,Streeisseu.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("SHRADDHAVAN")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,Shradhawan.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("Swaranandwan")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Swaranandwan.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("WOOL WORK AND SWEATER DEPARTMENT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this,WoolArtAndSweater.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("WOOD ART DEPARTMENT")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, Woodart.class);
                            startActivity(intent);
                        }
                    }, 100);
                }
                else if (aa.equals("ZILLA PARISHAD SCHOOL ANANDWAN")) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Scanner.this, ZillaParishadSchool.class);
                            startActivity(intent);
                        }
                    }, 100);
                }

            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }



    }
}

