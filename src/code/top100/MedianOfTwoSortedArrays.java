package code.top100;

public class MedianOfTwoSortedArrays {

    public static void main(String args[]){

//        int arr1[] = {1,5,8,10,18,20};
//        int arr2[] = {2,3,6,7};

        int arr1[] = {1,2};
        int arr2[] = {3,4};

        System.out.println(findMedianSortedArrays(arr1,arr2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1==null || nums1.length==0 && (nums2!=null && nums2.length>0)){

            int n = nums2.length;
            if(n%2==0){
                return (nums2[n/2]+nums2[(n-1)/2])*1.0/2;
            }
            else{
                return nums2[n/2];
            }
        }

        if(nums2==null || nums2.length==0 && (nums1!=null && nums1.length>0)){

            int n = nums1.length;
            if(n%2==0){
                return (nums1[n/2]+nums1[(n-1)/2])*1.0/2;
            }
            else{
                return nums1[n/2];
            }
        }


            if(nums1.length>nums2.length){
                return getMedian(nums2,nums1);
            }
            else{
                return getMedian(nums1,nums2);
            }

    }

    public static double getMedian(int arr[],int brr[]){

        int n1 = arr.length;
        int n2 = brr.length;
        int totalLength = n1+n2;
        int low = 0;
        int high = arr.length-1;

        while(low<=high){

            System.out.println("Low "+low+" High "+high);
            int cut1 = (high-low)/2 + low;
            int cut2 = (n1+n2+1)/2 - cut1;

            System.out.println("Cut1 "+cut1+" Cut2 "+cut2);

            int max1 = (cut1==0) ? Integer.MIN_VALUE : arr[cut1-1];
            int min1 = (cut1==n1) ? Integer.MAX_VALUE : arr[cut1];

            int max2 = (cut2==0) ? Integer.MIN_VALUE : brr[cut2-1];
            int min2 = (cut2==n2) ? Integer.MAX_VALUE : brr[cut2];

            System.out.println("max1 "+max1+" min1 "+min1+" max2 "+max2+" min2 "+min2);

            if(max1<=min2 && max2<=min1){

                if(totalLength%2==0){
                    return (Math.max(max1,max2)+Math.max(min1,min2))*1.0/2;
                }
                else{
                    return Math.max(max1,max2);
                }
            }
            else if(max1>min2){
                high = cut1-1;
            }
            else{
                low = cut1+1;
            }
        }
        return -1;
    }
}
