package fr.kvaternik.adrien.bookstore.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;

import butterknife.BindView;
import fr.kvaternik.adrien.bookstore.R;

/**
 * A refreshable activity.
 */
public abstract class RefreshableActivity extends BaseActivity {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    /**
     * Called when the user swipes to refresh.
     */
    protected abstract void onSwipeRefresh();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setup swipe refresh layout
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onSwipeRefresh();
            }
        });
    }

    /**
     * Shows the refresh indicator.
     */
    protected void showRefreshIndicator() {
        setRefreshIndicatorVisible(true);
    }

    /**
     * Hides the refresh indicator.
     */
    protected void hideRefreshIndicator() {
        setRefreshIndicatorVisible(false);
    }

    /**
     * Disables the refresh indicator.
     */
    protected void disableRefreshIndicator() {
        mSwipeRefreshLayout.setEnabled(false);
    }

    /**
     * Sets the visibility of the refresh indicator.
     * @param visible <code>true</code> if visible, <code>false</code> otherwise
     */
    private void setRefreshIndicatorVisible(final boolean visible) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(visible);
            }
        });
    }
}
