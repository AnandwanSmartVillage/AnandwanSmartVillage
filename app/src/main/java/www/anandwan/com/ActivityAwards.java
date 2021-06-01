package www.anandwan.com;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ActivityAwards  extends  AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ViewFlipper viewFlipper;
    private ViewFlipper viewFlipper1;

    TextView awd1,awd2;

    //Toolbar
    Toolbar toolbar;
    DrawerLayout nDrawerLayout;
    ActionBarDrawerToggle nDrawerToggle;
    Spinner spinner;

    Menu globalMenuItem;
    private android.os.LocaleList LocaleList;
    private Object position;
    private AdapterView parent;


    ViewFlipper v_flipper;
    Button button;
    TextView txt1;
    TextView txt2;
    TextView txt3;
    TextView txt4;
    TextView txt5;
    TextView txt6;
    TextView txt7;
    TextView txt8;
    TextView txt9;
    TextView txt10;

    TextView tx1;
    TextView tx2;
    TextView tx3;
    TextView tx4;
    TextView tx5;
    TextView tx6;
    TextView tx7;
    TextView tx8;
    TextView tx9;
    TextView tx10;
    TextView tx11;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;

    LinearLayout l1;
    LinearLayout l2;
    LinearLayout l3;
    LinearLayout l4;
    LinearLayout l5;
    LinearLayout l6;




    View v1;
    View v2;
    View v3;
    View v4;
    View v5;


    private int ci1;
    int[] aw1={R.drawable.awa};

    private int ci2;
    int[] aw2={R.drawable.awb};

    private int ci3;
    int[] aw3={R.drawable.awc};

    private int ci4;
    int[] aw4={R.drawable.awd};

    private int ci5;
    int[] aw5={R.drawable.awe};

    private int ci6;
    int[] aw6={R.drawable.awf};

    private int ci7;
    int[] aw7={R.drawable.gd};


    Button btn;
    TextView txt;
    TextView txta;
    TextView txtb;
    TextView txtc;
    TextView txtd;
    TextView txte;
    TextView txtf;
    TextView txtg;
    TextView txth;
    TextView txti;
    TextView tx;
    TextView txa;
    TextView txb;
    TextView txc;
    TextView txd;
    TextView txe;
    TextView txf;
    TextView txg;
    TextView txh;
    TextView txi;
    TextView txj;

    ImageView img;
    ImageView imga;
    ImageView imgb;
    ImageView imgc;
    ImageView imgd;
    ImageView imge;
    ImageView imgf;

    View va1;
    View va2;
    View va3;
    View va4;
    View va5;

    LinearLayout la;
    LinearLayout lb;
    LinearLayout lc;
    LinearLayout ld;
    LinearLayout le;
    LinearLayout lf;



    private int ci;
    int[] aw={R.drawable.awba};

    private int cia;
    int[] awa={R.drawable.awdb};

    private int cib;
    int[] awb={R.drawable.awdc};







    TextView txtaa;
    TextView txtab;
    TextView txtac;
    TextView txtad;
    TextView txtae;
    TextView txtaf;
    TextView txtag;
    TextView txtah;
    TextView txtai;
    TextView txtaj;
    TextView txaa;
    TextView txab;
    TextView txac;
    TextView txad;
    TextView txae;
    TextView txaf;
    TextView txag;
    TextView txah;
    TextView txai;
    TextView txaj;
    TextView txak;
    ImageView imgaa;
    ImageView imgab;
    ImageView imgac;
    ImageView imgad;
    ImageView imgae;
    ImageView imgaf;
    ImageView imgag;
    Button btnb;

    View vb1;
    View vb2;
    View vb3;
    View vb4;
    View vb5;




    private int ciaa;
    int[] awaa={R.drawable.awca};

    private int ciab;
    int[] awab={R.drawable.awcb};

    private int ciac;
    int[] awac={R.drawable.awcc};

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();

        Resources res = getResources();

        setContentView(R.layout.activity_awards);

        viewFlipper = findViewById(R.id.vf);
        viewFlipper1 = findViewById(R.id.vf1);


        awd1 = (TextView) findViewById(R.id.awitxt);
        awd2 = (TextView) findViewById(R.id.awdii);

        awd1.setVisibility(View.GONE);
        awd2.setVisibility(View.GONE);



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


        txt = (TextView) findViewById(R.id.awtxt);
        txta = (TextView) findViewById(R.id.awbtxt);
        txtb = (TextView) findViewById(R.id.awctxt);
        txtc = (TextView) findViewById(R.id.awdtxt);
        txtd = (TextView) findViewById(R.id.awetxt);
        txte = (TextView) findViewById(R.id.awftxt);
        txtf = (TextView) findViewById(R.id.awgtxt);
        txtg = (TextView) findViewById(R.id.awhtxt);
        txth = (TextView) findViewById(R.id.awitxt);
        txti = (TextView) findViewById(R.id.awktxt);

        tx = (TextView) findViewById(R.id.awd);
        txa = (TextView) findViewById(R.id.awdbb);
        txb = (TextView) findViewById(R.id.awdcc);
        txc = (TextView) findViewById(R.id.awddd);
        txd = (TextView) findViewById(R.id.awdee);
        txe = (TextView) findViewById(R.id.awdff);
        txf = (TextView) findViewById(R.id.awdgg);
        txg = (TextView) findViewById(R.id.awdhh);
        txh = (TextView) findViewById(R.id.awd1);
        txi = (TextView) findViewById(R.id.awdii);
        txj = (TextView) findViewById(R.id.awdkk);

        img = (ImageView) findViewById(R.id.awda);
        imga = (ImageView) findViewById(R.id.awdb);
        imgb = (ImageView) findViewById(R.id.awdc);
        imgc = (ImageView) findViewById(R.id.awdd);
        imgd = (ImageView) findViewById(R.id.awde);
        imge = (ImageView) findViewById(R.id.awdf);
        imgf = (ImageView) findViewById(R.id.awdk);


        va1 = (View)findViewById(R.id.v1);
        va2 = (View)findViewById(R.id.v2);
        va3 = (View)findViewById(R.id.v3);
        va4 = (View)findViewById(R.id.v4);
        va5 = (View)findViewById(R.id.v5);



        btn = (Button) findViewById(R.id.nat);
        btn.setOnClickListener(new View.OnClickListener() {

            Drawable background1 = btn.getBackground();
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tx.setText(getResources().getString(R.string.tx));

                txa.setText(getResources().getString(R.string.txa));

                txb.setText(getResources().getString(R.string.txb));


                txc.setVisibility(View.GONE);
                txd.setVisibility(View.GONE);
                txe.setVisibility(View.GONE);
                txh.setVisibility(View.GONE);



                txi.setText(getResources().getString(R.string.txi));

                txj.setVisibility(View.GONE);



                txf.setText(getResources().getString(R.string.txf));

                txg.setText(getResources().getString(R.string.txg));

                txt.setText(getResources().getString(R.string.txt));

                txta.setText(getResources().getString(R.string.txta));

                txtb.setText(getResources().getString(R.string.txtb));

                txtc.setVisibility(View.GONE);

                txtd.setVisibility(View.GONE);

                txte.setVisibility(View.GONE);

                txtf.setText(getResources().getString(R.string.txtf));

                txtg.setText(getResources().getString(R.string.txtg));

                txth.setText(getResources().getString(R.string.txth));

                txti.setVisibility(View.GONE);


                imgc.setVisibility(View.GONE);
                imgd.setVisibility(View.GONE);
                imge.setVisibility(View.GONE);
                imgf.setVisibility(View.GONE);


                va1.setVisibility(View.GONE);
                va2.setVisibility(View.GONE);
                va3.setVisibility(View.GONE);
                va4.setVisibility(View.GONE);
                va5.setVisibility(View.GONE);

                txth.setVisibility(View.VISIBLE);
                txi.setVisibility(View.VISIBLE);


                ci++;
                ci= ci % aw.length;
                img.setImageResource(aw[ci]);

                cia++;
                cia= cia % awa.length;
                imga.setImageResource(awa[cia]);

                cib++;
                cib= cib % awb.length;
                imgb.setImageResource(awb[cib]);

                if(btn.getText().equals("NATIONAL AWARDS"))
                {
                    btn.setText("NATIONAL AWARDS");
                    btn.setBackgroundResource(R.color.col);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }
                else if (btn.getText().equals("NATIONAL AWARDS"))
                {
                    btn.setText("NATIONAL AWARDS");
                    btn.setBackground(background1);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }

                if(btn.getText().equals("राष्ट्रीय पुरस्कार"))
                {
                    btn.setText("राष्ट्रीय पुरस्कार");
                    btn.setBackgroundResource(R.color.col);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }
                else if (btn.getText().equals("राष्ट्रीय पुरस्कार"))
                {
                    btn.setText("राष्ट्रीय पुरस्कार");
                    btn.setBackground(background1);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }

                if(btn.getText().equals("राष्ट्रीय पुरस्कार"))
                {
                    btn.setText("राष्ट्रीय पुरस्कार");
                    btn.setBackgroundResource(R.color.col);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }
                else if (btn.getText().equals("राष्ट्रीय पुरस्कार"))
                {
                    btn.setText("राष्ट्रीय पुरस्कार");
                    btn.setBackground(background1);
                    button.setBackground(background1);
                    btnb.setBackground(background1);
                }
            }
        });



        txtaa = (TextView) findViewById(R.id.awtxt);
        txtab = (TextView) findViewById(R.id.awbtxt);
        txtac = (TextView) findViewById(R.id.awctxt);
        txtad = (TextView) findViewById(R.id.awdtxt);
        txtae = (TextView) findViewById(R.id.awetxt);
        txtaf = (TextView) findViewById(R.id.awftxt);
        txtag = (TextView) findViewById(R.id.awgtxt);
        txtah = (TextView) findViewById(R.id.awhtxt);
        txtai = (TextView) findViewById(R.id.awitxt);
        txtaj = (TextView) findViewById(R.id.awktxt);

        txaa = (TextView) findViewById(R.id.awd);
        txab = (TextView) findViewById(R.id.awdbb);
        txac = (TextView) findViewById(R.id.awdcc);
        txad = (TextView) findViewById(R.id.awddd);
        txae = (TextView) findViewById(R.id.awdee);
        txaf = (TextView) findViewById(R.id.awdff);
        txag = (TextView) findViewById(R.id.awdgg);
        txah = (TextView) findViewById(R.id.awdhh);
        txai = (TextView) findViewById(R.id.awd1);
        txaj = (TextView) findViewById(R.id.awdii);
        txak = (TextView) findViewById(R.id.awdkk);


        imgaa = (ImageView) findViewById(R.id.awda);
        imgab = (ImageView) findViewById(R.id.awdb);
        imgac = (ImageView) findViewById(R.id.awdc);
        imgad = (ImageView) findViewById(R.id.awdd);
        imgae = (ImageView) findViewById(R.id.awde);
        imgaf = (ImageView) findViewById(R.id.awdf);
        imgag = (ImageView) findViewById(R.id.awdk);

        vb1 = (View)findViewById(R.id.v1);
        vb2 = (View)findViewById(R.id.v2);
        vb3 = (View)findViewById(R.id.v3);
        vb4 = (View)findViewById(R.id.v4);
        vb5 = (View)findViewById(R.id.v5);




        btnb = (Button) findViewById(R.id.regi);
        btnb.setOnClickListener(new View.OnClickListener() {
            Drawable background2 = btnb.getBackground();
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                txaa.setText(getResources().getString(R.string.txaa));

                txab.setText(getResources().getString(R.string.txab));

                txac.setText(getResources().getString(R.string.txac));

                txad.setVisibility(View.GONE);

                txae.setVisibility(View.GONE);

                txaf.setVisibility(View.GONE);

                txak.setVisibility(View.GONE);

                txtaj.setVisibility(View.GONE);

                txai.setVisibility(View.GONE);

                txaj.setVisibility(View.GONE);

                txtai.setVisibility(View.GONE);

                txag.setText(getResources().getString(R.string.txag));

                txah.setText(getResources().getString(R.string.txah));

                txtaa.setText(getResources().getString(R.string.txta));

                txtab.setText(getResources().getString(R.string.txtab));

                txtac.setText(getResources().getString(R.string.txtac));

                txtad.setVisibility(View.GONE);

                txtae.setVisibility(View.GONE);

                txtaf.setVisibility(View.GONE);

                txtag.setText(getResources().getString(R.string.txtag));

                txtah.setText(getResources().getString(R.string.txtah));

                imgad.setVisibility(View.GONE);
                imgae.setVisibility(View.GONE);
                imgaf.setVisibility(View.GONE);
                imgag.setVisibility(View.GONE);


                vb1.setVisibility(View.GONE);
                vb2.setVisibility(View.GONE);
                vb3.setVisibility(View.GONE);
                vb4.setVisibility(View.GONE);
                vb5.setVisibility(View.GONE);





                ciaa++;
                ciaa= ciaa % awaa.length;
                imgaa.setImageResource(awaa[ciaa]);

                ciab++;
                ciab= ciab % awab.length;
                imgab.setImageResource(awab[ciab]);

                ciac++;
                ciac= ciac % awac.length;
                imgac.setImageResource(awac[ciac]);




                if(btnb.getText().equals("REGIONAL AWARDS"))
                {
                    btnb.setText("REGIONAL AWARDS");
                    btnb.setBackgroundResource(R.color.col);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }
                else if (btnb.getText().equals("REGIONAL AWARDS")){
                    btnb.setText("REGIONAL AWARDS");
                    btnb.setBackground(background2);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }

                if(btnb.getText().equals("क्षेत्रीय पुरस्कार"))
                {
                    btnb.setText("क्षेत्रीय पुरस्कार");
                    btnb.setBackgroundResource(R.color.col);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }
                else if (btnb.getText().equals("क्षेत्रीय पुरस्कार")){
                    btnb.setText("क्षेत्रीय पुरस्कार");
                    btnb.setBackground(background2);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }

                if(btnb.getText().equals("प्रादेशिक पुरस्कार"))
                {
                    btnb.setText("प्रादेशिक पुरस्कार");
                    btnb.setBackgroundResource(R.color.col);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }
                else if (btnb.getText().equals("प्रादेशिक पुरस्कार")){
                    btnb.setText("प्रादेशिक पुरस्कार");
                    btnb.setBackground(background2);
                    button.setBackground(background2);
                    btn.setBackground(background2);
                }
            }
        });







        txt1 = (TextView) findViewById(R.id.awtxt);
        txt2 = (TextView) findViewById(R.id.awbtxt);
        txt3 = (TextView) findViewById(R.id.awctxt);
        txt4 = (TextView) findViewById(R.id.awdtxt);
        txt5 = (TextView) findViewById(R.id.awetxt);
        txt6 = (TextView) findViewById(R.id.awftxt);
        txt7 = (TextView) findViewById(R.id.awgtxt);
        txt8 = (TextView) findViewById(R.id.awhtxt);
        txt9 = (TextView) findViewById(R.id.awitxt);
        txt10 = (TextView) findViewById(R.id.awktxt);


        tx1 = (TextView) findViewById(R.id.awd);
        tx2 = (TextView) findViewById(R.id.awdbb);
        tx3 = (TextView) findViewById(R.id.awdcc);
        tx4 = (TextView) findViewById(R.id.awddd);
        tx5 = (TextView) findViewById(R.id.awdee);
        tx6 = (TextView) findViewById(R.id.awdff);
        tx7 = (TextView) findViewById(R.id.awdgg);
        tx8 = (TextView) findViewById(R.id.awdhh);
        tx10 = (TextView) findViewById(R.id.awd1);
        tx9 = (TextView) findViewById(R.id.awdii);
        tx11 = (TextView) findViewById(R.id.awdkk);


        img1 = (ImageView) findViewById(R.id.awda);
        img2 = (ImageView) findViewById(R.id.awdb);
        img3 = (ImageView) findViewById(R.id.awdc);
        img4 = (ImageView) findViewById(R.id.awdd);
        img5 = (ImageView) findViewById(R.id.awde);
        img6 = (ImageView) findViewById(R.id.awdf);
        img7 = (ImageView) findViewById(R.id.awdk);


        v1 = (View)findViewById(R.id.v1);
        v2 = (View)findViewById(R.id.v2);
        v3 = (View)findViewById(R.id.v3);
        v4 = (View)findViewById(R.id.v4);
        v5 = (View)findViewById(R.id.v5);



        button = (Button) findViewById(R.id.inter);
        button.setOnClickListener(new View.OnClickListener() {
            Drawable background = button.getBackground();
            Drawable background2 = btnb.getBackground();
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                tx1.setText(getResources().getString(R.string.tx1));

                tx2.setText(getResources().getString(R.string.tx2));

                tx3.setText(getResources().getString(R.string.tx3));

                tx4.setText(getResources().getString(R.string.tx4));

                tx5.setText(getResources().getString(R.string.tx5));

                tx6.setText(getResources().getString(R.string.tx6));

                tx7.setText(getResources().getString(R.string.tx7));

                tx8.setText(getResources().getString(R.string.tx8));

                tx10.setText(getResources().getString(R.string.tx10));

                tx11.setText(getResources().getString(R.string.tx11));

                txt1.setText(getResources().getString(R.string.txt1));

                txt2.setText(getResources().getString(R.string.txt2));

                txt3.setText(getResources().getString(R.string.txt3));

                txt4.setText(getResources().getString(R.string.txt4));

                txt5.setText(getResources().getString(R.string.txt5));

                txt6.setText(getResources().getString(R.string.txt6));

                txt7.setText(getResources().getString(R.string.txt7));

                txt8.setText(getResources().getString(R.string.txt8));

                txt10.setText(getResources().getString(R.string.txt10));

                txt10.setVisibility(View.VISIBLE);
                tx11.setVisibility(View.VISIBLE);

                txt9.setVisibility(View.GONE);
                tx9.setVisibility(View.GONE);
                tx10.setVisibility(View.VISIBLE);
                tx4.setVisibility(View.VISIBLE);
                tx5.setVisibility(View.VISIBLE);
                tx6.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                txt5.setVisibility(View.VISIBLE);
                txt6.setVisibility(View.VISIBLE);

                img7.setVisibility(View.VISIBLE);

                v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.VISIBLE);
                v3.setVisibility(View.VISIBLE);
                v4.setVisibility(View.VISIBLE);
                v5.setVisibility(View.VISIBLE);

                ci1++;
                ci1= ci1 % aw1.length;
                img1.setImageResource(aw1[ci1]);

                ci2++;
                ci2= ci2 % aw2.length;
                img2.setImageResource(aw2[ci2]);

                ci3++;
                ci3= ci3 % aw3.length;
                img3.setImageResource(aw3[ci3]);

                ci4++;
                ci4= ci4 % aw4.length;
                img4.setImageResource(aw4[ci4]);

                ci6++;
                ci6= ci6 % aw6.length;
                img6.setImageResource(aw6[ci6]);

                ci5++;
                ci5= ci5 % aw5.length;
                img5.setImageResource(aw5[ci5]);

                ci7++;
                ci7= ci7 % aw7.length;
                img7.setImageResource(aw7[ci7]);


                if(button.getText().equals("INTERNATIONAL AWARDS"))
                {
                    button.setText("INTERNATIONAL AWARDS");
                    button.setBackgroundResource(R.color.col);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }
                else if (button.getText().equals("INTERNATIONAL AWARDS")){
                    button.setText("INTERNATIONAL AWARDS");
                    button.setBackground(background);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }

                if(button.getText().equals("आंतरराष्ट्रीय पुरस्कार"))
                {
                    button.setText("आंतरराष्ट्रीय पुरस्कार");
                    button.setBackgroundResource(R.color.col);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }
                else if (button.getText().equals("आंतरराष्ट्रीय पुरस्कार")){
                    button.setText("आंतरराष्ट्रीय पुरस्कार");
                    button.setBackground(background);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }

                if(button.getText().equals("अंतर्राष्ट्रीय पुरस्कार"))
                {
                    button.setText("अंतर्राष्ट्रीय पुरस्कार");
                    button.setBackgroundResource(R.color.col);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }
                else if (button.getText().equals("अंतर्राष्ट्रीय पुरस्कार")){
                    button.setText("अंतर्राष्ट्रीय पुरस्कार");
                    button.setBackground(background);
                    btn.setBackground(background2);
                    btnb.setBackground(background2);
                }

                img4.setVisibility(View.VISIBLE);
                img5.setVisibility(View.VISIBLE);
                img6.setVisibility(View.VISIBLE);

            }
        });



    }


    public void prev(View v) {
        viewFlipper.showPrevious();
        viewFlipper1.showPrevious();
    }

    public void next(View v) {
        viewFlipper.showNext();
        viewFlipper1.showNext();
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







