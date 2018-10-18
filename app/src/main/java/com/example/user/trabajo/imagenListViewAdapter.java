package com.example.user.trabajo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by USER on 10/09/2016.
 */
public class imagenListViewAdapter extends ArrayAdapter<imagenListView> {

    Context myContext;
    int myLayoutResourceID;
    imagenListView myData[] = null;

    public imagenListViewAdapter(Context context,int layoutResourceID,imagenListView[] data){
        super(context,layoutResourceID,data);
        this.myContext = context;
        this.myLayoutResourceID = layoutResourceID;
        this.myData = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        imagenListViewHolder holder=null;

        if (row == null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row = inflater.inflate(myLayoutResourceID,parent,false);

            holder = new imagenListViewHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.imagen);
            holder.textView = (TextView) row.findViewById(R.id.txtTitulo);

            row.setTag(holder);
        }else{
            holder = (imagenListViewHolder) row.getTag();
        }

        imagenListView imagenListView = myData[position];
        holder.textView.setText(imagenListView.title);
        holder.imagen.setImageResource(imagenListView.icon);

        return row;
    }

    static class imagenListViewHolder{
        ImageView imagen;
        TextView textView;
    }

}
