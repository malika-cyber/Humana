package utilities;

public class EnvironmentManager {
    public static String baseUrl;
    public static String userName;
    public static String password;

    public static void SetUpEnv() throws Exception {
        switch (ConfigReader.getProperty("environment").toLowerCase()){
            case "dev":
                DEV();
                break;
            case "qa":
                QA();
                break;
            case "prod":
                PROD();
                break;
            default:
                throw new Exception("Invalid environment in configuration.properties.\n" +
                        "Please select from: Dev, Qa, Prod");
        }
    }
    //for api endpoint same as well

    private static void DEV() {
        //to set up dev variables
        baseUrl = "https://www.humana.com/";
        userName = "TestUserDEV";
        password = "test123";
    }
    private static void QA() {
        //qa variables
        baseUrl = "https://www.humana.com/"; //qa url
        userName = "TestUserQA";
        password = "test123";
    }
    private static void PROD() {
        //prod variables
        baseUrl = "https://www.humana.com/"; //prod url
        userName = "ProdUSER";
        password = "test123";
    }
}