package net.picenter.pictest.sort;

public class SortDemo {

	public static void main(String[] args) {
		int[] array = new int[] { 3, 5, 1, -1, 9, -5, 11, 15, 17, -1, 23, 33, 6, 16 };
		printInt(array);
		fastSort(array);
		printInt(array);

	}

	private static String printInt(int[] array) {
		if (null == array) {
			return null;
		}
		StringBuilder sb = new StringBuilder("[");
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
			sb.append(',');
		}
		if (array.length > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.append("]");
		System.out.println(sb.toString());
		return sb.toString();
	}

	private static void swap(int[] array, int i, int j) {
		if (null == array || array.length == 0 || i >= array.length || j >= array.length || i == j) {
			return;
		}
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}

	public static void selectSort(int[] array) {
		System.out.println("select sort ...");
		if (null == array || array.length == 0) {
			return;
		}
		int selected = 0;
		for (int i = 0; i < array.length; i++) {
			selected = i;
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[selected]) {
					selected = j;
				}
			}
			swap(array, i, selected);
		}
	}

	public static void paoSort(int[] array) {
		System.out.println("pao sort ...");
		if (null == array || array.length == 0) {
			return;
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					swap(array, j, j + 1);
				}
			}
		}
	}

	public static void fastSort(int[] array) {
		System.out.println("fast sort ...");
		if (null == array || 0 == array.length) {
			return;
		}
		fastPartition(array, 0, array.length-1);
	}

	private static void fastPartition(int[] array, int begin, int end) {
		System.out.println("begin=" + begin + "\t" + "end=" +end);
		if (null == array || 0 == array.length || begin >= array.length || end >= array.length || begin >= end) {
			return;
		}
		
		int s = begin + 1;
		int e = end;
		System.out.println("s=" + s + "\t" + "e=" +e);
		while (s <= end && e >= begin + 1 && s < e) {
			for (; array[e] > array[begin] && s < e; e--)
				;
			for (; array[s] < array[begin] && s < e; s++)
				;
			if (s < e) {
				swap(array, s, e);
			}
		}
		if (s != e) {
			System.out.println("bingo, error\t" + s + "\t" + e);
		}
		if (array[begin] > array[s]) {
			swap(array, begin, s);
		}
		fastPartition(array, begin, s - 1);
		fastPartition(array, e + 1, end);
	}
}
