package com.example.gerenciadordelivros.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.gerenciadordelivros.R;
import com.example.gerenciadordelivros.adapter.LivroAdapter;
import com.example.gerenciadordelivros.dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Livro> listaLivros = new ArrayList<Livro>();

        listaLivros.add(new Livro(1L, "Android para Leigos", "Michel Burton", "Alta Books", false));
        listaLivros.add(new Livro(2L, "Android para Leigos", "Michel Burton", "Alta Books", false));
        listaLivros.add(new Livro(3L, "Android para Programadores", "Paul J, Deitel", "Bookman", true));
        listaLivros.add(new Livro(4L, "Desenvolvimento para Android", "Griffiths, David", "Alta Books", false));
        listaLivros.add(new Livro(5L, "Android Base de Dados", "Queirós, Ricardo", "FCA Editora", true));
        listaLivros.add(new Livro(6L, "Android em Ação", "King, Chris", "Elsevier - Campus", false));
        listaLivros.add(new Livro(7L, "Jogos em Android", "Queirós, Ricardo", "FCA - Editora", true));
        listaLivros.add(new Livro(8L, "Android Essencial com Kotlin", "Ricardo R.", "NOVATEC", false));

        LivroAdapter livroAdapter = new LivroAdapter(listaLivros, this);

        recyclerView.setAdapter(livroAdapter);
    }
}