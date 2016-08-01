/**
 * @class: SACreative.java
 * @copyright: (c) 2015 SuperAwesome Ltd. All rights reserved.
 * @author: Gabriel Coman
 * @date: 28/09/2015
 *
 */
package tv.superawesome.lib.samodelspace;

/**
 * imports for this class
 */
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.jar.JarEntry;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;


/**
 * The creative contains essential ad information like format, click url
 * and such
 */
public class SACreative implements Parcelable, JSONSerializable {

    public int id;
    public String name;
    public int cpm;
    public String format;
    public String impressionUrl;
    public String customPayload;
    public String clickUrl;
    public boolean live;
    public boolean approved;
    public SADetails details;

    public SACreativeFormat creativeFormat;
    public String viewableImpressionUrl;
    public String trackingUrl;
    public String parentalGateOpenUrl;
    public String parentalGateCloseUrl;
    public String parentalGateFailUrl;
    public String parentalGateSuccessUrl;

    /**
     * public constructor
     */
    public SACreative() {
        /** do nothing */
    }

    public SACreative(JSONObject json) {
        readFromJson(json);
    }

    protected SACreative(Parcel in) {
        id = in.readInt();
        name = in.readString();
        cpm = in.readInt();
        format = in.readString();
        impressionUrl = in.readString();
        customPayload = in.readString();
        clickUrl = in.readString();
        live = in.readByte() != 0;
        approved = in.readByte() != 0;
        details = in.readParcelable(SADetails.class.getClassLoader());viewableImpressionUrl = in.readString();

        creativeFormat = in.readParcelable(SACreativeFormat.class.getClassLoader());
        viewableImpressionUrl = in.readString();
        trackingUrl = in.readString();
        parentalGateCloseUrl = in.readString();
        parentalGateFailUrl = in.readString();
        parentalGateOpenUrl = in.readString();
        parentalGateSuccessUrl = in.readString();
    }

    public static final Creator<SACreative> CREATOR = new Creator<SACreative>() {
        @Override
        public SACreative createFromParcel(Parcel in) {
            return new SACreative(in);
        }

        @Override
        public SACreative[] newArray(int size) {
            return new SACreative[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(cpm);
        dest.writeString(format);
        dest.writeString(impressionUrl);
        dest.writeString(customPayload);
        dest.writeString(clickUrl);
        dest.writeByte((byte) (approved ? 1 : 0));
        dest.writeByte((byte) (live ? 1 : 0));
        dest.writeParcelable(details, flags);

        dest.writeString(viewableImpressionUrl);
        dest.writeString(trackingUrl);
        dest.writeParcelable(creativeFormat, flags);
        dest.writeString(parentalGateCloseUrl);
        dest.writeString(parentalGateFailUrl);
        dest.writeString(parentalGateOpenUrl);
        dest.writeString(parentalGateSuccessUrl);

    }

    @Override
    public void readFromJson(JSONObject json) {
        id = SAJsonParser.getInt(json, "id");
        name = SAJsonParser.getString(json, "name");
        cpm = SAJsonParser.getInt(json, "cpm");
        format = SAJsonParser.getString(json, "format");
        impressionUrl = SAJsonParser.getString(json, "impression_url");
        clickUrl = SAJsonParser.getString(json, "click_url");
        customPayload = SAJsonParser.getString(json, "customPayload");
        approved = SAJsonParser.getBoolean(json, "approved");
        live = SAJsonParser.getBoolean(json, "live");
        details = new SADetails(SAJsonParser.getJsonObject(json, "details"));
        viewableImpressionUrl = SAJsonParser.getString(json, "viewableImpressionUrl");
        trackingUrl = SAJsonParser.getString(json, "trackingUrl");
        parentalGateSuccessUrl = SAJsonParser.getString(json, "parentalGateSuccessUrl");
        parentalGateFailUrl = SAJsonParser.getString(json, "parentalGateFailUrl");
        parentalGateCloseUrl = SAJsonParser.getString(json, "parentalGateCloseUrl");
        parentalGateOpenUrl = SAJsonParser.getString(json, "parentalGateOpenUrl");

        String obj = SAJsonParser.getString(json, "creativeFormat", SACreativeFormat.invalid.toString());
        if (obj.equals(SACreativeFormat.invalid.toString())){
            creativeFormat = SACreativeFormat.invalid;
        }
        if (obj.equals(SACreativeFormat.image.toString())){
            creativeFormat = SACreativeFormat.image;
        }
        if (obj.equals(SACreativeFormat.video.toString())){
            creativeFormat = SACreativeFormat.video;
        }
        if (obj.equals(SACreativeFormat.rich.toString())){
            creativeFormat = SACreativeFormat.rich;
        }
        if (obj.equals(SACreativeFormat.tag.toString())){
            creativeFormat = SACreativeFormat.tag;
        }
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "id", id,
                "name", name,
                "cpm", cpm,
                "format", format,
                "impression_url", impressionUrl,
                "customPayload", customPayload,
                "click_url", clickUrl,
                "live", live,
                "approved", approved,
                "details", details != null ? details.writeToJson() : null,
                "creativeFormat", creativeFormat.toString(),
                "viewableImpressionUrl", viewableImpressionUrl,
                "parentalGateCloseUrl", parentalGateCloseUrl,
                "parentalGateFailUrl", parentalGateFailUrl,
                "parentalGateSuccessUrl", parentalGateSuccessUrl,
                "parentalGateOpenUrl", parentalGateOpenUrl,
                "trackingUrl", trackingUrl
        });

    }
}
