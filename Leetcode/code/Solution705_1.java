package Leetcode.code;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 705. 设计哈希集合
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * <p>
 * 提示：
 * 0 <= key <= 10^6
 * 最多调用 10^4 次 add、remove 和 contains 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-hashset
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution705_1 {

    /**
     * 先复习一下hash表和hash值相关的知识点吧：https://www.jianshu.com/p/4cc2cc287e9f
     * <p>
     * 复习完成后，发现还是没有什么思路于是看了官方题解：
     * 1.首先计算hash值使用除留余数法：H(key) = key % p（p的大小取决于表长）
     * 对于表长的取值，表长越长，冲突的概率就越小，但空间占用就会变大；表长越小，冲突概率会变高，但空间占用越小。
     * 而p取不大于表长且最接近表长m的素数效果最好,官方题解取得p=m=769，这里也就用769吧 = =
     * <p>
     * 2.处理冲突：直接定址法和再hash法会涉及数组扩容，所以这里就采用连地址法了。
     */
    class MyHashSet {

        static final int p = 769;
        private LinkedList[] arr;

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {
            arr = new LinkedList[p];
            for (int i = 0; i < p; i++) {
                arr[i] = new LinkedList<Integer>();
            }
        }

        public void add(int key) {
            int h = key % p;
            for (Integer next : (Iterable<Integer>) arr[h]) {
                if (key == next) {
                    return;
                }
            }
            arr[h].add(key);
        }

        public void remove(int key) {
            int h = key % p;
            Iterator<Integer> iterator = arr[h].iterator();
            while (iterator.hasNext()) {
                if (key == iterator.next()) {
                    iterator.remove();
                    return;
                }
            }
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            int h = key % p;
            for (Integer integer : (Iterable<Integer>) arr[h]) {
                if (key == integer) return true;
            }
            return false;
        }
    }


    /**
     * 暴力解法，还有其他的几个
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/design-hashset/solution/yi-ti-san-jie-jian-dan-shu-zu-lian-biao-nj3dg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class MyHashSet2 {
        boolean[] nodes = new boolean[1000009];

        public void add(int key) {
            nodes[key] = true;
        }

        public void remove(int key) {
            nodes[key] = false;
        }

        public boolean contains(int key) {
            return nodes[key];
        }
    }
}
