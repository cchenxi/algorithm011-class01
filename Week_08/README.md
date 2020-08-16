# week-08

# 1. 位运算
机器中的数字表示方式和存储方式是二进制的。


## 1.1 原理 
### 1.1.1 取反（NOT ~）
取反是一元运算符，对一个二进制数的每一位执行逻辑反操作，**使数字1变成0，0变成1**。


### 1.1.2 按位或（OR |）
按位或处理两个长度相同的二进制，两个相应的二进位中**只要有一个为1，则该位的结果为1**。


### 1.1.3 按位异或（XOR ^）
按位异或运算，对等长二进制模式或二进制数的每一位执行逻辑异或操作。操作的结果是**如果某位不同则该位为1，否则该位为0**。也可以理解为"**不进位加法**"。
```
1 1 1 0 1
0 0 0 1 0
---------
1 1 1 1 1
    
1 1 1 0 1
1 1 0 1 0
---------
0 0 1 1 1
```


异或的高级操作
```
1. x ^ 0 = x
1 1 1 0 1
0 0 0 0 0
---------
1 1 1 0 1

2. x ^ 1s = ~x
1 1 1 0 1
1 1 1 1 1
---------
0 0 0 1 0

3. x ^ (~x) = 1s
1 1 1 0 1
0 0 0 1 0
---------
1 1 1 1 1

4. x ^ x = 0
1 1 1 0 1
1 1 1 0 1
---------
0 0 0 0 0

5. c = a ^ b, a ^ c = b, b ^ c = a

6. a ^ b ^ c = a ^ (b ^ c) = (a ^ b) ^ c
```


### 1.1.4 按位与（AND &）
按位与处理两个长度相同的二进制数，**两个相应的二进位都为1，该位的结果才为1，否则为0**。


### 1.1.5 移位（左移<<  右移>>）
移位是一个二元运算符，用来**将一个二进制数中的每一位全部都像一个方向移动指定位，溢出的部分将被舍弃，空缺的部分补0**。


## 1.2 应用
指定位置的位运算


从右往左 第0位开始
```
1. 将x最右边的n位清零: x & (~0 << n) 或者 x & (1s << n)
x = 1 1 1 0 1 1 0 1, n = 4
1s << 4 = 1 1 1 1 0 0 0 0
1 1 1 0 1 1 0 1
1 1 1 1 0 0 0 0
---------------
1 1 1 0 0 0 0 0

2. 获取x的第n位值（0 或者1）:(x >> n) & 1
(n + 1)位？
x = 1 1 1 0 1 1 0 1, n = 4
x >> 4 = 0 0 0 0 1 1 1 0
0 0 0 0 1 1 1 0
0 0 0 0 0 0 0 1
---------------
0 0 0 0 0 0 0 0

3. 获取x的第n位的幂值: x & (1 << n)
x = 1 1 1 0 1 1 0 1, n = 4
1 1 1 0 1 1 0 1
0 0 0 1 0 0 0 0
---------------
0 0 0 0 0 0 0 0

4. 仅将第n位置为1: x | (1 << n)

5. 仅将第n位置为0: x & (~(1 << n))

6. 将x最高位至第n位（含）清零: x & ((1 << n) -1)

7. 将第n位至第0位（含）清零: x & (~((1<< (n + 1))-1))

```


实战位运算要点
```
1. 判断奇偶
x % 2 == 1 奇数 => (x&1) == 1
x % 2 == 0 偶数 => (x&1) == 0

2. x >> 1 => x/2

3. 清零最低位的1
x = x & (x-1)

x = 10010
10010
10001
-----
10000

x=10000
10000
01000
-----
00000

以上两步依次清除了数字10010中的1

4. 得到最低位的1
x & -x

5. x & ~x = 0
```


翻转非负整数的常见做法
```java
int ans = 0;
int n = 234;
while (n != 0) {
	ans = ans * 10 + n % 10;
	n /= 10;
}
```


# 2. 布隆过滤器 Bloom Filter
一个很长的二进制向量和一系列随机映射函数。
布隆过滤器可以用于检索一个元素是否在一个集合中。
优点：空间效率和查询时间远远超过一般算法
缺点：有一定的误识别率和删除困难


原理
布隆过滤器的核心实现是一个超大的位数组和几个哈希函数。
![image.png](https://cdn.nlark.com/yuque/0/2020/png/372192/1597562834830-be9f636e-2d9f-41d7-8906-3831c4ea7a7a.png#align=left&display=inline&height=296&margin=%5Bobject%20Object%5D&name=image.png&originHeight=592&originWidth=1724&size=469260&status=done&style=none&width=862)


假设集合里面有3个元素{x, y, z}，哈希函数的个数为3。首先将位数组初始化，将每个位置置为0。对于集合里面的每一个元素，将元素依次通过3个哈希函数进行映射，每次映射都会产生一个哈希值，这个值对应位数组上面的一个点，然后将位数组对应的位置置为1。
查询W元素是否存在集合中的时候，同样的方法将W通过哈希函数映射到位数组上3个点。如果3个点中的其中一个点不为1，则可以判断元素一定不存在集合中。反之如果3个点都为1，则该元素可能存在集合中。
注意，此处不能判断该元素是否一定存在集合中，可能存在一定的误判率。


布隆过滤器添加元素

- 将要添加的元素给k个哈希函数
- 得到对应于位数组上的k个位置
- 将这k个位置设为1



布隆过滤器查询元素

- 将要查询的元素给k个哈希函数
- 得到对应于数组上的k个位置
- 如果k个位置有一个为0，则可定不在集合中
- 如果k个位置全部为1，则可能在集合中



布隆过滤器在实际应用中常作为最外层使用，用于快速判断，如果查询到可能在集合中，则会在通过持久化存储查询确认。


实际应用场景：

- 比特币网络
- 分布式系统
- Redis
- 垃圾邮件，评论



[https://www.cnblogs.com/cpselvis/p/6265825.html](https://www.cnblogs.com/cpselvis/p/6265825.html)
[https://blog.csdn.net/tianyaleixiaowu/article/details/74721877](https://blog.csdn.net/tianyaleixiaowu/article/details/74721877)


java实现
[https://github.com/Baqend/Orestes-Bloomfilter](https://github.com/Baqend/Orestes-Bloomfilter)
[https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java](https://github.com/lovasoa/bloomfilter/blob/master/src/main/java/BloomFilter.java)


# 3. LRU Cache
缓存两个要素

- 缓存大小
- 缓存替换策略 [https://en.wikipedia.org/wiki/Cache_replacement_policies](https://en.wikipedia.org/wiki/Cache_replacement_policies)



HashTable + Double LinkedList


# 4. 排序算法
比较类排序：通过比较来决定元素的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序


非比较类排序：不通过比较来决定元素的相对次序，他可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。一般只能用于整形。


十大经典排序算法：[https://www.cnblogs.com/onepixel/p/7674659.html](https://www.cnblogs.com/onepixel/p/7674659.html)


![image.png](https://cdn.nlark.com/yuque/0/2020/png/372192/1597568023597-8e914db3-42cf-4659-884d-00d1c108d932.png#align=left&display=inline&height=500&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1000&originWidth=1930&size=514314&status=done&style=none&width=965)


![image.png](https://cdn.nlark.com/yuque/0/2020/png/372192/1597568119466-5b9a4ca3-49b7-46d1-bf5c-bef3edd2ddc2.png#align=left&display=inline&height=553&margin=%5Bobject%20Object%5D&name=image.png&originHeight=1106&originWidth=1652&size=1259258&status=done&style=none&width=826)

---

## 4.1 初级排序 （n^2）
### 选择排序 selection sort
每次找最小值，然后放到待排序数组的起始位置
```java
public class SelectionSort {
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            //在未排序的部分中选择最小的值
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            //swap
            int tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }
}
```


### 插入排序 insertion sort
从前到后逐步构建有序序列，对于未排序的数据，在已排序序列中从后向前扫描，找到相应位置并插入。
```java
public class InsertionSort {
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;

            //在已排序序列中从后向前扫描，找到相应位置并插入
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
    }
}
```


### 冒泡排序 bubble sort
嵌套循环，每次查看相邻的元素，如果逆序则交换
```java
public class BubbleSort {
    public void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
}
```

---

## 4.2 高级排序（nlogn）
### 快速排序
数组取标杆pivot，将小元素放到pivot左边，大元素放到右侧，然后依次对左边和右边的子数组继续快排，以达到整个序列有序。
```java
public class QuickSort {
    public void sort(int[] array, int begin, int end) {
        if (array == null || array.length == 0 || begin >= end) {
            return;
        }

        int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(int[] array, int begin, int end) {
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int tmp = array[counter];
                array[counter] = array[i];
                array[i] = tmp;

                counter++;
            }
        }

        int tmp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = tmp;

        return counter;
    }
}
```
### 归并排序（分治）

- 将长度为n的输入序列分为两个长度为n/2的子序列
- 对这两个子序列分别采用归并排序
- 将两个排序好的子序列合并成一个最终的排序序列
```java
public class MergeSort {
    public void sort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;

        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1]; // 中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid)   temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int p = 0; p < temp.length; p++) {
            arr[left + p] = temp[p];
        }
    }
}
```


快速排序和归并排序具有相似性，但是步骤与顺序相反
归并，先排序左右子数组，然后合并两个有序子数组
快排，先调配出左右子数组，然后对于左右子数组进行排序
### 堆排序

1. 数组元素依次建立小顶堆
1. 依次取堆顶元素，并删除
```java
public class HeapSort {
    public static void sort(int[] array) {
        if (array.length == 0) return;
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int length, int i) {
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, length, largest);
        }
    }
}
```



---

## 4.3 特殊排序
### 计数排序
计数排序要求输入的数据必须是有确定范围的整数。将输入的数据值转化为键存储在额外开辟的数组空间中，然后依次把计数大于1的填充回原数组。
### 桶排序
假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序。
### 基数排序
按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推直到最高位。






