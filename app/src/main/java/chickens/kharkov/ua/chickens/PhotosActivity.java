package chickens.kharkov.ua.chickens;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class PhotosActivity extends ActionBarActivity {
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        Intent intent = getIntent();
        final ArrayList<String> photos = intent.getStringArrayListExtra("photos");
        Integer position = intent.getIntExtra("position", 0);

        pager = (ViewPager) findViewById(R.id.photosPager);
        pager.setAdapter(new PhotosViewPagerAdapter(getSupportFragmentManager(), photos));
        pager.setCurrentItem(position);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //set actionbar title
                Helpers.setActionBarTitle(
                        PhotosActivity.this,
                        String.format(PhotosActivity.this.getResources().getString(R.string.title_activity_photos), position + 1, photos.size()));
            }

            @Override
            public void onPageSelected(int position)
            {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_photos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
