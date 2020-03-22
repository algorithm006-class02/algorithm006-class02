<?php
class TireNode{
    public $letter; // 当前节点中存的字母
    public $children = []; // 当前节点的子节点
    public $isEnd = false; // 是否是该单词的最后一个字母
    
    public function __construct($letter=''){
        $this->letter = $letter;
    }
}

class Trie {
    private $root;
    private $size;
    
    public function __construct(){
        $this->root = new TireNode();
        $this->size = 0;
    }
    
    public function getRoot(){
        return $this->root;
    }
    
    public function getSize(){
        return $this->size;
    }
    
    // 遍历单词中的字母，从根节点开始逐个插入到 前缀树 中，children 属性是一个数组，key值是字节中的letter值
    public function insert($word){
        $cur = $this->getRoot();
        $l = strlen($word);

        for($i=0;$i<$l;$i++){
            $letter = $word[$i];            
            if(empty($cur->children[$letter])){
                $cur->children[$letter] = new TireNode($letter);              
                $this->size ++;
            }
            $cur = $cur->children[$letter];
        }
        
        $cur->isEnd = true;
    }
    
    public function search($word){
        $l = strlen($word);
        $cur = $this->getRoot();
        
        for($i=0;$i<$l;$i++){
            $char = $word[$i];
            if(empty($cur->children[$char])){
                return false;
            }
            $cur = $cur->children[$char];
        }
        // 不仅需要包含字母，还需要是一个完整的单词，如 tree 包含 tre ，但是 tre 并没有存入到 前缀树中
        return $cur->isEnd;
    }

// 简化版的 search
    public function startsWith($prefix) {
        $l = strlen($prefix);
        $cur = $this->getRoot();
        
        for($i=0;$i<$l;$i++){
            $char = $prefix[$i];
            if(empty($cur->children[$char])){
                return false;
            }
            $cur = $cur->children[$char];
        }
        return true;
    }

// 采用递归实现
    public function remove($word){
        return $this->removeChildren($this->getRoot(),0,$word);
    }
    
    private function removeChildren($node,$index,$word){
        // 如果树中没有该单词，则直接返回 false
        if(!$this->search($word)){
            return false;
        }
        
        if($index == strlen($word)){
            if(!$node->isEnd){ // 最后一个字母不是单词的结尾，不能删除
                return false;
            }
            
            if(!empty($node->children)){ // 当前节点的子节点不为空，不能删除
                return false;
            }
            
            return true;
        }
        
        $char = $word[$index];
        if(empty($node->children[$char])){
            return false;
        }
        
        $res = $this->removeChildren($node->children[$char],++$index,$word);
        if($res && $node->children){
            $node->children = [];
            return true;
        }
        
        return false; 
    }

}
