package com.stark.mark2.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;

import java.util.List;

public class FragmentUtils {

    public static void loadFragmentsTransaction(int viewID, int position, FragmentManager manager, List<Fragment> fragments) {
        FragmentTransaction transaction = manager.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {
            Fragment fragment = fragments.get(i);
            transaction.add(viewID, fragment, fragment.getClass().getName());
            if (position == i) {
                transaction.setMaxLifecycle(fragment, Lifecycle.State.RESUMED);
            } else {
                transaction.hide(fragment);
                transaction.setMaxLifecycle(fragment, Lifecycle.State.STARTED);
            }
        }
        transaction.commit();
    }

    public static void showHideFragmentTransaction(FragmentManager fragmentManager, Fragment showFragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        List<Fragment> fragments = fragmentManager.getFragments();

        for (Fragment f : fragments) {
            transaction.hide(f);
            transaction.setMaxLifecycle(f, Lifecycle.State.STARTED);
        }

        transaction.show(showFragment);
        transaction.setMaxLifecycle(showFragment, Lifecycle.State.RESUMED);

        transaction.commit();
    }

}
