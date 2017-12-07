package com.example.eduardo.paselistar.Adaptadores;

import android.content.Context;
import android.net.sip.SipSession;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eduardo.paselistar.R;
import com.example.eduardo.paselistar.modelos.GruposItem;

import java.util.ArrayList;

/**
 * Created by germa on 06/12/2017.
 */

public class ListaGruposAdaptador extends RecyclerView.Adapter<ListaGruposAdaptador.ViewHolder>{
    private ArrayList<GruposItem> dataset;
    private Context context;
    private Listener listener;

    public interface Listener{

        void abreLista(String materia, String grupo);
    }

    public ListaGruposAdaptador(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }
    public void agregarListaGrupos(ArrayList<GruposItem> grupos){
        dataset.addAll(grupos);
        notifyDataSetChanged();
    }
    public void setListener(Listener listener){
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.objeto_grupo,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    GruposItem g = dataset.get((int)v.getTag());
                    listener.abreLista(g.getClavemateria(),g.getGrupo());
                }
            }
        });

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        GruposItem a = dataset.get(position);
        holder.nombreMateria.setText(a.getMateria());
        holder.claveMateria.setText(a.getClavemateria());
        holder.grupoMateria.setText(a.getGrupo());
        holder.cardView.setTag(position);
    }

    @Override
    public int getItemCount() { return dataset.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombreMateria;
        private TextView claveMateria;
        private TextView grupoMateria;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            nombreMateria = itemView.findViewById(R.id.tvNombre);
            claveMateria = itemView.findViewById(R.id.tvClaveMateria);
            grupoMateria = itemView.findViewById(R.id.tvGrupo);
        }
    }


}

