package com.cs.blogger.Activities.Noticeboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.cs.blogger.Adapters.NoticeBoard.NoticeboardViewAllAdapter;
import com.cs.blogger.Model.Noticeboard;
import com.cs.blogger.R;

import java.util.ArrayList;

public class NoticeboardViewAll extends AppCompatActivity {

    RecyclerView noticeboardRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_noticeboard_view_all);
        noticeboardRecycler = findViewById(R.id.notice_board_viewall);
        noticeBoardRecycler();
    }


    private void noticeBoardRecycler() {

        noticeboardRecycler.setHasFixedSize(true);
        noticeboardRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        final ArrayList<Noticeboard> noticeboardArrayList = new ArrayList<>();

        noticeboardArrayList.add(new Noticeboard(R.drawable.soict, "School of ICT", "No of Notices: \nPhone: 0120 234 4200 "));
        noticeboardArrayList.add(new Noticeboard(R.drawable.soe, "School of Engineering", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.somanagement, "School of Management", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.sobiotech, "School of Biotechnology", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.solaw, "School of Law and Justice", "No of Notices: \nPhone: 0120 234 4200"));
        noticeboardArrayList.add(new Noticeboard(R.drawable.sovocational, "School of Vocational studies", "No of Notices:\nPhone: 0120 234 4200"));

        adapter = new NoticeboardViewAllAdapter(noticeboardArrayList, this);
        noticeboardRecycler.setAdapter(adapter);


    }

}
