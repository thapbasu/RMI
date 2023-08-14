import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DayServerInterface extends Remote {
    String getDay() throws RemoteException;
}