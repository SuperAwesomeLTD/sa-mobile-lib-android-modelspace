package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import java.util.List;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SACreative2 implements Parcelable, JSONSerializable {

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

    public SADetails2 details;

    protected SACreative2(Parcel in) {
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
        details = in.readParcelable(SADetails2.class.getClassLoader());
    }

    public SACreative2 (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    public static final Creator<SACreative2> CREATOR = new Creator<SACreative2>() {
        @Override
        public SACreative2 createFromParcel(Parcel in) {
            return new SACreative2(in);
        }

        @Override
        public SACreative2[] newArray(int size) {
            return new SACreative2[size];
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
        clickUrl = SAJsonParser.getString(jsonObject, "clickUrl");
        impressionUrl = SAJsonParser.getString(jsonObject, "impressionUrl");
        events = SAJsonParser.getListFromJsonArray(jsonObject, "events", new SAJsonToList<SATracking, JSONObject>() {
            @Override
            public SATracking traverseItem(JSONObject jsonObject) {
                return new SATracking(jsonObject);
            }
        });
        details = new SADetails2(SAJsonParser.getJsonObject(jsonObject, "details"));

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
                "clickUrl", clickUrl,
                "impressionUrl", impressionUrl,
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
