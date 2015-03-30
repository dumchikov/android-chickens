package chickens.kharkov.ua.chickens;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.grumoon.pulllistview.PullListView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CommentsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final String id = getArguments().getString("id");
        final View view = inflater.inflate(R.layout.fragment_comments, container, false);
        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.commentsPgb);
        final ListView pullListView = (ListView) view.findViewById(R.id.commentsListView);

        GetCommentsAsyncTask task = new GetCommentsAsyncTask(){
            @Override
            protected void onPostExecute(ArrayList<Comment> data) {
                pullListView.setAdapter(new CommentsAdapter(view.getContext(), data));
                progressBar.setVisibility(View.GONE);
            }
        };

        task.execute(id);
        return view;
    }
}
