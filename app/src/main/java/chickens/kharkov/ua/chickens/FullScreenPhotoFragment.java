package chickens.kharkov.ua.chickens;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidquery.AQuery;

public class FullScreenPhotoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_full_screen_photo, container, false);
        String url = getArguments().getString("photoUrl");
        final AQuery aq = new AQuery(view);
        aq.id(R.id.fullScreenPhotoIv).image(url, true, true);
        return view;
    }
}
