import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DayServerImpl extends UnicastRemoteObject implements DayServerInterface {
    protected DayServerImpl() throws RemoteException {
        super();
    }

    @Override
    public String getDay() throws RemoteException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        return formatter.format(currentDate);
    }

    public static void main(String[] args) {
        try {
            DayServerImpl server = new DayServerImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("DayServer", server);
            System.out.println("Server started");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
