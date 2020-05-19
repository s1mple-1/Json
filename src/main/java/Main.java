import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "Companies.json";
        Gson gson = new Gson();

        System.out.println("Компании:");
        ArrayList<Company> companiesList = gson.fromJson(new FileReader(new File(fileName)),
                new TypeToken<ArrayList<Company>>() {
                }.getType());

        companiesList.forEach(a -> System.out.println(a.getShortName() + " - дата основания " +
                dateFromString(a.getEgrul_date(), "yyyy-MM-dd", "dd/MM/yy")));

        System.out.println("");
        HashMap<ArrayList<Securities>, String> securitiesHashMap = new HashMap<>();
        companiesList.forEach(a -> securitiesHashMap.put(a.getSecuritiesList(), a.getFullName()));

        System.out.println("Аннулированные акции:");
        securitiesHashMap.forEach((securities, owner) -> securities.stream().
                filter(allSecure -> allSecure.getState().getName().equalsIgnoreCase("аннулирован")).
                forEach(endedSecure -> System.out.println(endedSecure.getCode() + ", " + endedSecure.getDateTo() + ", " + owner)));

        ArrayList<Securities> securitiesList = new ArrayList<>();
        securitiesHashMap.forEach((securities, owner) -> securitiesList.addAll(securities));
        long endedCount = securitiesList.stream().filter(allSecure -> allSecure.getState().getName().equalsIgnoreCase("аннулирован")).count();
        System.out.println("Всего аннулированных акций: " + endedCount);
        System.out.println("");

        printSecuritiesWithCode("RUB", securitiesList);
        printSecuritiesWithCode("USD", securitiesList);
        printSecuritiesWithCode("UAH", securitiesList);

        printCompaniesWhitDate("22/03/15", companiesList);
        printCompaniesWhitDate("22.03.1999", companiesList);
        printCompaniesWhitDate("22/03,01", companiesList);
    }

    private static void printSecuritiesWithCode(String code, ArrayList<Securities> securities) {
        if (!securities.isEmpty() && !code.isEmpty()) {
            System.out.println("Список акций по запрошенному коду " + code + ":");
            securities.stream().filter(a -> a.getCurrency().getCode().equalsIgnoreCase(code)).forEach(a -> System.out.println("id: " + a.getId() + ", code: " + a.getCode()));
            System.out.println("");
        } else System.out.println("Ошибка, передан пустой параметр");
    }

    private static void printCompaniesWhitDate(String date, ArrayList<Company> companies) {
        if (!date.isEmpty() && !companies.isEmpty()) {
            String[] splitInputDate = date.split("[\\p{Punct}]");
            String del = String.valueOf(date.charAt(2));
            String pt = "dd" + del + "MM" + del;
            String dateToParse = splitInputDate[0]+del+splitInputDate[1]+del+splitInputDate[2];
            DateTimeFormatter dtf;
            if (splitInputDate[2].length() == 2) {
                dtf = DateTimeFormatter.ofPattern(pt + "yy");
            } else {
                dtf = DateTimeFormatter.ofPattern(pt + "yyyy");
            }
            LocalDate checkDate = LocalDate.from(dtf.parse(dateToParse));
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println("Список компаний основанных после запрошенной даты " + checkDate);
            for (Company company : companies) {
                LocalDate localDate = LocalDate.from(dtf2.parse(company.getEgrul_date()));
                if (localDate.isAfter(checkDate)) {
                    System.out.println(company.getFullName() + " - " + localDate);
                }
            }
            System.out.println("");
        } else System.out.println("Ошибка, передан пустой параметр");
    }

    private static String dateFromString(String date, String inputPattern, String outputPattern) {
        if (!date.isEmpty() && !inputPattern.isEmpty() && !outputPattern.isEmpty()) {
            DateTimeFormatter inDtf = DateTimeFormatter.ofPattern(inputPattern);
            DateTimeFormatter outDtf = DateTimeFormatter.ofPattern(outputPattern);
            LocalDate localDate = LocalDate.from(inDtf.parse(date));
            return localDate.format(outDtf);
        } else return "Ошибка, передан пустой параметр";
    }
}
