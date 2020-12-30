package common.sort;

@SuppressWarnings("unused")
public class QuickSort {

    //快排升序排序
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int l = left, r = right;
        //这里要直接记值，而不是下标！因为过程中位置会变化
        int provit = array[(left + right) / 2];
        while (l <= r) {
            while (l <= r && array[l] < provit) l++;
            while (l <= r && array[r] > provit) r--;
            if (l <= r) {
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        quickSort(array, left, r);
        quickSort(array, l, right);
    }
}
