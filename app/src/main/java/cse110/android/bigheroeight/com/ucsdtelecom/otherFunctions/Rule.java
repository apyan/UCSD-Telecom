package cse110.android.bigheroeight.com.ucsdtelecom.otherFunctions;

/**
 * Created by abraham on 2/28/2015.
 */
public class Rule {

    String permissionNumber;
    public Rule(String permission){

        this.permissionNumber = permission;
    }

    /*returns which activity to open*/
    public String getActivity(){
        if(permissionNumber.equals("00"))
            return "cse110.android.bigheroeight.com.ucsdtelecom.MainMenuRetailActivity";
        else if (permissionNumber.equals("11"))
            return "cse110.android.bigheroeight.com.ucsdtelecom.MainMenuMarketingRepActivity";
        else if (permissionNumber.equals("10"))
            return "cse110.android.bigheroeight.com.ucsdtelecom.MainMenuCustomerRepActivity";

        return "";
    }
}
