public class maxRepeating1668 {

    public int maxRepeating(String sequence, String word) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (sb.length() < sequence.length()) {
            sb.append(word);
            if (sequence.contains(sb.toString())) {
                count++;
            } else
                break;

        }
        return count;
    }



    // submission method
    public int maxRepeating2(String sequence, String word) {
        int count = 0;
        String temp = word;
        while(true){
            int index = sequence.indexOf(temp);
            if(index == -1){
                break;
            }else{
                count++;
                temp += word;
            }
        }
        return count;
    }
}
