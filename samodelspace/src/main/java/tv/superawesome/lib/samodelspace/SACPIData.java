package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;

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
        if (!json.isNull("utm_source")){
            advertiserId = json.optInt("utm_source");
        }
        if (!json.isNull("utm_campaign")) {
            campaignId = json.optInt("utm_campaign");
        }
        if (!json.isNull("utm_term")) {
            lineItemId = json.optInt("utm_term");
        }
        if (!json.isNull("utm_content")) {
            creativeId = json.optInt("utm_content");
        }
        if (!json.isNull("utm_medium")) {
            placementId = json.optInt("utm_medium");
        }
    }

    @Override
    public JSONObject writeToJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("advertiserId", advertiserId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("campaignId", campaignId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("lineItemId", lineItemId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("creativeId", creativeId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("placementId", placementId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
