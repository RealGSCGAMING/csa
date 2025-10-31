public class SingleNumber {
    public static void main(String[] args) {

        int[] nums = {1};
        System.out.println(singleNumber(nums));

    }

    public static int singleNumber(int[] nums) {

        // fast solution
        int i3 = 0;
        for (int i = 0; i < nums.length; i++) i3 = i3^nums[i];
        //return i3;


        // my solution
        for (int i = 0; i < nums.length; i++) {
            boolean hi = false;
            for (int i2 = 0; i2 < nums.length; i2++) {
                if (i != i2 && nums[i] == nums[i2]) {
                    hi = true;
                    break;
                }
            }
            if (!hi) return nums[i];
        }
        return 0;
    }
}
