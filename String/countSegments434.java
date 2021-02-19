public class countSegments434 {

    // original
    public int countSegments2(String s) {
        if (s.trim().isEmpty())
            return 0;
        // System.out.println("-"+s.trim()+"-");
        // String[] a = s.split("\\s+");
        return s.trim().split("\\s+").length;
    }


    // opt 0 ms	36.7 MB
    public int countSegments(String s) {
        int count = 0;
        boolean isW = false;
        for (char c: s.toCharArray()) {
            if (c != ' ') {
                if (!isW) {
                    count++;
                    isW = true;
                }
            } else {
                isW = false;
            }
        }

        return count;
    }
}
