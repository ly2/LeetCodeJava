import java.util.HashSet;
import java.util.Set;

public class numUniqueEmails929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e : emails) {
            StringBuilder sb = new StringBuilder();
            char[] arr = e.toCharArray();
            int i = 0;
            boolean plus = false;
            while (arr[i] != '@') {
                if (arr[i] == '+')
                    plus = true;
                if (!plus && arr[i] != '.' )
                    sb.append(arr[i]);
                i++;
            }

            while (i < arr.length) {
                sb.append(arr[i]);
                i++;
            }
            set.add(sb.toString());
        }



        return set.size();
    }

    public int numUniqueEmails1(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) unique(set, email);
        return set.size();
    }

    private void unique(Set<String> set, String email) {
        int sepIndex = email.indexOf("@");
        String local = email.substring(0, sepIndex);
        String domain = email.substring(sepIndex);
        sepIndex = local.indexOf("+");
        if (sepIndex > -1) local = local.substring(0, sepIndex);
        local = local.replace(".", "");
        set.add(local + domain);
    }


    // clean
    public int numUniqueEmails2(String[] emails) {
        Set<String> seen = new HashSet();
        for (String email : emails) {
            int i = email.indexOf('@');
            String local = email.substring(0, i);
            String rest = email.substring(i);
            i = local.indexOf("+");
            if (i > -1) local = local.substring(0, i);
            // Note: one should escape the specific character '.',
            // since it is treated as a regex expression.
            local = local.replaceAll("\\.", "");
            seen.add(local + rest);
        }

        return seen.size();
    }
}
