class Solution {
    public int maximumProduct(int[] nums) {

        int largest1 = nums[0];
        int largest2 = nums[1];
        int largest3 = nums[2];

        // Arrange the first three values
        if (largest1 < largest2) {
            int temp = largest1;
            largest1 = largest2;
            largest2 = temp;
        }

        if (largest1 < largest3) {
            int temp = largest1;
            largest1 = largest3;
            largest3 = temp;
        }

        if (largest2 < largest3) {
            int temp = largest2;
            largest2 = largest3;
            largest3 = temp;
        }

        int smallest1 = nums[0];
        int smallest2 = nums[1];

        if (smallest1 > smallest2) {
            int temp = smallest1;
            smallest1 = smallest2;
            smallest2 = temp;
        }

        for (int i = 3; i < nums.length; i++) {

            int number = nums[i];

            // Update the three largest values
            if (number > largest1) {
                largest3 = largest2;
                largest2 = largest1;
                largest1 = number;
            } else if (number > largest2) {
                largest3 = largest2;
                largest2 = number;
            } else if (number > largest3) {
                largest3 = number;
            }

            // Update the two smallest values
            if (number < smallest1) {
                smallest2 = smallest1;
                smallest1 = number;
            } else if (number < smallest2) {
                smallest2 = number;
            }
        }

        /*
         nums[2] was not checked for the two-smallest section
         because the main loop starts from index 3.
        */
        int number = nums[2];

        if (number < smallest1) {
            smallest2 = smallest1;
            smallest1 = number;
        } else if (number < smallest2) {
            smallest2 = number;
        }

        int product1 = largest1 * largest2 * largest3;
        int product2 = smallest1 * smallest2 * largest1;

        if (product1 > product2) {
            return product1;
        } else {
            return product2;
        }
    }
}