import java.util.Arrays;

/*
 * Find the largest span of zeroes in a binary number given its decimal equivalent
 * Ex: 72 -> 1001000 will produce 2 because the largest number of zeroes bound by two 
 * 1's is 2.
 * 
 */
public class BinaryGap {
	public static void main(String[] args)
	{
		
		System.out.println(solution(1041));
		System.out.println(solution(72));
		System.out.println(solution(6));
		
		
	}
	
	public static int solution(int N)
	{
		//System.out.println("Param: " + N);
		//convert to binary to manipulate
		String bin = Integer.toBinaryString(N);
		//System.out.println("binary of " + N + ": " + bin);
		//handle case where no ones exist
		if (bin.indexOf("1") == -1) 
			return 0;
		else if (bin.indexOf("0") == -1)
		{
			return 0;
		}
		else
		{
			//remove last element if there is no 1 at the end
			if (bin.charAt(bin.length()-1) != '1')
			{
				bin = bin.substring(0, bin.lastIndexOf('1'));
			}
			
			//get all the gaps
			String[] gaps = bin.split("1");
			
			if (gaps.length == 0)
			{
				//no gaps for cases like "110"
				return 0;
			}
			//System.out.println("gaps length: " + gaps.length);
			//sort the array to find the max value
			Arrays.sort(gaps);
			//return the longest gap
			return gaps[gaps.length-1].length();
		}
	}
}
