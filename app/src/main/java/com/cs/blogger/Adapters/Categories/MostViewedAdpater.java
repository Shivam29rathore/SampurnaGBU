package com.cs.blogger.Adapters.Categories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Activities.Noticeboard.SchoolOfEngineering;
import com.cs.blogger.Activities.Noticeboard.SchoolOfICT;
import com.cs.blogger.Activities.Noticeboard.SchoolOfLaw;
import com.cs.blogger.Activities.Noticeboard.SchoolOfManagement;
import com.cs.blogger.Model.MostViewed;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class MostViewedAdpater extends RecyclerView.Adapter<MostViewedAdpater.MostViewedViewHolder> {

    ArrayList<MostViewed> mostViewedLocations;
    Context context;

    public MostViewedAdpater(ArrayList<MostViewed> mostViewedLocations, Context context) {
        this.mostViewedLocations = mostViewedLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_dashboard_mostviewed_cardview, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewed helperClass = mostViewedLocations.get(position);

        holder.imageView.setImageResource(helperClass.getImageView());
        holder.textView.setText(helperClass.getTextView());
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public class MostViewedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView;

        public MostViewedViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imageView = itemView.findViewById(R.id.mv_image);
            textView = itemView.findViewById(R.id.mv_title);
        }

        @Override
        public void onClick(View v) {

            //Getting position of each row
            int position = getAdapterPosition();

            MostViewed item = mostViewedLocations.get(position);

            if(item.getTextView() == "School of Engineering"){
                context.startActivity(new Intent(context, SchoolOfEngineering.class));

            }
            else if( item.getTextView() == "School of Law and Justice"){
                context.startActivity(new Intent(context, SchoolOfLaw.class));

            }
            else if( item.getTextView() == "School of ICT"){
                context.startActivity(new Intent(context, SchoolOfICT.class));

            }

            else{
                context.startActivity(new Intent(context, SchoolOfManagement.class));
            }

        }

        }
    }


