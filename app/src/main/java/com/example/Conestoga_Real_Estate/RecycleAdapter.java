package com.example.Conestoga_Real_Estate;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;




public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.myViewHolder> {

    Context mcontext;
    ArrayList<Property> mData;
    private  OnViewListener mOnViewListener;

    public RecycleAdapter(Context mcontext, ArrayList<Property> mData, OnViewListener onViewListener) {
        this.mcontext = mcontext;
        this.mData = mData;
        this.mOnViewListener = onViewListener;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View v = inflater.inflate(R.layout.activity_property_list, parent, false);
        return new myViewHolder(v, mOnViewListener);
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position){

        Property tempproperty = mData.get(position);

        holder.propName.setText(tempproperty.getPropName());
        int imageResource = holder.itemView.getResources().getIdentifier(tempproperty.getImg(),null, mcontext.getPackageName());

        holder.background.setImageResource(imageResource);
        holder.propPrice.setText(tempproperty.getPrice());
        holder.propType.setText(tempproperty.gettype());

    }

    @Override
    public int getItemCount(){
        return mData.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView background;
        TextView propName;
        TextView propPrice;
        TextView propType;

        OnViewListener onViewListener;

        public myViewHolder(View itemView, OnViewListener onViewListener){
            super(itemView);

            background = itemView.findViewById(R.id.background);
            propName = itemView.findViewById(R.id.PropName);
            propPrice = itemView.findViewById(R.id.PropPrice);
            propType = itemView.findViewById(R.id.propType);
            this.onViewListener = onViewListener;
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View itemView) {
            int position = getAdapterPosition();
            onViewListener.onViewClick(position);
            //Snackbar.make(itemView, "Click detected on item " + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();

        }


    }

    public interface OnViewListener{
        void onViewClick(int position);
    }

}
