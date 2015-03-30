package chickens.kharkov.ua.chickens;
import android.os.AsyncTask;

public class GetDetailsAsyncTask extends AsyncTask<String, Void, Details> {

    @Override
    protected Details doInBackground(String... params) {
        Details data = ChickensApi.GetDetails(params[0]);
        return data;
    }
}
