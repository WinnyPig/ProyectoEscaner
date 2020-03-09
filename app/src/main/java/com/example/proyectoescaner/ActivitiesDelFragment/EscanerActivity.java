package com.example.proyectoescaner.ActivitiesDelFragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyectoescaner.Fragmentos.EscanerFragment;
import com.example.proyectoescaner.Fragmentos.ModificarFragment;
import com.example.proyectoescaner.Fragmentos.RecyclerViewFragment;
import com.example.proyectoescaner.Objetos.Escaner;
import com.example.proyectoescaner.R;

import java.util.ArrayList;

public class EscanerActivity extends AppCompatActivity implements ModificarFragment.OnEscanerEliminadoListener, ModificarFragment.AtrasListadoEscanerListener, RecyclerViewFragment.OnEscaner_Listener {

    public ArrayList<Escaner> escaneres;

    public EscanerActivity() {
        this.escaneres = new ArrayList<>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaner);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        RecyclerViewFragment fragment = RecyclerViewFragment.newInstance();

         escaneres.add(new Escaner("AAAAAAA"));
         escaneres.add(new Escaner("EEEEEEE"));
         escaneres.add(new Escaner("VVVVVVV"));

         fragment.escaneres = this.escaneres;
         transaction.replace(R.id.contenedor, fragment).addToBackStack(null);

         transaction.commit();
    }

    @Override
    public void OnProductoEliminado(Escaner e) {
        escaneres.remove(e);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        RecyclerViewFragment fragment = RecyclerViewFragment.newInstance();
        fragment.escaneres = this.escaneres;
        transaction.addToBackStack(null);

        transaction.replace(R.id.contenedor, fragment);

        transaction.commit();
    }

  @Override
    public void AtrasListadoEscaneresClick() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        RecyclerViewFragment fragment = RecyclerViewFragment.newInstance();
        fragment.escaneres = this.escaneres;

        transaction.replace(R.id.contenedor, fragment);

        transaction.commit();
    }


        @Override
        public void onEscaneresClick(Escaner escaner){
            FragmentManager supportFragmentManager = getSupportFragmentManager();

            FragmentTransaction transaction = supportFragmentManager.beginTransaction();

            ModificarFragment fragment = ModificarFragment.newInstance();
            fragment.escaneres = escaner;

            transaction.replace(R.id.contenedor, fragment);

            transaction.commit();
        }


}
