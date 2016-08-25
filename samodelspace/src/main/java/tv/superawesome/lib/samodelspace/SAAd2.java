package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SAAd2 implements Parcelable, JSONSerializable {
    public int error;
    public int advertiserId;
    public int publisherId;
    public int app;
    public int lineItemId;
    public int campaignId;
    public int placementId;
    public boolean test;
    public boolean isFallback;
    public boolean isFill;
    public boolean isHouse;
    public boolean safeAdApproved;
    public boolean showPadlock;

    public boolean isVAST;
    public SAVASTAdType vastType;
    public String vastRedirect;

    public SACreative2 creative;


    protected SAAd2(Parcel in) {
        error = in.readInt();
        advertiserId = in.readInt();
        publisherId = in.readInt();
        app = in.readInt();
        lineItemId = in.readInt();
        campaignId = in.readInt();
        placementId = in.readInt();
        test = in.readByte() != 0;
        isFallback = in.readByte() != 0;
        isFill = in.readByte() != 0;
        isHouse = in.readByte() != 0;
        safeAdApproved = in.readByte() != 0;
        showPadlock = in.readByte() != 0;
        isVAST = in.readByte() != 0;
        vastType = in.readParcelable(SAVASTAdType.class.getClassLoader());
        vastRedirect = in.readString();
        creative = in.readParcelable(SACreative2.class.getClassLoader());
    }

    public SAAd2 (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    public static final Creator<SAAd2> CREATOR = new Creator<SAAd2>() {
        @Override
        public SAAd2 createFromParcel(Parcel in) {
            return new SAAd2(in);
        }

        @Override
        public SAAd2[] newArray(int size) {
            return new SAAd2[size];
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
        dest.writeByte((byte) (test ? 1 : 0));
        dest.writeByte((byte) (isFallback ? 1 : 0));
        dest.writeByte((byte) (isFill ? 1 : 0));
        dest.writeByte((byte) (isHouse ? 1 : 0));
        dest.writeByte((byte) (safeAdApproved ? 1 : 0));
        dest.writeByte((byte) (showPadlock ? 1 : 0));
        dest.writeByte((byte) (isVAST ? 1 : 0));
        dest.writeParcelable(vastType, flags);
        dest.writeString(vastRedirect);
        dest.writeParcelable(creative, flags);
    }

    @Override
    public void readFromJson(JSONObject jsonObject) {
        error = SAJsonParser.getInt(jsonObject, "error");
        advertiserId = SAJsonParser.getInt(jsonObject, "advertiserId");
        publisherId = SAJsonParser.getInt(jsonObject, "publisherId");
        app = SAJsonParser.getInt(jsonObject, "app");
        lineItemId = SAJsonParser.getInt(jsonObject, "lineItemId");
        campaignId = SAJsonParser.getInt(jsonObject, "campaignId");
        placementId = SAJsonParser.getInt(jsonObject, "placementId");
        test = SAJsonParser.getBoolean(jsonObject, "test");
        isFallback = SAJsonParser.getBoolean(jsonObject, "isFallback");
        isFill = SAJsonParser.getBoolean(jsonObject, "isFill");
        isHouse = SAJsonParser.getBoolean(jsonObject, "isHouse");
        safeAdApproved = SAJsonParser.getBoolean(jsonObject, "safeAdApproved");
        showPadlock = SAJsonParser.getBoolean(jsonObject, "showPadlock");
        isVAST = SAJsonParser.getBoolean(jsonObject, "isVAST");
        vastRedirect = SAJsonParser.getString(jsonObject, "vastRedirect");
        creative = new SACreative2(SAJsonParser.getJsonObject(jsonObject, "creative"));

        String obj = SAJsonParser.getString(jsonObject, "vastType", SAVASTAdType.Invalid.toString());
        if (obj.equals(SAVASTAdType.Invalid.toString())){
            vastType = SAVASTAdType.Invalid;
        }
        if (obj.equals(SAVASTAdType.InLine.toString())){
            vastType = SAVASTAdType.InLine;
        }
        if (obj.equals(SAVASTAdType.Wrapper.toString())){
            vastType = SAVASTAdType.Wrapper;
        }
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "error", error,
                "advertiserId", advertiserId,
                "publisherId", publisherId,
                "app", app,
                "lineItemId", lineItemId,
                "campaignId", campaignId,
                "placementId", placementId,
                "test", test,
                "isFallback", isFallback,
                "isFill", isFill,
                "isHouse", isHouse,
                "safeAdApproved", safeAdApproved,
                "showPadlock", showPadlock,
                "isVAST", isVAST,
                "vastRedirect", vastRedirect,
                "vastType", vastType.toString(),
                "creative", creative.writeToJson()
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
