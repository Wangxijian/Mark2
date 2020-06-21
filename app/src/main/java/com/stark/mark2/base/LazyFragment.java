package com.stark.mark2.base;

import androidx.fragment.app.Fragment;

public abstract class LazyFragment extends Fragment {
    private boolean isLoaded = false;

    @Override
    public void onResume() {
        super.onResume();
        if (!isLoaded && !isHidden()) {
            init();
            isLoaded = true;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isLoaded = false;
    }

    public abstract void init();



}
