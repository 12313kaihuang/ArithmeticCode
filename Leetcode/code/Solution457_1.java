package Leetcode.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 457. 环形数组是否存在循环
 * <p>
 * 存在一个不含 0 的 环形 数组nums ，每个 nums[i] 都表示位于下标 i 的角色应该向前或向后移动的下标个数：
 * 如果 nums[i] 是正数，向前 移动 nums[i] 步
 * 如果nums[i] 是负数，向后 移动 nums[i] 步
 * <p>
 * 因为数组是 环形 的，所以可以假设从最后一个元素向前移动一步会到达第一个元素，而第一个元素向后移动一步会到达最后一个元素。
 * <p>
 * 数组中的 循环 由长度为 k 的下标序列 seq ：
 * 遵循上述移动规则将导致重复下标序列 seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * 所有 nums[seq[j]] 应当不是 全正 就是 全负
 * k > 1
 * <p>
 * 如果 nums 中存在循环，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * <p>
 * 示例 2：
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * <p>
 * 示例 3:
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 的运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有 nums[seq[j]] 应当不是全正就是全负。
 * <p>
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(n) 且额外空间复杂度为 O(1) 的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circular-array-loop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution457_1 {

    //[2,-1,1,2,2]
    public boolean circularArrayLoop(int[] nums) {
        int len = nums.length;
        for (int start = 0; start < nums.length; start++) { //以每个节点为起点尝试查找环形数组
            Set<Integer> set = new HashSet<>();
            System.out.println();
            for (int cur = start, step = nums[start]; ; ) { //i为当前节点下标
                if (step * nums[cur] < 0) break; //题目要求所有nums[seq[j]]不是 全正 就是 全负，这时不满足条件
                int next = getNext(cur, len, nums[cur]); //下一个节点下标
                System.out.println(cur + " to " + next + ", step:" + nums[cur]);
                if (cur == next || !set.add(cur)) break; //自旋或链路中存在了重复元素
                if (next == start) return true;
                else cur = next;
            }
        }
        return false;
    }

    //step绝对值会大于length，这里也有讲究啊
    private int getNext(int now, int length, int step) {
        step = step % length;
//        if (step >= 0) return (now + step) % length;
//        else return (now + length + step) % length;
        return (now + step + length) % length;
    }


    //思路不变 逻辑简化
    public boolean circularArrayLoop2(int[] nums) {
        int len = nums.length;
        for (int start = 0; start < nums.length; start++) { //以每个节点为起点尝试查找环形数组
            Set<Integer> set = new HashSet<>();
            for (int cur = start, step = nums[start]; ; ) { //i为当前节点下标
                if (step * nums[cur] < 0) break; //题目要求所有nums[seq[j]]不是 全正 就是 全负，这时不满足条件
                int next = (cur + (nums[cur] % len) + len) % len; //下一个节点下标
                System.out.println(cur + " to " + next + ", step:" + nums[cur]);
                if (cur == next || !set.add(cur)) break; //自旋或链路中存在了重复元素
                if (next == start) return true;
                else cur = next;
            }
        }
        return false;
    }

    public boolean circularArrayLoop3(int[] nums) {
        int len = nums.length;
        for (int start = 0; start < nums.length; start++) { //以每个节点为起点尝试查找环形数组
            Set<Integer> set = new HashSet<>();
            for (int cur = start, step = nums[start]; ; ) { //i为当前节点下标
                if (step * nums[cur] < 0) break; //题目要求所有nums[seq[j]]不是 全正 就是 全负，这时不满足条件
                int next = (cur + (nums[cur] % len) + len) % len; //下一个节点下标
                System.out.println(cur + " to " + next + ", step:" + nums[cur]);
                if (cur == next) break; //自旋退出
                //next == start 好理解，同时此时含有了重复元素，那么就说明产生了环，而自旋的场景
                //上一个if已经判断了，则当前是有的，只用判断是否有，而不用判读具体路径
                if (next == start || !set.add(cur)) return true;
                else cur = next;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution457_1().circularArrayLoop2(new int[]{2, -1, 1, 2, 2}));
//        System.out.println(new Solution457_1().circularArrayLoop(new int[]{-1, 2}));
//        System.out.println(new Solution457_1().circularArrayLoop(new int[]{-2, 1, -1, -2, -2}));
//        System.out.println(new Solution457_1().circularArrayLoop(new int[]{-1, -2, -3, -4, -5}));
//        System.out.println(new Solution457_1().circularArrayLoop(new int[]{1, 1, 2}));
        System.out.println(new Solution457_1().circularArrayLoop(new int[]{-2, -3, -9}));
//        System.out.println(3 % 4);
//        System.out.println(-3 % 4);
    }
}
