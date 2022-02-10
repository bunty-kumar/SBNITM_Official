package com.bunty.sbnitmofficial.ui.notice;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bunty.sbnitmofficial.FullImageView;
import com.bunty.sbnitmofficial.R;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NoticeViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.newsfeed_item_layout, parent, false);

        return new NoticeViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewAdapter holder, int position) {

        NoticeData currentItem = list.get(position);
        holder.showNoticeTitle.setText(currentItem.getTitle());
        holder.noticeDate.setText(currentItem.getDate());
        holder.noticeTime.setText(currentItem.getTime());

        try {
            if (currentItem.getImage() != null)
                Glide.with(context).load(currentItem.getImage()).into(holder.showNoticeImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.showNoticeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FullImageView.class);
                intent.putExtra("image", currentItem.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoticeViewAdapter extends RecyclerView.ViewHolder {

        private TextView showNoticeTitle, noticeDate, noticeTime;
        private ImageView showNoticeImage;

        public NoticeViewAdapter(@NonNull View itemView) {
            super(itemView);

            showNoticeTitle = itemView.findViewById(R.id.showNoticeTitle);
            showNoticeImage = itemView.findViewById(R.id.showNoticeImage);
            noticeDate = itemView.findViewById(R.id.noticeDate);
            noticeTime = itemView.findViewById(R.id.noticeTime);
        }
    }
}
