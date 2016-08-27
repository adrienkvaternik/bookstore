package fr.kvaternik.adrien.bookstore.view.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.kvaternik.adrien.bookstore.R;
import fr.kvaternik.adrien.bookstore.view.fragment.BaseFragment;
import fr.kvaternik.adrien.bookstore.view.fragment.BookListFragment;

/**
 * The book activity.
 */
public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // set the book list fragment
        replaceFragment(new BookListFragment());
    }

    /**
     * Replace the fragment in the back stack.
     *
     * @param fragment the replacing fragment.
     */
    private void replaceFragment(@NonNull BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
