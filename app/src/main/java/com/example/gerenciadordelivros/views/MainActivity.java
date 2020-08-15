package com.example.gerenciadordelivros.views;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gerenciadordelivros.R;
import com.example.gerenciadordelivros.adapter.LivroAdapter;
import com.example.gerenciadordelivros.data.LivroDAO;
import com.example.gerenciadordelivros.dominio.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LivroDAO livroDAO;

    private LivroAdapter livroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        //listaLivros.add(new Livro(1L, "Android para Leigos", "Michel Burton", "Alta Books", 0));
        //listaLivros.add(new Livro(2L, "Android para Leigos", "Michel Burton", "Alta Books", 0));
        //listaLivros.add(new Livro(3L, "Android para Programadores", "Paul J, Deitel", "Bookman", 1));
        //listaLivros.add(new Livro(4L, "Desenvolvimento para Android", "Griffiths, David", "Alta Books", 0));
        //listaLivros.add(new Livro(5L, "Android Base de Dados", "Queirós, Ricardo", "FCA Editora", 1));
        //listaLivros.add(new Livro(6L, "Android em Ação", "King, Chris", "Elsevier - Campus", 0));
        //listaLivros.add(new Livro(7L, "Jogos em Android", "Queirós, Ricardo", "FCA - Editora", 1));
        //listaLivros.add(new Livro(8L, "Android Essencial com Kotlin", "Ricardo R.", "NOVATEC", 0));

        livroDAO = LivroDAO.getInstance(this);
        List<Livro> listaLivros = livroDAO.list();

        livroAdapter = new LivroAdapter(listaLivros, this);

        recyclerView.setAdapter(livroAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_adicionar:
                Intent intent = new Intent(getApplicationContext(),EditarLivroActivity.class);
                startActivityForResult(intent, 100);
                return true;
            case R.id.action_sair:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==100 && resultCode == RESULT_OK){
            atualizaListaLivros();
        }
    }

    public void atualizaListaLivros(){
        List<Livro> livros = livroDAO.list();
        livroAdapter.setItems(livros);
        livroAdapter.notifyDataSetChanged();

    }
}