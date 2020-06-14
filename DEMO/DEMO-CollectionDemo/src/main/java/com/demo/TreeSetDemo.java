package com.demo;



/*
 * TreeSet:能够对元素按照某种规则进行排序。
 * 底层是二叉树结构
 * 元素是如何放进去的？
 * 第一个元素存储时，直接做为根节点存储，
 * 从第二个元素开始，每个元素与根节点比较
 * 大           作为右孩子，
 * 小	作为左孩子
 * 相等       不理他
 *
 * 元素的取出
 *
 * 先序遍历：先根节点，再左子树，再右子数
 * 中序遍历：先左子树，再根节点，再右子数
 * 后序遍历:先左子树,再右子数，再根节点
 *
 * A：自然排序
 * B：比较器排序
 */

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args){
        //自然排序
        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(21);
        ts.add(22);
        ts.add(24);
        ts.add(23);
        ts.add(29);
        ts.add(21);
        ts.add(22);

        for(Integer i : ts){
            System.out.println(i);
        }

    }

}
