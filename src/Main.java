import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.setContentPane(interfaz.getPrincipal());
        interfaz.setVisible(true);
        interfaz.setTitle("Seguimiento de Paquetes");
        interfaz.setBounds(100, 100, 800, 700);
        interfaz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println();
    }
}