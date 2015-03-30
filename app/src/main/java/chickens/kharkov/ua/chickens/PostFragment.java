package chickens.kharkov.ua.chickens;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PostFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final String id = getArguments().getString("id");
        final View view = inflater.inflate(R.layout.fragment_post, container, false);

        final ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.detailsPgb);
        final TextView txv = new TextView(view.getContext());
        txv.setTextColor(view.getResources().getColor(R.color.commentText));
        txv.setPadding(16,16,16,16);
        txv.setTextSize(15);
        txv.setTypeface(Helpers.getTypeface(view.getContext(),"Roboto-Regular.ttf"));

        final GridViewWithHeaderAndFooter gridView = (GridViewWithHeaderAndFooter) view.findViewById(R.id.gridView);
        View footerView = new View(view.getContext());
        footerView.setMinimumHeight(16);
        gridView.addFooterView(footerView);

        final GetDetailsAsyncTask task = new GetDetailsAsyncTask(){
            @Override
            protected void onPostExecute(Details data) {
                txv.setText(data.Text);
                gridView.addHeaderView(txv);
                gridView.setAdapter(new DetailsPhotosAdapter(gridView.getContext(), data.Photos));
                progressBar.setVisibility(View.GONE);
            }
        };
        task.execute(id);
        return view;
    }
}
