package com.stark.mark2.ui.party_affairs_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.stark.mark2.R;
import com.stark.mark2.adapter.base.FragmentLazyPagerAdapter;
import com.stark.mark2.bean.News;
import com.stark.mark2.databinding.ActivityPartyFeePaymentBinding;
import com.stark.mark2.ui.home.fragment.NewsFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.CurrentMonthPaymentFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.GroupFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.MemberFragment;
import com.stark.mark2.ui.party_affairs_management.fragment.PaymentHistoryFragment;
import com.stark.mark2.util.DAOUtils;

import java.util.ArrayList;

public class PartyFeePaymentActivity extends FragmentActivity {

    private ActivityPartyFeePaymentBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_party_fee_payment);
        initTab();
    }

    private void initTab() {

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new CurrentMonthPaymentFragment());
        fragments.add(new PaymentHistoryFragment());



        ArrayList<String> titles = new ArrayList<>();
        titles.add("本月缴费情况");
        titles.add("历史缴费情况");


        FragmentLazyPagerAdapter adapter = new FragmentLazyPagerAdapter(getSupportFragmentManager(), fragments, titles);
        mBinding.content.setAdapter(adapter);

        mBinding.tab.setupWithViewPager(mBinding.content);


    }
}
