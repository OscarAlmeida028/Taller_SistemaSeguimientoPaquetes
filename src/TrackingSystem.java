import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrackingSystem {
    List<Package> packages = new ArrayList<>();

    public List<Package> addPredefinedPackages() {
        List<Package> datosQuemados = new ArrayList<>();
        Address senderAddress = new Address("848 Thompson Dr", "Anytown", "CA", "12345");
        Address recipientAddress = new Address("155 Wilson Ave", "Othertown", "CA", "67890");
        Package pkg1 = new Package(senderAddress,recipientAddress, LocalDate.of(2023,6,1));
        datosQuemados.add(pkg1);


        senderAddress = new Address("4985 Stelton Rd", "Pearland ", "TX", "54321");
        recipientAddress = new Address("321 Maple Ave", "Kapolei", "CA", "111456");
        Package pkg2 = new Package(senderAddress,recipientAddress, LocalDate.of(2023, 5, 1));
        datosQuemados.add(pkg2);

        senderAddress = new Address("212 E. Cullen Building", "Houston ", "B", "67890");
        recipientAddress = new Address("123 Oak Ave", "Victoria ", "CA", "204205");
        Package pkg3 = new Package(senderAddress,recipientAddress, LocalDate.of(2023, 5, 2));
        datosQuemados.add(pkg3);

        senderAddress = new Address("919 w Norton Ave", "Arlington", "TX ", "199198");
        recipientAddress = new Address("321 Elm St", "Hattiesburg", "MS ", "5422213");
        Package pkg4 = new Package(senderAddress,recipientAddress, LocalDate.of(2023, 5, 3));
        datosQuemados.add(pkg4);

        senderAddress = new Address("1 South Blvd", "Atlanta ", "GA ", "2607001");
        recipientAddress = new Address("123 Main St", "Lancaster ", "PA ", "100001");
        Package pkg5 = new Package(senderAddress,recipientAddress, LocalDate.of(2023, 5, 9));
        datosQuemados.add(pkg5);

        senderAddress = new Address("1475 Shelburne Rd", "Mitchell ", "SD ", "101010");
        recipientAddress = new Address("321 Maple Ave", "Akron ", "OH ", "657589");
        Package pkg6 = new Package(senderAddress,recipientAddress, LocalDate.of(2023, 5, 11));
        datosQuemados.add(pkg6);

        packages.addAll(datosQuemados);

        return datosQuemados;
        }

    public void addPackage(Package pkg) {
        for (Package p : packages) {
            if (p.getTrackingNumber().equals(pkg.getTrackingNumber())) {
                JOptionPane.showMessageDialog(null, "El paquete con el número de seguimiento " + pkg.getTrackingNumber() + " ya existe.");
                return;
            }
        }
        packages.add(pkg);
        JOptionPane.showMessageDialog(null, "El paquete con el número de seguimiento " + pkg.getTrackingNumber() + " se agregó con éxito.");
    }

    public boolean removePackage(String trackingNumber){
        Package package1;
        for (int i=0;i<packages.size();i++) {
            package1=packages.get(i);
            if(package1.getTrackingNumber().equals(trackingNumber)){
                packages.remove(i);
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress(String recipientAddress){
        for (Package p : packages) {
            if (p.getRecipientAddress().toString().equals(recipientAddress)) {
                return p;
            }
        }
        JOptionPane.showMessageDialog(null,"No se encontró ningún paquete con la dirección indicada. ");
        return null;

    }

   public Package searchByTrackingNumber(String trackingNumber){
       try{
           int numTrack=Integer.parseInt(trackingNumber.substring(3));

           int izquierda = Integer.parseInt(packages.get(0).getTrackingNumber().substring(3));
           int derecha = Integer.parseInt(packages.get(packages.size()-1).getTrackingNumber().substring(3));

           while (izquierda <= derecha) {
               int medio = (izquierda + derecha) / 2;
               int condicion=Integer.parseInt(packages.get(medio).getTrackingNumber().substring(3));
               if (condicion==numTrack) {
                   return packages.get(medio);
               } else if (condicion < numTrack) {
                   izquierda = medio + 1;
               } else {
                   derecha = medio - 1;
               }
           }
       }catch (IndexOutOfBoundsException e) {
           return null;
       }
       return null;
    }

    public List<Package> searchByCity (String city){
        List<Package> paquetesCiudad = new ArrayList<>();
        for (Package p : packages) {
            if (p.getRecipientAddress().getCity().equals(city)) {
                paquetesCiudad.add(p);
            }
        }
        return paquetesCiudad;
    }

    public List<Package> MostrarPaquetes(){
        List<Package> mostrarList = packages;
        return mostrarList;
    }
}
