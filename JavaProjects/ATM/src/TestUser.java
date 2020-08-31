import com.pluralsight.getorganized.ATM;

public class TestUser{

    public static void main(String[] args) throws Exception {
      //  ATM atm = new ATM();
       // atm.GreetUser();

        Helper newHelper = new Helper();
        newHelper.getConnection();
        newHelper.getResult("Select * from cars", 1);

    }

}
