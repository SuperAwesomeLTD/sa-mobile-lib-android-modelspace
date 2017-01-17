/**
 * @Copyright:   SuperAwesome Trading Limited 2017
 * @Author:      Gabriel Coman (gabriel.coman@superawesome.tv)
 */
package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.SABaseObject;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Class that contains information for data usually needed by the CPI process.
 * It's used when the Google Play Store sends additional information when installing
 * an app through our campaign system, such as:
 *  - the campaign, line item (sub-campaign), creative and placement IDs that generated the
 *    current install
 *  - the configuration (staging or production) where the install generated
 *
 */
public class SAReferralData extends SABaseObject implements Parcelable {

    // constants
    private static final int CPI_DEF_VAL = -1;

    // member variables
    public int configuration = CPI_DEF_VAL;
    public int campaignId    = CPI_DEF_VAL;
    public int lineItemId    = CPI_DEF_VAL;
    public int creativeId    = CPI_DEF_VAL;
    public int placementId   = CPI_DEF_VAL;

    /**
     * Basic constructor
     */
    public SAReferralData() {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SAReferralData(String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SAReferralData(JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SAReferralData(Parcel in) {
        configuration = in.readInt();
        campaignId = in.readInt();
        lineItemId = in.readInt();
        creativeId = in.readInt();
        placementId = in.readInt();
    }

    /**
     * Overridden SAJsonSerializable method that describes the conditions for model validity
     *
     * @return true or false whether
     */
    @Override
    public boolean isValid() {
        return placementId > CPI_DEF_VAL &&
                campaignId > CPI_DEF_VAL &&
                lineItemId > CPI_DEF_VAL &&
                creativeId > CPI_DEF_VAL ;
    }

    /**
     * Overridden SAJsonSerializable method that describes how a JSON object maps to a Java model
     *
     * @param jsonObject a valid JSONObject
     */
    @Override
    public void readFromJson(JSONObject jsonObject) {
        configuration = SAJsonParser.getInt(jsonObject, "utm_source", configuration);
        campaignId = SAJsonParser.getInt(jsonObject, "utm_campaign", campaignId);
        lineItemId = SAJsonParser.getInt(jsonObject, "utm_term", lineItemId);
        creativeId = SAJsonParser.getInt(jsonObject, "utm_content", creativeId);
        placementId = SAJsonParser.getInt(jsonObject, "utm_medium", placementId);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
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

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SAReferralData> CREATOR = new Creator<SAReferralData>() {
        @Override
        public SAReferralData createFromParcel(Parcel in) {
            return new SAReferralData(in);
        }

        @Override
        public SAReferralData[] newArray(int size) {
            return new SAReferralData[size];
        }
    };

    /**
     * Method needed for Parcelable implementation
     *
     * @return always 0
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Method needed for Parcelable implementation
     *
     * @param dest  destination parcel
     * @param flags special flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(configuration);
        dest.writeInt(campaignId);
        dest.writeInt(lineItemId);
        dest.writeInt(creativeId);
        dest.writeInt(placementId);
    }

}
