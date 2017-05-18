package com.example.vikram.freshapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Vikram on 08-May-17.
 */

public class RecyclerAdaper extends RecyclerView.Adapter<RecyclerAdaper.MyViewHolder> {

    private static final String TAG = RecyclerAdaper.class.getSimpleName();
    Context context;
    private Itemclick clickListener;

    List<Model> list1;
    private static int type1 = 1;
    private static int type2 = 2;


    public RecyclerAdaper(Context context, List<Model> list1) {
        this.context = context;
        this.list1 = list1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class Holder1 extends MyViewHolder{
        TextView tname,tid,tcolor, ttype;
        CardView card;
        public Holder1(View itemView) {
            super(itemView);

            tname = (TextView)itemView.findViewById(R.id.tv_name);
            tid = (TextView)itemView.findViewById(R.id.tv_id);
            ttype = (TextView)itemView.findViewById(R.id.tv_type);
            tcolor = (TextView)itemView.findViewById(R.id.tv_color);
            card = (CardView)itemView.findViewById(R.id.card);
        }
    }
    private class Holder2 extends MyViewHolder{
        TextView tname,tid,tcolor, ttype;
        CardView card;
        public Holder2(View itemView) {
            super(itemView);
            tname = (TextView)itemView.findViewById(R.id.tv_name);
            tid = (TextView)itemView.findViewById(R.id.tv_id);
            ttype = (TextView)itemView.findViewById(R.id.tv_type);
            tcolor = (TextView)itemView.findViewById(R.id.tv_color);
            card = (CardView)itemView.findViewById(R.id.card);
        }
    }

    @Override
    public int getItemViewType(int position) {
       if(list1.get(position).getType()==1){
           return type1;
       }
       else {
           return type2;
       }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=null;
        if(viewType == type1){
            view = LayoutInflater.from(context).inflate(R.layout.item_type_1,parent,false);
            return new Holder1(view);
        }
        else
        {
            view = LayoutInflater.from(context).inflate(R.layout.item_type_2,parent,false);
            return new Holder2(view);
        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        final Model model = list1.get(position);
        if(holder.getItemViewType() == type1){
            Holder1 h1= (Holder1) holder;
            h1.tname.setText(model.getName());
            h1.tid.setText(model.getId());
            h1.tcolor.setText(model.getColor());
            h1.ttype.setText(""+model.getType());
            h1.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener !=null)
                    {
                        clickListener.onclick(position);
                    }
                }
            });
        }
        else{
            Holder2 h2 = (Holder2) holder;
            h2.tname.setText(model.getName());
            h2.tid.setText(model.getId());
            h2.tcolor.setText(model.getColor());
            h2.ttype.setText(""+model.getType());
            h2.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(clickListener !=null)
                    {
                        clickListener.onclick(position);
                    }
                }
            });
        }
    }
    @Override
    public int getItemCount() {
        return list1.size();
    }

    public void setClickListener(Itemclick itemClickListener) {
        this.clickListener = itemClickListener;
    }

}
