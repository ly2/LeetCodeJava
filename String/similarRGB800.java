public class similarRGB800 {

    // original 4 ms	37.1 MB
    public String similarRGB(String color) {
        if (color.charAt(1) == color.charAt(2) &&color.charAt(3) == color.charAt(4) &&color.charAt(5) == color.charAt(6)  )
            return color;
        int[] rgb = new int[3], oldrgb = new int[3];
        for (int i = 0; i < 3; i++) {
//            char c1 = color.charAt(i*2+1);
//            char c2 = color.charAt(i*2+2);
//            if (c1 <= '9') {
//                oldrgb[i] = (c1-'0')*16;
//            } else {
//                oldrgb[i] = (c1-'a'+10)*16;
//            }
//            if (c2 <= '9') {
//                oldrgb[i] += (c2-'0');
//            } else {
//                oldrgb[i] += (c2-'a'+10);
//            }
            oldrgb[i] = Integer.valueOf(color.substring(i*2+1, i*2+3), 16);
        }
        int dif = Integer.MAX_VALUE;
        for (int i = 0; i < 16; i++) {
            int r = i*16+i;
            for (int j = 0; j < 16; j++) {
                int g = j *16+j;
                for (int z = 0; z < 16; z++) {
                    int b = z*16+z;
                    int c = (oldrgb[0]-r)*(oldrgb[0]-r) + (oldrgb[1]-g)*(oldrgb[1]-g) +(oldrgb[2]-b)*(oldrgb[2]-b);
                    if (c < dif) {
                        rgb[0] = i;
                        rgb[1] = j;
                        rgb[2] = z;
                        dif = c;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int c : rgb) {
            if (c > 9) {
                sb.append( (char) ('a'+ c-10)).append( (char) ('a'+ c-10));
            } else {
                sb.append(c).append(c);
            }
        }
        return sb.toString();
    }



    // submission method! 0ms
    public String similarRGB2(String color) {
        StringBuilder result = new StringBuilder().append('#');
        int letterOffset = 'a' - 10;
        for (int i = 1; i < color.length(); i += 2) {
            char c1 = color.charAt(i);
            char c2 = color.charAt(i + 1);
            if (c1 == c2) {
                result.append(c1).append(c1);
                continue;
            }
            int d1 = c1 - (Character.isDigit(c1) ? '0' : letterOffset);
            int d2 = c2 - (Character.isDigit(c2) ? '0' : letterOffset);
            int val = 16 * d1 + d2;

            // because all short-hand values (00,11,22,33...) in hexa are multiples of 17 in decimal (0,17,34, 51...).
            int best = val / 17 + (val % 17) / 9;
            char c = (char) (best + (best < 10 ? '0' : letterOffset));
            result.append(c).append(c);
        }
        return result.toString();
    }
}
