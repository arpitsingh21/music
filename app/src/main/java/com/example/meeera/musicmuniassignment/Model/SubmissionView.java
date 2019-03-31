package com.example.meeera.musicmuniassignment.Model;

import java.util.List;

/**
 * Created by Arpit on 7/6/18.
 */

public interface SubmissionView {
    void setItems(List<SubmissionModel> submissionModelList);
    void onFailure();
    void showProgressBar();
    void hideProgressBar();
}
