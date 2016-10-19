package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int placementId = 0;
    public SACreativeFormat format = SACreativeFormat.invalid;
    public int status = 0;
    public List<SAAd> ads = new ArrayList<>();

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public SAResponse () {
        initDefaults();
    }

    public SAResponse (JSONObject jsonObject) {
        initDefaults();
        readFromJson(jsonObject);
    }

    protected SAResponse(Parcel in) {
        status = in.readInt();
        ads = in.createTypedArrayList(SAAd.CREATOR);
        placementId = in.readInt();
        format = in.readParcelable(SACreativeFormat.class.getClassLoader());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        placementId = 0;
        status = 0;
        format = SACreativeFormat.invalid;
        ads = new ArrayList<>();
    }

    @Override
    public boolean isValid() {
        return ads.size() >= 1;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // JSONSerializable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void readFromJson(JSONObject json) {
        status = SAJsonParser.getInt(json, "status", status);
        placementId = SAJsonParser.getInt(json, "placementId", placementId);

        JSONArray adsArray = SAJsonParser.getJsonArray(json, "ads", new JSONArray());
        ads = SAJsonParser.getListFromJsonArray(adsArray, new SAJsonToList<SAAd, JSONObject>() {
            @Override
            public SAAd traverseItem(JSONObject jsonObject) {
                return new SAAd(jsonObject);
            }
        });

        int icreativeFormat = SAJsonParser.getInt(json, "format", 0);
        switch (icreativeFormat) {
            case 1: format = SACreativeFormat.image; break;
            case 2: format = SACreativeFormat.video; break;
            case 3: format = SACreativeFormat.rich; break;
            case 4: format = SACreativeFormat.tag; break;
            case 5: format = SACreativeFormat.gamewall; break;
            default: format = SACreativeFormat.invalid; break;
        }
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "status", status,
                "placementId", placementId,
                "format", format.ordinal(),
                "ads", SAJsonParser.getJsonArrayFromList(ads, new SAListToJson<JSONObject, SAAd>() {
                            @Override
                            public JSONObject traverseItem(SAAd saAd) {
                                return saAd.writeToJson();
                            }
                        })
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

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
        dest.writeInt(placementId);
        dest.writeTypedList(ads);
        dest.writeParcelable(format, flags);
    }
}
