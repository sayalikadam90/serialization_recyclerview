package com.example.serialization_practice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterName extends RecyclerView.Adapter<AdapterName.ViewHolder> {

    Context mcontext;
    List<model> NameList;

    public AdapterName(Context mcontext, List<model> NameList){
        this.mcontext=mcontext;
        this.NameList=NameList;

    }
    @NonNull
    @Override
    public AdapterName.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View nameview= LayoutInflater.from(parent.getContext()).inflate(R.layout.customview,parent,false);
        return new ViewHolder(nameview);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterName.ViewHolder holder, int position) {
        model name=NameList.get(position);
        holder.modelname.setText(name.getName());
        holder.modelemail.setText(name.getEmail());
        holder.modelmobile.setText(name.getMobile());


    }

    @Override
    public int getItemCount() {
        return NameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView modelname;
        TextView modelemail;
        TextView modelmobile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            modelname=itemView.findViewById(R.id.customname);
            modelemail=itemView.findViewById(R.id.customemail);
            modelmobile=itemView.findViewById(R.id.custommobile);

            modelname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    model modelname=NameList.get(getAdapterPosition());
                    Intent intent=new Intent(mcontext,MainActivity2.class);
                    intent.putExtra("show",modelname);
                    mcontext.startActivity(intent);
                }
            });

        }
    }
}
