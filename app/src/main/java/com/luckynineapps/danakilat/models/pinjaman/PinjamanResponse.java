
package com.luckynineapps.danakilat.models.pinjaman;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PinjamanResponse {

    @SerializedName("data")
    private List<Pinjaman> mData;
    @SerializedName("status")
    private String mStatus;

    public List<Pinjaman> getData() {
        return mData;
    }

    public void setData(List<Pinjaman> data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
