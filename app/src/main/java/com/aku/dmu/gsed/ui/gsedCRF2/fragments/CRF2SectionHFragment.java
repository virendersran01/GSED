package com.aku.dmu.gsed.ui.gsedCRF2.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.FragmentCrf2SectionHBinding;
import com.aku.dmu.gsed.ui.gsedCRF2.callbacks.Callbacks;

/**
 * A simple {@link Fragment} subclass.
 */
public class CRF2SectionHFragment extends Fragment {


    Callbacks callbacks;
    FragmentCrf2SectionHBinding bi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        bi = DataBindingUtil.inflate(inflater, R.layout.fragment_crf2_section_h, container, false);
        bi.setCallback(this);
        getActivity().setTitle(getString(R.string.crf2_sectionc));

        return bi.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        callbacks = (Callbacks) context;
    }

}
