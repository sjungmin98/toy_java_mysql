package co_templates;

public class MethodsSubs {
    // 접근자 리턴 메소드 이름 (파라메터){
    //      return 0;   
    // }
    public void methodsSubs(){
         System.out.println("MethodsSubs = methodsSubs()");
    }

    // with params
    public void methodsSubsWithParams(String fname) {
        System.out.println("MethodsSubs = methodsSubsWithParams(String fname)");
        System.out.println("params : fname-" + fname);
    }

    // with params
    public int methodsSubsWithParamsReturn(int firstNumber, int secondNumber){
        System.out.println("MethodsSubs = methodsSubsWithParamsReturn(int firstNumber, int secondNumber) ");
        System.out.println("params : firstNumber-"+firstNumber+", secondNumber-"+secondNumber);
        int resultNumber = firstNumber + secondNumber;
        return resultNumber;
    }
}