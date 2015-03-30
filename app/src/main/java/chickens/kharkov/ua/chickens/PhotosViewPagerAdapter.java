package chickens.kharkov.ua.chickens;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PhotosViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> photos;

    public PhotosViewPagerAdapter(FragmentManager fm,  ArrayList<String> photos) {
        super(fm);

        this.photos = photos;
    }

    @Override
    public Fragment getItem(int index) {
        String photoUrl = (String)photos.toArray()[index];
        FullScreenPhotoFragment fr =  new FullScreenPhotoFragment();
        Bundle args = new Bundle();
        args.putString("photoUrl", photoUrl);
        fr.setArguments(args);
        return fr;
    }

    @Override
    public int getCount() {
       return photos.size();
    }
}


