package ArithmeticCode.SwordToOffer.code;

import ArithmeticCode.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
/**
 * Created by Hy on 2019/12/20 9:35
 * <p>
 * 二叉树中和为某一值的路径.md
 */
public class Test24 {

    private ArrayList<ArrayList<Integer>> result = null;
    private ArrayList<Integer> list = null;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        result = new ArrayList<>();
        list = new ArrayList<>();
        if (root == null) return result;
        Find(root, target);

        //排序
        result.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

        return result;
    }

    private void Find(TreeNode root, int target) {
        if (root == null) return;
        list.add(root.val);
        target -= root.val;
        if (target < 0) {
            //剪枝
            return;
        } else if (target == 0 && root.left == null && root.right == null) {
            //到达叶子节点且和为目标值
            result.add(new ArrayList<>(list));
        }else {
            //target >0 且未到达叶子节点 继续递归遍历
            Find(root.left, target);
            Find(root.right, target);
        }
        list.remove(list.size() - 1);
    }


//    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
//    private ArrayList<Integer> list = new ArrayList<Integer>();
//    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//        if(root == null) return listAll;
//        list.add(root.val);
//        target -= root.val;
//        if(target == 0 && root.left == null && root.right == null)
//            listAll.add(new ArrayList<Integer>(list));
//        FindPath(root.left, target);
//        FindPath(root.right, target);
//        list.remove(list.size()-1);
//        return listAll;
//    }
}
