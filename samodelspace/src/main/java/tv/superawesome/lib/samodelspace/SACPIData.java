package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 15/07/16.
 */
public class SACPIData implements Parcelable, JSONSerializable {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int configuration;
    public int campaignId;
    public int lineItemId;
    public int creativeId;
    public int placementId;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public SACPIData () {
        initDefaults();
    }

    public SACPIData(JSONObject json) {
        initDefaults();
        readFromJson(json);
    }

    protected SACPIData(Parcel in) {
        configuration = in.readInt();
        campaignId = in.readInt();
        lineItemId = in.readInt();
        creativeId = in.readInt();
        placementId = in.readInt();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        configuration = 0;
        campaignId = 0;
        lineItemId = 0;
        creativeId = 0;
        placementId = 0;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // JSONSerializable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void readFromJson(JSONObject json) {
        configuration = SAJsonParser.getInt(json, "utm_source", configuration);
        campaignId = SAJsonParser.getInt(json, "utm_campaign", campaignId);
        lineItemId = SAJsonParser.getInt(json, "utm_term", lineItemId);
        creativeId = SAJsonParser.getInt(json, "utm_content", creativeId);
        placementId = SAJsonParser.getInt(json, "utm_medium", placementId);
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "configuration", configuration,
                "campaignId", campaignId,
                "lineItemId", lineItemId,
                "creativeId", creativeId,
                "placementId", placementId
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////


    public static final Creator<SACPIData> CREATOR = new Creator<SACPIData>() {
        @Override
        public SACPIData createFromParcel(Parcel in) {
            return new SACPIData(in);
        }

        @Override
        public SACPIData[] newArray(int size) {
            return new SACPIData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(configuration);
        dest.writeInt(campaignId);
        dest.writeInt(lineItemId);
        dest.writeInt(creativeId);
        dest.writeInt(placementId);
    }

}
