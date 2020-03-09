package com.example.proyectoescaner.Adaptadores;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoescaner.Objetos.Escaner;
import com.example.proyectoescaner.R;

public class EscaneresViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_codigo;


    public EscaneresViewHolder(View itemView, Context context) {
        super(itemView);

        tv_codigo = itemView.findViewById(R.id.tv_codigo);
    }

    public void bindEscaner(Escaner e){
        tv_codigo.setText(e.getCodigo());
    }
}
