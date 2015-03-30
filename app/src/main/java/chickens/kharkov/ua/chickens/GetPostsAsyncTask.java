package chickens.kharkov.ua.chickens;
import android.os.AsyncTask;
import com.grumoon.pulllistview.PullListView;

import java.util.ArrayList;

public class GetPostsAsyncTask extends AsyncTask<Void, Integer, ArrayList<Chicken>> {
    private Boolean isRefresh;
    private PostAdapter postAdapter;
    private PullListView pullListView;

    public GetPostsAsyncTask(Boolean isRefresh, PostAdapter postAdapter, PullListView pullListView){
        this.isRefresh = isRefresh;
        this.postAdapter = postAdapter;
        this.pullListView = pullListView;
    }

    @Override
    protected ArrayList<Chicken> doInBackground(Void... params) {
        ArrayList<Chicken> chickens = ChickensApi.GetPosts(isRefresh ? 0 : postAdapter.getCount(), 10);
        return chickens;
    }

    @Override
    protected void onPostExecute(ArrayList<Chicken> result) {
        if (isRefresh){
            postAdapter.clear();
            postAdapter.addAll(result);
            pullListView.refreshComplete();
        }
        else{
            postAdapter.addAll(result);
            pullListView.getMoreComplete();
            if(result.isEmpty()){
                pullListView.setNoMore();
            }
        }
    }
}
