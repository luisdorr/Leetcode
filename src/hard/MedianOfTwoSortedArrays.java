//Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
package hard;

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int numberOfElements = nums1.length + nums2.length;
        int beforeMiddle = 0, afterMiddle = 0, count = 1;
        int indexInNums1 = 0, indexInNums2 = 0;

        while(count <= numberOfElements/2 + 1){
            beforeMiddle = afterMiddle;
            if(indexInNums1 < nums1.length && indexInNums2 < nums2.length){
                if(nums1[indexInNums1] <= nums2[indexInNums2]){
                    afterMiddle = nums1[indexInNums1];
                    indexInNums1++;
                } else if (nums2[indexInNums2] < nums1[indexInNums1]) {
                    afterMiddle = nums2[indexInNums2];
                    indexInNums2++;
                }
            } else if (indexInNums1 < nums1.length && indexInNums2 >= nums2.length) {
                afterMiddle = nums1[indexInNums1];
                indexInNums1++;
            } else if (indexInNums2 < nums2.length && indexInNums1 >= nums1.length) {
                afterMiddle = nums2[indexInNums2];
                indexInNums2++;
            }
            count++;

        }

        if(numberOfElements % 2 == 0){
            return (double)(beforeMiddle + afterMiddle) / 2;
        }
        return afterMiddle;
    }
}
