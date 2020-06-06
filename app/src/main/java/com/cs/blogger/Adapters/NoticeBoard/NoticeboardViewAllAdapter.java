package com.cs.blogger.Adapters.NoticeBoard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Activities.Noticeboard.SchoolOfBiotech;
import com.cs.blogger.Activities.Noticeboard.SchoolOfEngineering;
import com.cs.blogger.Activities.Noticeboard.SchoolOfICT;
import com.cs.blogger.Activities.Noticeboard.SchoolOfLaw;
import com.cs.blogger.Activities.Noticeboard.SchoolOfManagement;
import com.cs.blogger.Activities.Noticeboard.SchoolOfVocationalStudies;
import com.cs.blogger.Model.Noticeboard;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 */

public class NoticeboardViewAllAdapter extends RecyclerView.Adapter<NoticeboardViewAllAdapter.NoticeboardViewHolder> {

    ArrayList<Noticeboard> noticeboards_all;
    Context context;


    public NoticeboardViewAllAdapter(ArrayList<Noticeboard> noticeboards_all, Context context) {
        this.noticeboards_all = noticeboards_all;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.noticeboardviewall_item, parent, false);
        NoticeboardViewHolder featuredViewHolder = new NoticeboardViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeboardViewHolder holder, int position) {

        Noticeboard noticeboard = noticeboards_all.get(position);

        holder.image.setImageResource(noticeboard.getImage());
        holder.title.setText(noticeboard.getTitle());
        holder.desc.setText(noticeboard.getDescription());

    }

    @Override
    public int getItemCount() {
        return noticeboards_all.size();
    }


    public class NoticeboardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView image;
        TextView title, desc;

        public NoticeboardViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            //Hooks
            image = itemView.findViewById(R.id.notice_image_viewall);
            title = itemView.findViewById(R.id.notice_title_viewall);
            desc = itemView.findViewById(R.id.notice_desc_viewall);

        }

        @Override
        public void onClick(View v) {

            //Getting position of each row
            int position = getAdapterPosition();

            Noticeboard item = noticeboards_all.get(position);

            if (item.getTitle() == "School of Engineering") {
                context.startActivity(new Intent(context, SchoolOfEngineering.class));

            } else if (item.getTitle() == "School of Law and Justice") {
                context.startActivity(new Intent(context, SchoolOfLaw.class));

            } else if (item.getTitle() == "School of ICT") {
                context.startActivity(new Intent(context, SchoolOfICT.class));

            } else if (item.getTitle() == "School of Management") {
                context.startActivity(new Intent(context, SchoolOfManagement.class));

            } else if (item.getTitle() == "School of Biotechnology") {
                context.startActivity(new Intent(context, SchoolOfBiotech.class));

            } else {
                context.startActivity(new Intent(context, SchoolOfVocationalStudies.class));
            }

        }

    }
}



