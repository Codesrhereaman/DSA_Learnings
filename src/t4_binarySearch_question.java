public class t4_binarySearch_question {
    public static void main(String[] args) {
        //Q1 and Q2
//        int [] arr = {85,78,56,23,18,15,10,9,7,6,1};
//        int [] arr2 = {1,4,7,9,12,18,26,35,45,56,67,78,89,99};
//        int target = 18;
//        if(ceiling_element(arr,target) !=-1){
//            System.out.println("Ceiling element for this target "+target+" is: "+ceiling_element(arr,target));
//        }
//        if(floor_element(arr,target) !=-1){
//            System.out.println("Floor element for this target "+target+" is: "+floor_element(arr,target));
//        }
//        printResult(ceiling_floor_element(arr2,target),target);

        //Q3
//        int [] nums = {1,2,4,7,7,7,7,7,8,8,8,10};
//        target = 7;
//        System.out.println(searchRange(nums,target)[0]+" "+searchRange(nums,target)[1]);

        //Q4
//        int[] arr = {
//                 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 282, 283, 284, 285, 286, 287, 288, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 323, 324, 325, 326, 327, 328, 329, 330, 331, 332, 333, 334, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 439, 440, 441, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 565, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 624, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 637, 638, 639, 640, 641, 642, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 671, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 716, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 738, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 860, 861, 862, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999
//        };
//        System.out.println(position(arr,665));

        //Q5
//        int [] arr = {
//                0,1,2,4,2,1
//        };
//        search (arr,3);

//        int[] arr = {
//                2,5,6,0,0,1,2
//        };
//        int target = 3;
//        System.out.println(searchInRotated(arr,target));

        //Q10
//        int [] num1 = {
//                1,2
//        };
//        int [] num2  = {
//                2
//        };
//        System.out.printf("%.5f",findMedianSortedArrays(num1,num2));


    }

    //Q10
//    private static double findMedianSortedArrays(int [] num1,int [] num2){
//        int m = num1.length;
//        int n = num2.length;
//        if (n<m ){
//            return medianVal(num2,num1);
//        }
//        int start = 0;
//        int end = m - 1;
//        int half = (m+n+1) /2 ;
//        while(start <= end){
//            int i = (start + end) / 2; //index values of smaller array
//            int j = (half - i)/2 -2; //make it as index for array 2
//
//            int maxLeftA = (i < 0) ? Integer.MIN_VALUE : num1[i];
//            int minRightA = (i+1 >= m) ? Integer.MAX_VALUE : num1[i+1];
//
//            int maxLeftB = (j < 0) ? Integer.MIN_VALUE : num2[j];
//            int minRightB = (j+1 >= n) ? Integer.MAX_VALUE : num2[j+1];
//            //checking that we had chosen the correct part
//            if(maxLeftA<=minRightB && maxLeftB<=minRightA){
//                if((m+n & 1) ==0){
//                    return (Math.max(maxLeftA,maxLeftB) + Math.min(minRightA,minRightB)) /2f;
//                }
//                else{
//                    return Math.max(maxLeftA,maxLeftB);
//                }
//            }
//
//            else if (maxLeftA > minRightB){
//                end = i - 1;
//            }
//            else {
//                start  = i + 1;
//            }
//        }
//        return -1;
//    }
//    private static double medianVal(int [] num1,int [] num2){
//        int m = num1.length;
//        int n = num2.length;
//
//        if (n < m) {
//            return medianVal(num2, num1);  // ensure num1 is smaller
//        }
//
//        int start = 0;
//        int end = m;
//        int half = (m + n + 1) / 2;
//
//        while (start <= end) {
//            int i = (start + end) / 2;   // partition index in num1
//            int j = half - i;            // partition index in num2
//
//            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : num1[i - 1];
//            int minRightA = (i == m) ? Integer.MAX_VALUE : num1[i];
//
//            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : num2[j - 1];
//            int minRightB = (j == n) ? Integer.MAX_VALUE : num2[j];
//
//            // check correct partition
//            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
//                if ((m + n) % 2 == 0) {
//                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
//                } else {
//                    return Math.max(maxLeftA, maxLeftB);
//                }
//            }
//            else if (maxLeftA > minRightB) {
//                end = i - 1; // move left
//            }
//            else {
//                start = i + 1; // move right
//            }
//        }
//        return -1; // should not reach
//    }


    //Q9
//    public int splitArray(int[] nums, int k) {
//        int start = 0;
//        int end = 0;
//        for (int j : nums) {
//            start = Math.max(start, j);
//            end += j;
//        }
//
//        while(start < end){
//            int count = 0;
//            int thisSum = 0;
//            int mid = start + (end - start) /2;
//            for (int num : nums){
//                //creates array util sum reaches mid
//                if (num + thisSum > mid){
//                    thisSum = num;
//                    count ++;
//                    if (count > k) break;
//                }
//                else{
//                    thisSum += num;
//                }
//            }
//            if(count < k){
//                end = mid;
//            }
//            else {
//                start = mid +1;
//            }
//        }
//        return end;
//
//    }
//
//
//    //Q8 what is the rotation count in rotated sorted array ->  find pivot (pivot + 1) times the array is rotated
//    //Q7 search in rotated sorted array
//    private static boolean searchInRotated(int [] nums,int target){
//        int pivot = pivotFindInDuplicates(nums);
//        boolean firstFound = search(nums,target,0,pivot) ;
//        if (firstFound){
//            return true;
//        }
//        else{
//            return search(nums,target,pivot+1,nums.length - 1);
//        }
//    }
//    private static int pivotFindInDuplicates(int [] arr){
//        int start = 0;
//        int end = arr.length -1;
//        int mid ;
//        while (start <= end){
//            mid = start + (end-start) /2;
//            if (mid < end &&  arr[mid] > arr[mid+1]){
//                return mid;
//            }
//            if(start < mid && arr[mid] < arr[mid-1]){
//                return mid-1;
//            }
//            //removing duplicates after checking them for pivot
//            //tell me if array must have duplicates for this or not
//            if (arr[mid] == arr[start] && arr[end] == arr[mid]){
//                if (start <mid && arr[start] > arr[start+1]) {
//                    return start;
//                }
//                start ++;
//                if (end > mid && arr[end]  < arr[end-1]){
//                    return end;
//                }
//                end--;
//            }
//            else if(arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]){
//                start = mid + 1;
//            }
//            else{
//                end = mid -1;
//            }
//        }
//        return -1;
//    }
//    private static boolean search(int[] arr,int target,int start,int end){
//        int mid;
//        while(end >= start){
//            mid = (start + end)/2;
//            if(arr[mid]==target){
//                return true;
//            } else if (arr[mid]>target) {
//                end = mid-1;
//            }
//            else{
//                start = mid+1;
//            }
//        }
//        return false;
//    }
//    private static int pivotFind(int [] arr){
//        int start = 0;
//        int end = arr.length -1;
//        int mid ;
//        while (start <= end){
//            mid = start + (end-start) /2;
//            if (end > mid && arr[mid] > arr[mid+1]){
//                return mid;
//            } else if (start  <mid && arr[start] > arr[mid]) {
//                end = mid-1;
//            }
//            else{
//                start = mid+1;
//                end = mid;
//            }
//        }
//        return end;
//    }

    //Q6
//    public static int search(int [] arr,int target){
//        int peakElementIndex = peakIndexInMountainArray(arr);
//        int index1 = OrderAgnosticBS(arr,target,0,peakElementIndex);
//        int index2 = OrderAgnosticBS(arr,target,peakElementIndex+1,arr.length-1);
//        return Math.min(index1,index2);
//    }
//    static int OrderAgnosticBS(int[] arr,int target,int start,int end){
//        boolean isAsc = arr[start] < arr[end];
//
//        while(end >= start){
//            int mid = start + (end - start)/2;
//            if(arr[mid]==target){
//                return mid;
//            }
//            if(isAsc){
//                if (arr[mid]>target) {
//                    end = mid-1;
//                }
//                else{
//                    start = mid+1;
//                }
//            }
//            else{
//                if (arr[mid]<target) {
//                    end = mid-1;
//                }
//                else{
//                    start = mid+1;
//                }
//            }
//
//        }
//        System.out.println("element not found");
//        return -1;
//    }
//    //Q5
//    public static int peakIndexInMountainArray(int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//        int mid ;
//        while (end > start) {
//            mid = start + (end - start) / 2;
//            if (arr[mid+1] < arr[mid] ){
//                end = mid - 1;
//            }
//            else {
//                start = mid + 1;
//            }
//        }
//        return start;
//    }
//    //Q4
//    public static int position(int[] arr,int target){
//        int start = 0;
//        int end = 2,mid;
//        while (arr[end] < target){
//            start = end;
//            end = 2*start;
//            if(end>= arr.length){
//                end = arr.length -1;
//            }
//        }
//        while (end >= start) {
//            mid = start + (end - start) / 2;
//            if (arr[mid] > target) {
//                end = mid - 1;
//            }
//            else if(arr[mid] < target){
//                start = mid + 1;
//            }
//            else{
//                return mid;
//            }
//        }
//        return -1;
//    }
//    //Q3
//    public static int [] searchRange(int[] nums , int target){
//        int [] ans = {-1,-1};
//        int start = search(nums,target,true);
//        int end = search(nums,target,false);
//        ans[0] = start;
//        ans[1] = end;
//        return ans ;
//    }
//    public static int search(int[] nums, int target,boolean StartEndIndex) {
//        int start = 0;
//        int end = nums.length - 1;
//        int mid = 0;
//        int ans =-1 ;
//
//        while (end >= start) {
//            mid = start + (end - start) / 2;
//            if (nums[mid] > target) {
//                end = mid - 1;
//            }
//            else if(nums[mid] < target){
//                start = mid + 1;
//            }
//            else{
//                ans = mid;
//                if(StartEndIndex){
//                    end = mid-1;
//                }
//                else{
//                    start = mid+1;
//                }
//            }
//        }
//        return ans;
//    }
//    //Q2 Find  the smallest letter greater than target -> 744 in leetcode
//
//    //Q1 Find floor and ceiling of the target element in the array
//    //printing the result
//    static void printResult(int[] result,int target) {
//        if (result[0] == -1) System.out.println("there is no possible element in this array that is ceiling for target");
//        else System.out.println("Ceiling element for this target "+target+" is: "+result[0]);
//        if (result[1] == -1) System.out.println("there is no possible element in this array that is floor for target");
//        else System.out.println("floor element for this target "+target+" is: "+result[1]);
//    }
//    //finding ceiling or floor using a same loop
//    static int[] ceiling_floor_element(int[] arr,int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        boolean isAsc = arr[start] < arr[end];
//
//        while (end >= start) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] == target) {
//                return new int [] {arr[mid],arr[mid]} ;
//            }
//            if (isAsc) {
//                if (arr[mid] > target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else {
//                if (arr[mid] < target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }
//        Integer ceiling = (isAsc ? (start < arr.length ? arr[start] : null )
//                : (-1 < end ? arr[end] : null));
//        Integer floor = (isAsc ? (-1 < end ? arr[end] : null )
//                : (start < arr.length ? arr[end] : null));
//        return new int[]{ceiling != null ? ceiling : -1,  floor != null ? floor : -1};
//    }
//    //finding the ceiling element in a sorted array
//    static int ceiling_element(int[] arr,int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        boolean isAsc = arr[start] < arr[end];
//
//        while (end >= start) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] == target) {
//                return arr[mid];
//            }
//            if (isAsc) {
//                if (arr[mid] > target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else {
//                if (arr[mid] < target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }
//        if (isAsc){
//            if(start < arr.length){
//                return arr[start];
//            }
//        }
//        else {
//            if (end > -1) {
//                return arr[end];
//            }
//        }
//        System.out.println("there is no possible element in this array that is ceiling for target");
//        return -1;
//    }
//    //finding the floor of any element
//    static int floor_element(int[] arr,int target) {
//        int start = 0;
//        int end = arr.length - 1;
//        boolean isAsc = arr[start] < arr[end];
//
//        while (end >= start) {
//            int mid = start + (end - start) / 2;
//            if (arr[mid] == target) {
//                return arr[mid];
//            }
//            if (isAsc) {
//                if (arr[mid] > target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            } else {
//                if (arr[mid] < target) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }
//        if (isAsc){
//            if(-1 < end){
//                return arr[end];
//            }
//        }
//        else {
//            if (start < arr.length) {
//                return arr[start];
//            }
//        }
//        System.out.println("there is no possible element in this array that is floor for target");
//        return -1;
//    }
}
