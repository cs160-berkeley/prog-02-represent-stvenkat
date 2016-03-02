package com.example.sreeshav.prog02;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.view.WindowInsets;
import android.widget.TextView;

/**
 * Created by sreeshav on 3/1/16.
 */
public class RepresentativeIntent extends Activity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        final Resources res = getResources();
        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                final boolean round = insets.isRound();
//                int rowMargin = res.getDimensionPixelOffset(R.dimen.page_row_margin);
//                int colMargin = res.getDimensionPixelOffset(round ?
//                        R.dimen.page_column_margin_round : R.dimen.page_column_margin);
//                pager.setPageMargins(rowMargin, colMargin);
                return insets;
            }
        });
        pager.setAdapter(new RepresentativeAdapter(this, getFragmentManager()));
    }
}
