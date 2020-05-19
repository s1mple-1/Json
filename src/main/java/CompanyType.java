import com.google.gson.annotations.SerializedName;

public class CompanyType {
    private int id;
    @SerializedName("name_full")
    private String fullName;
    @SerializedName("name_short")
    private String shortName;

    @Override
    public String toString() {
        return "CompanyType{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
