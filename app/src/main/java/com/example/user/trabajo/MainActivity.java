package com.example.user.trabajo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spUsuarios;
    TextView txtContrasena;
    Button btnAceptar,btnCerrar;

    Object usuario[][] = new Object[2][2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spUsuarios = (Spinner) findViewById(R.id.spUsuarios);
        txtContrasena = (TextView) findViewById(R.id.txtContrasena);
        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnCerrar = (Button) findViewById(R.id.btnCerrar);

        btnAceptar.setOnClickListener(this);
        btnCerrar.setOnClickListener(this);
        spUsuarios.setOnItemSelectedListener(this);

        cargarSpinnerUsuarios();

        getSupportActionBar().setTitle("Inicio de Sesión");
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()) {
            case R.id.btnAceptar:
                String contrasena = (txtContrasena.getText().toString());
                //Toast.makeText(this,contrasena,Toast.LENGTH_LONG).show();

                if (spUsuarios.getSelectedItemPosition()==0 && contrasena.equals("123")){
                    //Toast.makeText(this,"Ingreso",Toast.LENGTH_LONG).show();
                    /*Pasar parametros de una activity a otro a otro*/
                    Intent pantalla2 = new Intent(this, Activity2.class); //enlazar la ventana
                    Bundle parametros = new Bundle(); //pasar parametros
                    parametros.putString("usuario",spUsuarios.getSelectedItem().toString());//primero el key, valor
                    //parametros.putString("contrasena",txtContrasena.getText().toString());//primero el key, valor
                    pantalla2.putExtras(parametros); //agregando todos los parametros a la activity
                    startActivity(pantalla2);   //mostrar la activity con todos los parametros
                    /*Pasar parametros de una activity a otro a otro*/
                    txtContrasena.setText("");
                }else if (spUsuarios.getSelectedItemPosition()==1 && contrasena.equals("456")){
                    //Toast.makeText(this,"Ingreso",Toast.LENGTH_LONG).show();
                    Intent pantalla2 = new Intent(this, Activity2.class);
                    Bundle parametros = new Bundle();
                    parametros.putString("usuario",spUsuarios.getSelectedItem().toString());
                    pantalla2.putExtras(parametros);
                    startActivity(pantalla2);
                    txtContrasena.setText("");
                }else{
                    Toast.makeText(this,"No Ingreso, Verifique contraseña",Toast.LENGTH_LONG).show();
                    txtContrasena.setText("");
                }
                break;

            case R.id.btnCerrar:
                finish();
                break;
        }
    }

    public void cargarSpinnerUsuarios(){
        usuario[0][0] = "admin";
        usuario[0][1] = 123;

        usuario[1][0] = "silviopd";
        usuario[1][1] = 456;

        String articuloSpinner[] = new String [usuario.length];
        for (int i=0;i<usuario.length;i++){
            articuloSpinner[i] = usuario[i][0].toString();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,articuloSpinner);
        spUsuarios.setAdapter(adapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        txtContrasena.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
