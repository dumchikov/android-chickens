package chickens.kharkov.ua.chickens;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.astuetz.PagerSlidingTabStrip;


public class DetailsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Helpers.setActionBarTitle(this, getResources().getString(R.string.title_activity_details));

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        // Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new TabsViewPagerAdapter(getSupportFragmentManager(), id));

        // Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setShouldExpand(true);
        tabs.setViewPager(pager);
        tabs.setTextSize(20);
        Helpers.setTypeFace(tabs, "Roboto-Bold.ttf", Typeface.NORMAL);
    }
}
