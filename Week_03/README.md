# 学习笔记

## 递归

递归模板代码

```java
class Demo {
    public void recur(int level, int param) { 
        // terminator 
        if (level > MAX_LEVEL) { 
            // process result 
            return; 
        }
    
        // process current logic 
        process(level, param);
    
        // drill down 
        recur(level + 1, newParam);
        
        // restore current status 
    }
}
```
递归 （recursion）模板

1. 递归终结条件
2. 处理当前层逻辑
3. 下探到下一层
4. 清理当前层



解决递归问题需要将问题分解，找到重复子问题，再针对子问题写方法。



原则
1. 不要人肉递归，画递归状态树
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维



## 分治 回溯

分治的本质还是递归

分治的思想是，找问题重复性，将一个问题分解成若干子问题，解决问题、组合各个子问题的结果。



分治代码模板

1. recursion terminator
2. prepare data
3. conquer subproblems
4. process and generate the final result
5. revert the current level states



回溯采用的是试错的思想，穷举所有的解，找到满足要求的解；通过尝试发现当前的阶段的答案不能得到正确的解，将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的解