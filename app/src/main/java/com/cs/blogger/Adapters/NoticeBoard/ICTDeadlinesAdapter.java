package com.cs.blogger.Adapters.NoticeBoard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Model.NoticeBoardICt;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class ICTDeadlinesAdapter extends RecyclerView.Adapter<ICTDeadlinesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NoticeBoardICt> deadlines;

    public ICTDeadlinesAdapter(Context context, ArrayList<NoticeBoardICt> deadlines) {
        this.context = context;
        this.deadlines = deadlines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ict_deadlines_item, parent, false);
        ViewHolder lvh = new ViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NoticeBoardICt helperClass = deadlines.get(position);
        holder.heading.setText(helperClass.getHeading());
        holder.discription.setText(helperClass.getDiscription());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return deadlines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView heading;
        TextView discription;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient_ict_deadlines);
            heading = itemView.findViewById(R.id.deadlines_heading);
            discription = itemView.findViewById(R.id.deadlines_content);
        }

    }
}
