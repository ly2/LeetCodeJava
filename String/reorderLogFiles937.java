import java.util.*;

public class reorderLogFiles937 {
    public String[] reorderLogFiles(String[] logs) {

        Comparator<String> mycomp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] log1 = o1.split(" ", 2);
                String[] log2 = o2.split(" ", 2);

                boolean isdigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isdigit2 = Character.isDigit(log2[1].charAt(0));

                if (!isdigit1 && !isdigit2) {
                    int cmp = log1[1].compareTo(log2[1]);
                    return cmp == 0? log1[0].compareTo(log2[0]) : cmp;
                }

                if (isdigit1 && !isdigit2) {
                    return 1;
                } else if (!isdigit1 && isdigit2) {
                    return -1;
                } else
                    return 0;

            }
        };


        Arrays.sort(logs);
        return logs;
    }




    // binary search
    public String[] reorderLogFiles2(String[] logs) {
        List<String> result = new ArrayList();
        int index = 0;
        for(String log:logs) {
            if(!isNumberLog(log)) {
                addStringLogToList(result, log);
            }
        }
        for(String log:logs) {
            if(isNumberLog(log)) {
                result.add(log);
            }
        }
        return result.toArray(new String[result.size()]);
    }


    boolean isNumberLog(String log) {
        char c = log.charAt(log.indexOf(' ')+1);
        return c >= '0' && c <= '9';
    }
    int compareLogStrings(String log1, String log2) {
        String s1 = log1.substring(log1.indexOf(' '));
        String s2 = log2.substring(log2.indexOf(' '));
        if(s1.compareTo(s2) == 0) {
            return log1.compareTo(log2);
        }
        else  {
            return s1.compareTo(s2);
        }
    }
    void addStringLogToList(List<String> result, String log) {
        int left = 0, right = result.size();
        int mid = 0;
        while(left < right) {
            mid = left-(left-right)/2;
            if(compareLogStrings(log, result.get(mid)) >= 0) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        if(result.size()>=1 && compareLogStrings(log, result.get(mid)) >= 0) {
            result.add(mid+1, log);
        }
        else {
            result.add(mid, log);
        }

    }
}
