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

public class ConveyanceAdapter extends RecyclerView.Adapter<ConveyanceAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Categories> conveyance;

    public ConveyanceAdapter(Context context, ArrayList<Categories> conveyance) {
        this.context = context;
        this.conveyance = conveyance;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.conveyance_item, parent, false);
        ViewHolder lvh = new ViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Categories helperClass = conveyance.get(position);
        holder.imageView.setImageResource(helperClass.getImage());
        holder.textView.setText(helperClass.getTitile());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return conveyance.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient_conveyance);
            imageView = itemView.findViewById(R.id.conveyance_image);
            textView = itemView.findViewById(R.id.conveyance_text);
        }

    }
}
