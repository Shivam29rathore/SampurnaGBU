package com.cs.blogger.Adapters.Categories;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Activities.Categories.ConvenceInCampus;
import com.cs.blogger.Activities.Categories.Eatery;
import com.cs.blogger.Activities.Elearning.Elearning;
import com.cs.blogger.Activities.Categories.EmergencyServices;
import com.cs.blogger.Activities.Results.Results;
import com.cs.blogger.Model.Categories;
import com.cs.blogger.R;

import java.util.ArrayList;
/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {
    private Context context;
    private ArrayList<Categories> allcategories;

    public CategoriesAdapter(Context context, ArrayList<Categories> allcategories) {
        this.context = context;
        this.allcategories = allcategories;
    }



    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_dashboard_categories_cardview, parent, false);
        AdapterAllCategoriesViewHolder lvh = new AdapterAllCategoriesViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {

        Categories helperClass = allcategories.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitile());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return allcategories.size();
    }

    public class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            
            itemView.setOnClickListener(this);
            relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
        }

        @Override
        public void onClick(View v) {

            //Getting position of each row
            int position = getAdapterPosition();

            Categories item = allcategories.get(position);

            if(item.getTitile() == "E-Learning"){
                context.startActivity(new Intent(context, Elearning.class));

            }
            else if( item.getTitile() == "Emergency Services"){
                context.startActivity(new Intent(context, EmergencyServices.class));

            }
            else if( item.getTitile() == "Eatery"){
                context.startActivity(new Intent(context, Eatery.class));

            }

            else if( item.getTitile() == "Conveyance"){
                context.startActivity(new Intent(context, ConvenceInCampus.class));

            }
            else{
                context.startActivity(new Intent(context, Results.class));
            }

        }
    }

}