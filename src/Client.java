import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            DayServerInterface server = (DayServerInterface) Naming.lookup("rmi://localhost/DayServer");
            String day = server.getDay();
            System.out.println("Today is " + day);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}