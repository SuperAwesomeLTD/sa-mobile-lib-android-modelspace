package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

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

    public SAData(JSONObject json) {
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
        adHtml = SAJsonParser.getString(json, "adHtml");
        imagePath = SAJsonParser.getString(json, "imagePath");
        vastAd = new SAVASTAd(SAJsonParser.getJsonObject(json, "vastAd"));
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "adHtml", adHtml,
                "imagePath", imagePath,
                "vastAd", vastAd != null ? vastAd.writeToJson() : null
        });
    }
}
