public class read157 {

    /**
     * The read4 API is defined in the parent class Reader4.
     *     int read4(char[] buf4);
     */

    class Reader4 {

        public int read4(char[] buf4) {
            return 0;
        }
    }

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int copyofchar = 0, countofonce = 4;
            char[] buf4 = new char[4];

            while(copyofchar < n && countofonce == 4) {
                countofonce = read4(buf4);

                for(int i = 0; i < countofonce; i++) {
                    if (copyofchar == n)
                        return copyofchar;
                    buf[copyofchar++] = buf4[i];
                }

            }
            return copyofchar;

        }
    }
}
