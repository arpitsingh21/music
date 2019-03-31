package com.example.meeera.musicmuniassignment.Presenter;

import android.content.Context;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.example.meeera.musicmuniassignment.Model.SubmissionView;
import com.example.meeera.musicmuniassignment.Model.SubmissionModel;
import com.example.meeera.musicmuniassignment.UI.RunOnUIThread;

import java.util.List;
import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;

/**
 * Created by Arpit on 7/6/18.
 */

public class SubmissionPresenter implements BasePresenter {

    private SubmissionView submissionView;
    private Context context;
    private List<SubmissionModel> submissionModelList;
    private AmazonDynamoDBClient client;

    public SubmissionPresenter(SubmissionView submissionView, Context context) {
        this.submissionView = submissionView;
        this.context = context;
        CognitoCachingCredentialsProvider cachingCredentialsProvider = new CognitoCachingCredentialsProvider(
                context,
                "ap-south-1:60314d52-74b2-4a50-92e2-ea4828bc8775",
                Regions.AP_SOUTH_1
        );
        client = new AmazonDynamoDBClient(cachingCredentialsProvider);
        client.setRegion(Region.getRegion(Regions.AP_SOUTH_1));
    }

    @Override
    public void retrieveData() {
        submissionView.showProgressBar();
        final DynamoDBMapper mapper = new DynamoDBMapper(client);
        submissionModelList = mapper.parallelScan(SubmissionModel.class, new DynamoDBScanExpression(),4);

        if (submissionModelList!=null){
            submissionView.hideProgressBar();
            submissionView.setItems(submissionModelList);
        }
        else {
            submissionView.hideProgressBar();
            submissionView.onFailure();
        }
//        Task.callInBackground(new Callable<List<SubmissionModel>>() {
//            @Override
//            public List<SubmissionModel> call() throws Exception {
//                try {
//                    return submissionModelList;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    return null;
//                }
//            }
//        }).onSuccess(new Continuation<List<SubmissionModel>, Object>() {
//
//            @Override
//            public Object then(Task<List<SubmissionModel>> task) throws Exception {
//                if (task.getResult() == null) {
//                    RunOnUIThread.run(new Runnable() {
//                        @Override
//                        public void run() {
//
//                        }
//                    });
//                    return null;
//                }
//                RunOnUIThread.run(new Runnable() {
//                    @Override
//                    public void run() {
//                        submissionView.hideProgressBar();
//                        submissionView.setItems(submissionModelList);
//                    }
//                });
//                return null;
//            }
//        });
    }
}
