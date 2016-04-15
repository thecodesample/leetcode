/**
 * 
 */
package com.thecodesample.leetcode;

import java.util.List;

/**
 * <pre>
 * Problem：
 * 
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * 
 * For more information, please visit the following website
 * 
 * https://oj.leetcode.com/problems/triangle/
 * 
 * </pre>
 * 
 * @author wangmengjun
 *
 */
public class TriangleSolution {

	/**
	 * 采用由下到上的方式进行遍历。可以定义一个数组int[]
	 * mins，长度n与最后一行的元素个数相等，记录经过某点的数字最小值。数组初始值为最后一行元素的值
	 * 。然后从倒数第二行开始遍历，该行数据个数比它的下一行数据个数要少1，每个节点和它的下一行的两个元素相连, 调整mins
	 * 数组中的元素，mins[j] = currentRowElems.get(j)+ Math.min(mins[j], mins[j +
	 * 1])，一步一步调整，最后数值mins[0]就是我们想要的值。
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {

		int len = triangle.size();
		int[] mins = new int[len];

		// 将最后一行的所有元素全部存放到mins数组中去
		List<Integer> bottomIntList = triangle.get(len - 1);
		for (int i = 0; i < bottomIntList.size(); i++) {
			mins[i] = bottomIntList.get(i);
		}

		// 从倒数第二行开始处理
		for (int i = len - 2; i >= 0; i--) {
			List<Integer> currentRowElems = triangle.get(i);
			int currentListSize = currentRowElems.size();
			for (int j = 0; j < currentListSize; j++) {
				mins[j] = currentRowElems.get(j)
						+ Math.min(mins[j], mins[j + 1]);
			}
		}

		return mins[0];
	}
}
