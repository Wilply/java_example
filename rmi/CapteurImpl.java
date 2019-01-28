import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class CapteurImpl extends UnicastRemoteObject implements CapteurInterface {
    //attributs
    private String name;
    private double value;

    //constructeurs
    public CapteurImpl(String name) throws RemoteException {
        this.name = name;
        this.value = 0;
    }

    public CapteurImpl() throws RemoteException {
        this.name = "unknown";
        this.value = 0;
    }

    //methodes
    public void setValue(double value) {
        System.out.println("Methode setValue() appelée");
        this.value = value;
    }
    
    public String getName() {
        System.out.println("Methode getName() appelée");
        return this.name;
    }

    public double getValue() {
        System.out.println("Methode getValue() appelée");
        return this.value;
    }
}