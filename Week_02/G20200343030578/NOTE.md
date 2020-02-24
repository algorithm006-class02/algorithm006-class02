学习笔记

* 哈希表与集合

  - 哈希表
    - 简介
      - 存储键值对
      - 通过哈希函数确定存储位置
    - 基本操作及时间复杂度
      - 插入
        - O( 1 )
      - 删除
        - O( 1 )
      - 查找
        - O( 1 )
    - Java 实现（各种 Map ）
      - https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Map.html
  - 集合
    - 简介
      - 存储无序不重复元素
    - 基本操作及时间复杂度
      - 插入
        - O( 1 )
      - 删除
        - O( 1 )
      - 查找
        - O( 1 )
    - Java 实现（各种 Set ）
      - https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/Set.html

* 树与二叉树

  - 树

  - 二叉树

    - 遍历操作（递归实现）
      - 前序
      - 中序
      - 后序

  - 二叉搜索树

    - 简介
      - 左子树上所有结点的值均小于它的根结点的值；
      - 右子树上所有结点的值均大于它的根结点的值；
      - 以此类推：左、右子树也分别为二叉查找树
    - 性质
      - 中序遍历：升序排列
    - 常见操作及时间复杂度
      - 查询
        - O( log n )
      - 插入
        - O( log n )
      - 删除
        - O( log n )
      - 动画示例
        - https://visualgo.net/zh/bst

  - 有关递归的理解

    - 思路

      - 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
      - 数学归纳法思维

    - 递归 Java 模板

      ```java
      public void recur( int level, int param) {
           // terminator
           if ( level > MAX_LEVEL) {
               // process result
               return; 
           }
           // process current logic
           process( level,  param); 
           // drill down
           recur(  level: level + 1,  newParam); 
           // restore current status
      }
      ```

      