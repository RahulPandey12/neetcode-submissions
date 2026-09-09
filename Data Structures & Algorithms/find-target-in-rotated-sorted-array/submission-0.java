class Solution {

    public int search(int[] nums, int target) {

        // 1. Find minimum element index
        int minIndex = findMinIndex(nums);

        // 2. Search in left sorted part
        int result = binarySearch(nums, target, 0, minIndex - 1);

        if (result != -1) {
            return result;
        }

        // 3. Search in right sorted part
        return binarySearch(nums, target, minIndex, nums.length - 1);
    }

    public int findMinIndex(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}