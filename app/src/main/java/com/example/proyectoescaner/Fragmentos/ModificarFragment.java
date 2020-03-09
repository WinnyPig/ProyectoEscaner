package com.example.proyectoescaner.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyectoescaner.Objetos.Escaner;
import com.example.proyectoescaner.R;
import com.google.android.material.snackbar.Snackbar;

public class ModificarFragment extends Fragment implements View.OnClickListener {

    View view;
    public Escaner escaneres;

    TextView codigo;
    Button borrar, atras;

    private OnEscanerEliminadoListener fragmentL;
    private AtrasListadoEscanerListener listadoEscaneresListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.modificar_fragment,container,false);


        codigo = view.findViewById(R.id.codigo);

        borrar = view.findViewById(R.id.btn_borrar);
        atras = view.findViewById(R.id.btn_atras);

        codigo.setText(escaneres.getCodigo());

        borrar.setOnClickListener(this);
        atras.setOnClickListener(this);

        return view;
    }

    public static ModificarFragment newInstance(){
        ModificarFragment fragment = new ModificarFragment();

        return fragment;
    }

    public interface OnEscanerEliminadoListener{
        public void OnProductoEliminado(Escaner e);
    }

    public interface AtrasListadoEscanerListener{
        public void AtrasListadoEscaneresClick();
    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn_borrar) {
            Snackbar.make(view, "Pulse CONFIRMAR para eliminarlo", Snackbar.LENGTH_INDEFINITE).setAction("CONFIRMAR", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentL.OnProductoEliminado(escaneres);
                    Toast.makeText(getContext(), escaneres.getCodigo() + "" + " se ha eliminado correctamente", Toast.LENGTH_LONG).show();
                }
            }).show();
        }

        if(v.getId() == R.id.btn_atras){
            listadoEscaneresListener.AtrasListadoEscaneresClick();
        }
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof OnEscanerEliminadoListener){
            fragmentL = (OnEscanerEliminadoListener) context;
        }
        if(context instanceof AtrasListadoEscanerListener){
            listadoEscaneresListener = (AtrasListadoEscanerListener) context;
        }
    }
}
