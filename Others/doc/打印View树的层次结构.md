# 打印View树的层次结构

## 题目描述
打印`Android`中`View`树的层次结构。
## 解题思路
`View`本身是多叉树的实现，所以通过递归循环遍历即可。<br/>
例如： <br/>
```xml
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1">


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <TextView
                android:id="@+id/tv_result"
                android:layout_width="match_parent"
                android:layout_height="wrap_content" />

            <FrameLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content">

            </FrameLayout>
        </LinearLayout>
    </ScrollView>

    <Button
        android:id="@+id/print_btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="打印View Tree"
        android:textAllCaps="false" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</LinearLayout>
```
### 思路一：
```java
public class Solution {
    /**
     * 打印VIewTree的层次结构
     *
     * @param root view
     * @param deep 层级  用于缩进的
     */
    private String getViewTreeStr(View root, int deep) {
        StringBuilder builder = new StringBuilder();
        if (root != null) {
            builder.append(getSpace(deep)).append("<").append(root.getClass().getSimpleName());
            if (root instanceof ViewGroup) {
                builder.append(">\n\n");
                int childCount = ((ViewGroup) root).getChildCount();
                for (int i = 0; i < childCount; i++) {
                    builder.append(getViewTreeStr(((ViewGroup) root).getChildAt(i), deep + 1));
                }
                builder.append(getSpace(deep)).append("</").append(root.getClass().getSimpleName()).append(">\n");
            } else {
                builder.append("/>\n");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    private static String SPACE = "\t";

    private String getSpace(int deep) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            s.append(SPACE);
        }
        return s.toString();
    }
}
```


