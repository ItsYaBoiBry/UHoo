package hoo.u.magazine.u_hooprototype;

/**
 * Created by bryan on 16/1/2018.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class AdapterPager extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public AdapterPager(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FragmentMedicalGP tabGP = new FragmentMedicalGP();
                return tabGP;
            case 1:
                FragmentMedicalSP tabSP = new FragmentMedicalSP();
                return tabSP;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}