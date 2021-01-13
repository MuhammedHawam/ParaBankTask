package procedures;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import page.RegisterPage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class registerProcedure {
    public JSONObject user;
    public JSONObject users;

    public String firstName ;
    public String lastName ;
    public String addressStreet ;
    public String city ;
    public String state ;
    public String zipCode ;
    public String phoneNumber ;
    public String ssn ;
    public String username ;
    public String password ;
    public String repeatedPassword ;
    //Users usr;

    public void prepareTestData() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/register.json");
        Object obj = jsonParser.parse(reader);

        JSONArray info = (JSONArray) obj;
        System.out.println(info);




        for(int i=0;i < info.size();i++)

        {

            users = (JSONObject) info.get(i);

            System.out.println(users);//This prints every block - one json object

            user = (JSONObject) users.get("registerInfo");

            System.out.println(user); //This prints each data in the block

            firstName = (String) user.get("firstName");
            lastName = (String) user.get("lastName");
            addressStreet = (String) user.get("addressStreet");
            city = (String) user.get("city");
            state = (String) user.get("state");
            zipCode = (String) user.get("zipCode");
            phoneNumber = (String) user.get("phoneNumber");
            ssn = (String) user.get("ssn");
            username = (String) user.get("username");
            password = (String) user.get("password");
            repeatedPassword = (String) user.get("repeatedPassword");

        }
    }
    public void registerAndFillForm(RemoteWebDriver driver) throws IOException, ParseException {
        RegisterPage page = new RegisterPage(driver);

        page.clickRegisterBtn()
                .fillRegisterForm(new String[]{
                        firstName,
                        lastName,
                        addressStreet,
                        city,
                        state,
                        zipCode,
                        phoneNumber,
                        ssn,
                        username,
                        password,
                        repeatedPassword
                });
        boolean result = page.verifySuccessMsg();
        if (!result)
        {
            Assert.fail("Failed To Register");
        }
        else
        {
            writeInLoginFile();
            Assert.assertEquals(result,true);
        }

    }

    /*
    *
     Function to write the successfully registered user in login json file
    *
    */
    private void writeInLoginFile() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("resources/TestData/login.json");
        Object obj = jsonParser.parse(reader);

        //JSONArray info = (JSONArray) obj;
        users = (JSONObject) obj;
        user = (JSONObject) users.get("login");


        user.put("userName",  username);
        user.put("password", password);
        //Write in Json
        try (FileWriter file = new FileWriter("resources/TestData/login.json")){
            file.append(users.toJSONString());
            file.flush();
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        System.out.println(user);
    }
}
