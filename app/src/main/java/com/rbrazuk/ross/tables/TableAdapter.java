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

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private List<Team> mTeams;

    private Context mContext;

    public TableAdapter(Context context, List<Team> teams) {
        mTeams = teams;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View teamView = inflater.inflate(R.layout.list_item_team, parent, false);

        return new ViewHolder(teamView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Team team = mTeams.get(position);
        holder.bindTeam(team);
    }

    @Override
    public int getItemCount() {
        return mTeams.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.tvPosition) TextView mPositionTextView;
        @BindView(R.id.tvTeamName) TextView mTeamNameTextView;
        @BindView(R.id.tvPoints) TextView mPointsTextView;

        private Team mTeam;

        public void bindTeam(Team team) {
            mTeam = team;
            mTeamNameTextView.setText(mTeam.getName());
            mPositionTextView.setText(String.valueOf(mTeam.getPosition()));
            mPointsTextView.setText(String.valueOf(mTeam.getPoints()));
        }

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
