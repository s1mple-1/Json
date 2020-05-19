import com.google.gson.annotations.SerializedName;

public class Currency {
    private int id;
    private String code;
    @SerializedName("name_full")
    private String fullName;
    @SerializedName("name_short")
    private String shortName;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}