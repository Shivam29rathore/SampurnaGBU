package com.cs.blogger.Adapters.eLearning;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Model.ResultsHelper;
import com.cs.blogger.Model.eLearningHelper;
import com.cs.blogger.R;

import java.util.ArrayList;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 */

public class previousyearPapersAdapter extends RecyclerView.Adapter<previousyearPapersAdapter.NoticeboardViewHolder> {

    ArrayList<eLearningHelper> papers;
    Context context;

    public previousyearPapersAdapter(ArrayList<eLearningHelper> results, Context context) {
        this.papers = results;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_previousyearpaper, parent, false);
        NoticeboardViewHolder featuredViewHolder = new NoticeboardViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NoticeboardViewHolder holder, int position) {

        final eLearningHelper resultsHelper = papers.get(position);

        holder.link.setText(resultsHelper.getDownloadlink());
        holder.title.setText(resultsHelper.getTitle());
        holder.desc.setText(resultsHelper.getDesc());
        holder.downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFile(holder.title.getContext(),resultsHelper.getTitle(),".jpeg",DIRECTORY_DOWNLOADS,resultsHelper.getDownloadlink());
            }
        });




    }


    public void downloadFile(Context context, String fileName, String fileExtension, String destinationDirectory, String url) {

        DownloadManager downloadmanager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context, destinationDirectory, fileName + fileExtension);

        downloadmanager.enqueue(request);
    }


    @Override
    public int getItemCount() {
        return papers.size();
    }


    public class NoticeboardViewHolder extends RecyclerView.ViewHolder {


        TextView title, desc,link;
        Button downloadbtn;

        public NoticeboardViewHolder(@NonNull View itemView) {
            super(itemView);


            //Hooks
            downloadbtn = itemView.findViewById(R.id.paper_download);
            title = itemView.findViewById(R.id.Paper_title);
            desc = itemView.findViewById(R.id.paper_desc);
            link = itemView.findViewById(R.id.paper_link);


        }


    }
}



