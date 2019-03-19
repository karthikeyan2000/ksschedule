package in.skylifetech.ks;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {      //Fragment pager adapter.
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Day 1", "Day 2", "Day 3"};

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }       //Constructor.

    @Override
    public Fragment getItem(int position) {     //Gets the fragment for the given position.
        if (position == 0) {
            return new Day1();
        } else if (position == 1) {
            return new Day2();
        } else {
            return new Day3();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }       //Returns the total count.

    @Override
    public CharSequence getPageTitle(int position) {    //Returns the page title in order.
        return tabTitles[position];
    }
}
