package xyz.mgj.quickreturn;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.etiennelawlor.quickreturn.library.enums.QuickReturnViewType;
import com.etiennelawlor.quickreturn.library.listeners.QuickReturnRecyclerViewOnScrollListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);

        // Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout
            = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);

        String quickText = getResources().getString(R.string.quick_and_nice);

        setSupportActionBar(toolbar);
        collapsingToolbarLayout.setTitle(quickText);

        // RecyclerView
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        ListAdapter adapter = new ListAdapter();
        recyclerView.setAdapter(adapter);

        //FAB listeners
        FloatingActionButton share = (FloatingActionButton) findViewById(R.id.share);
        share.setOnClickListener(v -> {
            Snackbar.make(coordinatorLayout, "Shared", Snackbar.LENGTH_SHORT).show();
        });

        FloatingActionButton like = (FloatingActionButton) findViewById(R.id.like);
        like.setOnClickListener(v -> {
            Snackbar.make(coordinatorLayout, "Liked", Snackbar.LENGTH_SHORT).show();
        });

        // FAB quick return
        int footerHeight = getResources().getDimensionPixelSize(R.dimen.footer_height);

        QuickReturnRecyclerViewOnScrollListener scrollListener = new QuickReturnRecyclerViewOnScrollListener.Builder(QuickReturnViewType.FOOTER)
            .footer(share)
            .minFooterTranslation(footerHeight)
            .isSnappable(true)
            .build();
        recyclerView.setOnScrollListener(scrollListener);
    }
}
