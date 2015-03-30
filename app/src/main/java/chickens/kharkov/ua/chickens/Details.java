package chickens.kharkov.ua.chickens;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Max on 19.03.2015.
 */
public class Details implements Serializable {

    public Details(JSONObject object){
        try {
            this.Text = object.getString("Text");
            this.Photos = new ArrayList<String>();
            JSONArray photos = ChickensApi.getJSONArray(object.getString("Photos"));
            for (int i = 0; i < photos.length(); i++) {
                this.Photos.add(photos.getString(i));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String Text;
    public ArrayList<String> Photos;
}
