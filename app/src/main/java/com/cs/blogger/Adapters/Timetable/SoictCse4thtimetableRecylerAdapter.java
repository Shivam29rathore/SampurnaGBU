package com.cs.blogger.Adapters.Timetable;

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
import com.cs.blogger.Model.TimetableHelper;
import com.cs.blogger.R;

import java.util.ArrayList;

/**
 * Created by Shivam Singh Rathore on 18/05/20
 *
 */

public class SoictCse4thtimetableRecylerAdapter extends RecyclerView.Adapter<SoictCse4thtimetableRecylerAdapter.AdapterAllCategoriesViewHolder> {
    private Context context;
    private ArrayList<TimetableHelper> timetables;

    public SoictCse4thtimetableRecylerAdapter(Context context, ArrayList<TimetableHelper> timetables) {
        this.context = context;
          this.timetables = timetables;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_timetable_cse4th_mon, parent, false);
        AdapterAllCategoriesViewHolder lvh = new AdapterAllCategoriesViewHolder(view);
        return lvh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        TimetableHelper helperClass = timetables.get(position);
        holder.faculty.setText(helperClass.getFaculty());
        holder.subject.setText(helperClass.getSubject());
        holder.timing.setText(helperClass.getTiming());
        holder.roomno.setText(helperClass.getRoomno());

    }


    @Override
    public int getItemCount() {
        return timetables.size();
    }

    public class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {


        TextView subject,faculty,timing,roomno;

        public AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

            subject = itemView.findViewById(R.id.timetable_subject_cse4th_mon);
            faculty = itemView.findViewById(R.id.timetable_faculty_cse4th_mon);
            timing = itemView.findViewById(R.id.timetable_timing_cse4th_mon);
            roomno = itemView.findViewById(R.id.timetable_roomno_cse4th_mon);


        }

    }

}