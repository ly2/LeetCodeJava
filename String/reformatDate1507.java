import java.util.HashMap;
import java.util.Map;

public class reformatDate1507 {
    HashMap<String, String> month = getMonths();


    public String reformatDate(String date) {
        String[] strs = date.split("\\s+"); // use the space will be faster!
        StringBuilder sb = new StringBuilder();
        sb.append(strs[2]).append('-');
        sb.append(month.get(strs[1])).append('-');
        if (Character.isDigit(strs[0].charAt(1))) {
            sb.append(strs[0].charAt(0)).append(strs[0].charAt(1));
        } else {
            sb.append('0').append(strs[0].charAt(0));
        }
        return sb.toString();
    }
    private HashMap<String, String> getMonths(){
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}
