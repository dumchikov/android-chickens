package chickens.kharkov.ua.chickens;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Comment implements Serializable {
    public String Avatar;
    public String Link;
    public String Name;
    public String Text;
    public String Date;

    public Comment(JSONObject object){
        try {
            this.Avatar = object.getString("Avatar");
            this.Link = object.getString("Link");
            this.Name = object.getString("Name");
            this.Text = object.getString("Text");
            this.Date = object.getString("Date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Comment> fromJson(JSONArray jsonObjects) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                comments.add(new Comment(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return comments;
    }
}
