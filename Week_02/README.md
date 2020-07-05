# week-02

> 哈希表、映射、集合
>
> 树、二叉树、二叉搜索树
>
> 队和二叉堆、图



<a name="6l8fo"></a>
# 1. 哈希
哈希表（散列表），是根据关键码值直接进行访问的数据结构。

它通过把关键码值映射到表中的一个位置来访问记录，以加快查找的速度。

这个映射函数也称为散列函数，存放记录的数组叫做哈希表。

## 1.1 HashMap总结
### 1.1.1 HashMap概览
HashMap 继承抽象类`AbstractMap`,
实现了Map接口及`Serializable`和`Cloneable`接口。

HashMap的底层数据结构是数组+链表/红黑树。

允许null作为键/值

### 1.1.2 HashMap常用方法分析
put方法分析
```java
/**
 * Associates the specified value with the specified key in this map.
 * If the map previously contained a mapping for the key, the old
 * value is replaced.
 *
 * @param key key with which the specified value is to be associated
 * @param value value to be associated with the specified key
 * @return the previous value associated with <tt>key</tt>, or
 *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
 *         (A <tt>null</tt> return can also indicate that the map
 *         previously associated <tt>null</tt> with <tt>key</tt>.)
 */
public V put(K key, V value) {
   	//对key的hashCode()做hash
    return putVal(hash(key), key, value, false, true);
}

//计算hash
//高16位不变，低16位和高16位做异或
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

/**
 * Implements Map.put and related methods
 *
 * @param hash hash for key
 * @param key the key
 * @param value the value to put
 * @param onlyIfAbsent if true, don't change existing value
 * @param evict if false, the table is in creation mode.
 * @return previous value, or null if none
 */
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    //tab为空则创建
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    //计算index，如果index的桶上没有值，则创建新的桶
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    
    //index的桶上有值
    else {
        Node<K,V> e; K k;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        
        //树
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
       
        //链表
        else {
            for (int binCount = 0; ; ++binCount) {
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        
        
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```


get方法分析
```java

public V get(Object key) {
    Node<K,V> e;
    return (e = getNode(hash(key), key)) == null ? null : e.value;
}

final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        
        //直接命中
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        
        //未命中
        if ((e = first.next) != null) {
            //在树中查找
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            
            //在链表中查找
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

[示例：收藏精选代码](https://shimo.im/docs/R6g9WJV89QkHrDhr/read)
# 2. 树，二叉树，二叉搜索树
## 2.1 二叉树
树节点的定义代码
```java
class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
    	this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
二叉树的遍历

1. 前序遍历（根节点 -> 左子树 -> 右子树）
```java
public void help(TreeNode root, List<Integer> result) {
    if (root != null) {
        result.add(root.val);
        if (root.left != null) {
            help(root.left, result);
        }
        if (root.right != null) {
            help(root.right, result);
        }
    }
}
```

2. 中序遍历（左子树 -> 根节点 -> 右子树）
```java
public void help(TreeNode root, List<Integer> list) {
    if (root != null) {
        if (root.left != null) {
            help(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            help(root.right, list);
        }
    }
}
```

3. 后序遍历（左子树 -> 右子树 -> 根节点）
```java
public void help(TreeNode root, List<Integer> list) {
    if (root != null) {
        if (root.left != null) {
            help(root.left, list);
        }
        if (root.right != null) {
            help(root.right, list);
        }
        list.add(root.val);
    }
}
```
树的定义本身无法进行有效的循环。

## 2.2 二叉搜索树
二叉搜索树，又称为二叉排序树，有序二叉树，排序二叉树，指的是一颗空树或者具有下列性质的二叉树。

1. 左子树上所有节点均小于它的根节点的值
1. 右子树上所有节点均大于它的根节点的值
1. 以此类推，左、右子树也分别是二叉搜索树


[数据结构和算法动态可视化](https://visualgo.net/zh)

# 3. 堆
堆是可以迅速找到一堆数中最大值或最小值的数据结构。

根节点最大的堆叫大顶堆或者大根堆，根节点最小的堆叫小顶堆或者小根堆。
## 3.1 二叉堆
性质1：是一颗完全树

性质2：树中任意节点的值总是>=其子节点的值

二叉堆一般通过数组实现

假设“第一个元素”在数组中的索引为0的话，则父节点和子节点的位置关系如下：

索引i的左孩子索引为 2*i + 1

索引i的右孩子索引为 2*i + 2

索引i的父节点索引为 floor((i - 1) / 2)


