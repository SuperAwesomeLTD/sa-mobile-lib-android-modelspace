package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

public class SACPIData implements Parcelable, JSONSerializable {

    private static final int CPI_DEF_VAL = -1;

    public int configuration = CPI_DEF_VAL;
    public int campaignId = CPI_DEF_VAL;
    public int lineItemId = CPI_DEF_VAL;
    public int creativeId = CPI_DEF_VAL;
    public int placementId = CPI_DEF_VAL;

    public SACPIData () {
        // do nothing
    }

    public SACPIData(JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    public SACPIData (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    protected SACPIData(Parcel in) {
        configuration = in.readInt();
        campaignId = in.readInt();
        lineItemId = in.readInt();
        creativeId = in.readInt();
        placementId = in.readInt();
    }

    @Override
    public boolean isValid() {
        return placementId > CPI_DEF_VAL &&
                campaignId > CPI_DEF_VAL &&
                lineItemId > CPI_DEF_VAL &&
                creativeId > CPI_DEF_VAL ;
    }

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
                "utm_source", configuration,
                "utm_term", campaignId,
                "utm_term", lineItemId,
                "utm_content", creativeId,
                "utm_medium", placementId
        });
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
        dest.writeInt(configuration);
        dest.writeInt(campaignId);
        dest.writeInt(lineItemId);
        dest.writeInt(creativeId);
        dest.writeInt(placementId);
    }

}
