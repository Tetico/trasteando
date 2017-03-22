package com.oriol.tetic.trasteando;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button siguiente;
    ImageButton ibtnDate;

    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;
    EditText editFecha;

    private int mMes, mDia, mAño;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguiente = (Button) findViewById(R.id.buttonSiguiente);
        ibtnDate = (ImageButton)findViewById(R.id.ibtnFecha);

        nombre = (EditText) findViewById(R.id.editNombreCompleto);
        editFecha = (EditText) findViewById(R.id.editFecha);
        telefono = (EditText) findViewById(R.id.editTelf);
        email = (EditText) findViewById(R.id.editEmail);
        descripcion = (EditText) findViewById(R.id.editDescripcion);

        editFecha.setOnClickListener(this);
        ibtnDate.setOnClickListener(this);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent explicit_intent= new Intent(MainActivity.this, DetalleActivity.class);
                String auxediNombre = nombre.getText().toString();
                String auxediFecha= editFecha.getText().toString();
                String auxediTelefono= telefono.getText().toString();
                String auxediEmail= email.getText().toString();
                String auxediDescripcion= descripcion.getText().toString();


                explicit_intent.putExtra("pnombre",auxediNombre);
                explicit_intent.putExtra("pfecha",auxediFecha);
                explicit_intent.putExtra("ptelefono",auxediTelefono);
                explicit_intent.putExtra("pemail",auxediEmail);
                explicit_intent.putExtra("pdescripcion",auxediDescripcion);

                startActivity(explicit_intent);
            }
        });


    }


    @Override
    public void onClick(View v) {

        if (v == editFecha) {


            final Calendar c = Calendar.getInstance();
            mAño = c.get(Calendar.YEAR);
            mMes = c.get(Calendar.MONTH);
            mDia = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            editFecha.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mAño, mMes, mDia);
            dpd.show();
        }

        if (v == ibtnDate) {


            final Calendar c = Calendar.getInstance();
            mAño = c.get(Calendar.YEAR);
            mMes = c.get(Calendar.MONTH);
            mDia = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog dpd = new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            editFecha.setText(dayOfMonth + "-"
                                    + (monthOfYear + 1) + "-" + year);

                        }
                    }, mAño, mMes, mDia);
            dpd.show();
        }

        }
    }



