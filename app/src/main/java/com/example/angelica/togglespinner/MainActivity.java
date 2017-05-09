package com.example.angelica.togglespinner;

import android.nfc.cardemulation.OffHostApduService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ToggleButton toggleButton;
    Spinner spinner;
    List list = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        toggleButton= (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean On) {
                if(On==true){
                    list.clear();
                    list.remove("Zuluaga");
                    list.remove("Herrera");
                    list.remove("Granada");
                    list.add("jhonny Ospina");
                    list.add("Mauricio Zuluaga");
                    list.add("Juan Pablo");
                }else{
                    list.clear();
                    list.remove("jhonny Ospina");
                    list.remove("Mauricio Zuluaga");
                    list.remove("Juan Pablo");
                    list.add("Zuluaga");
                    list.add("Herrera");
                    list.add("Granada");
                }
            }



        });

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, list);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Nombre Seleccionado: "+ String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}

