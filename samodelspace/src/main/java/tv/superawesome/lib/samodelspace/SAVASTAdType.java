package tv.superawesome.lib.samodelspace;

import android.os.Parcel;
import android.os.Parcelable;

public enum SAVASTAdType implements Parcelable {
    Invalid (0) {
        @Override
        public String toString() {
            return "Invalid";
        }
    },
    InLine (1) {
        @Override
        public String toString() {
            return "InLine";
        }
    },
    Wrapper (2) {
        @Override
        public String toString() {
            return "Wrapper";
        }
    };

    private final int value;
    SAVASTAdType(int i) {
        this.value = i;
    }

    public static SAVASTAdType fromValue (int value) {
        if (value == 2) return Wrapper;
        if (value == 1) return InLine;
        return Invalid;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(ordinal());
    }

    public static final Creator<SAVASTAdType> CREATOR = new Creator<SAVASTAdType>() {
        @Override
        public SAVASTAdType createFromParcel(final Parcel source) {
            return SAVASTAdType.values()[source.readInt()];
        }

        @Override
        public SAVASTAdType[] newArray(final int size) {
            return new SAVASTAdType[size];
        }
    };
}
