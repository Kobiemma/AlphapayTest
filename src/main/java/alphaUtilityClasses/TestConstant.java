package alphaUtilityClasses;



public class TestConstant{
	
	
	//Url
	 public static final String baseURL = "http://alphapay.netlify.app";
	 
	 
	//Paths
	 public static String projectPath = System.getProperty("user.dir");
	 public static final String Path_TestData = projectPath+"/src/test/resources/alphaTestData.xlsx";
     
   
     
     //Login excel sheets names
     public static final String Sheet1 = "ValidLoginCredentials";
     public static final String Sheet2 = "InvalidLoginCredentials";
     
     public static final String Sheet3 = "ValidSignupInputs";
     public static final String Sheet4 = "InvalidSignupInputs";
     public static final String Sheet5 = "ValidUpdateProfileInputs";
    
     public static final String Sheet6 = "InvalidUpdateProfileInputs";
     
     public static final String Sheet7 = "ValidChangePasswordData";
     public static final String Sheet8 = "InvalidChangePasswordData";
}
