package chickens.kharkov.ua.chickens;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsViewPagerAdapter extends FragmentPagerAdapter {
    private String id;

    public TabsViewPagerAdapter(FragmentManager fm, String id) {
        super(fm);
        this.id = id;
    }

    @Override
    public Fragment getItem(int index) {

        Fragment f = null;

        switch (index) {
            case 0:
                f = new PostFragment();
                break;
            case 1:
                f = new CommentsFragment();
                break;
        }

        if (f != null){
            Bundle args = new Bundle();
            args.putSerializable("id", id);
            f.setArguments(args);
        }

        return f;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "история";
            case 1:
                return "комментарии";
        }

        return "";
    }
}

