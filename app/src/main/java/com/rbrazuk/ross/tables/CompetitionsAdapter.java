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

        TextView competitionNameTextView = holder.mCompetitionNameTextView;
        competitionNameTextView.setText(competition.getCaption());
    }

    @Override
    public int getItemCount() {
        return mCompetitions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvCompetitionName) TextView mCompetitionNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
