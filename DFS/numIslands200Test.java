import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class numIslands200Test {

    @Test
    public void numIslands() {
        char[][] grid = new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

        numIslands200 islands200 = new numIslands200();
        Assert.assertEquals(1, islands200.numIslands(grid));

    }
}