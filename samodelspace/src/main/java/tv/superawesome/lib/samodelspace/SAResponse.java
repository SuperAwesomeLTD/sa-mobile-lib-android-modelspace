package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Created by gabriel.coman on 22/09/16.
 */
public class SAResponse implements Parcelable, JSONSerializable {

    public int status = 0;
    public List<SAAd> ads = new ArrayList<>();

    public SAResponse () {
        // normal constructor
    }

    public SAResponse (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    protected SAResponse(Parcel in) {
        status = in.readInt();
        ads = in.createTypedArrayList(SAAd.CREATOR);
    }

    public static final Creator<SAResponse> CREATOR = new Creator<SAResponse>() {
        @Override
        public SAResponse createFromParcel(Parcel in) {
            return new SAResponse(in);
        }

        @Override
        public SAResponse[] newArray(int size) {
            return new SAResponse[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(status);
        dest.writeTypedList(ads);
    }

    @Override
    public void readFromJson(JSONObject jsonObject) {
        status = SAJsonParser.getInt(jsonObject, "status");
        ads = SAJsonParser.getListFromJsonArray(jsonObject, "ads", new SAJsonToList<SAAd, JSONObject>() {
            @Override
            public SAAd traverseItem(JSONObject jsonObject) {
                return new SAAd(jsonObject);
            }
        });
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "status", status,
                "ads", SAJsonParser.getJsonArrayFromList(ads, new SAListToJson<JSONObject, SAAd>() {
                    @Override
                    public JSONObject traverseItem(SAAd saAd) {
                        return saAd.writeToJson();
                    }
                })
        });
    }

    @Override
    public boolean isValid() {
        return ads.size() >= 1;
    }
}
