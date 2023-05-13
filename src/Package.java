import java.time.LocalDate;

public class Package  /*Comparable<TrackingSystem>*/{
    private String trackingNumber;
    private Address senderAddress, recipientAddress;
    private LocalDate estimatedDeliveryDate;

    private static int cont = 1;

    public Package(Address senderAddress, Address recipientAddress, LocalDate estimatedDeliveryDate) {
        this.trackingNumber = "AS" + String.format("%03d", cont++);
        this.senderAddress = senderAddress;
        this.recipientAddress = recipientAddress;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Address getRecipientAddress() {
        return recipientAddress;
    }

    @Override
    public String toString() {
        return "\n\nInformación del paquete:" +
                "\nTracking Number: " + trackingNumber +
                "\nFecha de entrega estimada: " + estimatedDeliveryDate+"\n"+
                "\nDirección del remitente: " + senderAddress +"\n"+
                "\nDirección del receptor: " + recipientAddress+"\n";
    }
}
