package com.d.cvandportfolioapp.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d.cvandportfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class PortfolioFragment extends Fragment implements PortfolioCallback{

    RecyclerView rvPortfolio;
    PortfolioAdapter adapter;
    List<PortfolioItem> mdata;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvPortfolio = view.findViewById(R.id.rv_portfolio);

        mdata = new ArrayList<>();
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());
        mdata.add(new PortfolioItem());

        adapter = new PortfolioAdapter(mdata, this);

        rvPortfolio.setLayoutManager(new GridLayoutManager(getContext(), 3));
        rvPortfolio.setAdapter(adapter);
    }

    @Override
    public void onPortfolioItemClick(int pos) {
        PortfolioDetailFragment portfolioDetailFragment = new PortfolioDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioDetailFragment.setArguments(bundle);

        portfolioDetailFragment.show(getActivity().getSupportFragmentManager(), "tagname");
    }
}