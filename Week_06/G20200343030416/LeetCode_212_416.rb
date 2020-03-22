=begin
	给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母在一个单词中不允许被重复使用。
=end

#解法一、使用Trie树和DFS + 剪枝
require 'set'
END_OF_WORD = "#"
def find_words(board, words)
    return [] if !board || !board[0]
    return [] if !words
    @result = Set.new
    root = {}
    for word in words
        node = root
        for char in word.chars
            node = node[char] = node.fetch(char, {})
        end
        node[END_OF_WORD] = END_OF_WORD
    end

    @m, @n = board.length, board[0].length
    for i in 0...@m
        for j in 0...@n
            if root.has_key?(board[i][j])
                dfs(board, i, j, "", root)
            end
        end
    end
    return Array(@result)
end

def dfs(board, i, j, cur_word, cur_dict)
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    cur_word += board[i][j]
    cur_dict = cur_dict[board[i][j]]
    if cur_dict.has_key?(END_OF_WORD)
        @result.merge([cur_word])
    end
    tmp, board[i][j] = board[i][j], '@'
    for k in 0...4
        x, y = i + dx[k], j + dy[k]
        if 0 <= x && x < @m && 0 <= y && y < @n && board[x][y] != '@' && cur_dict.has_key?(board[x][y])
            dfs(board, x, y, cur_word, cur_dict)
        end
    end
    board[i][j] = tmp
end