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
 * Class that defines a tracking element in AwesomeAds.
 * Each tracking element contains an:
 *  - event name (a string)
 *  - an URL to be hit
 */
public class SATracking extends SABaseObject implements Parcelable {

    // member variables
    public String event = null;
    public String URL   = null;

    /**
     * Basic constructor
     */
    public SATracking () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SATracking (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SATracking (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SATracking(Parcel in) {
        event = in.readString();
        URL = in.readString();
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
        event = SAJsonParser.getString(jsonObject, "event", event);
        URL = SAJsonParser.getString(jsonObject, "URL", URL);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "event", event,
                "URL", URL
        });
    }

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SATracking> CREATOR = new Creator<SATracking>() {
        @Override
        public SATracking createFromParcel(Parcel in) {
            return new SATracking(in);
        }

        @Override
        public SATracking[] newArray(int size) {
            return new SATracking[size];
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
        dest.writeString(event);
        dest.writeString(URL);
    }
}
