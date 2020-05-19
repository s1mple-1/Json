import com.google.gson.annotations.SerializedName;

public class Securities {
    private int id;
    private String code;
    @SerializedName("name_full")
    private String fullName;
    private String cfi;
    @SerializedName("date_to")
    private String dateTo;
    @SerializedName("state_reg_date")
    private String stateRegDate;
    private State state;
    private Currency currency;

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCfi() {
        return cfi;
    }

    public String getDateTo() {
        return dateTo;
    }

    public String getStateRegDate() {
        return stateRegDate;
    }

    public State getState() {
        return state;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Securities{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", fullName='" + fullName + '\'' +
                ", cfi='" + cfi + '\'' +
                ", dateTo=" + dateTo +
                ", stateRegDate=" + stateRegDate +
                ", state=" + state +
                ", currency=" + currency +
                '}';
    }
}