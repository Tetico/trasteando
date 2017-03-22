package com.oriol.tetic.trasteando;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class DetalleActivity extends AppCompatActivity {

    Button btnEditar;
    TextView etiNombre;
    TextView etiFecha;
    TextView etiTelefono, etiEmail, etiDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        etiNombre = (TextView) findViewById(R.id.tvNombre);
        etiFecha = (TextView) findViewById(R.id.tvCampoFecha);
        etiTelefono = (TextView) findViewById(R.id.tvCampoTelf);
        etiEmail = (TextView) findViewById(R.id.tvCampoEmail);
        etiDescripcion = (TextView) findViewById(R.id.tvCampoDescripcion);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {

            String datoNombre = (String) extras.get("pnombre");
            String datoFecha = (String) extras.get("pfecha");
            String datoTelefono = (String) extras.get("ptelefono");
            String datoEmail = (String) extras.get("pemail");
            String datoDescripcion = (String) extras.get("pdescripcion");


            etiNombre.setText(datoNombre);
            etiFecha.setText(datoFecha);
            etiTelefono.setText(datoTelefono);
            etiEmail.setText(datoEmail);
            etiDescripcion.setText(datoDescripcion);


        }


        btnEditar = (Button) findViewById(R.id.botonEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }

    public void llamar(View v) {

        String telefono = etiTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));
    }

    public void  enviarMail(View v) {
        String email = etiEmail.getText().toString();
        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.setData(Uri.parse("mailto:"));
        intentEmail.putExtra(Intent.EXTRA_EMAIL, email);
        intentEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(intentEmail, "Email"));
    }
}
