package sols;

public class MedianSortedArrays {

	public double Solution(int[] nums1, int[] nums2) {
		/*
		 * ATTEMPT 1, I thought the median was the average woops, its just the middle
		 * value or value(s) divided by 2 depending on odd or even m+n. I passed
		 * 2050/2081 test cases with this however..
		 * 
		 * double avg = 0; for (int i = 0; i < (nums1.length >= nums2.length ?
		 * nums1.length : nums2.length); i++) { if (nums2.length == 0 || i >=
		 * nums2.length) avg+=nums1[i]; else if(nums1.length == 0 || i >= nums1.length)
		 * avg+=nums2[i]; else avg+=nums1[i] + nums2[i]; } if (nums2.length == 0) return
		 * avg/nums1.length; if (nums1.length == 0) return avg/nums2.length; else return
		 * avg/(nums1.length+nums2.length);
		 */

		// ATTEMPT 2
		// We know that the median value in a sorted array guarantees us values less
		// then the median to its left
		// and values greater then the median to its right.
		// we know that if the middle value of two sets are the same thats the median.
		// else If the first sets median for example 10 is > than the second sets median
		// lets say 5
		// the median of BOTH sets must necessarily be to the LEFT of 10 in set 1 and to
		// the RIGHT of 5 in set 2
		// We can move our search pointer to the median of [beginning set 1 ..... 10]
		// and [5 .....the end of set 2]
		// in this way we cut the search range in half every iteration.

		double median1;
		double median2;

		if (nums1.length == 0 || nums2.length == 0) {
			if (nums1.length == 0) {
				return median2 = nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2.0
						: nums2[nums2.length / 2];
			} else {
				return median1 = nums1.length % 2 == 0 ? (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2.0
						: nums1[nums1.length / 2];
			}
		}
		
		// At this point neither of them are zero length
		median1 = nums1.length % 2 == 0 ? (nums1[nums1.length / 2] + nums1[(nums1.length / 2) - 1]) / 2.0
				: nums1[nums1.length / 2];
		median2 = nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[(nums2.length / 2) - 1]) / 2.0
				: nums2[nums2.length / 2];

		int pivot1 = nums1.length / 2;
		int pivot2 = nums2.length / 2;

		if (median1 == median2) {
			return median1;
		}
	
		//Now the chopdown
		while (pivot1 !=0 || pivot2 != 0) {

			if (median1 > median2) {
				// We know the common median lies in : arraybegin ...... pivot 1 and pivot2
				// .......array end
				pivot1 /= 2;
				pivot2 += (pivot2 / 2);
				if (pivot2 == 0 && (nums2.length % 2 != 0 || nums1.length %2 !=0)) {
					return Math.min(nums1[pivot1],nums2[pivot2]);
				}
				
				else if (pivot2 == 0 && (nums2.length % 2 == 0 && nums1.length %2 ==0)) {
					return (nums1[pivot1]+nums2[pivot2]) /2.00;
				}
				median1 = (nums1.length - (pivot1+1)) % 2 == 0 && pivot1 != 0 ? (nums1[pivot1] + nums1[(pivot1) - 1]) / 2.0 : nums1[pivot1];
				median2 = (nums2.length- (pivot2+1)) % 2 == 0 && pivot2 != 0 ? (nums2[pivot2] + nums2[(pivot2) - 1]) / 2.0 : nums2[pivot2];
			}
			
			else if (median2 > median1 ) {
				// We know the common median lies in : arraybegin ...... pivot 1 and pivot2
				// .......array end
				pivot2 /= 2;
				pivot1 += (pivot2 / 2);
				if (pivot2 == 0 && (nums2.length % 2 != 0 || nums1.length %2 !=0)) {
					return Math.min(nums1[pivot1],nums2[pivot2]);
				}
				
				else if (pivot2 == 0 && (nums2.length % 2 == 0 && nums1.length %2 ==0)) {
					return (nums1[pivot1]+nums2[pivot2]) /2.00;
				}
				
				median1 = (nums1.length - (pivot1+1)) % 2 == 0 && pivot1 != 0 ? (nums1[pivot1] + nums1[(pivot1) - 1]) / 2.0 : nums1[pivot1];
				median2 = (nums2.length- (pivot2+1)) % 2 == 0 && pivot2 != 0 ? (nums2[pivot2] + nums2[(pivot2) - 1]) / 2.0 : nums2[pivot2];
			}

		}
		return 0.00;

	}

	public static void main(String args[]) {

		int[] nums2 = {1,2,3,4,5,6,7,8,9,10};

		int[] nums1 = {3,4,5,7,8,10};

		double ret = new MedianSortedArrays().Solution(nums1, nums2);

		System.out.print(ret);
	}

}