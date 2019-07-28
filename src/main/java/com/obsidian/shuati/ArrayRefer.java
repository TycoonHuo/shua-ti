package com.obsidian.shuati;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;

/**
 *
 * 关于数组的刷题
 * 第一个数组几乎完全有序，其中有一个数顺序错了。
 * 从第二个数组中拿出一个最大的满足替换的值。
 *
 *
 * @author huoyun
 * @date 2019/7/28-15:25
 */
public class ArrayRefer {

    public static void change(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // 把第一个放进去
        map.put(arr1[0], 0);

        for (int i = 1; i < arr1.length; i++) {
            int a = arr1[i];
            int b = arr1[i - 1];
            if (a > b) {
                map.put(a, i);
            } else {
                map.put(null, i);
            }
        }
        Integer integer = map.get(null);
        int before = arr1[integer - 1];
        int after = arr1[integer + 1];

        int tmp = 0;
        for (int i = 0; i < arr2.length; i++) {
            int a = arr2[i];
            if (a > before && a < after && a > tmp) {
                tmp = arr2[i];
            }
        }

        arr1[integer] = tmp;

        System.out.println(ToStringBuilder.reflectionToString(arr1, ToStringStyle.JSON_STYLE));
    }


    public static void main(String[] args) {
        int[] arr1 = {7, 4, 10};
        int[] arr2 = {2, 1, 5, 9, 9};
        change(arr1, arr2);
    }
}
