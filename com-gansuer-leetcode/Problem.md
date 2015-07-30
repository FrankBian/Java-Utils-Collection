
# Intro

This below problems are from [the LeetCode OJ](https://leetcode.com/problems/)

## 1. Two Sum

this is the description :

>Given an array of integers, find two numbers such that they add up to a specific target number.  
>The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.  
>You may assume that each input would have exactly one solution.    
>Input: numbers={2, 7, 11, 15}, target=9   
>Output: index1=1, index2=2   

## 2. Add Two Numbers

this is the description :

>You are given two linked lists representing two non-negative numbers. 
>The digits are stored in reverse order and each of their nodes contain a single digit.    
>Add the two numbers and return it as a linked list.   
>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)   
>Output: 7 -> 0 -> 8  
 
## 3.Longest  Substring Without Repeating characters

this is the description :

>Given a string, find the length of the longest substring without repeating characters.   
>For example, the longest substring without repeating letters for "abcabcbb" is "abc",   
>which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.  

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