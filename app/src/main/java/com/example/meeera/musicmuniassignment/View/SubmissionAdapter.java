package com.example.meeera.musicmuniassignment.View;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.meeera.musicmuniassignment.R;
import com.example.meeera.musicmuniassignment.Model.SubmissionModel;

import java.util.List;

/**
 * Created by Arpit on 7/6/18.
 */

public class SubmissionAdapter extends RecyclerView.Adapter<SubmissionViewHolder> {

    private Context context;
    private List<SubmissionModel> submissionModelList;

    public SubmissionAdapter(List<SubmissionModel> submissionModelList, Context context){
        this.submissionModelList = submissionModelList;
        this.context = context;
    }
    @NonNull
    @Override
    public SubmissionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new SubmissionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubmissionViewHolder holder, int position) {
        holder.txtTitle.setText(submissionModelList.get(position).getTitle());
        holder.txtTime.setText("Submitted " + DateUtils.getRelativeTimeSpanString(submissionModelList.get(position).getTimeStamp(), System.currentTimeMillis(), 0, DateUtils.FORMAT_ABBREV_RELATIVE));
        if(submissionModelList.get(position).getIsReviewed()){
            holder.txtStatus.setText(R.string.reviewed);
            holder.txtStatus.setTextColor(Color.GREEN);
        }else{
            holder.txtStatus.setText(R.string.notReviewed);
            holder.txtStatus.setTextColor(Color.RED);
        }
    }

    @Override
    public int getItemCount() {
        return submissionModelList.size();
    }

    public void updateList(List<SubmissionModel> submissionModelList) {
        this.submissionModelList= submissionModelList;
        notifyDataSetChanged();
    }
}
