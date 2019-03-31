package com.example.meeera.musicmuniassignment.View;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.meeera.musicmuniassignment.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Arpit on 7/6/18.
 */

public class SubmissionViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.txtTitle)
    TextView txtTitle;

    @BindView(R.id.review)
    TextView txtStatus;

    @BindView(R.id.time)
    TextView txtTime;

    public SubmissionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
