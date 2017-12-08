package com.example.eduardo.paselistar.Adaptadores;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.eduardo.paselistar.R;
import com.example.eduardo.paselistar.modelos.AlumnosItem;

import java.util.ArrayList;

/**
 * Created by eduardo on 5/12/17.
 */

public class ListaAlumnosAdaptador extends RecyclerView.Adapter<ListaAlumnosAdaptador.ViewHolder> {
    private ArrayList<AlumnosItem> dataset;
    private Context context;
    private Listener listener;

    public interface Listener{
        void detallesAlumno(AlumnosItem alumno);
        void marcaDesmarcaFalta(AlumnosItem alumnos, View view);

    }

    public void setListener(Listener listener){ this.listener=listener;};

    public ListaAlumnosAdaptador(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    public void agregarListaAlumnos(ArrayList<AlumnosItem> alummnos){
        dataset.addAll(alummnos);
        notifyDataSetChanged();
    }
    public ArrayList<AlumnosItem> getDataset(){
        return dataset;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.objeto_alumno,parent,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    AlumnosItem a =dataset.get((int)view.getTag());
                    listener.marcaDesmarcaFalta(a,view);
                }
            }
        });
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(listener!=null){
                    AlumnosItem a =dataset.get((int)view.getTag());
                    listener.detallesAlumno(a);
                }
                return false;
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        AlumnosItem a = dataset.get(position);
        holder.nombreTextView.setText(a.getApellidopaterno()+" "+a.getApellidomaterno()+" "+a.getNombre());
        Glide.with(context)
                .load("http://189.202.197.43/fotos/"+a.getNcontrol()+".jpg")
        .centerCrop()
        .crossFade()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(holder.fotoImageView);
        if(dataset.get(position).getAsistencia()==null || dataset.get(position).getAsistencia()=="1"){
            holder.cardView.setCardBackgroundColor(Color.WHITE);
        }
        else{holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.sayan_rose));}
        holder.cardView.setTag(position);
    }

    @Override
    public int getItemCount(){
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoImageView;
        private TextView nombreTextView;
        private CardView cardView;

        public ViewHolder(View itemView){
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.imageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.tvNombre);
            cardView = (CardView) itemView;
        }
}

}
