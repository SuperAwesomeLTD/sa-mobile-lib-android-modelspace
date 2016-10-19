package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 25/08/16.
 */
public class SAMedia implements Parcelable, JSONSerializable {

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Public members
    ////////////////////////////////////////////////////////////////////////////////////////////////

    public String html;
    public String playableDiskUrl;
    public String playableMediaUrl;
    public String type;
    public boolean isOnDisk;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    ////////////////////////////////////////////////////////////////////////////////////////////////

    protected SAMedia(Parcel in) {
        html = in.readString();
        playableDiskUrl = in.readString();
        playableMediaUrl = in.readString();
        type = in.readString();
        isOnDisk = in.readByte() != 0;
    }

    public SAMedia () {
        initDefaults();
    }

    public SAMedia (JSONObject jsonObject) {
        initDefaults();
        readFromJson(jsonObject);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Helpers
    ////////////////////////////////////////////////////////////////////////////////////////////////

    private void initDefaults () {
        html = null;
        playableDiskUrl = null;
        playableMediaUrl = null;
        type = null;
        isOnDisk = false;
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
        html = SAJsonParser.getString(json, "html", html);
        playableDiskUrl = SAJsonParser.getString(json, "playableDiskUrl", playableDiskUrl);
        playableMediaUrl = SAJsonParser.getString(json, "playableMediaUrl", playableMediaUrl);
        type = SAJsonParser.getString(json, "type", type);
        isOnDisk = SAJsonParser.getBoolean(json, "isOnDisk", isOnDisk);
    }

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

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // Parceable implementation
    ////////////////////////////////////////////////////////////////////////////////////////////////

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(html);
        dest.writeString(playableDiskUrl);
        dest.writeString(playableMediaUrl);
        dest.writeString(type);
        dest.writeByte((byte) (isOnDisk ? 1 : 0));
    }
}
