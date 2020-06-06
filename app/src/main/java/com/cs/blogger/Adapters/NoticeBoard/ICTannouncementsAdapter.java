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

public class ICTannouncementsAdapter extends RecyclerView.Adapter<ICTannouncementsAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NoticeBoardICt> announcements;

    public ICTannouncementsAdapter(Context context, ArrayList<NoticeBoardICt> announcements) {
        this.context = context;
        this.announcements = announcements;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ict_announcments_item, parent, false);
        ViewHolder lvh = new ViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        NoticeBoardICt helperClass = announcements.get(position);
        holder.heading.setText(helperClass.getHeading());
        holder.description.setText(helperClass.getDiscription());
        holder.relativeLayout.setBackground(helperClass.getGradient());
    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout relativeLayout;
        TextView heading;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            relativeLayout = itemView.findViewById(R.id.background_gradient_ict_announcements);
            heading = itemView.findViewById(R.id.announcement_heading);
            description = itemView.findViewById(R.id.announcements_content);
        }

    }
}
