package Leetcode.code;

import java.util.*;

/**
 * 1418. 点菜展示表
 * <p>
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 * orders[i]=[customerNamei,tableNumberi,foodItemi] ，其中 customerNamei 是客户的姓名，
 * tableNumberi 是客户所在餐桌的桌号，而 foodItemi 是客户点的餐品名称。
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，其第一列为餐桌桌号 “Table” ，
 * 后面每一列都是按字母顺序排列的餐品名称。接下来每一行中的项则表示每张餐桌订购的相应餐品数量，
 * 第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/display-table-of-food-orders-in-a-restaurant
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1418_1 {

    public Solution1418_1() {
    }

    //常规解法
    //看了一下题解基本都是这个思路，实现上有些小的优化，这里就没有再去细究了
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> tables = new HashSet<>();
        Set<String> foods = new HashSet<>();
        Map<String, Integer> orderMap = new HashMap<>();
        for (List<String> order : orders) {
            String key = order.get(1) + "_" + order.get(2);
            Integer num = orderMap.getOrDefault(key, 0);
            orderMap.put(key, num + 1);
            tables.add(order.get(1));
            foods.add(order.get(2));
        }

        List<List<String>> res = new ArrayList<>();
        List<String> row1 = new ArrayList<>(foods);
        Collections.sort(row1);
        row1.add(0, "Table");
        res.add(row1);

        List<String> tableList = new ArrayList<>(tables);
        tableList.sort(Comparator.comparingInt(Integer::parseInt));
        for (String table : tableList) {
            List<String> tableOrder = new ArrayList<>();
            tableOrder.add(table);
            for (int i = 1; i < row1.size(); i++) {
                tableOrder.add(String.valueOf(orderMap.getOrDefault(table + "_" + row1.get(i), 0)));
            }
            res.add(tableOrder);
        }
        return res;
    }
}
