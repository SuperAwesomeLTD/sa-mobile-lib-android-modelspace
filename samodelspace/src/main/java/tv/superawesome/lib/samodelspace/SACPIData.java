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

    /**
     * Notes on fields:
     * advertiserId     = utm_source
     * campaignId       = utm_campaign
     * lineItemId       = utm_term
     * creativeId       = utm_content
     * placementId      = utm_medium
     */
    public int advertiserId;
    public int campaignId;
    public int lineItemId;
    public int creativeId;
    public int placementId;

    /**
     * Public json contructor
     * @param json json object
     * @throws JSONException
     */
    public SACPIData(JSONObject json) throws JSONException {
        readFromJson(json);
    }

    protected SACPIData(Parcel in) {
        advertiserId = in.readInt();
        campaignId = in.readInt();
        lineItemId = in.readInt();
        creativeId = in.readInt();
        placementId = in.readInt();
    }

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
        dest.writeInt(advertiserId);
        dest.writeInt(campaignId);
        dest.writeInt(lineItemId);
        dest.writeInt(creativeId);
        dest.writeInt(placementId);
    }

    @Override
    public void readFromJson(JSONObject json) {
        advertiserId = SAJsonParser.getInt(json, "utm_source");
        campaignId = SAJsonParser.getInt(json, "utm_campaign");
        lineItemId = SAJsonParser.getInt(json, "utm_term");
        creativeId = SAJsonParser.getInt(json, "utm_content");
        placementId = SAJsonParser.getInt(json, "utm_medium");
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "advertiserId", advertiserId,
                "campaignId", campaignId,
                "lineItemId", lineItemId,
                "creativeId", creativeId,
                "placementId", placementId
        });
    }
}
