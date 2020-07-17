package com.d.cvandportfolioapp.team;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.d.cvandportfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class TeamFragment extends Fragment {

    RecyclerView rvTeam;
    TeamAdapter adapter;
    List<TeamItem> teams;

    public TeamFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvTeam = view.findViewById(R.id.rv_team);

        teams = new ArrayList<>();
        teams.add(new TeamItem("DMChinh 1", getString(R.string.lorem_text2), R.drawable.useillust));
        teams.add(new TeamItem("DMChinh 2", getString(R.string.lorem_text), R.drawable.user));
        teams.add(new TeamItem("DMChinh 3", getString(R.string.lorem_text2), R.drawable.uservoyager));
        teams.add(new TeamItem("DMChinh 4", getString(R.string.lorem_text), R.drawable.circul6));

        rvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamAdapter(teams);
        rvTeam.setAdapter(adapter);
    }
}