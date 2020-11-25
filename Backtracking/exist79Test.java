import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class exist79Test {

    @Test
    public void exist() {
        exist79 e = new exist79();
        char [][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        for (char[] x: board) {
            for (char c: x)
                System.out.print(c + " ");
            System.out.println();
        }
        System.out.println(e.exist(board, "ABCB"));
        Assert.assertFalse(e.exist(board, "ABCB"));
    }

    @Test
    public void exist2() {
        exist79 e = new exist79();
        char [][] board = new char[][] {{'a'}};
        for (char[] x: board) {
            for (char c: x)
                System.out.print(c + " ");
            System.out.println();
        }

        Assert.assertTrue(e.exist(board, "a"));
    }
    @Test
    public void exist3() {
        exist79 e = new exist79();
        char [][] board = new char[][] {{'a','a'}};
        for (char[] x: board) {
            for (char c: x)
                System.out.print(c + " ");
            System.out.println();
        }

        Assert.assertFalse(e.exist(board, "aaa"));
    }
}