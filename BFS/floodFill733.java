public class floodFill733 {
    // DFS
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {

        int color = image[sr][sc];
        if (color == newColor)
            return image;
        image[sr][sc] = newColor;
        if (sr -1 >= 0 && image[sr -1][sc] == color)
            floodFill(image, sr-1, sc, newColor);
        if (sc -1 >= 0 && image[sr][sc-1] == color)
            floodFill(image, sr, sc-1, newColor);
        if (sr +1 < image.length && image[sr +1][sc] == color)
            floodFill(image, sr+1, sc, newColor);
        if (sc +1 < image[0].length && image[sr][sc+1] == color)
            floodFill(image, sr, sc+1, newColor);
        return image;
    }


    // BFS
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color == newColor)
            return image;

        // todo

        return image;
    }
}
