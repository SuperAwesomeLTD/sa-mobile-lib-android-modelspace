package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SACreative implements Parcelable, JSONSerializable {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int id;
    public String name;
    public int cpm;
    public String format;
    public SACreativeFormat creativeFormat;
    public boolean live;
    public boolean approved;
    public String customPayload;
    public String clickUrl;
    public String impressionUrl;
    public String installUrl;
    public String bundleId;
    public List<SATracking> events;
    public SADetails details;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public SACreative () {
        initDefaults();
    }

    protected SACreative(Parcel in) {
        id = in.readInt();
        name = in.readString();
        cpm = in.readInt();
        format = in.readString();
        creativeFormat = in.readParcelable(SACreativeFormat.class.getClassLoader());
        live = in.readByte() != 0;
        approved = in.readByte() != 0;
        customPayload = in.readString();
        clickUrl = in.readString();
        impressionUrl = in.readString();
        installUrl = in.readString();
        bundleId = in.readString();
        events = in.createTypedArrayList(SATracking.CREATOR);
        details = in.readParcelable(SADetails.class.getClassLoader());
    }

    public SACreative(JSONObject jsonObject) {
        initDefaults();
        readFromJson(jsonObject);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        id = 0;
        name = null;
        cpm = 0;
        format = null;
        creativeFormat = SACreativeFormat.invalid;
        live = true;
        approved = true;
        customPayload = null;
        clickUrl = null;
        installUrl = null;
        impressionUrl = null;
        bundleId = null;

        events = new ArrayList<>();
        details = new SADetails();
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
        id = SAJsonParser.getInt(json, "id", id);
        name = SAJsonParser.getString(json, "name", name);
        cpm = SAJsonParser.getInt(json, "cpm", cpm);
        format = SAJsonParser.getString(json, "format", format);
        live = SAJsonParser.getBoolean(json, "live", live);
        approved = SAJsonParser.getBoolean(json, "approved", approved);
        customPayload = SAJsonParser.getString(json, "customPayload", customPayload);
        clickUrl = SAJsonParser.getString(json, "click_url", clickUrl);
        impressionUrl = SAJsonParser.getString(json, "impression_url", impressionUrl);
        installUrl = SAJsonParser.getString(json, "installUrl", installUrl);
        bundleId = SAJsonParser.getString(json, "bundleId", bundleId);

        int icreativeFormat = SAJsonParser.getInt(json, "creativeFormat", 0);
        switch (icreativeFormat) {
            case 1: creativeFormat = SACreativeFormat.image; break;
            case 2: creativeFormat = SACreativeFormat.video; break;
            case 3: creativeFormat = SACreativeFormat.rich; break;
            case 4: creativeFormat = SACreativeFormat.tag; break;
            case 5: creativeFormat = SACreativeFormat.gamewall; break;
            default: creativeFormat = SACreativeFormat.invalid; break;
        }

        JSONArray eventsArray = SAJsonParser.getJsonArray(json, "events", new JSONArray());
        events = SAJsonParser.getListFromJsonArray(eventsArray, new SAJsonToList<SATracking, JSONObject>() {
            @Override
            public SATracking traverseItem(JSONObject jsonObject) {
                return new SATracking(jsonObject);
            }
        });

        JSONObject detailsJson = SAJsonParser.getJsonObject(json, "details", new JSONObject());
        details = new SADetails(detailsJson);
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "id", id,
                "name", name,
                "cpm", cpm,
                "format", format,
                "creativeFormat", creativeFormat.ordinal(),
                "live", live,
                "approved", approved,
                "customPayload", customPayload,
                "click_url", clickUrl,
                "impression_url", impressionUrl,
                "installUrl", installUrl,
                "bundleId", bundleId,
                "events", SAJsonParser.getJsonArrayFromList(events, new SAListToJson<JSONObject, SATracking>() {
            @Override
            public JSONObject traverseItem(SATracking saTracking) {
                return saTracking.writeToJson();
            }
        }),
                "details", details.writeToJson()
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

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
        dest.writeParcelable(creativeFormat, flags);
        dest.writeByte((byte) (live ? 1 : 0));
        dest.writeByte((byte) (approved ? 1 : 0));
        dest.writeString(customPayload);
        dest.writeString(clickUrl);
        dest.writeString(impressionUrl);
        dest.writeString(installUrl);
        dest.writeString(bundleId);
        dest.writeTypedList(events);
        dest.writeParcelable(details, flags);
    }
}
