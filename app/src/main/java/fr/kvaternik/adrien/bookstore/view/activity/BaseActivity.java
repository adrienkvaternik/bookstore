package fr.kvaternik.adrien.bookstore.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * The base class for activities. All activities must extend from this class.
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * Provides the activity content view identifier.
     * @return The content view identifier.
     */
    protected abstract int getContentViewId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set content view
        setContentView(getContentViewId());
        // ButterKnife binding
        ButterKnife.bind(this);
    }
}
