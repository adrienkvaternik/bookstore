package fr.kvaternik.adrien.bookstore.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * The base class for fragments. All fragments must extend from this class.
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;

    /**
     * Used to bind views with ButterKnife.
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getViewId(), container, false);
        mUnbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * Used to unbind views with ButterKnife.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    /**
     * Provides the fragment view identifier.
     *
     * @return The view identifier.
     */
    public abstract int getViewId();
}
