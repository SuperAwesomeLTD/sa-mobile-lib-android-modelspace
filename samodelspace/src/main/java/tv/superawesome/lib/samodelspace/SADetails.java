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
        readFromJson(jsonObject);
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

    @Override
    public void readFromJson(JSONObject jsonObject) {
        width = SAJsonParser.getInt(jsonObject, "width");
        height = SAJsonParser.getInt(jsonObject, "height");
        name = SAJsonParser.getString(jsonObject, "name");
        placementFormat = SAJsonParser.getString(jsonObject, "placementFormat");
        bitrate = SAJsonParser.getInt(jsonObject, "bitrate");
        duration = SAJsonParser.getInt(jsonObject, "duration");
        value = SAJsonParser.getInt(jsonObject, "value");
        image = SAJsonParser.getString(jsonObject, "image");
        video = SAJsonParser.getString(jsonObject, "video");
        tag = SAJsonParser.getString(jsonObject, "tag");
        zipFile = SAJsonParser.getString(jsonObject, "zipFile");
        url = SAJsonParser.getString(jsonObject, "url");
        cdnUrl = SAJsonParser.getString(jsonObject, "cdnUrl");
        vast = SAJsonParser.getString(jsonObject, "vast");
        media = new SAMedia(SAJsonParser.getJsonObject(jsonObject, "media"));
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[] {
                "width", width,
                "height", height,
                "name", name,
                "placementFormat", placementFormat,
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

    @Override
    public boolean isValid() {
        return true;
    }
}
