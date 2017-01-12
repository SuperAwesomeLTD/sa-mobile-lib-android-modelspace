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
 * Main class that contains all the information needed to play an ad and send all relevant
 * events back to our ad server.
 *  - error (not really used)
 *  - advertiser, publisher, app, line item, campaign, placement IDs
 *  - campaign type (CPM or CPI)
 *  - moat - a float value that tells the SDK when to fire Moat tracking (if available); This value
 *    is compared to a randomly generated int between 0 and 1; if the int is less than the moat
 *    value, then the whole additional tracking happens
 *  - test, is fallback, is fill, is house, safe ad approved, show padlock - flags that determine
 *    whether the SDK should show the "Safe Ad Padlock" over an ad or not
 *  - device
 *  - isVast, vast type, vast redirect - indicate whether an ad is of vast type and  adds other
 *    vast info
 *  - a SACreative object
 */
public class SAAd extends SABaseObject implements Parcelable {

    // member variables
    public int error = 0;
    public int advertiserId = 0;
    public int publisherId = 0;
    public int app = 0;
    public int lineItemId = 0;
    public int campaignId = 0;
    public int placementId = 0;
    public int campaignType = SACampaignType.CPM.ordinal();
    public SACampaignType saCampaignType = SACampaignType.fromValue(campaignType);
    public double moat = 0.2;
    public boolean test = false;
    public boolean isFallback = false;
    public boolean isFill = false;
    public boolean isHouse = false;
    public boolean safeAdApproved = false;
    public boolean showPadlock = false;
    public String device = null;
    public SACreative creative = new SACreative();

    /**
     * Basic constructor
     */
    public SAAd () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SAAd (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SAAd (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SAAd(Parcel in) {
        error = in.readInt();
        advertiserId = in.readInt();
        publisherId = in.readInt();
        app = in.readInt();
        lineItemId = in.readInt();
        campaignId = in.readInt();
        placementId = in.readInt();
        campaignType = in.readInt();
        moat = in.readDouble();
        saCampaignType = in.readParcelable(SACampaignType.class.getClassLoader());
        test = in.readByte() != 0;
        isFallback = in.readByte() != 0;
        isFill = in.readByte() != 0;
        isHouse = in.readByte() != 0;
        safeAdApproved = in.readByte() != 0;
        showPadlock = in.readByte() != 0;
        device = in.readString();
        creative = in.readParcelable(SACreative.class.getClassLoader());
    }

    /**
     * Overridden SAJsonSerializable method that describes the conditions for model validity
     *
     * @return true or false
     */
    @Override
    public boolean isValid() {

        if (creative == null)  return false;
        if (creative.creativeFormat == SACreativeFormat.invalid) return false;
        if (creative.details == null) return false;

        switch (creative.creativeFormat) {
            case image:{ if (creative.details.image == null) return false; break; }
            case video:{ if (creative.details.vast == null)  return false; break; }
            case rich:{ if (creative.details.url == null)  return false; break; }
            case tag:{ if (creative.details.tag == null)  return false; break; }
            default:{ break; }
        }

        return true;
    }

    /**
     * Overridden SAJsonSerializable method that describes how a JSON object maps to a Java model
     *
     * @param jsonObject a valid JSONObject
     */
    @Override
    public void readFromJson(JSONObject jsonObject) {

        error = SAJsonParser.getInt(jsonObject, "error", error);
        advertiserId = SAJsonParser.getInt(jsonObject, "advertiserId", advertiserId);
        publisherId = SAJsonParser.getInt(jsonObject, "publisherId", publisherId);
        app = SAJsonParser.getInt(jsonObject, "app", app);

        int val1 = SAJsonParser.getInt(jsonObject, "moat", (int) moat * 100);
        double val2 = SAJsonParser.getDouble(jsonObject, "moat", moat);
        moat = Math.max(val2, (double) val1);
        moat = moat > 1 ? 1 : moat;

        lineItemId = SAJsonParser.getInt(jsonObject, "line_item_id", lineItemId);
        campaignId = SAJsonParser.getInt(jsonObject, "campaign_id", campaignId);
        placementId = SAJsonParser.getInt(jsonObject, "placementId", placementId);
        campaignType = SAJsonParser.getInt(jsonObject, "campaign_type", campaignType);
        saCampaignType = SACampaignType.fromValue(campaignType);
        test = SAJsonParser.getBoolean(jsonObject, "test", test);
        isFallback = SAJsonParser.getBoolean(jsonObject, "is_fallback", isFallback);
        isFill = SAJsonParser.getBoolean(jsonObject, "is_fill", isFill);
        isHouse = SAJsonParser.getBoolean(jsonObject, "is_house", isHouse);
        safeAdApproved = SAJsonParser.getBoolean(jsonObject, "safe_ad_approved", safeAdApproved);
        showPadlock = SAJsonParser.getBoolean(jsonObject, "show_padlock", showPadlock);
        device = SAJsonParser.getString(jsonObject, "device", device);

        JSONObject creativeJson = SAJsonParser.getJsonObject(jsonObject, "creative", new JSONObject());
        creative = new SACreative(creativeJson);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "error", error,
                "advertiserId", advertiserId,
                "publisherId", publisherId,
                "app", app,
                "moat", moat,
                "line_item_id", lineItemId,
                "campaign_id", campaignId,
                "placementId", placementId,
                "campaign_type", campaignType,
                "test", test,
                "is_fallback", isFallback,
                "is_fill", isFill,
                "is_house", isHouse,
                "safe_ad_approved", safeAdApproved,
                "show_padlock", showPadlock,
                "creative", creative.writeToJson(),
                "device", device
        });
    }

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SAAd> CREATOR = new Creator<SAAd>() {
        @Override
        public SAAd createFromParcel(Parcel in) {
            return new SAAd(in);
        }

        @Override
        public SAAd[] newArray(int size) {
            return new SAAd[size];
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
        dest.writeInt(error);
        dest.writeInt(advertiserId);
        dest.writeInt(publisherId);
        dest.writeInt(app);
        dest.writeInt(lineItemId);
        dest.writeInt(campaignId);
        dest.writeInt(placementId);
        dest.writeInt(campaignType);
        dest.writeDouble(moat);
        dest.writeParcelable(saCampaignType, flags);
        dest.writeByte((byte) (test ? 1 : 0));
        dest.writeByte((byte) (isFallback ? 1 : 0));
        dest.writeByte((byte) (isFill ? 1 : 0));
        dest.writeByte((byte) (isHouse ? 1 : 0));
        dest.writeByte((byte) (safeAdApproved ? 1 : 0));
        dest.writeByte((byte) (showPadlock ? 1 : 0));
        dest.writeString(device);
        dest.writeParcelable(creative, flags);
    }
}
