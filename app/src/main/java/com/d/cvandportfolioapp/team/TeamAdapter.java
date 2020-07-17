package com.d.cvandportfolioapp.team;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.d.cvandportfolioapp.R;

import java.util.List;

class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<TeamItem> mdata;

    public TeamAdapter(List<TeamItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.tvName.setText(mdata.get(position).getName());
        holder.tvDesc.setText(mdata.get(position).getDesc());
        holder.img.setImageResource(mdata.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDesc;
        ImageView img;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.team_item_name);
            tvDesc = itemView.findViewById(R.id.team_item_desc);
            img = itemView.findViewById(R.id.team_item_img);
        }
    }
}
