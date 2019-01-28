import java.rmi.*;

interface CapteurInterface extends Remote {
    String getName() throws RemoteException;
    double getValue() throws RemoteException;
    void setValue(double value) throws RemoteException;
}