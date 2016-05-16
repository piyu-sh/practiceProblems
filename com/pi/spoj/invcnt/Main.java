package com.pi.spoj.invcnt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < testCases; i++) {
			br.readLine();
			int N = Integer.parseInt(br.readLine().trim());
			int[] A = new int[N];
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(br.readLine());
			}
			// int temp[] = new int[A.length];
			long count = 0;
			// count = countByMergeSort(A, temp, 0, A.length - 1);
			// count = countByBubbleSort(A, count);
			System.out.println(count);
		}
	}

	private static long countByMergeSort(int[] a, int[] temp, int left,
			int right) {
		int mid = 0;
		long count = 0;
		if (right > left) {
			mid = (right + left) / 2;
			count += countByMergeSort(a, temp, left, mid);
			count += countByMergeSort(a, temp, mid + 1, right);
			count += merge(a, temp, left, mid + 1, right);
		}
		return count;
	}

	private static long merge(int[] a, int[] temp, int left, int mid, int right) {
		long count = 0;
		int i = left;
		int j = mid;
		int k = left;
		while (i <= mid - 1 && j <= right) {
			if (a[i] <= a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];

				/* this is tricky -- see above explanation/diagram for merge() */
				count = count + (mid - i);
			}
		}
		/*
		 * Copy the remaining elements of left subarray (if there are any) to
		 * temp
		 */
		while (i <= mid - 1)
			temp[k++] = a[i++];

		/*
		 * Copy the remaining elements of right subarray (if there are any) to
		 * temp
		 */
		while (j <= right)
			temp[k++] = a[j++];

		/* Copy back the merged elements to original array */
		for (i = left; i <= right; i++)
			a[i] = temp[i];
		return count;
	}

	private static long countByBubbleSort(int[] A, long count) {
		for (int j = 0; j < A.length - 1; j++) {
			for (int j2 = j + 1; j2 < A.length; j2++) {
				if (A[j] > A[j2]) {
					count++;
				}
			}
		}
		return count;
	}

}
