学习笔记

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

原则
1. 不要人肉递归，画递归状态树
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

分治代码模板
1. recursion terminator
2. prepare data
3. conquer subproblems
4. process and generate the final result
5. revert the current level states