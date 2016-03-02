package com.example.sreeshav.prog02;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;
import android.view.Gravity;

public class RepresentativeAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;

    public RepresentativeAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;
    }

    /** A simple container for static data in each page */
    private static class Page {
        String repName;
        String partyName;
        int cardGravity = Gravity.CENTER;
        boolean expansionEnabled = false;
        float expansionFactor = 1.0f;
        int expansionDirection = CardFragment.EXPAND_DOWN;

        public Page(String rep, String party) {
            this.repName = rep;
            this.partyName = party;
        }
    }

    private final Page[][] PAGES = {
            {
                    new Page("Rep. Barbara Lee","Party: Democrat"),
            },
            {
                    new Page("Sen. Barbara Boxer","Party: Democrat"),
            },
            {
                    new Page("Sen. Dianne Feinstein","Party: Democrat"),
            },

    };


    @Override
    public Fragment getFragment(int row, int col) {
        Page page = PAGES[row][col];
        String rep = page.repName;
        String party = page.partyName;
        CardFragment fragment = CardFragment.create(rep, party);
        // Advanced settings
        fragment.setCardGravity(page.cardGravity);
        fragment.setExpansionEnabled(page.expansionEnabled);
        fragment.setExpansionDirection(page.expansionDirection);
        fragment.setExpansionFactor(page.expansionFactor);
        return fragment;
    }

    @Override
    public Drawable getBackgroundForRow(int row) {
        return GridPagerAdapter.BACKGROUND_NONE;
    }

    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }
}
