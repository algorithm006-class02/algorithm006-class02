=begin
	给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
	转换需遵循如下规则：
	    每次转换只能改变一个字母。s
		转换过程中的中间单词必须是字典中的单词。
=end

#解法一、使用双向BFS
require 'set'
def ladder_length(begin_word, end_word, word_list)
    if !word_list.include?(end_word) || !end_word || !begin_word || !word_list
        return 0
    end
    front = Set.new([begin_word])
    back = Set.new([end_word])
    dist = 1
    word_list = Set.new(word_list)
    word_len = begin_word.length
    while !front.empty? && !back.empty?
        dist += 1
        next_front = Set.new()
        for word in front
            for i in 0...word_len
                for c in ('a'..'z')
                    if c != word[i]
                        new_word = word[0...i] + c + word[i + 1..-1]
                        return dist if back.include?(new_word)
                        if word_list.include?(new_word)
                            next_front.merge([new_word])
                            word_list.delete(new_word)
                        end
                    end
                end
            end
        end
        front = next_front
        if back.length < front.length
            front, back = back, front
        end
    end
    return 0
end