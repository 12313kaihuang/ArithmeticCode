package Leetcode.code;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 706. 设计哈希映射
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * 示例：
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * 提示：
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashmap
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution706_1 {

    /**
     * 这个跟705. 设计哈希集合其实是一个题，只不过一个是set一个是map
     */
    public static void main(String[] args) {

    }
}

//链地址法
class MyHashMap {

    private static final int p = 769;
    private final LinkedList<Pair>[] arr;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        arr = new LinkedList[p];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int h = key % p;
        if (arr[h] == null) {
            arr[h] = new LinkedList<>();
        }
        for (Pair pair : arr[h]) {
            if (key == pair.getKey()) {
                pair.value = value;
                return;
            }
        }
        arr[h].add(new Pair(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = key % p;
        if (arr[h] == null) return -1;
        for (Pair pair : arr[h]) {
            if (key == pair.getKey()) {
                return pair.value;
            }
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = key % p;
        if (arr[h] == null) return;
        Iterator<Pair> iterator = arr[h].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove();
                return;
            }
        }
    }

    static class Pair {
        private final int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }
    }
}

// 暴力解法，时间上肯定快，空间占用太大
class MyHashMap1 {

    private final Integer[] arr;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap1() {
        arr = new Integer[1_000_009];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        arr[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return arr[key] == null ? -1 : arr[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        arr[key] = null;
    }
}

