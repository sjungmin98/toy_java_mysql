package quests;

public class AdditionsMain {
    public static void main(String[] args) {
        AdditionsSub subs = new AdditionsSub();
        int result = subs.additionsSubsWithParamsReturn();
        System.out.println("Addition: " + result);
        subs.closeScanner();
    }
}
