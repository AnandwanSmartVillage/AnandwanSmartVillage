package www.anandwan.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class pinfo<button> extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pinfo);


        button = (Button) findViewById(R.id.ssc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(pinfo.this,ActivityAwards.class);
                startActivity(intent);
            }
        });


        Spinner myspinner = (Spinner) findViewById(R.id.country);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(pinfo.this,
                R.layout.custom_spinner, getResources().getStringArray(R.array.country_arrays));
        myAdapter.setDropDownViewResource(R.layout.custom_drp);
        myspinner.setAdapter(myAdapter);

        Spinner spinner = (Spinner) findViewById(R.id.blood);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(pinfo.this,
                R.layout.custom_spinner, getResources().getStringArray(R.array.blood));
        Adapter.setDropDownViewResource(R.layout.custom_drp);
        spinner.setAdapter(Adapter);

        Spinner spinne = (Spinner) findViewById(R.id.spin);
        ArrayAdapter<String> Adapters = new ArrayAdapter<String>(pinfo.this,
                R.layout.custom_spinner, getResources().getStringArray(R.array.Gender));
        Adapters.setDropDownViewResource(R.layout.custom_drp);
        spinne.setAdapter(Adapters);


    }

}
