package javaPractice;

public class practiceArrays {

	public static void dispArray(int[] input) {

		for (int counter = 0; counter < input.length; counter++) {

			System.out.println(input[counter]);

		}

	}

	public static int[] revArray(int[] input) {

		int[] reverse = new int[input.length];

		for (int i = 0, j = reverse.length - 1; i < input.length; i++, j--) {

			reverse[j] = input[i];

		}
		return reverse;

	}

	public static void main(String[] args) {

		int[] marks = new int[] { 22, 50, 60, 90, 78 };
		dispArray(marks);
		int[] revmarks;
		revmarks = revArray(marks);
		System.out.println("The reversed Arrat = ");
		dispArray(revmarks);

	}

}
