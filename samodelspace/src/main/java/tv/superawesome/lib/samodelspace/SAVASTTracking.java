package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 22/12/15.
 */
public class SAVASTTracking implements Parcelable, JSONSerializable {

    public String event;
    public String url;

    public SAVASTTracking() {

    }

    public SAVASTTracking(JSONObject json) {
        readFromJson(json);
    }

    protected SAVASTTracking(Parcel in) {
        event = in.readString();
        url = in.readString();
    }

    public static final Creator<SAVASTTracking> CREATOR = new Creator<SAVASTTracking>() {
        @Override
        public SAVASTTracking createFromParcel(Parcel in) {
            return new SAVASTTracking(in);
        }

        @Override
        public SAVASTTracking[] newArray(int size) {
            return new SAVASTTracking[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(event);
        dest.writeString(url);
    }

    @Override
    public void readFromJson(JSONObject json){
        event = SAJsonParser.getString(json, "event");
        url = SAJsonParser.getString(json, "url");
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "event", event,
                "url", url
        });
    }
}
