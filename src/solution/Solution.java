package solution;

/**
 * Created by Vishal_Mukta on 12/22/2018.
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0) {
            return median(nums2, 0, n - 1);
        }
        if (n == 0) {
            return median(nums1, 0, m - 1);
        }
        if (nums1[m - 1] <= nums2[0]) {
            if ((m + n) % 2 == 1) {
                if (((m + n) / 2) < m) {
                    return nums1[(m + n) / 2];
                } else {
                    return nums2[((m + n) / 2) - m];
                }
            } else {
                if (((m + n) / 2) < m) {
                    return (nums1[((m + n) / 2) - 1] + nums1[(m + n) / 2]) / 2.0;
                } else if (((m + n) / 2) > m) {
                    return (nums2[((m + n) / 2) - 1 - m] + nums2[((m + n) / 2) - m]) / 2.0;
                } else {
                    return (nums1[m - 1] + nums2[0]) / 2.0;
                }
            }
        } else if (nums1[0] >= nums2[n - 1]) {
            if ((m + n) % 2 == 1) {
                if (((m + n) / 2) < n) {
                    return nums2[(m + n) / 2];
                } else {
                    return nums1[((m + n) / 2) - n];
                }
            } else {
                if (((m + n) / 2) < n) {
                    return (nums2[((m + n) / 2) - 1] + nums2[(m + n) / 2]) / 2.0;
                } else if (((m + n) / 2) > n) {
                    return (nums1[((m + n) / 2) - 1 - n] + nums1[((m + n) / 2) - n]) / 2.0;
                } else {
                    return (nums2[n - 1] + nums1[0]) / 2.0;
                }
            }
        }
        if ((m <= 1000) && (n <= 1000)) {
            int res[] = new int[m + n];
            int i = 0, j = 0, k = 0;
            while ((i < m) && (j < n)) {
                if (nums1[i] <= nums2[j]) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums2[j++];
                }
            }
            while (i < m) {
                res[k++] = nums1[i++];
            }
            while (j < n) {
                res[k++] = nums2[j++];
            }/*
            for (i = 0; i < m; i++) {
                res[i] = nums1[i];
            }
            for (j = 0; j < n; j++) {
                res[i + j] = nums2[j];
            }
            Arrays.sort(res);*/
            return median(res, 0, m + n - 1);
        }
        int smaller[];
        int larger[];
        if (m < n) {
            smaller = nums1;
            larger = nums2;
        } else {
            smaller = nums2;
            larger = nums1;
        }
        return median(smaller, 0, m - 1, larger, 0, n - 1);
    }

    private int mid(int first, int last) {
        return first + ((last - first) / 2);
    }

    private double median(int[] nums, int first, int last) {
        int mid = mid(first, last);
        if ((last - first) % 2 == 0) {
            return nums[mid];
        }
        return (nums[mid] + nums[mid + 1]) / 2.0;
    }

    private double median(int[] nums1, int first1, int last1, int[] nums2, int first2, int last2) {
        if ((first1 == last1) && (first2 == last2)) {
            /*if ((nums1.length + nums2.length) % 2 == 1) {
                return nums1[first1] < nums2[first2] ? nums1[first1] : nums2[first2];
            }*/
            return (nums1[first1] + nums2[first2]) / 2.0;
        }
        int mid1 = mid(first1, last1), mid2 = mid(first2, last2);
        double med1 = median(nums1, first1, last1), med2 = median(nums2, first2, last2);
        if (med1 < med2) {
            return median(nums1, ((last1 - first1) % 2 == 1) ? mid1 + 1 : mid1, last1, nums2, first2, last2 - (last1 - mid1));
        } else if (med1 > med2) {
            return median(nums1, first1, mid1, nums2, first2 + (mid1 - first1), last2);
        }
        return med1;
    }
}
