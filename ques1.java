import java.util.Scanner;
//SID - 18103073
//By :  Madhav Oberoi
public class ques1 {
	public static void main(final String[] args) {
		System.out.println("Enter the first string");
		// taking user input
		final Scanner scan = new Scanner(System.in);
		String mainString, pattern;
		mainString = scan.nextLine();

		System.out.println("Enter the second string");
		pattern = scan.next();

		scan.close();
		int z = 0, ans = 0;
		final int len1 = mainString.length(), len2 = pattern.length();
		// checking if pattern's length is greater than that of string in which we need
		//here we are using sliding window technique otherwise we can also check every substring of length len2 and sort them to check equality with sorted pattern string
		if (len1 < len2)
			System.out.println("0");
		else {
			int[] count1;

			count1 = new int[256];

			int[] count2;

			count2 = new int[256];

			for (int i = 0; i < len2; i++)
				count2[(int) pattern.charAt(i)]++;

			for (int i = 0; i < len2; i++) {

				int k = (int) mainString.charAt(i);
				if (count1[k] < count2[k])
					z++;
				count1[k]++;

				if (z == len2)
					ans++;
			}

			for (int i = len2; i < len1; i++) {
				int k = (int) mainString.charAt(i);
				int p = (int) mainString.charAt(i - len2);

				if (count1[p] <= count2[p])
					z--;

				count1[p]--;

				if (count1[k] < count2[k])
					z++;

				count1[k]++;

				if (z == len2)
					ans++;
			}
			System.out.println("Total count of pattern in given string is");
			System.out.println(ans);
		}
	}

}
