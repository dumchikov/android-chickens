package chickens.kharkov.ua.chickens;
import android.os.AsyncTask;

import java.util.ArrayList;

public class GetCommentsAsyncTask extends AsyncTask<String, Void, ArrayList<Comment>> {

    @Override
    protected ArrayList<Comment> doInBackground(String... params) {
        ArrayList<Comment> data = ChickensApi.GetComments(params[0]);
        return data;
    }
}