package chickens.kharkov.ua.chickens;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidquery.AQuery;

import java.util.ArrayList;

public class CommentsAdapter  extends ArrayAdapter<Comment> {
    private Typeface typeface;

    public CommentsAdapter(Context context, ArrayList<Comment> items) {
        super(context, 0, items);
        typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.comment, parent, false);
        }

        final AQuery aq = new AQuery(convertView);
        TextView textTv = aq.id(R.id.commentText).text(comment.Text).getTextView();
        textTv.setTypeface(typeface);

        TextView titleTv = aq.id(R.id.commentTitle).text(comment.Name).getTextView();
        titleTv.setTypeface(typeface);

        TextView dateTv = aq.id(R.id.dateText).text(comment.Date).getTextView();
        dateTv.setTypeface(typeface);

        aq.id(R.id.commentImage).image(comment.Avatar, true, true);

        return convertView;
    }
}
