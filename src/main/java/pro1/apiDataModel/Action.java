package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Action
{
    @SerializedName("Obsazeni")
    public long studentsCount;
    @SerializedName("ucitIdno")
    public long teacherId;
    @SerializedName("denZkr")
    public String dayShortcut;

}
