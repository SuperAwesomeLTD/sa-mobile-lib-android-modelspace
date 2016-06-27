package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;

/**
 * Created by gabriel.coman on 19/04/16.
 */
public class SAData implements Parcelable, JSONSerializable {

    public String adHtml;
    public String imagePath;
    public SAVASTAd vastAd = null;

    public SAData(){
        /** standard constructor */
    }

    public SAData(JSONObject json) throws JSONException {
        readFromJson(json);
    }

    protected SAData(Parcel in) {
        adHtml = in.readString();
        imagePath = in.readString();
        vastAd = in.readParcelable(SAVASTAd.class.getClassLoader());
    }

    public static final Creator<SAData> CREATOR = new Creator<SAData>() {
        @Override
        public SAData createFromParcel(Parcel in) {
            return new SAData(in);
        }

        @Override
        public SAData[] newArray(int size) {
            return new SAData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(adHtml);
        dest.writeString(imagePath);
        dest.writeParcelable(vastAd, flags);
    }

    @Override
    public void readFromJson(JSONObject json) {
        if (!json.isNull("adHtml")) {
            adHtml = json.optString("adHtml");
        }
        if (!json.isNull("imagePath")) {
            imagePath = json.optString("imagePath");
        }
        if (!json.isNull("vastAd")) {
            JSONObject obj = json.optJSONObject("vastAd");
            try {
                vastAd = new SAVASTAd(obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public JSONObject writeToJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("adHtml", adHtml);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            json.put("imagePath", imagePath);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (vastAd != null) {
            try {
                json.put("vastAd", vastAd.writeToJson());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json;
    }
}
