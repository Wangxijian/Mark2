package com.stark.mark2.ui;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.stark.mark2.R;
import com.stark.mark2.databinding.ActivityMainBinding;
import com.stark.mark2.ui.home.HomeFragment;
import com.stark.mark2.ui.party_affairs_management.PartyAffairsManagementFragment;
import com.stark.mark2.ui.party_building.PartyBuildingFragment;
import com.stark.mark2.ui.study.StudyFragment;
import com.stark.mark2.ui.user.UserFragment;
import com.stark.mark2.util.FragmentUtils;
import com.stark.mark2.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {


    private String[] mTitles = {"首页", "矩衡党建", "专题学习", "党务管理", "我的"};
    private int[] mIconUnSelectIds = {
            R.mipmap.home_unselected, R.mipmap.party_building_unselected,
            R.mipmap.study_unselected, R.mipmap.management_unselected,
            R.mipmap.user_unselected};
    private int[] mIconSelectIds = {
            R.mipmap.home_selected, R.mipmap.party_building_selected,
            R.mipmap.study_selected, R.mipmap.management_selected,
            R.mipmap.user_selected};


    HomeFragment homeFragment;
    PartyBuildingFragment partyBuildingFragment;
    StudyFragment studyFragment;
    PartyAffairsManagementFragment partyAffairsManagementFragment;
    UserFragment userFragment;

    FragmentManager manager;
    List<Fragment> list;

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        homeFragment = new HomeFragment();
        partyBuildingFragment = new PartyBuildingFragment();
        studyFragment = new StudyFragment();
        partyAffairsManagementFragment = new PartyAffairsManagementFragment();
        userFragment = new UserFragment();
        list= new ArrayList<>();
        list.add(homeFragment);
        list.add(partyBuildingFragment);
        list.add(studyFragment);
        list.add(partyAffairsManagementFragment);
        list.add(userFragment);
        manager = getSupportFragmentManager();

        mBinding.tabHome.setOnClickListener(v -> select(0));
        mBinding.tabPartyBuilding.setOnClickListener(v -> select(1));
        mBinding.tabStudy.setOnClickListener(v -> select(2));
        mBinding.tabManagement.setOnClickListener(v -> select(3));
        mBinding.tabUser.setOnClickListener(v -> select(4));


        initTab();
    }

    private void initTab(){
        changeTab(0);
        FragmentUtils.loadFragmentsTransaction(R.id.main,0,manager,list);
    }

    private void clearTab() {
        mBinding.textHome.setTextColor(Utils.getColor(this, R.color.black));
        mBinding.textPartyBuilding.setTextColor(Utils.getColor(this, R.color.black));
        mBinding.textStudy.setTextColor(Utils.getColor(this, R.color.black));
        mBinding.textManagement.setTextColor(Utils.getColor(this, R.color.black));
        mBinding.textUser.setTextColor(Utils.getColor(this, R.color.black));

        mBinding.imgHome.setImageResource(R.mipmap.home_unselected);
        mBinding.imgPartyBuilding.setImageResource(R.mipmap.party_building_unselected);
        mBinding.imgStudy.setImageResource(R.mipmap.study_unselected);
        mBinding.imgManagement.setImageResource(R.mipmap.management_unselected);
        mBinding.imgUser.setImageResource(R.mipmap.user_unselected);
    }

    public void select(int index) {
        clearTab();
        changeTab(index);
        switch (index) {
            case 0:
                FragmentUtils.showHideFragmentTransaction(manager, homeFragment);
                break;
            case 1:
                FragmentUtils.showHideFragmentTransaction(manager, partyBuildingFragment);
                break;
            case 2:
                FragmentUtils.showHideFragmentTransaction(manager, studyFragment);
                break;
            case 3:
                FragmentUtils.showHideFragmentTransaction(manager, partyAffairsManagementFragment);
                break;
            case 4:
                FragmentUtils.showHideFragmentTransaction(manager, userFragment);
                break;
        }
    }

    public void changeTab(int index){
        switch (index){
            case 0:
                mBinding.textHome.setTextColor(Utils.getColor(this, R.color.colorPrimary));
                mBinding.imgHome.setImageResource(R.mipmap.home_selected);
                break;
            case 1:
                mBinding.textPartyBuilding.setTextColor(Utils.getColor(this, R.color.colorPrimary));
                mBinding.imgPartyBuilding.setImageResource(R.mipmap.party_building_selected);
                break;
            case 2:
                mBinding.textStudy.setTextColor(Utils.getColor(this, R.color.colorPrimary));
                mBinding.imgStudy.setImageResource(R.mipmap.study_selected);
                break;
            case 3:
                mBinding.textManagement.setTextColor(Utils.getColor(this, R.color.colorPrimary));
                mBinding.imgManagement.setImageResource(R.mipmap.management_selected);
                break;
            case 4:
                mBinding.textUser.setTextColor(Utils.getColor(this, R.color.colorPrimary));
                mBinding.imgUser.setImageResource(R.mipmap.user_selected);
                break;
        }
    }


}
