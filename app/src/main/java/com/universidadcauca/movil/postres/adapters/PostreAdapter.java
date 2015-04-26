package com.universidadcauca.movil.postres.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.universidadcauca.movil.postres.R;
import com.universidadcauca.movil.postres.models.Postre;

import java.util.List;

/**
 * Created by DarioFernando on 18/04/2015.
 */
public class PostreAdapter extends BaseAdapter {

    Context context;
    List<Postre> data;

    public PostreAdapter(Context context, List<Postre> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;
        if(convertView == null)
            v = View.inflate(context, R.layout.template_postre, null);
        else
            v = convertView;

        Postre p = (Postre) getItem(position);

        TextView txt = (TextView) v.findViewById(R.id.postre_nombre);
        txt.setText(p.getNombre());

        txt = (TextView) v.findViewById(R.id.postre_des);
        txt.setText(p.getDescripcion());

        txt = (TextView) v.findViewById(R.id.postre_tiempo);
        txt.setText(p.getTiempo());

        txt = (TextView) v.findViewById(R.id.postre_price);
        txt.setText(p.getPrecio());

        return v;
    }
}
