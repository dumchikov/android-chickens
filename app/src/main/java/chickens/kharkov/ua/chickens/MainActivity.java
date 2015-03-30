package chickens.kharkov.ua.chickens;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.grumoon.pulllistview.PullListView;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        //StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Helpers.setActionBarTitle(this, getResources().getString(R.string.app_name));

        final PullListView pullListView = (PullListView) findViewById(R.id.listView);
        final PostAdapter adapter = new PostAdapter(this, new ArrayList<Chicken>());
        pullListView.setAdapter(adapter);

        pullListView.setOnRefreshListener(new PullListView.OnRefreshListener() {

            @Override
            public void onRefresh() {
                if (ChickensApi.isOnline(MainActivity.this)){
                    GetPostsAsyncTask task = new GetPostsAsyncTask(true, adapter, pullListView);
                    task.execute();
                }

            }
        });

        pullListView.setOnGetMoreListener(new PullListView.OnGetMoreListener() {

            @Override
            public void onGetMore() {
                if (ChickensApi.isOnline(MainActivity.this)){
                    GetPostsAsyncTask task = new GetPostsAsyncTask(false, adapter, pullListView);
                    task.execute();
                }
            }

        });

        pullListView.performRefresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
