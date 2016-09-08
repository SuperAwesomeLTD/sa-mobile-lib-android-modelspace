package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

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
    public List<SATracking> events;

    public SADetails details;

    public SACreative () {
        details = new SADetails() ;
        events = new ArrayList<>();
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
        events = in.createTypedArrayList(SATracking.CREATOR);
        details = in.readParcelable(SADetails.class.getClassLoader());
    }

    public SACreative(JSONObject jsonObject) {
        readFromJson(jsonObject);
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
        dest.writeParcelable(creativeFormat, flags);
        dest.writeByte((byte) (live ? 1 : 0));
        dest.writeByte((byte) (approved ? 1 : 0));
        dest.writeString(customPayload);
        dest.writeString(clickUrl);
        dest.writeString(impressionUrl);
        dest.writeTypedList(events);
        dest.writeParcelable(details, flags);
    }

    @Override
    public void readFromJson(JSONObject jsonObject) {
        id = SAJsonParser.getInt(jsonObject, "id");
        name = SAJsonParser.getString(jsonObject, "name");
        cpm = SAJsonParser.getInt(jsonObject, "cpm");
        format = SAJsonParser.getString(jsonObject, "format");
        live = SAJsonParser.getBoolean(jsonObject, "live");
        approved = SAJsonParser.getBoolean(jsonObject, "approved");
        customPayload = SAJsonParser.getString(jsonObject, "customPayload");
        clickUrl = SAJsonParser.getString(jsonObject, "click_url");
        impressionUrl = SAJsonParser.getString(jsonObject, "impression_url");
        events = SAJsonParser.getListFromJsonArray(jsonObject, "events", new SAJsonToList<SATracking, JSONObject>() {
            @Override
            public SATracking traverseItem(JSONObject jsonObject) {
                return new SATracking(jsonObject);
            }
        });
        details = new SADetails(SAJsonParser.getJsonObject(jsonObject, "details"));

        String obj = SAJsonParser.getString(jsonObject, "creativeFormat", SACreativeFormat.invalid.toString());
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
        return SAJsonParser.newObject(new Object[] {
                "id", id,
                "name", name,
                "cpm", cpm,
                "format", format,
                "creativeFormat", creativeFormat.toString(),
                "live", live,
                "approved", approved,
                "customPayload", customPayload,
                "click_url", clickUrl,
                "impression_url", impressionUrl,
                "events", SAJsonParser.getJsonArrayFromList(events, new SAListToJson<JSONObject, SATracking>() {
                    @Override
                    public JSONObject traverseItem(SATracking saTracking) {
                        return saTracking.writeToJson();
                    }
                }),
                "details", details.writeToJson()
        });
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
