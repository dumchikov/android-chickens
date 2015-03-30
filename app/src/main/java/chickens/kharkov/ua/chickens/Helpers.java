package chickens.kharkov.ua.chickens;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import java.util.HashMap;
import java.util.Map;

public class Helpers {

    public static void setActionBarTitle(Context context, String title){
        SpannableString s = new SpannableString(title);
        s.setSpan(new TypefaceSpan(context, "LOBSTER.TTF"), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        android.support.v7.app.ActionBar actionBar = ((ActionBarActivity)context).getSupportActionBar();
        actionBar.setTitle(s);
    }

    public static Typeface getTypeface(Context ctx, String font){
        Typeface typeface = Typeface.createFromAsset(ctx.getAssets(), String.format("fonts/%s", font));
        return typeface;
    }

    public static void setTypeFace(PagerSlidingTabStrip view, String font, int style){
        Typeface typeface = Typeface.createFromAsset(view.getContext().getAssets(), String.format("fonts/%s", font));
        view.setTypeface(typeface, style);
    }
}
