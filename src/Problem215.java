import java.util.Random;

/*
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
 */
/*
思路：
（1）直接排序取倒数第k个
（2）快排+分治，首先在left+1和right之间随机找一个数，left和i的数字交换作为pivot，是为了防止出现最坏情况，然后从left+1开始遍历，
如果nums[j]比pivot小的话就交换，全部遍历完之后，再把pivot和比pivot小的最右边界交换，这样j左边的比pivot小，右边的比pivot大。
然后判断j是否是自己想要的第k大的数，j比length-k说明在后面那一段，否则在前面那一段
 */
public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        // int numsLen = nums.length;
        // Arrays.sort(nums);
        // return nums[numsLen-k];

        int l = 0, r = nums.length-1, target=nums.length-k;
        while(true){
            int index = partition(nums, l, r);
            if (index==target){
                return nums[index];
            }else if (index<target){
                l = index+1;
            }else{
                r = index-1;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int partition(int[] nums, int left, int right){
        if (right>left){
            int randomIndex = new Random().nextInt(right-left)+left+1;
            swap(nums, randomIndex, left);
        }
        int pivot = nums[left];
        int j = left;
        for (int i=left+1; i<=right; i++){
            if (nums[i]<pivot){
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }
}
