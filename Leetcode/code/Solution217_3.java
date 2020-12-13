import java.util.stream.IntStream;

public class Solution217_3 {

    /**
     * Stream应用
     */
    public boolean containsDuplicate(int[] nums) {
        return IntStream.of(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {
        //System.out.println(new Solution().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(new Solution217_3().containsDuplicate(new int[]{1, 2, 3, 1}));
        System.out.println(new Solution217_3().containsDuplicate(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution217_3().containsDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }
}
