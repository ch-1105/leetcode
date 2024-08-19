package com.ch.lccode.list;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        CanPlaceFlowers canPlaceFlowers = new CanPlaceFlowers();
        int[] flowerbed = {0,0};
        System.out.println(canPlaceFlowers.canPlaceFlowers(flowerbed, 2));
    }
// 太复杂了
//    public boolean canPlaceFlowers(int[] flowerbed, int n) {
//        int count = 0;
//        if (flowerbed.length == 0 || n == 0 ) return true;
//        if (flowerbed.length == 1 && n == 1 && flowerbed[0] == 0) return true;
//        if (flowerbed.length == 1) return false;
//
//        //首尾计算
//        if(flowerbed[1] == 0 && flowerbed[0] == 0){
//            count++;
//            flowerbed[0] = 1;
//        }
//        if (flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0){
//            count++;
//            flowerbed[flowerbed.length-1] = 1;
//        }
//
//        for (int i = 1; i < flowerbed.length-1 ; i++) { //跳过开始位和最后一位
//            if (flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0) {
//                count++;
//                flowerbed[i] = 1;
//            }
//        }
//        return n <= count;
//    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0;) {
            if (flowerbed[i] == 1) { //当前位是1,下一位必定是0 直接跳过
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) { //末尾 或者下一位是空的
                n--;
                i += 2;
            } else { //当前位是0,下一位是1,直接跳三格
                i += 3;
            }
        }
        return n <= 0;
    }
}
