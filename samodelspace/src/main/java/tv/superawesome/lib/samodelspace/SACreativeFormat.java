/**
 * @class: SAAd.java
 * @copyright: (c) 2015 SuperAwesome Ltd. All rights reserved.
 * @author: Gabriel Coman
 * @date: 28/09/2015
 *
 */

package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * An enum that defines the number of formats an ad can be in
 *  - invalid: defined by the SDK in case of some error
 *  - image: the creative is a simple banner image
 *  - video: the creative is a video that must be streamed
 *  - rich: a mini-HTML page with user interaction
 *  - tag: a rich-media (usually) served as a JS file via a 3rd party service
 */
public enum SACreativeFormat implements Parcelable {

    invalid(0) {
        @Override
        public String toString() {
            return "invalid";
        }
    },
    image(1) {
        @Override
        public String toString() {
            return "image";
        }
    },
    video(2) {
        @Override
        public String toString() {
            return "video";
        }
    },
    rich(3){
        @Override
        public String toString() {
            return "rich";
        }
    },
    tag(4) {
        @Override
        public String toString() {
            return "tag";
        }
    },
    appwall(5) {
        @Override
        public String toString() {
            return "appwall";
        }
    };

    private final int value;
    SACreativeFormat(int i) {
        this.value = i;
    }

    public static SACreativeFormat fromValue (int value) {
        if (value == 5) return appwall;
        if (value == 4) return tag;
        if (value == 3) return rich;
        if (value == 2) return video;
        if (value == 1) return image;
        return invalid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(ordinal());
    }

    public static final Creator<SACreativeFormat> CREATOR = new Creator<SACreativeFormat>() {
        @Override
        public SACreativeFormat createFromParcel(final Parcel source) {
            return SACreativeFormat.values()[source.readInt()];
        }

        @Override
        public SACreativeFormat[] newArray(final int size) {
            return new SACreativeFormat[size];
        }
    };
}
