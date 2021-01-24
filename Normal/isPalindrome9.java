public class isPalindrome9 {


    // math method
    public boolean isPalindrome(int x) {
        if(x>=0 && x<10)
        {
            return true;
        }
        if(x<0 || x%10==0)
        {
            return false;
        }
        int rev=0;
        int copy=x;
        while(copy!=0)
        {
            int lsb=copy%10;
            rev=(rev*10)+lsb;
            copy/=10;
        }
        if(rev==x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    // converting to string, 7 ms	38.5 MB
    public boolean isPalindrome2(int x) {
        if (x < 0 || x%10 == 0)
            return false;
        if (x / 10 == 0)
            return true;

        String reverse = String.valueOf(x);
        int i = 0;
        int j = reverse.length()-1;
        while (true) {
            if (reverse.charAt(i) != reverse.charAt(j))
                return false;

            if (i == j || i == j-1)
                break;
            i++;
            j--;
        }

        return true;
    }

}
