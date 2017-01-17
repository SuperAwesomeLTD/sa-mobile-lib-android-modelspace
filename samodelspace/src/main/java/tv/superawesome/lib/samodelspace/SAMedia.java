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
 * Class that defines a media element to be played
 * Most important elements contained are:
 *  - a html string to be rendered into a web view
 *  - a disk & media url for a video
 */
public class SAMedia extends SABaseObject implements Parcelable {

    // member variables
    public String  html             = null;
    public String  playableDiskUrl  = null;
    public String  playableMediaUrl = null;
    public String  type             = null;
    public boolean isOnDisk         = false;

    /**
     * Basic constructor
     */
    public SAMedia () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SAMedia (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SAMedia (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SAMedia(Parcel in) {
        html = in.readString();
        playableDiskUrl = in.readString();
        playableMediaUrl = in.readString();
        type = in.readString();
        isOnDisk = in.readByte() != 0;
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
        html = SAJsonParser.getString(jsonObject, "html", html);
        playableDiskUrl = SAJsonParser.getString(jsonObject, "playableDiskUrl", playableDiskUrl);
        playableMediaUrl = SAJsonParser.getString(jsonObject, "playableMediaUrl", playableMediaUrl);
        type = SAJsonParser.getString(jsonObject, "type", type);
        isOnDisk = SAJsonParser.getBoolean(jsonObject, "isOnDisk", isOnDisk);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "html", html,
                "playableDiskUrl", playableDiskUrl,
                "playableMediaUrl", playableMediaUrl,
                "type", type,
                "isOnDisk", isOnDisk
        });
    }

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SAMedia> CREATOR = new Creator<SAMedia>() {
        @Override
        public SAMedia createFromParcel(Parcel in) {
            return new SAMedia(in);
        }

        @Override
        public SAMedia[] newArray(int size) {
            return new SAMedia[size];
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
        dest.writeString(html);
        dest.writeString(playableDiskUrl);
        dest.writeString(playableMediaUrl);
        dest.writeString(type);
        dest.writeByte((byte) (isOnDisk ? 1 : 0));
    }
}
