import java.util.ArrayList;
import java.util.List;

public class PowerSetGenerator {
    public static List<List<Integer>> generatePowerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePowerSet(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private static void generatePowerSet(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        currentSubset.add(nums[index]);
        generatePowerSet(nums, index + 1, currentSubset, result);

        currentSubset.remove(currentSubset.size() - 1);
        generatePowerSet(nums, index + 1, currentSubset, result);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> powerSet = generatePowerSet(nums);

        System.out.println("Power Set:");
        for (List<Integer> subset : powerSet) {
            System.out.println(subset);
        }
    }
}
