/**
 * @class: SAAd.java
 * @copyright: (c) 2015 SuperAwesome Ltd. All rights reserved.
 * @author: Gabriel Coman
 * @date: 28/09/2015
 *
 */
package tv.superawesome.lib.samodelspace;

/**
 * Imports needed for this class
 */
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayDeque;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * This model class contains all information that is received from the server
 * when an Ad is requested, as well as some aux fields that will be generated
 * by the SDK
 */
public class SAAd implements Parcelable, JSONSerializable {

    public int error;
    public int advertiserId;
    public int publisherId;
    public int app;
    public int placementId;
    public int lineItemId;
    public int campaignId;
    public int campaignType;
    public SACampaignType saCampaignType;
    public boolean test;
    public boolean isFallback;
    public boolean isFill;
    public boolean isHouse;
    public boolean safeAdApproved;
    public boolean showPadlock;
    public SACreative creative;

    /**
     * public constructor
     */
    public SAAd() {
        /** do nothing */
    }

    public SAAd(JSONObject json) {
        readFromJson(json);
    }

    protected SAAd(Parcel in) {
        error = in.readInt();
        advertiserId = in.readInt();
        publisherId = in.readInt();
        app = in.readInt();
        placementId = in.readInt();
        lineItemId = in.readInt();
        campaignId = in.readInt();
        campaignType = in.readInt();
        test = in.readByte() != 0;
        isFallback = in.readByte() != 0;
        isFill = in.readByte() != 0;
        isHouse = in.readByte() != 0;
        safeAdApproved = in.readByte() != 0;
        showPadlock = in.readByte() != 0;
        saCampaignType = in.readParcelable(SACampaignType.class.getClassLoader());
        creative = in.readParcelable(SACreative.class.getClassLoader());
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(error);
        dest.writeInt(advertiserId);
        dest.writeInt(publisherId);
        dest.writeInt(app);
        dest.writeInt(placementId);
        dest.writeInt(lineItemId);
        dest.writeInt(campaignId);
        dest.writeInt(campaignType);
        dest.writeParcelable(saCampaignType, flags);
        dest.writeByte((byte) (test ? 1 : 0));
        dest.writeByte((byte) (isFallback ? 1 : 0));
        dest.writeByte((byte) (isFill ? 1 : 0));
        dest.writeByte((byte) (isHouse ? 1 : 0));
        dest.writeByte((byte) (safeAdApproved ? 1 : 0));
        dest.writeByte((byte) (showPadlock ? 1 : 0));
        dest.writeParcelable(creative, flags);
    }

    @Override
    public void readFromJson(JSONObject json) {
        error = SAJsonParser.getInt(json, "error");
        advertiserId = SAJsonParser.getInt(json, "advertiserId");
        publisherId = SAJsonParser.getInt(json, "publisherId");
        app = SAJsonParser.getInt(json, "app");
        placementId = SAJsonParser.getInt(json, "placementId");
        lineItemId = SAJsonParser.getInt(json, "line_item_id");
        campaignId = SAJsonParser.getInt(json, "campaign_id");
        campaignType = SAJsonParser.getInt(json, "campaign_type");
        test = SAJsonParser.getBoolean(json, "test");
        isFallback = SAJsonParser.getBoolean(json, "is_fallback");
        isFill = SAJsonParser.getBoolean(json, "is_fill");
        isHouse = SAJsonParser.getBoolean(json, "is_house");
        safeAdApproved = SAJsonParser.getBoolean(json, "safe_ad_approved");
        showPadlock = SAJsonParser.getBoolean(json, "show_padlock");
        creative = new SACreative(SAJsonParser.getJsonObject(json, "creative"));

        String obj = SAJsonParser.getString(json, "saCreativeType");
        if (obj != null) {
            if (obj.equals("CPI")) {
                saCampaignType = SACampaignType.CPI;
            } else if (obj.equals("CMP")) {
                saCampaignType = SACampaignType.CPM;
            }
        }
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "error", error,
                "publisherId", publisherId,
                "advertiserId", advertiserId,
                "app", app,
                "placementId", placementId,
                "line_item_id", lineItemId,
                "campaign_id", campaignId,
                "campaign_type", campaignType,
                "saCampaignType", saCampaignType.toString(),
                "test", test,
                "is_fallback", isFallback,
                "is_fill", isFill,
                "is_house", isHouse,
                "safe_ad_approved", safeAdApproved,
                "show_padlock", showPadlock,
                "creative", creative != null ? creative.writeToJson() : null
        });
    }

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
}
