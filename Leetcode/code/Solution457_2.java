package Leetcode.code;

@SuppressWarnings("unused")
public class Solution457_2 {

    int n;
    int[] nums;

    /**
     * 思路大同小异，check的时候通过k标记遍历节点数目，
     * 若k大于n则说明有重复节点被处理
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/circular-array-loop/solution/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-ag05/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean circularArrayLoop(int[] _nums) {
        nums = _nums;
        n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(i)) return true;
        }
        return false;
    }

    boolean check(int start) {
        int cur = start;
        boolean flag = nums[start] > 0;
        int k = 1;
        while (true) {
            if (k > n) return false;
            int next = ((cur + nums[cur]) % n + n) % n;
            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            cur = next;
            k++;
        }
    }


    int OFFSET = 100010;

    /**
     * 标记遍历过的节点，当从A节点发现到X节点不行时，那么中间到节点也不需要
     * 再次进入循环查找路径
     * <p>
     * 作者：AC_OIer
     * 链接：https://leetcode-cn.com/problems/circular-array-loop/solution/gong-shui-san-xie-yi-ti-shuang-jie-mo-ni-ag05/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean circularArrayLoop2(int[] nums) {
        int n = nums.length;
        for (int start = 0; start < n; start++) {
            if (nums[start] >= OFFSET) continue; //说明此节点在前面遍历过了，且无法通过此节点找到环路
            int cur = start, tag = OFFSET + start, last = -1;
            boolean flag = nums[cur] > 0;
            while (true) {
                int next = ((cur + nums[cur]) % n + n) % n;
                last = nums[cur];
                nums[cur] = tag;
                cur = next;
                if (cur == start) break;
                if (nums[cur] >= OFFSET) break;  //又一次遍历到了已遍历过的元素，说明产生了环路，但此时可能是自旋的环路
                if (flag && nums[cur] < 0) break; //符号不同，退出循环
                if (!flag && nums[cur] > 0) break;
            }
            //此时cur其实等于next，判断next节点是否被访问过，即判断是否有环路
            //last不等于0说明不会自旋
            if (last % n != 0 && nums[cur] == tag) return true;
        }
        return false;
    }
}
