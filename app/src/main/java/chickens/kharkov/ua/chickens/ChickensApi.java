package chickens.kharkov.ua.chickens;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by Max on 19.03.2015.
 */
public class ChickensApi {
    private static final String postsUrl = "http://ckns.apphb.com/home/getposts?skip=%d&take=%d";
    private static final String detailsUrl = "http://ckns.apphb.com/home/getdetails/%s";
    private static final String commentsUrl = "http://ckns.apphb.com/home/getcomments/%s";

    public static ArrayList<Chicken> GetPosts(int skip, int take){
        String url = String.format(postsUrl, skip,take);
        String json = getJsonString(url);
        ArrayList<Chicken> chickens = Chicken.fromJson(getJSONArray(json));
        return chickens;
    }

    public static ArrayList<Comment> GetComments(String id){
        String url = String.format(commentsUrl, id);
        String json = getJsonString(url);
        ArrayList<Comment> comments = Comment.fromJson(getJSONArray(json));
        return comments;
    }

    public static Details GetDetails(String id){
        String url = String.format(detailsUrl, id);
        String json = getJsonString(url);
        Details details = new Details(getJSONObject(json));
        return details;
    }

    public static JSONArray getJSONArray(String json) {
        try {
            JSONArray jObj = new JSONArray(json);
            return jObj;
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            return null;
        }
    }

    private static JSONObject getJSONObject(String json){
        try {
            JSONObject jObj = new JSONObject(json);
            return jObj;
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
            return null;
        }
    }

    private static String getJsonString(String url){
        InputStream is = null;
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            String json = sb.toString();
            return json;
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
            return "";
        }
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }

        AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
        builder1.setMessage("No internet connection.");
        builder1.setCancelable(true);
        AlertDialog alert11 = builder1.create();
        alert11.show();
        return false;
    }
}
