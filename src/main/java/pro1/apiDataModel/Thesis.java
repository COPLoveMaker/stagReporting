package pro1.apiDataModel;
import com.google.gson.annotations.SerializedName;

public class Thesis {
    @SerializedName("datumZadani")
    public Date dateAssigned;
    @SerializedName("datumOdevzdani")
    public Date dateSubmitted;
}

