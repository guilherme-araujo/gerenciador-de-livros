package com.example.gerenciadordelivros.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gerenciadordelivros.R;
import com.example.gerenciadordelivros.dominio.Livro;

import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroHolder> {

    private List<Livro> livros;
    private Context context;

    public LivroAdapter(List<Livro> livros, Context context) {
        this.livros = livros;
        this.context = context;
    }

    @NonNull
    @Override
    public LivroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_livro,parent,false);
        LivroHolder livroHolder = new LivroHolder(view);

        return livroHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LivroHolder holder, int position) {

        Livro livro = livros.get(position);
        holder.txtTitulo.setText(livro.getTitulo());
        holder.txtAutor.setText(livro.getAutor());
        holder.txtEditora.setText(livro.getEditora());
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public class LivroHolder extends RecyclerView.ViewHolder {

        public TextView txtTitulo;
        public TextView txtAutor;
        public TextView txtEditora;
        public ImageView ic_livro;

        public LivroHolder(View view) {
            super(view);

            txtTitulo = view.findViewById(R.id.txtTitulo);
            txtTitulo = view.findViewById(R.id.txtAutor);
            txtTitulo = view.findViewById(R.id.txtEditora);
            txtTitulo = view.findViewById(R.id.ic_livro);
        }
    }
}
