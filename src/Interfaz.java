import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class Interfaz extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel Principal;
    private JTabbedPane tabbedPane2;
    private JButton btnQuemarDatos;
    private JTextArea textAQuemaDatos;
    private JTextField textCalleRemi;
    private JTextField textCiudadRemi;
    private JTextField textEstadoRemi;
    private JTextField textCodigoRemi;
    private JTextField textCalleDest;
    private JTextField textCiudadDest;
    private JTextField textEstadoDest;
    private JTextField textCodigoDest;
    private JTextField textDia;
    private JTextField textMes;
    private JTextField textAnio;
    private JButton btnCrearPaquete;
    private JButton btnEliminarPaquete;
    private JTextArea textAEliminaPaquete;
    private JTextField textTrackEliminar;
    private JButton btnMostrar;
    private JTextArea textArMostrar;
    private JTextArea textABuscarDireccion;
    private JButton btnBuscarDireccion;
    private JTextField textEstadoBuscar;
    private JTextField textCiudadBuscar;
    private JTextField textCalleBuscar;
    private JTextField textCodigoBuscar;
    private JTextArea textArBuscarTrack;
    private JButton btnBuscarTrack;
    private JTextField textTrackBuscar;
    private JTextArea textABuscarCiudad;
    private JButton btnBuscarCiudad;
    private JTextField textBuscarCiudad;


    TrackingSystem trackingSystem = new TrackingSystem();

    public Interfaz() {
        btnQuemarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAQuemaDatos.setText("Los datos quemados son:" + trackingSystem.addPredefinedPackages());
            }
        });
        btnCrearPaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackingSystem.addPackage(new Package(new Address(textCalleRemi.getText(), textCalleRemi.getText(), textEstadoRemi.getText(), textCodigoRemi.getText()),
                        new Address(textCiudadDest.getText(), textCalleDest.getText(), textEstadoDest.getText(), textCodigoDest.getText()),
                        LocalDate.of(Integer.parseInt(textDia.getText()), Integer.parseInt(textMes.getText()), Integer.parseInt(textAnio.getText()))));
            }
        });
        btnEliminarPaquete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(trackingSystem.removePackage(textTrackEliminar.getText())){
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el paquete");
                }else{
                    JOptionPane.showMessageDialog(null, "Paquete no encontrado");
                }
            }
        });
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Package> mostrarPaquetes = trackingSystem.MostrarPaquetes();
                if(mostrarPaquetes != null){
                    textArMostrar.setText("Paquetes: " + mostrarPaquetes);
                }
                else{
                    textArMostrar.setText("No hay paquetes.");
                }
            }
        });
        btnBuscarDireccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textABuscarDireccion.setText("\nResultado\n" +trackingSystem.searchByRecipientAddress(String.valueOf(new Address(textCalleBuscar.getText(),textCiudadBuscar.getText(),textEstadoBuscar.getText(),textCodigoBuscar.getText()))));
            }
        });
        btnBuscarTrack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArBuscarTrack.setText("\nResultado\n" +trackingSystem.searchByTrackingNumber(textTrackBuscar.getText()));
            }
        });
        btnBuscarCiudad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textABuscarCiudad.setText("\nResultado\n" +trackingSystem.searchByCity(textBuscarCiudad.getText()));
            }
        });
    }



    public JPanel getPrincipal() {
        return Principal;
    }
}