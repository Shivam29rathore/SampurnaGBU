package com.cs.blogger.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.blogger.Model.Blog;
import com.cs.blogger.R;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;
/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class BlogRecylerAdapter extends RecyclerView.Adapter<BlogRecylerAdapter.ViewHolder> {

    private Context context;
    private List<Blog> blogList;




    public BlogRecylerAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }
// Where to find the single cardView as ViewHolder object
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_post,parent,false);

        return new ViewHolder(view,context);
    }
// What to do when we find the cardview
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Blog blog = blogList.get(position);
        String imageurl = null;


        holder.title.setText(blog.getTitle());
        holder.disc.setText(blog.getDesc());
        //Converting the time format to readable time format.
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(blog.getTimestamp()))
                .getTime());

        holder.timestamp.setText(formattedDate);

        imageurl = blog.getImage();

        Picasso.get().load(imageurl).fit().placeholder(R.mipmap.buffer).into(holder.image);


    }



    // No of rows in Recyler View
    @Override
    public int getItemCount() {

        return blogList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView disc;
        public TextView timestamp;
        public ImageView image;
        String Userid;


        public ViewHolder(@NonNull View view,Context ctx) {
            super(view);

            context= ctx;
            title=  view.findViewById(R.id.postTitleList);
            disc= view.findViewById(R.id.postDescroptionList);
            timestamp= view.findViewById(R.id.timestampList);
            image = view.findViewById(R.id.postImageList);

            Userid= null;


        }
    }
}
