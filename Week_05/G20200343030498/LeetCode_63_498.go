package main

func main() {

}

func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	row := len(obstacleGrid)
	if row < 1 {
		return 0
	}
	col := len(obstacleGrid[0])

	dp := make([]int, col)
	dp[col-1] = 1
	for i := row-1; i >= 0; i-- {
		for j := col-1; j >= 0; j-- {
			if obstacleGrid[i][j] == 1 { //障碍物
				dp[j] = 0
			} else if j < col -1 {
				dp[j] += dp[j+1]  // => dp[j](dp[i][j]) = dp[j](dp[i+1][j]) + dp[j+1](dp[i][j+1]) => dp[i][j] = dp[i+1][j] + dp[i][j+1]
			}
		}
	}

	return dp[0]
}

//func uniquePathsWithObstacles(obstacleGrid [][]int) int {
//	row := len(obstacleGrid)
//	if row < 1 {
//		return 0
//	}
//	col := len(obstacleGrid[0])
//	if col < 1 {
//		return 1
//	}
//	if obstacleGrid[row-1][col-1] == 1 || obstacleGrid[0][0] == 1 { //起点或终点有障碍物
//		return 0
//	}
//
//	for i := row-1; i >= 0; i-- {
//		for j := col-1; j >= 0; j-- {
//			if obstacleGrid[i][j] == 0 {
//				if i == row - 1 && j == col - 1 { //终点置为1
//					obstacleGrid[i][j] = 1
//					continue
//				}
//
//				if j+1 < col {
//					obstacleGrid[i][j] += obstacleGrid[i][j+1]
//				}
//
//				if i+1 < row {
//					obstacleGrid[i][j] += obstacleGrid[i+1][j]
//				}
//			} else {
//				obstacleGrid[i][j] = 0  //障碍物
//			}
//
//		}
//	}
//
//	return obstacleGrid[0][0]
//}

/*
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    row := len(obstacleGrid)
    if row == 0 {
        return 0
    }
    col := len(obstacleGrid[0])
    if col == 0 {
        return 1
    }

    return recursion(obstacleGrid, 0 , 0, row, col)
}

func recursion(obstacleGrid [][]int, r, c, row, col int) int {

    //recirsion terminator
    if r >= row || c >= col { //出界
        return 0
    }
    if r < row && c < col && obstacleGrid[r][c] == 1 { // 障碍物
        return 0
    }
    if r == row-1 && c == col-1 { //到达终点
        return 1
    }

    return recursion(obstacleGrid, r + 1, c, row, col) + recursion(obstacleGrid, r, c + 1, row, col)
}

*/