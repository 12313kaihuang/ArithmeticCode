package ArithmeticCode.SwordToOffer.code;

/**
 * 翻转单词顺序列.md
 */
public class Test44 {

    public static void main(String[] args) {
        System.out.println(new Test44().ReverseSentence("I am a student."));
        System.out.println(new Test44().ReverseSentence2("I am a student."));
        System.out.println(new Test44().ReverseSentence2("Wonderful"));
        System.out.println(new Test44().ReverseSentence2("Hello World!"));
    }

    //通过空格分隔成字符串组，然后再从后向前拼接
    //这里的区分用了api，也可以换成遍历去自己拆分
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        String[] words = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            builder.append(words[i]);
            if (i > 0) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }

    public String ReverseSentence2(String str) {

        if (str == null || str.length() == 0 || str.trim().equals("")) {
            return str;
        }

        char[] chars = str.toCharArray();
        //先翻转整个字符串
        reverse(chars, 0, chars.length - 1);

        //再翻转每个单词
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }

        //翻转最后一个单词
        reverse(chars, start, chars.length - 1);


        return String.valueOf(chars);
    }

    //翻转chars从start 到 end的字符串
    private void reverse(char[] chars, int start, int end) {
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
    }


}
