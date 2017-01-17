/**
 * @Copyright:   SuperAwesome Trading Limited 2017
 * @Author:      Gabriel Coman (gabriel.coman@superawesome.tv)
 */
package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import tv.superawesome.lib.sajsonparser.SABaseObject;
import tv.superawesome.lib.sajsonparser.SAJsonParser;
import tv.superawesome.lib.sajsonparser.SAJsonToList;
import tv.superawesome.lib.sajsonparser.SAListToJson;

/**
 * Class that contains creative info, such as:
 *  - creative id and name
 *  - cpm (not really relevant for the SDK)
 *  - format (video, tag, rich media, image, etc)
 *  - live & approved
 *  - a custom payload
 *  - click url
 *  - external impression & install url
 *  - bundle Id
 *  - a list of events to be triggered on different stages of ad execution
 *  - a SADetails object
 *
 */
public class SACreative extends SABaseObject implements Parcelable {

    // member variables
    public int              id             = 0;
    public String           name           = null;
    public int              cpm            = 0;
    public SACreativeFormat format         = SACreativeFormat.invalid;
    public boolean          live           = true;
    public boolean          approved       = true;
    public String           customPayload  = null;
    public String           clickUrl       = null;
    public String           impressionUrl  = null;
    public String           installUrl     = null;
    public String           bundleId       = null;
    public List<SATracking> events         = new ArrayList<>();
    public SADetails        details        = new SADetails();

    /**
     * Basic constructor
     */
    public SACreative () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SACreative (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SACreative(JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SACreative(Parcel in) {
        id = in.readInt();
        name = in.readString();
        cpm = in.readInt();
        format = in.readParcelable(SACreativeFormat.class.getClassLoader());
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

    /**
     * Overridden SAJsonSerializable method that describes the conditions for model validity
     *
     * @return true or false
     */
    @Override
    public boolean isValid() {
        return true;
    }

    /**
     * Overridden SAJsonSerializable method that describes how a JSON object maps to a Java model
     *
     * @param jsonObject a valid JSONObject
     */
    @Override
    public void readFromJson(JSONObject jsonObject) {
        id = SAJsonParser.getInt(jsonObject, "id", id);
        name = SAJsonParser.getString(jsonObject, "name", name);
        cpm = SAJsonParser.getInt(jsonObject, "cpm", cpm);

        String formatString = SAJsonParser.getString(jsonObject, "format", null);
        format = SACreativeFormat.fromString(formatString);

        live = SAJsonParser.getBoolean(jsonObject, "live", live);
        approved = SAJsonParser.getBoolean(jsonObject, "approved", approved);
        customPayload = SAJsonParser.getString(jsonObject, "customPayload", customPayload);
        clickUrl = SAJsonParser.getString(jsonObject, "click_url", clickUrl);
        impressionUrl = SAJsonParser.getString(jsonObject, "impression_url", impressionUrl);
        installUrl = SAJsonParser.getString(jsonObject, "installUrl", installUrl);
        bundleId = SAJsonParser.getString(jsonObject, "bundleId", bundleId);

        JSONArray eventsArray = SAJsonParser.getJsonArray(jsonObject, "events", new JSONArray());
        events = SAJsonParser.getListFromJsonArray(eventsArray, new SAJsonToList<SATracking, JSONObject>() {
            @Override
            public SATracking traverseItem(JSONObject jsonObject) {
                return new SATracking(jsonObject);
            }
        });

        JSONObject detailsJson = SAJsonParser.getJsonObject(jsonObject, "details", new JSONObject());
        details = new SADetails(detailsJson);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "id", id,
                "name", name,
                "cpm", cpm,
                "format", format.toString(),
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

    /**
     * Method needed for Parcelable implementation
     */
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
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeInt(cpm);
        dest.writeParcelable(format, flags);
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
