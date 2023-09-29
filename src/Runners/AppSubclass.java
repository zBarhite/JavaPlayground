package Runners;

public class AppSubclass extends App{

    @Override
    public String reportStatus(){
        return "Different String";
    }
    static AppSubclass returnAppSubclass(){
        System.out.println("!Creating new AppSubclass");
        return new AppSubclass();
    }

    
    public AppSubclass(){
        System.out.println("Created new AppSubclass");
        //return new App(0);
    }


    public static void main(String[] args) throws Exception {
        //AppSubclass test1 = new AppSubclass();
        AppSubclass test1 = returnAppSubclass();

        //AppSubclass test2 = new AppSubclass();
        //System.out.println("App status: " + test1.reportStatus());
        System.out.println("AppSubclass status: " + test1.reportStatus());
    }
}
