package chickens.kharkov.ua.chickens;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.androidquery.AQuery;
import java.util.ArrayList;

/**
 * Created by Max on 22.03.2015.
 */
public class DetailsPhotosAdapter extends ArrayAdapter<String> {
    private ArrayList<String> photos;

    public DetailsPhotosAdapter(Context context, ArrayList<String> photos) {
        super(context, 0, photos);
        this.photos = photos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final String photo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_chicken_details_photo, parent, false);
        }

        AQuery aq = new AQuery(convertView);
        ImageView imageView = aq.id(R.id.imageView2).image(photo, true, true).getImageView();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PhotosActivity.class);
                intent.putExtra("photos", photos);
                intent.putExtra("position", photos.indexOf(photo));
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
