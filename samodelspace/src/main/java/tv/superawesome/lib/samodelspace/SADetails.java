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
 * Class that contains details about a creative, such as:
 *  - width, height
 *  - name
 *  - format
 *  - bitrate, duration, value (for video; not really used)
 *  - image, video, tag, url, vast - needed to describe the location of the creative (whether
 *    rich media, video, 3rd party tag, etc)
 *  - cdnUrl & zipFile (not really used)
 *  - a SAMedia object
 *
 */
public class SADetails extends SABaseObject implements Parcelable {

    // member variables
    public int width = 0;
    public int height = 0;
    public String name = null;
    public String placementFormat = null;
    public int bitrate = 0;
    public int duration = 0;
    public int value = 0;
    public String image = null;
    public String video = null;
    public String tag = null;
    public String zipFile = null;
    public String url = null;
    public String cdnUrl = null;
    public String vast = null;
    public SAMedia media = new SAMedia();

    /**
     * Basic constructor
     */
    public SADetails () {
        // do nothing
    }

    /**
     * Constructor with a JSON string
     *
     * @param json a valid JSON string
     */
    public SADetails (String json) {
        JSONObject jsonObject = SAJsonParser.newObject(json);
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a JSON object
     *
     * @param jsonObject a valid JSON object
     */
    public SADetails (JSONObject jsonObject) {
        readFromJson(jsonObject);
    }

    /**
     * Constructor with a Parcel object
     *
     * @param in the parcel object to read data from
     */
    protected SADetails(Parcel in) {
        width = in.readInt();
        height = in.readInt();
        name = in.readString();
        placementFormat = in.readString();
        bitrate = in.readInt();
        duration = in.readInt();
        value = in.readInt();
        image = in.readString();
        video = in.readString();
        tag = in.readString();
        zipFile = in.readString();
        url = in.readString();
        cdnUrl = in.readString();
        vast = in.readString();
        media = in.readParcelable(SAMedia.class.getClassLoader());
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
        width = SAJsonParser.getInt(jsonObject, "width", width);
        height = SAJsonParser.getInt(jsonObject, "height", height);
        name = SAJsonParser.getString(jsonObject, "name", name);
        placementFormat = SAJsonParser.getString(jsonObject, "placement_format", placementFormat);
        bitrate = SAJsonParser.getInt(jsonObject, "bitrate", bitrate);
        duration = SAJsonParser.getInt(jsonObject, "duration", duration);
        value = SAJsonParser.getInt(jsonObject, "value", value);
        image = SAJsonParser.getString(jsonObject, "image", image);
        video = SAJsonParser.getString(jsonObject, "video", video);
        tag = SAJsonParser.getString(jsonObject, "tag", tag);
        zipFile = SAJsonParser.getString(jsonObject, "zipFile", zipFile);
        url = SAJsonParser.getString(jsonObject, "url", url);
        cdnUrl = SAJsonParser.getString(jsonObject, "cdnUrl", cdnUrl);
        vast = SAJsonParser.getString(jsonObject, "vast", vast);

        JSONObject mediaJson = SAJsonParser.getJsonObject(jsonObject, "media", new JSONObject());
        media = new SAMedia(mediaJson);
    }

    /**
     * Overridden SAJsonSerializable method that describes how a Java model maps to a JSON object
     *
     * @return a valid JSONObject
     */
    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "width", width,
                "height", height,
                "name", name,
                "placement_format", placementFormat,
                "bitrate", bitrate,
                "duration", duration,
                "value", value,
                "image", image,
                "video", video,
                "tag", tag,
                "zipFile", zipFile,
                "url", url,
                "cdnUrl", cdnUrl,
                "vast", vast,
                "media", media.writeToJson()
        });
    }

    /**
     * Method needed for Parcelable implementation
     */
    public static final Creator<SADetails> CREATOR = new Creator<SADetails>() {
        @Override
        public SADetails createFromParcel(Parcel in) {
            return new SADetails(in);
        }

        @Override
        public SADetails[] newArray(int size) {
            return new SADetails[size];
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
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(name);
        dest.writeString(placementFormat);
        dest.writeInt(bitrate);
        dest.writeInt(duration);
        dest.writeInt(value);
        dest.writeString(image);
        dest.writeString(video);
        dest.writeString(tag);
        dest.writeString(zipFile);
        dest.writeString(url);
        dest.writeString(cdnUrl);
        dest.writeString(vast);
        dest.writeParcelable(media, flags);
    }
}
