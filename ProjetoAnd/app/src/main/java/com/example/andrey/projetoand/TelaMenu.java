package com.example.andrey.projetoand;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.andrey.projetoand.Controller.Controller;

import java.util.ArrayList;
import java.util.List;

public class TelaMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ClickRecyclerView_Interface{


    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerAdapter adapter;
    private List<Pessoa> pessoasListas = new ArrayList<>();
    private FloatingActionButton floatingActionButton;
    private TextView tv_nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setaRecyclerView();

        setaButtons();
        listenersButtons();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View headerView = navigationView.getHeaderView(0);
        tv_nome = (TextView) headerView.findViewById(R.id.tv_nome);
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(Controller.getInstance().getValue() != null){
            tv_nome.setText(Controller.getInstance().getValue());
        }
    }

    public void setaRecyclerView(){

        //Aqui é instanciado o Recyclerview
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_recyclerteste);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        adapter = new RecyclerAdapter(this, pessoasListas, this);
        mRecyclerView.setAdapter(adapter);
    }

    public void setaButtons(){

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_fab);

    }

    /**
     * Aqui é o método onde trata o clique em um item da lista
     */
    @Override
    public void onCustomClick(Object object) {


    }

    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Cria uma nova pessoa chamada Renan Teles
                Pessoa pessoa1 = new Pessoa();
                pessoa1.setNome("Micael Lopes");

                //Adiciona a pessoa1 e avisa o adapter que o conteúdo
                //da lista foi alterado
                pessoasListas.add(pessoa1);
                adapter.notifyDataSetChanged();

            }
        });
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_menu, menu);
        return true;
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menu1) {
            Intent intent = new Intent(getApplicationContext(), TelaConfig.class);
            startActivity(intent);

        } else if (id == R.id.menu2) {
            Intent intent = new Intent(getApplicationContext(), TelaWeb.class);
            startActivity(intent);

        } else if (id == R.id.sair) {
            Intent intent = new Intent(getApplicationContext(), TelaLogin.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void telaEdita(View view){
        Intent intent = new Intent(TelaMenu.this, TelaEdicao.class);
        startActivity(intent);
    }

    public void liga(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:08388280717"));
        startActivity(intent);
    }

}
