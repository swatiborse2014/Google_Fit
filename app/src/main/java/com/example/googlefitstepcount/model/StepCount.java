package com.example.googlefitstepcount.model;

import android.os.Parcel;
import android.os.Parcelable;

public class StepCount  {

    String startDate;
    String endDate;
    String stepValue;

    public StepCount(String startDate, String endDate, String stepValue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stepValue = stepValue;
    }


    public StepCount() {

    }

    protected StepCount(Parcel in) {
        startDate = in.readString();
        endDate = in.readString();
        stepValue = in.readString();
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStepValue() {
        return stepValue;
    }

    public void setStepValue(String stepValue) {
        this.stepValue = stepValue;
    }

}
