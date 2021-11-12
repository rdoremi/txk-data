package com.leetcode;

import com.data.set.Set;

import java.nio.charset.StandardCharsets;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

public class LeetCode {
    public static int countGoodTriplets(int[] arr, int a, int b, int c) {

        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                        result++;
                    }
                }
            }
        }
        return result;

        /*测试： int[] arr = {1,1,2,2,3};
        int  a = 0, b = 0, c = 1;
        int i = countGoodTriplets(arr, a, b, c);
        System.out.println(i);*/

    }

    /*实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
    示例 1：
    输入: s = "leetcode"
    输出: false */
    public static boolean isUnique(String astr) {
       /* HashSet hashSet = new HashSet();
        for (int i = 0; i < astr.length(); i++) {
            hashSet.add(astr.charAt(i));

        }
        if (hashSet.size() == astr.length()){
            return true;
        }
        return false;*/
        int k = 0;
        for (int i = 0; i < astr.length(); i++) {

            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    k++;
                }
            }
        }
        if (k > 0) {
            return false;
        }
        return true;
        /* boolean rs = isUnique("adsf");
        System.out.println(rs);*/
    }

    /*
    * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
    *示例 1：
        输入: s1 = "abc", s2 = "bca"
        输出: true
        示例 2：

        输入: s1 = "abc", s2 = "bad"
        输出: false

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/check-permutation-lcci
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    * */
    public static boolean checkPermutation(String s1, String s2) {
       /* if (s1.length() != s2.length()) {
            return false;
        }
        List list = new ArrayList();
        for (int i = 0; i < s1.length(); i++) {
            list.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(s2.charAt(i))){
                    list.remove(j);
                }
            }
        }
        if (!list.isEmpty()){
            return false;
        }
        return true;*/
        //如果两个字符串不相等，直接返回false
        if (s1.length() != s2.length())
            return false;
        int[] nums = new int[128];
        int len = s1.length();
        //先统计字符串s1中每个字符的数量
        for (int i = 0; i < len; i++) {
            nums[s1.charAt(i) - 'A']++;
        }
        //然后在减去s2中每个字符的数量，如果有小于0的，直接返回false
        for (int i = 0; i < len; i++) {
            if (--nums[s2.charAt(i) - 'A'] < 0)
                return false;
        }
        return true;

        /*  char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);
        return new String(c1).equals(new String(c2));
*/
    }
    /*URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
    示例 1：
    输入："Mr John Smith    ", 13
    输出："Mr%20John%20Smith"

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/string-to-url-lcci*/

    public static String replaceSpaces(String s, int length) {

       /* String[] c = new String[length];
        for (int i = 0; i < length; i++) {
            c[i] = String.valueOf(s.charAt(i));
        }*/
        String str = s.substring(0, length).replace(" ", "%20");

        return str;
    }

    /* 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
     示例1:
     输入："aabcccccaaa"
     输出："a2b1c5a3"
     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/compress-string-lcci*/
    public static String compressString(String S) {

        String str = "";
        for (int i = 0; i < S.length(); i++) {
            int k = 1;
            int j = i + 1;
            while (j < S.length() && S.charAt(i) == S.charAt(j++)) {
                k++;
            }
            str += (String.valueOf(S.charAt(i)) + k);
            i += k - 1;
        }
        if (str.length() > S.length()) {
            return S;
        }
        return str;


        /*
        * if (S.length() == 0) { // 空串处理
            return S;
        }
        StringBuffer ans = new StringBuffer();
        int cnt = 1;
        char ch = S.charAt(0);
        for (int i = 1; i < S.length(); ++i) {
            if (ch == S.charAt(i)) {
                cnt++;
            } else {
                ans.append(ch);
                ans.append(cnt);
                ch = S.charAt(i);
                cnt = 1;
            }
        }
        ans.append(ch);
        ans.append(cnt);
        return ans.length() >= S.length() ? S : ans.toString();*/
    }

    /*字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

    示例1:

     输入：s1 = "waterbottle", s2 = "erbottlewat"
     输出：True

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/string-rotation-lcci
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length() || "".equals(s1) || "".equals(s2)) {
            return false;
        }
        String str = "";
        for (int i = 0; i < s1.length(); i++) {
            String temp = s1.substring(0, i);
            String temp2 = s1.substring(i);
            String st = temp2 + temp;
            if (st.equals(s2)) {
                return true;
            }
        }
        return false;
    }

    /*编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

    示例1:

     输入：[1, 2, 3, 3, 2, 1]
     输出：[1, 2, 3]*/
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode head;
    private int size;

    public LeetCode() {
        size = 0;
    }

    private void add(int val) {
        if (head == null) {
            head = new ListNode(val);
            size++;
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(val);
        size++;
    }

    private void add(ListNode node, int val) {
        if (node == null) {
            node = new ListNode(val);
            size++;
            return;
        }

        ListNode cur = node;
        while (cur.next != null) {
            if (cur.val != val) {
                cur = cur.next;
            } else {
                break;
            }

        }
        cur.next = new ListNode(val);
        size++;
    }

    private void print() {
        System.out.println("size = " + size);
        ListNode cc = head;
        System.out.println(cc.val);
        while (cc.next != null) {
            cc = cc.next;
            System.out.println(cc.val);
        }
    }


    public ListNode removeDuplicateNodes() {
        /*ListNode node = null;
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        node = new ListNode(cur.val);
        while (cur.next != null) {
            cur = cur.next;
            ListNode tCur = node;
            while (tCur.next != null) {

                if (cur.val == tCur.val) {
                    break;
                }
                    tCur = tCur.next;

            }
            if (tCur.next == null) {
                tCur.next = new ListNode(cur.val);
            }
        }

        head = node;

        return node;*/
        if (head == null)
            return null;
        HashSet<Integer> set = new HashSet();
        ListNode cur = head;
        set.add(cur.val);
        while (cur.next != null) {
            if (set.add(cur.next.val)) {
                cur = cur.next;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;


    }
    public static int id;

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek =date.getDayOfWeek();
        System.out.println(dayOfWeek.getValue());
        LeetCode code=new LeetCode();
        code.id=50;
        System.out.println(code.id);
    }
}
