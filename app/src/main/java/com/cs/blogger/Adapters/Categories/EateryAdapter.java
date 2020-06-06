package com.cs.blogger.Adapters.Categories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Model.Categories;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class EateryAdapter extends RecyclerView.Adapter<EateryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Categories> eaterylist;

    public EateryAdapter(Context context, ArrayList<Categories> allcategories) {
        this.context = context;
        this.eaterylist = allcategories;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catall_eatery_cardview, parent, false);
        ViewHolder lvh = new ViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Categories helperClass = eaterylist.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitile());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return eaterylist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient_eatery);
            imageView = itemView.findViewById(R.id.eatery_image);
            textView = itemView.findViewById(R.id.eatery_title);
        }

    }
}
