package ArithmeticCode.SwordToOffer.code;

/**
 * 替换空格
 * Created by Hy on 2019/11/11 19:50
 */
public class Test2 {

    public class Solution {
        public String replaceSpace(StringBuffer str) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == ' ') {
                    builder.append("%20");
                } else {
                    builder.append(charAt);
                }
            }
            return builder.toString();
        }
    }

    public class Solution2 {
        public String replaceSpace(StringBuffer str) {
            int spaceNum = 0;
            //计算空格的数量
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') spaceNum++;
            }
            if (spaceNum == 0) return str.toString();

            //替换后的长度
            int newLength = str.length() + spaceNum * 2;

            int indexOld = str.length() - 1;  //原串末尾下标
            str.setLength(newLength);  //设置新的长度
            int indexNew = newLength - 1;  //新串末尾下标
            while (indexOld >= 0 && indexOld <= indexNew) {
                if (str.charAt(indexOld) == ' ') {
                    //替换空格
                    str.setCharAt(indexNew--, '0');
                    str.setCharAt(indexNew--, '2');
                    str.setCharAt(indexNew--, '%');
                } else {
                    str.setCharAt(indexNew--, str.charAt(indexOld));
                }
                indexOld--;
            }
            return str.toString();
        }
    }
}
