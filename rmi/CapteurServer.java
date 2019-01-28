import java.rmi.*;
import java.rmi.registry.LocateRegistry;

/*  *********************************
    * IL FAUT LANCER LE rmiregistry *
    * DEPUIS LE MEME DOSSIER OU YA  *
    * LE CODE COMPILE !             *
    *********************************
*/

/* YA PLUS BESOINS DE GENERER LES STUB ET
LES SKELETON, C'EST AUTOMATIQUE
*/

/* Enfaite le rmiregistry a besoin d'acceder a tout
les .class, sauf que il ne sait pas ou ils sont.
Donc soit on lance le rmiregistry dans le dossier ou
ya le code compilé soit on specifie le $CLASSPATH correctement.
Attention les variable d'envirronment sont specifiques au terminal, 
il faut les rajouter dans chaque nouveaux terminal ou dans le .bashrc
*/

/* On peut aussi lancer le rmiregistry directement depuis le code avec 
LocateRegistry.createRegistry(1099) c'est la methode la plus simple et
ca evite de devoir lancer le rmiregistry dans un terminal ainsi que tout
les problème de classpath et de policy
*/

/* Ducoup les hisoire de -Djava.security.policy=java.policy
on osef total
*/

public class CapteurServer {
    public static void main(String[] args) {
        /*C'est pas obligatoire et en plus c'est deprecated
        * System.setSecurityManager(new RMISecurityManager());
        * Par contre ca c'est pas deprecated
        * System.setSecurityManager(System.getSecurityManager());
        */
        try {
            //On instancie le Capteur
            CapteurImpl capteur = new CapteurImpl();
            System.out.println("Capteur Crée");

            //pour lancer le rmiregistry depuis le code
            //decommenter la ligne ci-dessous
            //LocateRegistry.createRegistry(1099);

            //On ajoute cette instance dans le RMI registry
            //afin de la rendre accessible a distance
            Naming.rebind("//localhost:1099/capteur", capteur);
            System.out.println("Le serveur est pret");

        } catch (Exception e) {
            //On affiche les erreurs
            e.printStackTrace();
        }
    }
}