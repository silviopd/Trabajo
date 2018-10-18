package com.example.user.trabajo;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.user.trabajo.R.id.btnimagen1;

public class cargarImagenes extends Fragment implements View.OnClickListener {

    Button imagen1,imagen2;
    ImageView imgImagenes;

    private static final String IMAGEN_DESCARGAR_1 = "http://vignette4.wikia.nocookie.net/distos/images/e/e6/Vete_a_la_versh_EP29.png/revision/latest?cb=20140309040159&path-prefix=es";
    private static final String IMAGEN_DESCARGAR_2 = "http://vetealaversh.com/wp-content/uploads/2016/01/005-820x250.png";

    public cargarImagenes() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cargar_imagenes, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imagen1 = (Button) view.findViewById(R.id.btnimagen1);
        imagen2 = (Button) view.findViewById(R.id.btnImagen2);
        imgImagenes = (ImageView) view.findViewById(R.id.imgImagenes);

        imagen1.setOnClickListener(this);
        imagen2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        cargarImagen tarea1 = new cargarImagen();

        switch(view.getId()) {
            case R.id.btnimagen1:
                tarea1.execute(IMAGEN_DESCARGAR_1);
                //Toast.makeText(view.getContext(),"Imagen 1",Toast.LENGTH_LONG).show();
                break;
            case R.id.btnImagen2:
                tarea1.execute(IMAGEN_DESCARGAR_2);
                //Toast.makeText(view.getContext(),"Imagen 2",Toast.LENGTH_LONG).show();
                break;
        }
    }

    //el que recibe,,lo que bota
    private class cargarImagen extends AsyncTask<String,Void,Bitmap> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(getContext());
            pDialog.setMessage("Descargando imagen...");
            pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            String imagenDescargar = params[0];
            Bitmap imagenDescargada = descargarImagen(imagenDescargar);
            return imagenDescargada;
        }


        @Override
        protected void onPostExecute(Bitmap result) {
            imgImagenes.setImageBitmap(result);

            pDialog.dismiss();
        }
    }

    private Bitmap descargarImagen (String direccion){
        URL imageUrl = null;
        Bitmap imagen = null;
        try{
            imageUrl = new URL(direccion);
            HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
            conn.connect();
            imagen = BitmapFactory.decodeStream(conn.getInputStream());
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return imagen;
    }
}
