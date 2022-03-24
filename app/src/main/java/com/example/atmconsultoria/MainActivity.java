package com.example.atmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes,
                R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void enviarEmail(){
        String celular = "tel:11996324884";
        String imagem = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.melhoresdestinos.com.br%2Fwp-content%2Fuploads%2F2020%2F06%2Fpraias-brasil-sancho.jpg&imgrefurl=https%3A%2F%2Fwww.melhoresdestinos.com.br%2Fmelhores-praias-do-brasil.html&tbnid=m1UZBhdJKv2-5M&vet=12ahUKEwjwqdy-n9_2AhVhq5UCHWArCvsQMygCegUIARDXAQ..i&docid=dJNdRiaq8Tj_RM&w=1600&h=1067&q=praia&ved=2ahUKEwjwqdy-n9_2AhVhq5UCHWArCvsQMygCegUIARDXAQ";
        String endereco = "https://www.google.com/maps/place/Est%C3%A1dio+Jos%C3%A9+Am%C3%A9rico+de+Almeida+Filho+-+Almeid%C3%A3o/@-7.1671695,-34.8756373,17z/data=!3m1!4b1!4m5!3m4!1s0x7ace9d004ac17eb:0x6e99f40a36372b29!8m2!3d-7.1671695!4d-34.8734486";
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(celular));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf");
        startActivity(Intent.createChooser(intent, "Escolha um App de email"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
