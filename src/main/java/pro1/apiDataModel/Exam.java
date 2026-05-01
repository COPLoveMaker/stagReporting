package pro1.apiDataModel;

import com.google.gson.annotations.SerializedName;

public class Exam {
    @SerializedName("mistnost")
    public String room;

    @SerializedName("obsazeni")
    public int studentsCount;
}