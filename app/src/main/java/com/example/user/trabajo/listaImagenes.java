package com.example.user.trabajo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class listaImagenes extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    Button cargarImagenes;
    ListView lista;

    public listaImagenes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_imagenes, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cargarImagenes = (Button) view.findViewById(R.id.btnImagenes);
        lista = (ListView) view.findViewById(R.id.listarImagenes);

        cargarImagenes.setOnClickListener(this);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {

            case R.id.btnImagenes:
                imagenListView imagenListView_datos[] = new imagenListView[]{
                        new imagenListView(R.drawable.imagen1,"Imagen 1"),
                        new imagenListView(R.drawable.imagen2,"Imagen 2"),
                        new imagenListView(R.drawable.imagen3,"Imagen 3"),
                        new imagenListView(R.drawable.imagen4,"Imagen 4"),
                        new imagenListView(R.drawable.imagen5,"Imagen 5"),
                        new imagenListView(R.drawable.imagen7,"Imagen 6"),
                        new imagenListView(R.drawable.imagen8,"Imagen 7"),
                        new imagenListView(R.drawable.imagen9,"Imagen 8"),
                        new imagenListView(R.drawable.imagen10,"Imagen 9"),
                        new imagenListView(R.drawable.imagen11,"Imagen 10")
                };
                imagenListViewAdapter adapter = new imagenListViewAdapter(getContext(),R.layout.listview_item_row,imagenListView_datos);
                lista.setAdapter(adapter);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView v = (TextView)view.findViewById(R.id.txtTitulo);
        Toast.makeText(getContext(), v.getText(),Toast.LENGTH_SHORT).show();
    }
}
