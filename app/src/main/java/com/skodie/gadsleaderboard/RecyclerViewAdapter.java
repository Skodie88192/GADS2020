package com.skodie.gadsleaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.skodie.gadsleaderboard.model.LearningLeadersInfo;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context mContext;
    private List<LearningLeadersInfo> mLeadersInfoList;
    //ImageView imageView;

    private View mView;

    public RecyclerViewAdapter(Context context ,  List<LearningLeadersInfo> mLeadersInfoList) {
        this.mContext = context;
       // this.imageView = imageView;
        this.mLeadersInfoList = mLeadersInfoList;


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard, parent, false);
        return new RecyclerViewAdapter.ViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        String imageUrl = mLeadersInfoList.get(position).getBadgeUrl();
        String studentDetails = mLeadersInfoList.get(position).getHours() +
                " learning hours," +
                mLeadersInfoList.get(position).getCountry();
//        Log.e("ImageUrl", imageUrl);

        Glide.with(mContext)
                .load(imageUrl)
                .into(holder.mBadge);
        holder.mName.setText(mLeadersInfoList.get(position).getName());

        holder.mSubtitle.setText(studentDetails);


    }

    @Override
    public int getItemCount() {
        return mLeadersInfoList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mBadge;
        TextView mName, mSubtitle;

        public ViewHolder(View itemView) {
            super(itemView);

            mBadge = (ImageView) itemView.findViewById(R.id.badge);
            mName =(TextView) itemView.findViewById(R.id.name);
            mSubtitle =(TextView) itemView.findViewById(R.id.subtitle);

        }

    }



}
