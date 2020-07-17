package com.d.cvandportfolioapp.portfolio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.d.cvandportfolioapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class PortfolioDetailFragment extends BottomSheetDialogFragment {

    private ImageView imgPortfolio;
    private TextView tvTitle, tvDesc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgPortfolio = view.findViewById(R.id.portfolio_detail_img);
        tvTitle = view.findViewById(R.id.portfolio_detail_title);
        tvDesc = view.findViewById(R.id.portfolio_detail_desc);

        Bundle bundle = getArguments();
        assert bundle != null;
        PortfolioItem item = (PortfolioItem) bundle.getSerializable("object");
        loadPortfolioData(item);
    }

    void loadPortfolioData(PortfolioItem item) {

    }
}