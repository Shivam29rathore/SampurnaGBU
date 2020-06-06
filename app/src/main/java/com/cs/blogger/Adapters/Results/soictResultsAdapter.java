package com.cs.blogger.Adapters.Results;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.cs.blogger.Model.ResultsHelper;
import com.cs.blogger.R;

import java.util.ArrayList;
import java.util.Date;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 */

public class soictResultsAdapter extends RecyclerView.Adapter<soictResultsAdapter.NoticeboardViewHolder> {

    ArrayList<ResultsHelper> results;
    Context context;


    public soictResultsAdapter(ArrayList<ResultsHelper> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public NoticeboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result_soict, parent, false);
        NoticeboardViewHolder featuredViewHolder = new NoticeboardViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final NoticeboardViewHolder holder, int position) {

        final ResultsHelper resultsHelper = results.get(position);

        holder.link.setText(resultsHelper.getDownloadlink());
        holder.title.setText(resultsHelper.getTitle());
        holder.desc.setText(resultsHelper.getDescription());
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
        return results.size();
    }


    public class NoticeboardViewHolder extends RecyclerView.ViewHolder {


        TextView title, desc,link;
        Button downloadbtn;

        public NoticeboardViewHolder(@NonNull View itemView) {
            super(itemView);


            //Hooks
            downloadbtn = itemView.findViewById(R.id.result_download_soict);
            title = itemView.findViewById(R.id.result_title_soict);
            desc = itemView.findViewById(R.id.result_desc_soict);
            link = itemView.findViewById(R.id.result_link_soict);


        }


    }
}



