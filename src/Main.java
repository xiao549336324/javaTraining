//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Day3 day3 = new Day3();
        // function 1
        System.out.println(day3.nonRepeatingChar("ssedefjjlg"));

        // function 2
        String[] words = {"Java", "Python", "leetcode", "java", "Python", "coding"};
        System.out.println(day3.topKFrequentWords(words, 2));

        // function 3
        int[] nums = {1, 2, 3, 2, 4, 5, 5};
        System.out.println(day3.sumOfUniqueElements(nums));
    }
}