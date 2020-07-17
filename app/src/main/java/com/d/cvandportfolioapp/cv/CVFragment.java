package com.d.cvandportfolioapp.cv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.d.cvandportfolioapp.R;

import java.util.ArrayList;
import java.util.List;

public class CVFragment extends Fragment {

    RecyclerView rvCV;
    CVAdapter adapter;
    List<CVItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvCV = view.findViewById(R.id.recyclerview_cv);

        items = new ArrayList<>();
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text)));
        items.add(new CVItem("20 May 2013", getString(R.string.lorem_text2)));
        items.add(new CVItem("20 July 2013", getString(R.string.lorem_text)));
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text2)));
        items.add(new CVItem("20 May 2013", getString(R.string.lorem_text)));
        items.add(new CVItem("20 April 2013", getString(R.string.lorem_text2)));

        adapter = new CVAdapter(items);

        rvCV.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCV.setAdapter(adapter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cv, container, false);

    }
}
