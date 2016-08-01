/**
 * @class: SACreative.java
 * @copyright: (c) 2015 SuperAwesome Ltd. All rights reserved.
 * @author: Gabriel Coman
 * @date: 28/09/2015
 *
 */
package tv.superawesome.lib.samodelspace;

/**
 * Useful imports for this class
 **/
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * The SADetails class contains fine grained information about the creative
 * of an ad (such as width, iamge, vast, tag, etc)
 * Depending on the format of the creative, some fields are essential,
 * and some are optional
 *
 * This dependency is regulated by SAValidator.h
 */
public class SADetails implements Parcelable, JSONSerializable{

    public int width;
    public int height;
    public String image;
    public int value;
    public String name;
    public String video;
    public int bitrate;
    public int duration;
    public String vast;
    public String tag;
    public String zipFile;
    public String url;
    public String placementFormat;
    public String cdnUrl;
    public SAData data;

    /**
     * public constructor
     */
    public SADetails() {
        /** do nothing */
    }

    public SADetails(JSONObject json) {
        readFromJson(json);
    }

    protected SADetails(Parcel in) {
        width = in.readInt();
        height = in.readInt();
        image = in.readString();
        name = in.readString();
        video = in.readString();
        bitrate = in.readInt();
        duration = in.readInt();
        vast = in.readString();
        tag = in.readString();
        zipFile = in.readString();
        url = in.readString();
        placementFormat = in.readString();
        cdnUrl = in.readString();
        value = in.readInt();
        data = in.readParcelable(SAData.class.getClassLoader());
    }

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
        dest.writeString(image);
        dest.writeString(name);
        dest.writeString(video);
        dest.writeInt(bitrate);
        dest.writeInt(duration);
        dest.writeString(vast);
        dest.writeString(tag);
        dest.writeString(zipFile);
        dest.writeString(url);
        dest.writeString(placementFormat);
        dest.writeString(cdnUrl);
        dest.writeInt(value);
        dest.writeParcelable(data, flags);
    }

    @Override
    public void readFromJson(JSONObject json) {
        width = SAJsonParser.getInt(json, "width");
        height = SAJsonParser.getInt(json, "height");
        image = SAJsonParser.getString(json, "image");
        value = SAJsonParser.getInt(json, "value");
        name = SAJsonParser.getString(json, "name");
        video = SAJsonParser.getString(json, "video");
        bitrate = SAJsonParser.getInt(json, "bitrate");
        duration = SAJsonParser.getInt(json, "duration");
        vast = SAJsonParser.getString(json, "vast");
        tag = SAJsonParser.getString(json, "tag");
        zipFile = SAJsonParser.getString(json, "zipFile");
        url = SAJsonParser.getString(json, "url");
        placementFormat = SAJsonParser.getString(json, "placement_format");
        cdnUrl = SAJsonParser.getString(json, "cdnUrl");
        data = new SAData(SAJsonParser.getJsonObject(json, "data"));
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "width", width,
                "height", height,
                "image", image,
                "value", value,
                "name", name,
                "video", video,
                "bitrate", bitrate,
                "duration", duration,
                "vast", vast,
                "tag", tag,
                "zipFile", zipFile,
                "placement_format", placementFormat,
                "cdnUrl", cdnUrl,
                "data", data != null ? data.writeToJson() : null
        });
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
