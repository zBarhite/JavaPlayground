package Runners;

import InterfaceTesting.returnStatus;

public class App implements returnStatus{
    public static void main(String[] args) throws Exception {
        AppSubclass test = new AppSubclass();
        System.out.println(test.reportStatus());
        

    }



    public AppSubclass createAppSubclassWithInt(int enter){
        return new AppSubclass();
    }
    public String reportStatus(){
        return "I've made a change to the code";
    }
    public int processedRequests(){
        return 0;
    }
}
