package com.example.andrey.projetoand;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Andrey on 15/03/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerTesteViewHolder> {

    public static ClickRecyclerView_Interface clickRecyclerViewInterface;
    Context mctx;
    private List<Pessoa> mList;

    public RecyclerAdapter(Context ctx, List<Pessoa> list, ClickRecyclerView_Interface clickRecyclerViewInterface) {
        this.mctx = ctx;
        this.mList = list;
        this.clickRecyclerViewInterface = clickRecyclerViewInterface;
    }

    //Seta onde o item será populado( lista )
    @Override
    public RecyclerTesteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista, viewGroup, false);
        return new RecyclerTesteViewHolder(itemView);
    }

    //Pega o obejto da lista e passa pra view
    @Override
    public void onBindViewHolder(RecyclerTesteViewHolder viewHolder, int i) {
        Pessoa pessoa = mList.get(i);

        viewHolder.viewNome.setText(pessoa.getNome());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    //Declara as views que serão usadadas no onBindViewHolder
    protected class RecyclerTesteViewHolder extends RecyclerView.ViewHolder {

        protected TextView viewNome;

        public RecyclerTesteViewHolder(final View itemView) {
            super(itemView);

            viewNome = (TextView) itemView.findViewById(R.id.textview_nome);

            //Setup the click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    clickRecyclerViewInterface.onCustomClick(mList.get(getLayoutPosition()));

                }
            });
        }
    }
}
