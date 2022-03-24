package com.example.atmconsultoria.ui.sobre;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.atmconsultoria.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class SobreFragment extends Fragment {

    private SobreViewModel toolsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       /* toolsViewModel =
                ViewModelProviders.of(this).get(SobreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_sobre, container, false);
        final TextView textView = root.findViewById(R.id.text_sobre);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
        Element versao = new Element();
        versao.setTitle("Versão 1.0");

        String descricao = "A ATM Consultoria tem como missão apoiar organizações que desejam alcançar o sucesso através da excelência em gestão e da busca pela qualidade";
        return new AboutPage(getActivity()).setImage(R.drawable.logo)
                .setDescription(descricao)
                .addGroup("Entre em contato")
                .addEmail("atendimento@consultoria.com.br", "Envie um email")
                .addWebsite("https://www.google.com/","Acesse nosso site").addGroup("Redes sociais")
                .addFacebook("limadruga", "Facebook")
                .addInstagram("limadruga", "Instagram")
                .addTwitter("limadruga", "Twitter")
                .addGitHub("limadruga", "GitHub")
                .addPlayStore("com.facebook.katana", "Download App")
                .addItem(versao)
                .create();


    }
}