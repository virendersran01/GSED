package com.aku.dmu.gsed.ui.gsedSF;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aku.dmu.gsed.R;
import com.aku.dmu.gsed.databinding.ActivityGsedSfBinding;
import com.aku.dmu.gsed.ui.gsedSF.adapter.SFViewPagerAdapter;
import com.aku.dmu.gsed.ui.gsedSF.callbacks.SFCallbacks;
import com.aku.dmu.gsed.ui.gsedSF.fragments.SFSectionAFragment;

public class GSEDSFActivity extends AppCompatActivity implements SFCallbacks {

    ActivityGsedSfBinding bi;
    boolean valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_gsed_sf);

        setupViewPager();



    }

    private void setupViewPager() {

        SFViewPagerAdapter adapter = new SFViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SFSectionAFragment(), "SECTION A");
        bi.viewpager.setAdapter(adapter);
        bi.tabs.setupWithViewPager(bi.viewpager);

    }

    @Override
    public void validateFragmentOne(boolean validated) {
        valid = validated;
    }
}
