package com.offer.sword;

import java.util.LinkedList;

/**
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。 HF作为牛客的资深元老,自然也准备了一些小游戏。
 * 其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * 可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class LastRemaining62 {

    /**
     * 
     * @param n 小朋友编号 0-->n-1
     * @param m 数到第m则删除。0，1，2 则2是第三个
     * @return 最后剩下的那个
     */
    public int solution(int n, int m) {
        if (n < 1 || m < 0) {
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int rm = 0;
        while (list.size() > 1) {
            rm = (rm + m - 1) % list.size();
            list.remove(rm);
        }
        return list.size() == 1 ? list.getFirst() : -1;
    }

    // f(n,m) = {f(n-1,m)+m}%n
    public int solution2(int n, int m) {
        if (n < 1 || m < 0) {
            return -1;
        }
        // 当n=1时，只有一个小孩，剩下的肯定就是他，也就是0号
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}