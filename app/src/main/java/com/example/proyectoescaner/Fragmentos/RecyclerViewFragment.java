package com.example.proyectoescaner.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoescaner.Adaptadores.AdaptadorEscaneres;
import com.example.proyectoescaner.Objetos.Escaner;
import com.example.proyectoescaner.R;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    public AdaptadorEscaneres adaptador;
    private RecyclerView.LayoutManager layoutManager;
    public ArrayList<Escaner> escaneres;

    private OnEscaner_Listener escaner_listener;

    private EditText codigo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vistaLayout = inflater.inflate(R.layout.fragment_escaner, container, false);

        recyclerView = vistaLayout.findViewById(R.id.recyclerView);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adaptador = new AdaptadorEscaneres(getContext(), escaneres);

        adaptador.setOnClickListener(this);

        recyclerView.setAdapter(adaptador);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        codigo = vistaLayout.findViewById(R.id.etCodigo);


        return vistaLayout;

    }


    public static RecyclerViewFragment newInstance(){

        RecyclerViewFragment fragmentListadoGuias = new RecyclerViewFragment();

        return fragmentListadoGuias;

    }

    @Override
    public void onClick(View v) {
        int posicion = recyclerView.getChildAdapterPosition(v);
        escaner_listener.onEscaneresClick(escaneres.get(posicion));
    }


    public interface OnEscaner_Listener{
        public void onEscaneresClick(Escaner e);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnEscaner_Listener){
            escaner_listener = (OnEscaner_Listener) context;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState != null) {
            codigo.setText( savedInstanceState.getString("KEY_CODIGO"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putString("KEY_CODIGO", codigo.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
