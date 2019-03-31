package com.example.meeera.musicmuniassignment.View;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.example.meeera.musicmuniassignment.Model.SubmissionView;
import com.example.meeera.musicmuniassignment.Presenter.SubmissionPresenter;
import com.example.meeera.musicmuniassignment.R;
import com.example.meeera.musicmuniassignment.Model.SubmissionModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Arpit on 7/6/18.
 */

public class SubmissionActivity extends AppCompatActivity implements SubmissionView {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    SubmissionPresenter mainPresenter;
    SubmissionAdapter submissionAdapter;
    ProgressDialog progressDialog;
    private List<SubmissionModel> submissionModelList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        submissionAdapter = new SubmissionAdapter(submissionModelList, this);
        recyclerView.setAdapter(submissionAdapter);
        initializeProgress();
        mainPresenter = new SubmissionPresenter(this, this);
        mainPresenter.retrieveData();
    }



    @Override
    public void setItems(List<SubmissionModel> submissionModelList) {
        if (submissionModelList.size()>0) {
            submissionAdapter.updateList(submissionModelList);
        }else {
            Toast.makeText(this, "Empty List", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "Error Fetching list", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        progressDialog.show();
    }

    @Override
    public void hideProgressBar() {
        progressDialog.dismiss();
    }

    private void initializeProgress() {
        progressDialog = new ProgressDialog(SubmissionActivity.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Please wait..");
    }
}
