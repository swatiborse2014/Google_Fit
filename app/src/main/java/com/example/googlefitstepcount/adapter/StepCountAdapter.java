package com.example.googlefitstepcount.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.googlefitstepcount.R;
import com.example.googlefitstepcount.model.StepCount;

import java.util.List;

public class StepCountAdapter extends RecyclerView.Adapter<StepCountAdapter.ViewHolder> {
    private String TAG = StepCountAdapter.class.getSimpleName();
    private Context mContext;
    private String startDate;
    private String endDate;
    private String stepVal;
    private List<StepCount> arrStepCount;

    public StepCountAdapter(String startDate, String endDate, String stepVal, List<StepCount> stepCounts, Context mainActivityFinal) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.stepVal = stepVal;
        arrStepCount = stepCounts;
        mContext = mainActivityFinal;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_count_data, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StepCount stepCount = arrStepCount.get(position);
        holder.mTxtStart.setText(stepCount.getStartDate());
        holder.mTxtEnd.setText(stepCount.getEndDate());
        holder.mTxtStepVal.setText(stepCount.getStepValue());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return arrStepCount == null ? 0 : arrStepCount.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtStart;
        public TextView mTxtEnd;
        public TextView mTxtStepVal;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            mTxtStart = (TextView) itemLayoutView.findViewById(R.id.txt_start_date);
            mTxtEnd = (TextView) itemLayoutView.findViewById(R.id.txt_end_date);
            mTxtStepVal = (TextView) itemLayoutView.findViewById(R.id.txt_step_val);

        }
    }
}
