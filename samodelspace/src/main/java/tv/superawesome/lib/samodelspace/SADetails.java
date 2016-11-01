package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SADetails implements Parcelable, JSONSerializable {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public int width;
    public int height;
    public String name;
    public String placementFormat;
    public int bitrate;
    public int duration;
    public int value;
    public String image;
    public String video;
    public String tag;
    public String zipFile;
    public String url;
    public String cdnUrl;
    public String vast;
    public SAMedia media;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public SADetails () {
        initDefaults();
    }

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

    public SADetails(JSONObject jsonObject) {
        initDefaults();
        readFromJson(jsonObject);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        width = 0;
        height = 0;
        name = null;
        placementFormat = null;
        bitrate = 0;
        duration = 0;
        value = 0;
        image = null;
        video = null;
        tag = null;
        zipFile = null;
        cdnUrl = null;
        vast = null;

        media = new SAMedia();
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
        width = SAJsonParser.getInt(json, "width", width);
        height = SAJsonParser.getInt(json, "height", height);
        name = SAJsonParser.getString(json, "name", name);
        placementFormat = SAJsonParser.getString(json, "placement_format", placementFormat);
        bitrate = SAJsonParser.getInt(json, "bitrate", bitrate);
        duration = SAJsonParser.getInt(json, "duration", duration);
        value = SAJsonParser.getInt(json, "value", value);
        image = SAJsonParser.getString(json, "image", image);
        video = SAJsonParser.getString(json, "video", video);
        tag = SAJsonParser.getString(json, "tag", tag);
        zipFile = SAJsonParser.getString(json, "zipFile", zipFile);
        url = SAJsonParser.getString(json, "url", url);
        cdnUrl = SAJsonParser.getString(json, "cdnUrl", cdnUrl);
        vast = SAJsonParser.getString(json, "vast", vast);

        JSONObject mediaJson = SAJsonParser.getJsonObject(json, "media", new JSONObject());
        media = new SAMedia(mediaJson);
    }

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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

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

    @Override
    public int describeContents() {
        return 0;
    }

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
