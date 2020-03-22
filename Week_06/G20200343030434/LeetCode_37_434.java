package algorithm.leetCode.week04.No37;
class solution {
	//三个数组分别记录9行、9列、9个子数独中9个数字的使用状态，finished记录是否完成解数独
	boolean[][] rows=new boolean[9][9],cols=new boolean[9][9],blocks=new boolean[9][9];
	boolean finished=false;
	//解数独方法
	public void solveSudoku(char[][] board) {
		//初始化状态数组，遍历初始数独，将使用过的数字的状态置为true
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (board[row][col] != '.'){
					rows[row][board[row][col]-'1']=
						cols[col][board[row][col]-'1']=
						blocks[row/3*3+col/3][board[row][col]-'1']=true;
				}
			}
		}
		dfs(board,0,0);
	}
	//深度遍历，row记录当前要填写的行，col记录当前要填写的列
	private void dfs(char[][] board, int row, int col) {
		//0-8行都已经填写，解数独完毕
		if (row==9){
			finished=true;
			return;
		}
		//不是空白格，不需要填写，继续向后移动
		if (board[row][col] != '.'){
			//如果本行已经是最后一列，则继续填写下一行的第一列；否则继续当前行的下一列。
			if (col==8) dfs(board,row+1,0);
			else dfs(board,row,col+1);
		}else {
			//按顺序将当前行、列、子数独未使用的数字尝试填入空白格
			int block = row / 3 * 3 + col / 3;
			for (int i=0;i<9;i++){
				//如果i+1未使用，可以填入当前空白格
				if (!rows[row][i] && !cols[col][i] && !blocks[block][i]){
					board[row][col]=(char)(i+'1');
					//更新被入数字的状态
					rows[row][i]=cols[col][i]=blocks[block][i]=true;
					//填写完毕当前空白格，继续填写一格
					if (col==8)dfs(board,row+1,0);
					else dfs(board,row,col+1);
					//如果当前尝试填入的数字组合不能成功解数独(导致后序空白格无法填写)，则回溯
					if (!finished){
						//擦除填入的数字，并更新被擦除数字的状态
						board[row][col]='.';
						rows[row][i]=cols[col][i]=blocks[block][i]=false;
					}
				}
			}
		}
	}
}
