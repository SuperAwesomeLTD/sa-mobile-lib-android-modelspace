package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SATracking implements Parcelable, JSONSerializable {
    public String event;
    public String URL;

    protected SATracking(Parcel in) {
        event = in.readString();
        URL = in.readString();
    }

    public SATracking (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    public static final Creator<SATracking> CREATOR = new Creator<SATracking>() {
        @Override
        public SATracking createFromParcel(Parcel in) {
            return new SATracking(in);
        }

        @Override
        public SATracking[] newArray(int size) {
            return new SATracking[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(event);
        dest.writeString(URL);
    }

    @Override
    public void readFromJson(JSONObject jsonObject) {
        event = SAJsonParser.getString(jsonObject, "event");
        URL = SAJsonParser.getString(jsonObject, "URL");
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "event", event,
                "URL", URL
        });
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
