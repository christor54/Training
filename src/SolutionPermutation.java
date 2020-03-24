import java.util.ArrayList;
import java.util.List;

public class SolutionPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        permute(nums);
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> pioche = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            pioche.add(nums[i]);
        }

        permute(pioche, new ArrayList(),  result);

        return result;
    }

    static void permute(List<Integer> pioche, List<Integer> list, List<List<Integer>> result){
        if (pioche.isEmpty()){
            result.add(new ArrayList<>(list));
            return;
        }

        //Pick a integeter
        for(int i = 0; i < pioche.size(); i++){
            int pick = pioche.get(i); // 3
            pioche.remove(i);
            list.add(pick);
            permute(pioche, list, result);
            //backtrack
            pioche.add(i, pick);
            list.remove(list.size() -1);
        }

    }

}
