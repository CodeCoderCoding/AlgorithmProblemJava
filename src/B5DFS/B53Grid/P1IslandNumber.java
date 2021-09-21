package B5DFS.B53Grid;

/**
 * 岛屿数量
 * @author CodeCoderCoding
 */
public class P1IslandNumber {
    private int res;
    public int numIslands(char[][] grid) {
        res = 0;
        //遍历矩阵网格，方便开始其他岛屿的遍历，dfsGrid只具备遍历一格岛屿的能力，不能从一个岛屿跳到另一个岛屿去遍历
        //遍历矩阵就是为了从一个岛屿跳到另一个岛屿去遍历
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    dfsGrid(grid, i, j);
                    res ++;
                }
            }
        }
        return res;
    }

    //dfsGrid的作用是，在上面的循环中调用dfsGrid（给定一个初始坐标），然后dfsGrid从这个初始坐标开始遍历，
    //标记与这个初始坐标直接或间接相邻的陆地，这些陆地组成一个岛屿
    private void dfsGrid(char[][] grid, int row, int col) {
        //判断坐标是否(row,col)是否在网格中，如果不在则返回
        if (row >= grid.length || col >= grid[0].length || row < 0 || col < 0) {
            return;
        }

        if (grid[row][col] != '1') {
            return;
        }

        grid[row][col] = '2';//将格子标记为已经遍历过

        dfsGrid(grid, row - 1, col);
        dfsGrid(grid, row + 1, col);
        dfsGrid(grid, row, col - 1);
        dfsGrid(grid, row, col + 1);
    }
}
