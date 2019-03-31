package com.example.meeera.musicmuniassignment.Model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

/**
 * Created by Arpit on 6/6/18.
 */

@DynamoDBTable(tableName =  "riyaz_dev_submissions_for_review")
public class SubmissionModel {
    private String userId;
    private long timeStamp;
    private String title;
    private Boolean isReviewed;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    @DynamoDBRangeKey(attributeName = "timeStamp")
    @DynamoDBAttribute(attributeName = "timeStamp")
    public long getTimeStamp(){
        return timeStamp;
    }
    public void setTimeStamp(long timeStamp){
        this.timeStamp = timeStamp;
    }

    @DynamoDBAttribute(attributeName = "title")
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    @DynamoDBAttribute(attributeName = "isReviewed")
    public Boolean getIsReviewed(){
        return isReviewed;
    }
    public void setIsReviewed(Boolean isReviewed){
        this.isReviewed = isReviewed;
    }

}
