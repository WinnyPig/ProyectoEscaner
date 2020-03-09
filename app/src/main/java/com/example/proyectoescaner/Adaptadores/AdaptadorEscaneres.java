package com.example.proyectoescaner.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoescaner.Fragmentos.EscanerFragment;
import com.example.proyectoescaner.Objetos.Escaner;
import com.example.proyectoescaner.R;
import com.google.zxing.integration.android.IntentIntegrator;

import java.util.ArrayList;

public class AdaptadorEscaneres extends RecyclerView.Adapter<EscaneresViewHolder> implements View.OnClickListener {

    private ArrayList<Escaner> listaEscaner;
    private Context context;
    private View.OnClickListener mListener;

    public AdaptadorEscaneres(Context context, ArrayList<Escaner> listaEscaner){
        this.context = context;
        this.listaEscaner = listaEscaner;
    }
    @Override
    public EscaneresViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_listado_escaner, viewGroup, false);

        itemView.setOnClickListener(this);
        EscaneresViewHolder viewHolder = new EscaneresViewHolder(itemView, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( EscaneresViewHolder viewHolder, int posicion) {
        Escaner escaner = listaEscaner.get(posicion);
        viewHolder.bindEscaner(escaner);
    }


    public void setOnClickListener(View.OnClickListener listener){
        mListener = listener;
    }

    @Override
    public int getItemCount(){
        return listaEscaner.size();
    }

    @Override
    public void onClick(View view) {
        if(mListener != null){
            mListener.onClick(view);
        }
    }
}
