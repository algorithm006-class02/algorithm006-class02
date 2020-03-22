=begin
题目描述：
	给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。
    输入:
	[
	  [1,3,1],
	  [1,5,1],
	  [4,2,1]
	]
	输出: 7
	解释: 因为路径 1→3→1→1→1 的总和最小。
=end

#解法一、动态规划
def min_path_sum(grid)
    return 0 if grid.empty? || grid.nil?
    for i in 0...grid.length
        for j in 0...grid[0].length
            next if i == 0 && j == 0
            if i == 0
                grid[i][j] = grid[i][j - 1] + grid[i][j]
            elsif j == 0
                grid[i][j] = grid[i - 1][j] + grid[i][j]
            else
                grid[i][j] = [grid[i - 1][j], grid[i][j - 1]].min + grid[i][j]
            end
        end
    end
    return grid[- 1][- 1]
end