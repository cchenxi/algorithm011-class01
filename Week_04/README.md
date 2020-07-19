# week-04

<a name="Owkkp"></a>
## 深度优先搜索 广度优先搜索
搜索 - 遍历

1. 每个节点都要访问一次
1. 每个节点仅访问一次
1. 节点的访问顺序不限
   1. 深度优先 depth first search
   1. 广度优先 breadth first search
   1. 优先级优先（业务应用，抖音快手推荐），启发式搜索（深度学习）


<br />深度优先搜索代码
```java
/**
 * 深度优先遍历二叉树
 * 递归
 *
 * @param root
 * @return
 */
public List<Integer> dfs(TwoTreeNode root) {
    Set<TwoTreeNode> visited = new HashSet<>();
    List<Integer> result = new ArrayList<>();
    helpDfs(visited, root, result);
    return result;
}

private void helpDfs(Set<TwoTreeNode> visited, TwoTreeNode root, List<Integer> result) {
    if (root == null || visited.contains(root)) {
        return;
    }
    visited.add(root);
    result.add(root.val);
    helpDfs(visited, root.left, result);
    helpDfs(visited, root.right, result);
}

/**
 * 深度优先遍历二叉树
 * 非递归
 *
 * @param root
 * @return
 */
public List<Integer> dfs2(TwoTreeNode root) {
    if (root == null) {
        return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Stack<TwoTreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
        if (root != null) {
            result.add(root.val);
            stack.push(root);
            root = root.left;
        } else {
            TwoTreeNode node = stack.pop();
            root = node.right;
        }
    }
    return result;
}

//二叉树
public class TwoTreeNode {
    public int val;
    public TwoTreeNode left, right;

    public TwoTreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```
深度优先搜索代码
```java
public List<Integer> bfs(TwoTreeNode root) {
    if (root == null) {
        return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Queue<TwoTreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        for (int i = 0; i < size; i++) {
            TwoTreeNode node = nodes.poll();
            result.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
    return result;
}
```


<a name="gvk47"></a>
## 
