package com.rbrazuk.ross.tables;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CompetitionsAdapter extends RecyclerView.Adapter<CompetitionsAdapter.ViewHolder> {

    private List<Competition> mCompetitions;

    private Context mContext;

    public CompetitionsAdapter(Context context, List<Competition> competitions) {
        mCompetitions = competitions;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View competitionView = inflater.inflate(R.layout.list_item_competitions, parent, false);

        return new ViewHolder(competitionView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Competition competition = mCompetitions.get(position);

        holder.bindCompetition(competition);
    }

    @Override
    public int getItemCount() {
        return mCompetitions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tvCompetitionName) TextView mCompetitionNameTextView;

        private Competition mCompetition;

        public void bindCompetition(Competition competition) {
            mCompetition = competition;
            mCompetitionNameTextView.setText(mCompetition.getCaption());
        }

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            ButterKnife.bind(this, itemView);
        }


        @Override
        public void onClick(View view) {

        }
    }
}
