package com.unitn.lpsmt.group13.pommidori;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variabili
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button calendario;
    Button btnScadenze;
    Button btnSessioni;

    AutoCompleteTextView listaScadenze;
    AutoCompleteTextView listaSessioni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Inizializzazione variabili
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.homeToolbar);

        btnScadenze = (Button) findViewById( R.id.btn_dropdown_scadenze);
        btnSessioni = (Button) findViewById( R.id.btn_dropdown_sessioni);

        listaScadenze = (AutoCompleteTextView) findViewById( R.id.dropdown_scadenze);
        listaSessioni = (AutoCompleteTextView) findViewById( R.id.dropdown_sessioni);

        calendario = findViewById(R.id.hp_calendario);

        //Metodi
        setNavigationDrawerMenu();
        setButtonListeners();
        setDropDownLists();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setDropDownLists();
    }

    //Chiudere il navigation drawer con il pulsante indietro
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.nav_settings:
                startActivity(new Intent(this, Impostazioni.class));
                break;
            case R.id.nav_report:
                startActivity(new Intent(this, Report.class));
                break;
            default:
                return false;
        }
        return true;
    }

    private void setNavigationDrawerMenu(){
        //settare toolbar com ActionBar dell'Activity
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu
        navigationView.bringToFront();  //viene visualizzato il menuItem quando è selezionato
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close); //qiando viene premuto il navigationIcon del toolbar, il drawerMenu viene aperto o chiuso
        drawerLayout.addDrawerListener(toggle); //aggiunge il listener al toolbar
        toggle.syncState(); //Sincronizza lo stato tra toolbar e drawer
        navigationView.setNavigationItemSelectedListener(this); //Listener per catturare gli eventi del NavigationView

        //settare titolo e icona del toolbar
        toolbar.setTitle("Pommidori");
        toolbar.setNavigationIcon(R.drawable.ic_menu_24);
    }
    private void setButtonListeners(){
        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this,Calendario.class));
            }
        });

        btnScadenze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( listaScadenze.isPopupShowing()){
                    listaScadenze.dismissDropDown();
                }else{
                    listaScadenze.showDropDown();
                }
            }
        });

        btnSessioni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( listaSessioni.isPopupShowing()){
                    listaSessioni.dismissDropDown();
                }else{
                    listaSessioni.showDropDown();
                }
            }
        });

    }

    private void setDropDownLists(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.planets_array,
                R.layout.dropdown_item
        );

        listaScadenze.setText( adapter.getItem(0));
        listaSessioni.setText( adapter.getItem(0));

        listaScadenze.setAdapter( adapter);
        listaSessioni.setAdapter( adapter);
    }
}