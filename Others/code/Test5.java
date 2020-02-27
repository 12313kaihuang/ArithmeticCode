package ArithmeticCode.Others.code;

/**
 * @author Hy
 * @date 2020/02/27 10:33
 * @description
 **/
public class Test5 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        int[] nums = new int[]{0, 1, 2, 0, 3};
        //int[] result = solution(nums);
        //for(int i =0;i<result.length;i++){
        //    System.out.print(result[i]);
        //}

        solution3(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        // System.out.println(solution(nums));
    }

    //空间换时间
    public static int[] solution(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            result[index++] = 0;
        }
        return result;
    }

    //基于冒泡
    public static void solution2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length - i - 1; j++) {
                if (nums[j] == 0) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    //O(n)
    public static void solution3(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0 && nums[index] != 0) {
                index = i;
            } else if (nums[i] != 0) {
                nums[index] = nums[i];
                nums[i] = 0;
                index++;
            }
        }
    }


}
