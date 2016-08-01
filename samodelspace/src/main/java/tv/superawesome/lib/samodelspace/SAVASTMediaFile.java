package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import tv.superawesome.lib.sajsonparser.JSONSerializable;
import tv.superawesome.lib.sajsonparser.SAJsonParser;

/**
 * Created by gabriel.coman on 22/12/15.
 */
public class SAVASTMediaFile implements Parcelable, JSONSerializable {

    public String width;
    public String height;
    public String url;
    public String type;

    public SAVASTMediaFile() {

    }

    public SAVASTMediaFile(JSONObject json) {
        readFromJson(json);
    }

    protected SAVASTMediaFile(Parcel in) {
        width = in.readString();
        height = in.readString();
        url = in.readString();
        type = in.readString();
    }

    public static final Creator<SAVASTMediaFile> CREATOR = new Creator<SAVASTMediaFile>() {
        @Override
        public SAVASTMediaFile createFromParcel(Parcel in) {
            return new SAVASTMediaFile(in);
        }

        @Override
        public SAVASTMediaFile[] newArray(int size) {
            return new SAVASTMediaFile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(url);
        dest.writeString(type);
    }

    @Override
    public void readFromJson(JSONObject json) {
        width = SAJsonParser.getString(json, "width");
        height = SAJsonParser.getString(json, "height");
        url = SAJsonParser.getString(json, "url");
        type = SAJsonParser.getString(json, "type");
    }

    @Override
    public JSONObject writeToJson() {
        return SAJsonParser.newObject(new Object[]{
                "width", width,
                "height", height,
                "url", height,
                "type", type
        });
    }

    @Override
    public boolean isValid() {
        return true;
    }
}
