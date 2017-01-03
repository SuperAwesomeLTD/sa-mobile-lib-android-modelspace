package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SABaseObject;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SAAd implements JSONSerializable, Parcelable {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int error;
    public int advertiserId;
    public int publisherId;
    public int app;
    public int lineItemId;
    public int campaignId;
    public int placementId;
    public int campaignType;
    public double moat;
    public SACampaignType saCampaignType;
    public boolean test;
    public boolean isFallback;
    public boolean isFill;
    public boolean isHouse;
    public boolean safeAdApproved;
    public boolean showPadlock;
    public String device;
    public boolean isVAST;
    public SAVASTAdType vastType;
    public String vastRedirect;
    public SACreative creative;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public SAAd () {
        initDefaults();
    }

    public SAAd(JSONObject jsonObject) {
        initDefaults();
        readFromJson(jsonObject);
    }

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
        isVAST = in.readByte() != 0;
        vastType = in.readParcelable(SAVASTAdType.class.getClassLoader());
        vastRedirect = in.readString();
        device = in.readString();
        creative = in.readParcelable(SACreative.class.getClassLoader());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        // init w/ defaults
        error = 0;
        advertiserId = 0;
        publisherId = 0;
        app = 0;
        lineItemId = 0;
        campaignId = 0;
        placementId = 0;
        moat = 0.2;
        campaignType = SACampaignType.CPM.ordinal();
        saCampaignType = SACampaignType.CPM;
        test = false;
        isFallback = false;
        isFill = false;
        isHouse = false;
        safeAdApproved = false;
        showPadlock = false;
        isVAST = false;
        vastType = SAVASTAdType.InLine;
        vastRedirect = null;
        device = null;

        // create the creative
        creative = new SACreative();
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

    public void sumAd (SAAd dest) {
        if (dest.creative.clickUrl != null) {
            this.creative.clickUrl = dest.creative.clickUrl;
        }

        this.creative.events.addAll(dest.creative.events);

        if (dest.creative.details.media != null) {
            this.creative.details.media = dest.creative.details.media;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // JSONSerializable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void readFromJson(JSONObject json) {

        error = SAJsonParser.getInt(json, "error", error);
        advertiserId = SAJsonParser.getInt(json, "advertiserId", advertiserId);
        publisherId = SAJsonParser.getInt(json, "publisherId", publisherId);
        app = SAJsonParser.getInt(json, "app", app);

        int val1 = SAJsonParser.getInt(json, "moat", (int) moat * 100);
        double val2 = SAJsonParser.getDouble(json, "moat", moat);
        moat = Math.max(val2, (double) val1);
        moat = moat > 1 ? 1 : moat;

        lineItemId = SAJsonParser.getInt(json, "line_item_id", lineItemId);
        campaignId = SAJsonParser.getInt(json, "campaign_id", campaignId);
        placementId = SAJsonParser.getInt(json, "placementId", placementId);
        campaignType = SAJsonParser.getInt(json, "campaign_type", campaignType);
        saCampaignType = campaignType == 0 ? SACampaignType.CPM : SACampaignType.CPI;
        test = SAJsonParser.getBoolean(json, "test", test);
        isFallback = SAJsonParser.getBoolean(json, "is_fallback", isFallback);
        isFill = SAJsonParser.getBoolean(json, "is_fill", isFill);
        isHouse = SAJsonParser.getBoolean(json, "is_house", isHouse);
        safeAdApproved = SAJsonParser.getBoolean(json, "safe_ad_approved", safeAdApproved);
        showPadlock = SAJsonParser.getBoolean(json, "show_padlock", showPadlock);
        isVAST = SAJsonParser.getBoolean(json, "isVAST", isVAST);
        vastRedirect = SAJsonParser.getString(json, "vastRedirect", vastRedirect);
        device = SAJsonParser.getString(json, "device", device);

        int ivastType = SAJsonParser.getInt(json, "vastType", 0);
        vastType = ivastType == 0 ? SAVASTAdType.Invalid : (ivastType == 1 ? SAVASTAdType.InLine : SAVASTAdType.Wrapper);

        JSONObject creativeJson = SAJsonParser.getJsonObject(json, "creative", new JSONObject());
        creative = new SACreative(creativeJson);
    }

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
                "isVAST", isVAST,
                "vastRedirect", vastRedirect,
                "vastType", vastType.ordinal(),
                "creative", creative.writeToJson(),
                "device", device
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

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
        dest.writeByte((byte) (isVAST ? 1 : 0));
        dest.writeParcelable(vastType, flags);
        dest.writeString(vastRedirect);
        dest.writeString(device);
        dest.writeParcelable(creative, flags);
    }
}
