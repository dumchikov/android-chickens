package chickens.kharkov.ua.chickens;
import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;

public class PostAdapter extends ArrayAdapter<Chicken> {
    private Typeface typeface;

    public PostAdapter(Context context, ArrayList<Chicken> chickens) {
        super(context, 0, chickens);
        typeface = Helpers.getTypeface(context,"roboto-light.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Chicken chicken = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.chicken_item, parent, false);
        }

        final AQuery aq = new AQuery(convertView);
        aq.id(R.id.imageView).image(chicken.Photo, true, true);
        TextView likesTv = aq.id(R.id.likes).text(String.valueOf(chicken.Likes)).getTextView();
        TextView commentsTv = aq.id(R.id.comments).text(String.valueOf(chicken.Comments)).getTextView();
        commentsTv.setTypeface(typeface);
        likesTv.setTypeface(typeface);

        aq.id(R.id.moreImg).clicked(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("id", chicken.Id);
                getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}