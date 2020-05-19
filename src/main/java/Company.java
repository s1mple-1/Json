import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Company {
    private int id;
    private String code;
    @SerializedName("name_full")
    private String fullName;
    @SerializedName("name_short")
    private String shortName;
    private long inn;
    @SerializedName("company_type")
    private CompanyType companyType;
    private long ogrn;
    private String egrul_date;
    private Country country;
    @SerializedName("fio_head")
    private String fioHead;
    private String address;
    private String phone;
    @SerializedName("e_mail")
    private String eMail;
    @SerializedName("www")
    private String site;
    @SerializedName("is_resident")
    private boolean isResident;
    @SerializedName("securities")
    private ArrayList<Securities> securitiesList;

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

    public long getInn() {
        return inn;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public long getOgrn() {
        return ogrn;
    }

    public String getEgrul_date() {
        return egrul_date;
    }

    public Country getCountry() {
        return country;
    }

    public String getFioHead() {
        return fioHead;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    public String getSite() {
        return site;
    }

    public boolean isResident() {
        return isResident;
    }

    public ArrayList<Securities> getSecuritiesList() {
        return securitiesList;
    }
}
