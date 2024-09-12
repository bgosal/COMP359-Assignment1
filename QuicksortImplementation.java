import java.util.Arrays;
import java.util.Random;

public class QuicksortImplementation{


    public static void quicksort(int[] array, int starting_index, int ending_index, String pivot_position){
        //System.out.println("Quicksort called on: " + Arrays.toString(array) + " from index " + starting_index + " to " + ending_index);
        if(starting_index < ending_index){
            
            int pivot_index = partition(array, starting_index, ending_index, pivot_position);

            quicksort(array, starting_index, pivot_index-1, pivot_position);
            quicksort(array, pivot_index+1, ending_index, pivot_position);

        }

        
        
    }  


    public static int partition(int []array, int starting_index, int ending_index, String pivot_position){
        
        int pivot_Index = choosePivot(array, starting_index, ending_index, pivot_position);
        int pivot_Value = array[pivot_Index];

        swap(array, pivot_Index, ending_index);


        pivot_Index = ending_index;

        int i = starting_index;
        int j = ending_index-1;

        //System.out.println("Partitioning: " + Arrays.toString(array) + " with pivot value " + pivot_Value);

        while (i<=j){
            while (i<=j && array[i]<=pivot_Value){
                i++;
            }

            while (i<=j && array[j]>=pivot_Value){
                j--;
            }   

            if (i<j){
                swap(array, i, j);
                i++;
                j--;
            }

        }

        swap(array,i, ending_index);
       // System.out.println("Partitioned: " + Arrays.toString(array) + " with pivot index " + i);
        return i;
        
    }

    public static int choosePivot(int [] array, int starting_index, int ending_index, String pivot_position){ //only choose the middle pivot for now 
        
        Random random = new Random();


        if (pivot_position.equals("first")){
            return starting_index;
        }

        else if (pivot_position.equals("last")){
            return ending_index;
        }

        else if (pivot_position.equals("middle")){
            return (starting_index + ending_index) / 2;
        }


        else if (pivot_position.equals("random")){
            return random.nextInt(ending_index - starting_index + 1) + starting_index;
        }

        else{
            
            return random.nextInt(ending_index - starting_index + 1) + starting_index;
        }

        
     
        
    }

    public static void swap(int []array, int index1, int index2){

        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

    }




    public static void main(String args[]){

    
        // these are just some random test arrays 
        // to be updated with the correct ones later
         int[] array1 = {8, 1, 6, 9, 6, 3, 5, 2, 7, 0};
         System.out.println("Original Array 1: " + Arrays.toString(array1));

        String[] positions ={"first", "last", "middle", "random"};

        for (String pivots : positions){
            int[] arrayCopy = array1.clone();
            
            quicksort(arrayCopy, 0, arrayCopy.length - 1, pivots);
            System.out.println("Sorted Array 1 with: " + pivots + " pivot" + Arrays.toString(arrayCopy));
        }

    

		// int[] array1 = {8, 1, 6, 9, 6, 3, 5, 2, 7, 0};
        // System.out.println("Original Array 1: " + Arrays.toString(array1));
        // quicksort(array1, 0, array1.length - 1);
        // System.out.println("Sorted Array 1: " + Arrays.toString(array1));

    	int[] a1 = {3, 7, 12, 18, 24, 31, 39, 46, 52, 60};    //10, sorted
    	int[] a2 = {42, 15, 7, 30, 22, 56, 3, 18, 9, 37};	  //10, unsorted 
    	int[] a3 = {100, 87, 75, 64, 53, 42, 31, 22, 14, 7};  //10, reverse-sorted
    	int[] a4 = {1, 4, 8, 12, 17, 22, 27, 32, 37, 42,
    	            47, 52, 57, 62, 67, 72, 77, 82, 87, 92,
    	            97, 102, 107, 112, 117, 122, 127, 132, 137, 142,
    	            147, 152, 157, 162, 167, 172, 177, 182, 187, 192,
    	            197, 202, 207, 212, 217, 222, 227, 232, 237, 242,
    	            247, 252, 257, 262, 267, 272, 277, 282, 287, 292,
    	            297, 302, 307, 312, 317, 322, 327, 332, 337, 342,
    	            347, 352, 357, 362, 367, 372, 377, 382, 387, 392,
    	            397, 402, 407, 412, 417, 422, 427, 432, 437, 442,
    	            447, 452, 457, 462, 467, 472, 477, 482, 487, 492
    	           }; //100, sorted
    	int[] a5 = {73, 29, 55, 14, 89, 42, 3, 68, 95, 37,
    				61, 8, 83, 25, 50, 12, 77, 39, 91, 6,
    				58, 19, 82, 45, 97, 31, 64, 2, 70, 36,
    				93, 17, 52, 80, 11, 48, 75, 22, 87, 5,
    				60, 33, 99, 16, 44, 71, 9, 56, 84, 27,
    				63, 1, 79, 35, 92, 20, 51, 67, 13, 88,
    				46, 74, 7, 98, 30, 57, 86, 23, 69, 41,
    				94, 10, 62, 38, 85, 18, 53, 76, 4, 96,
    				32, 66, 21, 81, 47, 90, 15, 59, 34, 78,
    				43, 100, 26, 72, 40, 65, 24, 54, 28, 49
    		       };  //100, unsorted
    	int[] a6 = {200, 198, 196, 194, 192, 190, 188, 186, 184, 182,
    				180, 178, 176, 174, 172, 170, 168, 166, 164, 162,
    				160, 158, 156, 154, 152, 150, 148, 146, 144, 142,
    				140, 138, 136, 134, 132, 130, 128, 126, 124, 122,
    				120, 118, 116, 114, 112, 110, 108, 106, 104, 102,
    				100, 98, 96, 94, 92, 90, 88, 86, 84, 82,
    				80, 78, 76, 74, 72, 70, 68, 66, 64, 62,
    				60, 58, 56, 54, 52, 50, 48, 46, 44, 42,
    				40, 38, 36, 34, 32, 30, 28, 26, 24, 22,
    				20, 18, 16, 14, 12, 10, 8, 6, 4, 2
    				}; //100, reverse-sorted
    	int[] a7 = 	{1, 4, 10, 16, 21, 27, 29, 34, 37, 40, 44, 46, 52, 56, 61, 65, 68, 73, 76, 80, 86, 92, 95, 98, 100, 102, 108, 111, 114, 118, 120, 124, 126, 128, 131, 133, 139, 141, 145, 150, 152, 154, 159, 163, 168, 174, 178, 180, 185, 190, 196, 199, 201, 203, 209, 211, 213, 218, 222, 226, 230, 236, 239, 243, 249, 254, 257, 260, 263, 267, 269, 273, 277, 283, 286, 292, 295, 298, 304, 307, 311, 315, 317, 319, 325, 329, 334, 336, 341, 345, 347, 349, 354, 356, 361, 367, 372, 375, 377, 379, 383, 386, 390, 393, 396, 398, 403, 406, 410, 413, 416, 421, 424, 429, 434, 439, 441, 446, 448, 452, 457, 462, 467, 472, 477, 482, 485, 491, 495, 499, 505, 511, 515, 518, 522, 526, 531, 535, 540, 544, 548, 553, 558, 561, 565, 568, 573, 577, 583, 585, 587, 591, 596, 600, 606, 611, 614, 620, 624, 627, 630, 635, 639, 645, 649, 653, 655, 659, 662, 668, 673, 677, 681, 687, 693, 695, 697, 699, 703, 705, 711, 714, 716, 719, 723, 725, 727, 731, 734, 739, 741, 745, 748, 752, 758, 760, 764, 767, 769, 773, 778, 782, 785, 790, 796, 798, 801, 806, 811, 814, 818, 822, 828, 832, 838, 842, 848, 850, 856, 861, 863, 866, 871, 874, 876, 879, 882, 884, 888, 890, 893, 897, 901, 905, 908, 914, 917, 921, 926, 928, 931, 936, 942, 946, 949, 951, 957, 963, 969, 972, 976, 980, 984, 989, 992, 998, 1000, 1003, 1006, 1009, 1012, 1018, 1022, 1027, 1030, 1034, 1039, 1043, 1049, 1051, 1057, 1061, 1066, 1068, 1073, 1078, 1081, 1085, 1089, 1093, 1095, 1099, 1102, 1107, 1113, 1118, 1123, 1129, 1133, 1139, 1145, 1151, 1157, 1163, 1168, 1174, 1177, 1179, 1184, 1186, 1191, 1193, 1196, 1202, 1206, 1210, 1213, 1215, 1221, 1223, 1227, 1230, 1232, 1238, 1241, 1247, 1249, 1255, 1260, 1264, 1268, 1270, 1276, 1281, 1283, 1289, 1291, 1294, 1300, 1304, 1309, 1312, 1318, 1321, 1327, 1332, 1337, 1340, 1342, 1345, 1349, 1352, 1354, 1359, 1364, 1370, 1376, 1379, 1384, 1387, 1389, 1393, 1396, 1401, 1405, 1408, 1412, 1418, 1423, 1426, 1429, 1435, 1438, 1442, 1448, 1450, 1455, 1461, 1464, 1468, 1474, 1476, 1478, 1480, 1483, 1488, 1492, 1494, 1497, 1499, 1504, 1510, 1516, 1519, 1522, 1524, 1529, 1534, 1538, 1542, 1546, 1552, 1557, 1561, 1564, 1566, 1570, 1572, 1574, 1576, 1578, 1584, 1587, 1593, 1596, 1602, 1606, 1612, 1614, 1619, 1621, 1627, 1630, 1633, 1639, 1643, 1648, 1651, 1656, 1661, 1664, 1667, 1670, 1672, 1676, 1682, 1685, 1688, 1694, 1697, 1699, 1704, 1707, 1713, 1719, 1722, 1728, 1730, 1734, 1739, 1742, 1748, 1750, 1755, 1760, 1763, 1767, 1772, 1776, 1778, 1782, 1786, 1789, 1792, 1795, 1798, 1802, 1806, 1811, 1814, 1818, 1821, 1824, 1827, 1832, 1836, 1842, 1844, 1847, 1853, 1859, 1862, 1866, 1871, 1875, 1879, 1881, 1883, 1885, 1890, 1895, 1901, 1903, 1907, 1909, 1913, 1918, 1923, 1925, 1928, 1931, 1936, 1940, 1946, 1951, 1957, 1960, 1963, 1968, 1972, 1976, 1980, 1986, 1992, 1997, 2000, 2002, 2004, 2008, 2010, 2016, 2021, 2023, 2029, 2034, 2040, 2043, 2046, 2049, 2053, 2059, 2065, 2069, 2072, 2077, 2080, 2082, 2085, 2091, 2097, 2099, 2103, 2108, 2112, 2118, 2123, 2129, 2133, 2139, 2142, 2145, 2151, 2157, 2160, 2165, 2171, 2174, 2180, 2185, 2191, 2195, 2199, 2201, 2203, 2208, 2210, 2215, 2217, 2222, 2224, 2230, 2232, 2236, 2239, 2245, 2247, 2249, 2254, 2259, 2265, 2267, 2272, 2274, 2278, 2280, 2286, 2290, 2293, 2295, 2297, 2301, 2304, 2308, 2310, 2315, 2321, 2326, 2329, 2331, 2335, 2338, 2343, 2347, 2353, 2359, 2361, 2365, 2371, 2375, 2377, 2383, 2389, 2393, 2396, 2402, 2404, 2410, 2413, 2419, 2425, 2429, 2434, 2438, 2440, 2443, 2445, 2447, 2449, 2451, 2454, 2459, 2465, 2471, 2473, 2476, 2481, 2484, 2487, 2491, 2497, 2503, 2505, 2511, 2514, 2517, 2522, 2525, 2528, 2532, 2536, 2538, 2541, 2544, 2550, 2555, 2560, 2566, 2568, 2570, 2575, 2581, 2583, 2586, 2589, 2591, 2596, 2598, 2600, 2606, 2609, 2613, 2616, 2620, 2626, 2632, 2637, 2642, 2648, 2653, 2656, 2660, 2662, 2668, 2672, 2675, 2680, 2684, 2689, 2693, 2699, 2701, 2707, 2710, 2716, 2722, 2724, 2727, 2731, 2733, 2737, 2742, 2748, 2751, 2757, 2762, 2764, 2766, 2770, 2773, 2777, 2782, 2786, 2789, 2794, 2800, 2805, 2807, 2811, 2815, 2817, 2820, 2826, 2831, 2837, 2839, 2845, 2851, 2857, 2860, 2865, 2869, 2875, 2877, 2879, 2885, 2890, 2894, 2897, 2899, 2901, 2903, 2908, 2913, 2919, 2925, 2929, 2932, 2935, 2941, 2945, 2950, 2954, 2957, 2962, 2964, 2968, 2974, 2980, 2984, 2990, 2992, 2998, 3001, 3006, 3008, 3011, 3013, 3019, 3023, 3026, 3028, 3034, 3037, 3040, 3046, 3052, 3058, 3060, 3066, 3069, 3071, 3077, 3083, 3088, 3091, 3094, 3098, 3100, 3103, 3108, 3114, 3120, 3122, 3127, 3129, 3132, 3138, 3143, 3148, 3151, 3156, 3162, 3168, 3173, 3175, 3181, 3185, 3187, 3189, 3195, 3200, 3205, 3208, 3212, 3217, 3223, 3229, 3233, 3239, 3241, 3247, 3251, 3253, 3256, 3262, 3264, 3266, 3271, 3277, 3279, 3281, 3286, 3292, 3295, 3298, 3303, 3309, 3313, 3319, 3324, 3326, 3330, 3334, 3338, 3341, 3344, 3346, 3351, 3353, 3356, 3359, 3362, 3367, 3370, 3375, 3377, 3379, 3382, 3388, 3394, 3399, 3404, 3410, 3413, 3419, 3421, 3425, 3428, 3430, 3432, 3437, 3440, 3446, 3452, 3454, 3457, 3460, 3462, 3466, 3468, 3472, 3478, 3484, 3490, 3496, 3499, 3503, 3505, 3511, 3517, 3523, 3529, 3534, 3538, 3543, 3549, 3552, 3557, 3562, 3564, 3568, 3571, 3576, 3579, 3581, 3586, 3589, 3591, 3593, 3597, 3601, 3607, 3613, 3618, 3623, 3628, 3631, 3637, 3641, 3646, 3652, 3656, 3662, 3668, 3674, 3678, 3682, 3685, 3687, 3693, 3698, 3704, 3707, 3710, 3716, 3718, 3724, 3729, 3733, 3735, 3741, 3746, 3749, 3753, 3756, 3762, 3767, 3771, 3773, 3778, 3784, 3790, 3795, 3797, 3802, 3808, 3812, 3818, 3824, 3829, 3833, 3836, 3840, 3842, 3848, 3853, 3859, 3865, 3869, 3874, 3878, 3881, 3885, 3888, 3893, 3895, 3901, 3907, 3910, 3915, 3919, 3923, 3927, 3929, 3935, 3937, 3939, 3943, 3947, 3949, 3951, 3957, 3963, 3968, 3971, 3973, 3975, 3977, 3981, 3986, 3991, 3996, 4002, 4008, 4014, 4016, 4021, 4027, 4033, 4038};//1000, sorted
    	int[] a8 = {990, 351, 914, 141, 304, 633, 746, 475, 276, 256, 450, 775, 55, 416, 550, 923, 529, 667, 475, 847, 141, 76, 748, 546, 668, 400, 54, 627, 226, 732, 253, 892, 119, 420, 178, 160, 315, 99, 293, 244, 919, 496, 323, 730, 201, 448, 430, 361, 137, 956, 38, 447, 494, 730, 530, 222, 181, 477, 83, 956, 189, 595, 400, 648, 155, 957, 663, 688, 232, 257, 899, 641, 327, 644, 663, 554, 310, 109, 437, 94, 401, 936, 672, 308, 541, 9, 946, 410, 38, 777, 84, 303, 39, 868, 444, 398, 846, 80, 925, 358, 212, 696, 770, 772, 407, 668, 844, 217, 272, 843, 47, 464, 22, 368, 757, 534, 902, 92, 714, 750, 665, 173, 581, 610, 49, 816, 491, 325, 834, 726, 944, 95, 862, 842, 509, 769, 540, 785, 78, 488, 592, 182, 377, 64, 287, 191, 612, 696, 697, 202, 938, 451, 603, 239, 8, 592, 978, 853, 134, 911, 474, 789, 841, 62, 637, 563, 745, 671, 312, 122, 379, 380, 773, 160, 624, 492, 846, 811, 324, 775, 561, 533, 527, 335, 801, 424, 289, 854, 615, 228, 50, 697, 121, 769, 385, 230, 543, 661, 968, 758, 321, 449, 152, 230, 339, 153, 865, 862, 545, 78, 376, 762, 561, 334, 171, 504, 142, 533, 491, 965, 934, 489, 678, 928, 826, 791, 554, 315, 431, 511, 630, 98, 12, 754, 247, 979, 663, 686, 822, 467, 992, 512, 283, 49, 695, 464, 829, 413, 306, 852, 508, 729, 516, 9, 601, 382, 267, 756, 914, 861, 56, 146, 695, 697, 896, 757, 844, 983, 908, 214, 726, 70, 900, 977, 816, 207, 222, 46, 746, 548, 803, 805, 859, 212, 757, 835, 669, 250, 167, 230, 568, 496, 917, 382, 210, 418, 32, 114, 134, 474, 743, 669, 712, 870, 651, 186, 859, 291, 642, 443, 261, 629, 33, 942, 64, 343, 805, 787, 949, 973, 735, 84, 896, 594, 458, 713, 770, 34, 144, 899, 640, 114, 380, 979, 647, 780, 337, 851, 272, 927, 348, 383, 702, 630, 356, 67, 632, 630, 693, 377, 181, 201, 612, 415, 468, 210, 498, 383, 947, 986, 136, 656, 694, 224, 282, 891, 151, 861, 823, 49, 967, 723, 283, 307, 705, 164, 623, 131, 486, 294, 881, 656, 600, 471, 980, 538, 477, 551, 784, 580, 458, 766, 674, 508, 250, 30, 894, 898, 690, 211, 220, 25, 748, 471, 264, 685, 360, 611, 13, 128, 257, 216, 472, 581, 87, 106, 94, 576, 788, 823, 133, 519, 810, 356, 434, 267, 702, 8, 818, 173, 574, 41, 635, 781, 547, 446, 876, 973, 863, 311, 915, 189, 687, 662, 188, 840, 223, 742, 797, 905, 457, 769, 280, 852, 210, 144, 684, 538, 497, 956, 746, 428, 313, 46, 721, 864, 388, 570, 101, 336, 718, 352, 683, 570, 326, 394, 975, 341, 455, 144, 867, 214, 47, 344, 826, 694, 479, 19, 360, 987, 80, 974, 647, 924, 284, 747, 274, 308, 248, 588, 794, 46, 487, 220, 191, 858, 673, 564, 407, 116, 290, 70, 318, 516, 865, 318, 297, 860, 70, 125, 872, 806, 724, 545, 468, 765, 382, 296, 549, 47, 964, 926, 23, 691, 317, 348, 335, 511, 218, 738, 435, 764, 204, 577, 707, 123, 579, 726, 79, 217, 492, 638, 459, 31, 726, 530, 512, 848, 925, 63, 586, 253, 566, 355, 708, 509, 364, 1, 638, 313, 169, 57, 101, 915, 380, 841, 972, 429, 177, 466, 765, 755, 653, 847, 497, 779, 462, 172, 525, 368, 976, 144, 505, 23, 121, 508, 151, 776, 857, 73, 106, 922, 94, 264, 614, 374, 330, 264, 967, 245, 429, 930, 457, 978, 228, 123, 134, 570, 207, 657, 327, 173, 680, 557, 337, 887, 22, 893, 674, 255, 769, 995, 615, 737, 237, 594, 262, 244, 957, 116, 302, 303, 735, 192, 544, 951, 292, 209, 36, 841, 913, 414, 667, 425, 957, 840, 777, 81, 422, 231, 221, 912, 258, 944, 932, 146, 353, 616, 739, 313, 307, 87, 357, 730, 184, 846, 959, 993, 929, 793, 460, 326, 675, 65, 11, 832, 646, 371, 50, 342, 3, 505, 559, 694, 604, 748, 833, 410, 292, 613, 100, 434, 553, 67, 529, 377, 616, 162, 917, 448, 540, 796, 390, 812, 217, 332, 38, 182, 623, 879, 704, 856, 435, 806, 182, 797, 873, 173, 101, 529, 840, 971, 301, 408, 947, 255, 155, 589, 950, 677, 998, 3, 6, 89, 168, 362, 270, 301, 562, 271, 298, 210, 955, 482, 605, 585, 423, 240, 80, 850, 247, 558, 392, 14, 11, 978, 469, 321, 210, 882, 958, 866, 715, 83, 227, 126, 807, 362, 461, 891, 739, 334, 803, 301, 196, 218, 327, 767, 262, 241, 20, 348, 653, 671, 248, 963, 938, 84, 636, 822, 47, 753, 58, 5, 610, 479, 600, 875, 662, 164, 58, 853, 772, 623, 356, 210, 879, 335, 56, 63, 365, 206, 336, 129, 734, 565, 394, 164, 244, 87, 850, 259, 319, 543, 420, 762, 816, 680, 84, 12, 113, 241, 863, 943, 681, 579, 226, 823, 351, 808, 976, 258, 799, 932, 96, 69, 238, 288, 989, 472, 527, 204, 278, 530, 127, 174, 508, 96, 920, 650, 938, 192, 792, 927, 702, 861, 499, 693, 102, 550, 953, 444, 28, 124, 376, 148, 869, 598, 243, 321, 503, 348, 168, 816, 275, 727, 405, 906, 237, 437, 529, 739, 314, 560, 694, 467, 120, 148, 921, 400, 654, 918, 148, 239, 798, 868, 851, 359, 91, 701, 211, 767, 975, 43, 205, 859, 29, 674, 946, 253, 238, 0, 576, 920, 507, 985, 110, 402, 69, 954, 162, 582, 720, 866, 275, 369, 355, 110, 549, 959, 560, 510, 269, 583, 284, 838, 702, 236, 309, 17, 684, 579, 692, 319, 500, 159, 254, 781, 513, 410, 321, 478, 586, 843, 489, 274, 182, 922, 624, 20, 617, 40, 626, 530, 966, 507, 515, 775, 174, 416, 227, 541, 47, 269, 171, 303, 689, 882, 160, 228};//1000, unsorted
    	int[] a9 = {998, 998, 997, 994, 991, 988, 987, 984, 981, 980, 978, 977, 976, 974, 974, 971, 970, 969, 968, 966, 966, 966, 964, 963, 962, 962, 962, 962, 961, 960, 957, 956, 954, 952, 951, 951, 949, 947, 944, 942, 942, 942, 940, 937, 934, 933, 931, 929, 928, 926, 923, 923, 922, 921, 919, 917, 916, 915, 914, 914, 912, 911, 911, 909, 906, 904, 903, 903, 903, 902, 900, 899, 899, 896, 893, 890, 890, 890, 887, 887, 886, 885, 885, 885, 884, 884, 881, 881, 880, 877, 876, 876, 876, 876, 876, 874, 872, 871, 868, 865, 865, 865, 865, 863, 862, 859, 859, 859, 859, 859, 859, 856, 854, 852, 851, 851, 849, 847, 845, 844, 842, 841, 841, 840, 837, 836, 835, 832, 829, 826, 826, 826, 823, 822, 821, 821, 819, 818, 818, 818, 817, 814, 814, 811, 809, 806, 803, 803, 802, 800, 797, 794, 794, 794, 792, 792, 789, 786, 785, 785, 782, 780, 780, 780, 780, 780, 779, 778, 778, 777, 776, 774, 772, 769, 768, 766, 763, 762, 759, 757, 754, 753, 751, 748, 745, 745, 744, 744, 744, 743, 742, 739, 737, 736, 733, 731, 731, 731, 730, 730, 728, 725, 723, 723, 722, 719, 718, 718, 715, 714, 713, 712, 709, 706, 706, 704, 703, 703, 700, 697, 696, 696, 694, 693, 693, 690, 689, 689, 687, 685, 685, 685, 684, 681, 680, 680, 680, 678, 678, 678, 676, 676, 673, 670, 667, 664, 662, 662, 661, 660, 658, 655, 654, 654, 651, 651, 651, 649, 649, 648, 645, 644, 644, 642, 639, 638, 635, 635, 635, 634, 633, 631, 630, 630, 627, 625, 625, 625, 625, 624, 623, 621, 620, 619, 619, 616, 616, 614, 613, 611, 609, 606, 605, 604, 602, 602, 601, 598, 598, 598, 598, 596, 593, 591, 590, 590, 590, 590, 590, 589, 588, 588, 587, 586, 584, 584, 583, 580, 580, 578, 577, 577, 576, 575, 573, 570, 570, 570, 570, 569, 569, 569, 567, 564, 564, 564, 563, 560, 557, 556, 554, 551, 550, 548, 548, 548, 548, 546, 546, 543, 540, 539, 536, 533, 531, 528, 527, 527, 527, 524, 523, 520, 518, 515, 514, 511, 511, 508, 507, 504, 504, 501, 500, 500, 498, 498, 495, 495, 495, 493, 491, 489, 489, 487, 484, 481, 478, 478, 478, 475, 472, 471, 468, 466, 464, 464, 462, 462, 461, 459, 457, 454, 452, 451, 450, 450, 449, 449, 446, 443, 443, 442, 440, 439, 437, 436, 433, 433, 432, 432, 430, 428, 426, 424, 422, 422, 421, 418, 417, 414, 412, 410, 409, 409, 409, 407, 404, 404, 404, 403, 401, 401, 400, 398, 397, 396, 396, 395, 395, 393, 393, 393, 390, 389, 389, 388, 386, 385, 385, 384, 381, 380, 377, 374, 372, 369, 369, 367, 365, 365, 362, 359, 356, 353, 351, 349, 349, 349, 346, 343, 343, 340, 338, 336, 335, 332, 332, 330, 330, 328, 325, 325, 325, 322, 319, 319, 319, 316, 316, 314, 311, 308, 308, 305, 302, 300, 298, 295, 295, 293, 291, 288, 286, 284, 284, 282, 282, 280, 278, 277, 276, 275, 275, 274, 272, 270, 268, 266, 265, 262, 260, 260, 260, 260, 257, 255, 255, 254, 253, 253, 250, 249, 249, 247, 245, 243, 242, 242, 239, 238, 235, 234, 232, 229, 229, 228, 228, 225, 222, 222, 220, 219, 219, 219, 217, 217, 216, 215, 215, 214, 214, 214, 211, 211, 209, 209, 206, 206, 204, 201, 200, 199, 199, 198, 196, 194, 194, 191, 191, 191, 191, 188, 185, 183, 183, 181, 180, 177, 174, 174, 174, 174, 172, 172, 170, 167, 165, 164, 164, 161, 161, 159, 157, 154, 152, 152, 150, 150, 148, 145, 145, 142, 142, 139, 137, 137, 137, 135, 132, 129, 126, 123, 120, 117, 117, 115, 112, 111, 109, 108, 108, 105, 103, 100, 98, 98, 95, 93, 91, 89, 88, 85, 82, 80, 77, 76, 74, 71, 70, 67, 67, 67, 66, 64, 64, 62, 61, 59, 59, 57, 56, 55, 55, 53, 51, 49, 46, 45, 44, 42, 42, 39, 37, 35, 33, 31, 29, 27, 24, 23, 23, 21, 21, 18, 17, 16, 13, 10, 10, 9, 7, 7, 5, 5, 4, 1, -2, -2, -2, -2, -5, -5, -7, -9, -9, -11, -11, -11, -14, -17, -17, -17, -18, -18, -20, -22, -25, -27, -29, -30, -32, -32, -33, -36, -39, -42, -44, -44, -47, -48, -48, -51, -53, -56, -57, -58, -60, -62, -63, -66, -68, -71, -71, -71, -74, -76, -79, -79, -82, -85, -86, -87, -90, -91, -94, -94, -95, -96, -98, -100, -101, -101, -101, -104, -105, -107, -108, -110, -112, -112, -113, -115, -116, -119, -119, -121, -123, -123, -123, -126, -127, -130, -132, -135, -138, -139, -141, -141, -144, -146, -149, -152, -153, -153, -154, -154, -156, -157, -160, -161, -162, -162, -164, -164, -166, -167, -170, -173, -173, -175, -177, -177, -179, -182, -183, -184, -187, -190, -191, -193, -196, -197, -197, -198, -198, -200, -200, -200, -202, -205, -207, -210, -213, -213, -214, -216, -216, -216, -219, -222, -224, -224, -224, -226, -229, -232, -232, -233, -236, -237, -239, -241, -241, -244, -245, -245, -245, -245, -248, -251, -253, -256, -258, -261, -263, -264, -264, -266, -267, -268, -269, -271, -274, -276, -277, -279, -280, -283, -283, -283, -285, -286, -286, -288, -288, -288, -290, -291, -291, -291, -292, -294, -294, -297, -298, -299, -301, -302, -303, -304, -305, -308, -309, -310, -310, -311, -314, -317, -319, -319, -320, -322, -323, -324, -324, -324, -324, -326, -327, -327, -327, -330, -330, -331, -331, -331, -331, -331, -331, -331, -333, -333, -335, -336, -336, -338, -338, -339, -341, -344, -346, -347, -350, -353, -356, -357, -358, -360, -362, -362, -363, -365, -365, -368, -370, -372, -374, -375, -378, -381, -384, -384, -386, -389, -389, -390, -390, -390, -391, -391, -391, -391, -393, -393, -396, -396, -397, -400, -402, -402, -404, -404, -407, -407, -408, -408, -410, -411, -412, -415};	//1000, reverse-sorted


          // if you dont have word wrap, you wont see the large arrays
    	  // you can turn word wrap on at Window>Editor>Word Wrap
    	  // some arrays contain negative numbers so our algorithm has to validate that as well
    	  


        // int[] array2 = {9, 5, 9, 4, 2, 3, 1, 0};
        // System.out.println("Original Array 2: " + Arrays.toString(array2));
        // quicksort(array2, 0, array2.length - 1);
        // System.out.println("Sorted Array 2: " + Arrays.toString(array2));

        // int[] array3 = {12, 99, 50, 49, 36, 0, 5, 5, 5, 79, 101};
        // System.out.println("Original Array 3: " + Arrays.toString(array3));
        // quicksort(array3, 0, array3.length - 1);
        // System.out.println("Sorted Array 3: " + Arrays.toString(array3));
    }
	
}
