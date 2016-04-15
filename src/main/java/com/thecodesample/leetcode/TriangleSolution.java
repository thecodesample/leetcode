/**
 * 
 */
package com.thecodesample.leetcode;

import java.util.List;

/**
 * <pre>
 * Problem��
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
	 * �������µ��ϵķ�ʽ���б��������Զ���һ������int[]
	 * mins������n�����һ�е�Ԫ�ظ�����ȣ���¼����ĳ���������Сֵ�������ʼֵΪ���һ��Ԫ�ص�ֵ
	 * ��Ȼ��ӵ����ڶ��п�ʼ�������������ݸ�����������һ�����ݸ���Ҫ��1��ÿ���ڵ��������һ�е�����Ԫ������, ����mins
	 * �����е�Ԫ�أ�mins[j] = currentRowElems.get(j)+ Math.min(mins[j], mins[j +
	 * 1])��һ��һ�������������ֵmins[0]����������Ҫ��ֵ��
	 * 
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {

		int len = triangle.size();
		int[] mins = new int[len];

		// �����һ�е�����Ԫ��ȫ����ŵ�mins������ȥ
		List<Integer> bottomIntList = triangle.get(len - 1);
		for (int i = 0; i < bottomIntList.size(); i++) {
			mins[i] = bottomIntList.get(i);
		}

		// �ӵ����ڶ��п�ʼ����
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
