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

public class ICTupcomingAdapter extends RecyclerView.Adapter<ICTupcomingAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NoticeBoardICt> upcomingevents;

    public ICTupcomingAdapter(Context context, ArrayList<NoticeBoardICt> upcomingevents) {
        this.context = context;
        this.upcomingevents = upcomingevents;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ict_upcomingevents_item, parent, false);
        ViewHolder lvh = new ViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       NoticeBoardICt helper = upcomingevents.get(position);
        holder.heading.setText(helper.getHeading());
        holder.description.setText(helper.getDiscription());
        holder.relativeLayout.setBackground(helper.getGradient());
    }

    @Override
    public int getItemCount() {
        return upcomingevents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView heading;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient_ict_upcomingevents);
            heading = itemView.findViewById(R.id.upcomingevents_heading);
            description = itemView.findViewById(R.id.upcomingevents_content);
        }

    }
}
