
# Intro

This below problems are from [the LeetCode OJ](https://leetcode.com/problems/)

## 1. Two Sum

this is the description :

    Given an array of integers, find two numbers such that they add up to a specific target number.  
    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.  
    You may assume that each input would have exactly one solution.    
    Input: numbers={2, 7, 11, 15}, target=9   
    Output: index1=1, index2=2   

## 2. Add Two Numbers

this is the description :

    You are given two linked lists representing two non-negative numbers. 
    The digits are stored in reverse order and each of their nodes contain a single digit.    
    Add the two numbers and return it as a linked list.   
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)   
    Output: 7 -> 0 -> 8  
 
## 3.Longest  Substring Without Repeating characters

this is the description :

    Given a string, find the length of the longest substring without repeating characters.   
    For example, the longest substring without repeating letters for "abcabcbb" is "abc",   
    which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.  

## 5.Longest Palindromic Substring

this is the description : 

    Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,    
    and there exists one unique longest palindromic substring.
    
## 6.ZigZag Conversion

this is the description :

    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
    
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    
    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

## 7.Reverse Integer

this is the description :

    Reverse digits of an integer.
    
    Example1: x = 123, return 321
    Example2: x = -123, return -321
    
    Have you thought about this?
    Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
    
    If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
    
    Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
    
    For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

## 8. String to Integer(atoi)

this is the description :

    Implement atoi to convert a string to an integer.   
    Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.  
    Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
    
## 9. Palindrome Numbe

this is the description :

    Determine whether an integer is a palindrome. Do this without extra space.

## 94. Binary Tree Inorder Traversal

this is the description :

    Given a binary tree, return the inorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,3,2].

    Note: Recursive solution is trivial, could you do it iteratively?

## 96. Unique Binary Search Trees

this is the description :

    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    For example,
    Given n = 3, there are a total of 5 unique BST's.

       1         3     3      2      1
        \       /     /      / \      \
         3     2     1      1   3      2
        /     /       \                 \
       2     1         2                 3

## 100. Same Tree

this is the description :

    Given two binary trees, write a function to check if they are equal or not.
    Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

## 101. Symmetric Tree

this is the description :

    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
    For example, this binary tree is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3
    But the following is not:
        1
       / \
      2   2
       \   \
       3    3
    Note:
    Bonus points if you could solve it both recursively and iteratively.

## 102. Binary Tree Level Order Traversal

this is the description :

    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]

## 103. Binary Tree Zigzag Level Order Traversal

this is the description :

    Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its zigzag level order traversal as:
    [
      [3],
      [20,9],
      [15,7]
    ]

## 104. Maximum Depth of Tree

this is the description :

    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## 105. Construct Binary Tree from Preorder and Inorder Traversal

this is the description :

    Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.

## 107. Binary Tree Level Order Traversal II

this is the description :

    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree {3,9,20,#,#,15,7},
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]

## 108. Convert Sorted Array to Binary Search Tree

this is the description :

    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

## 110. Balanced Binary Tree

this is the description :

    Given a binary tree, determine if it is height-balanced.
    For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

## 111. Minimum Depth of Binary Tree

this is the description :

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

## 114. Flatten Binary Tree to Linked List

this is the description :

    Given a binary tree, flatten it to a linked list in-place.

    For example,
    Given

             1
            / \
           2   5
          / \   \
         3   4   6
    The flattened tree should look like:
       1
        \
         2
          \
           3
            \
             4
              \
               5
                \
                 6
## 144. Binary Tree Preorder Traversal

this is the description :

    Given a binary tree, return the preorder traversal of its nodes' values.

    For example:
    Given binary tree {1,#,2,3},
       1
        \
         2
        /
       3
    return [1,2,3].

    Note: Recursive solution is trivial, could you do it iteratively?

## 173. Binary Search Tree Iterator

this is the description :

    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

    Calling next() will return the next smallest number in the BST.

    Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

## 199. Binary Tree Right Side View

this is the description :

    Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

    For example:
    Given the following binary tree,
       1            <---
     /   \
    2     3         <---
     \     \
      5     4       <---
    You should return [1, 3, 4].

## 208. Implement Trie(Prefix Tree)

this is the description :

    Implement a trie with insert, search, and startsWith methods.

    Note:
    You may assume that all inputs are consist of lowercase letters a-z.

## 226. Invert Binary Tree

this is the description : 

    Invert a binary tree.
    
         4
       /   \
      2     7
     / \   / \
    1   3 6   9
    
    to
    
         4
       /   \
      7     2
     / \   / \
    9   6 3   1
## 235. Lowest Common Ancestor of a Binary Search Tree

this is the description :

    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

            _______6______
           /              \
        ___2__          ___8__
       /      \        /      \
       0      _4       7       9
             /  \
             3   5
    For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
    
## 236. Lowest Common Ancestor of a Binary Tree 

this is the description :

    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    
    According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
    
            _______3______
           /              \
        ___5__          ___1__
       /      \        /      \
       6      _2       0       8
             /  \
             7   4
    For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

## 257. Binary Tree Paths

this is the description :

    Given a binary tree, return all root-to-leaf paths.

    For example, given the following binary tree:

       1
     /   \
    2     3
     \
      5
    All root-to-leaf paths are:

    ["1->2->5", "1->3"]