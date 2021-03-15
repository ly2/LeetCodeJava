public class canPlaceFlowers605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int prev2 = 0, prev = flowerbed[0];
        if (flowerbed.length == 1 && prev == 0)
            return n==1;

        for (int i = 1; i < flowerbed.length; i++) {
            if (prev2==0 && prev == 0 && flowerbed[i] == 0) {
                prev = 1;
                n--;
            }
            prev2 = prev;
            prev = flowerbed[i];
        }
        if (prev== 0 && prev2 == 0)
            n--;
        if (n <= 0)
            return true;
        return false;
    }
}
