package chickens.kharkov.ua.chickens;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class Chicken
{
    public String Id;
    public String Comments;
    public String Likes;
    public String Photo;

    public Chicken(JSONObject object){
        try {
            this.Id = object.getString("Id");
            this.Comments = object.getString("Comments");
            this.Likes  = object.getString("Likes");
            this.Photo = object.getString("Photo").isEmpty() ? "http://cs624328.vk.me/v624328628/22f68/TYR0HlChVuk.jpg" : object.getString("Photo");
        } catch (JSONException e) {
            e.printStackTrace();
}
    }

    public static ArrayList<Chicken> fromJson(JSONArray jsonObjects) {
        ArrayList<Chicken> chickens = new ArrayList<Chicken>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                chickens.add(new Chicken(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return chickens;
    }
}
