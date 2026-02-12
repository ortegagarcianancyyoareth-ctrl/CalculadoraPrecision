import javax.swing.*;
import java.awt.event.*;

public class CalculadoraPrecision extends JFrame {

    // Declaramos los componentes aqui arriba
    private JLabel etiqueta1;
    private JTextField cajaTexto1;
    
    private JLabel etiqueta2;
    private JTextField cajaTexto2;
    
    private JButton botonCalcular;
    
    // Etiquetas para mostrar los resultados (una por cada tipo)
    private JLabel resultadoByte;
    private JLabel resultadoShort;
    private JLabel resultadoInt;
    private JLabel resultadoLong;
    private JLabel resultadoFloat;
    private JLabel resultadoDouble;

    public CalculadoraPrecision() {
        // Configuracion de la ventana
        setLayout(null); // Esto es para mover las cosas con coordenadas
        setTitle("Tarea Calculadora Tipos");
        setSize(350, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Para que no se muevan los controles

        // --- ENTRADA DE DATOS ---
        
        // Primer numero
        etiqueta1 = new JLabel("Ingresa numero 1:");
        etiqueta1.setBounds(20, 20, 150, 20); // x, y, ancho, alto
        add(etiqueta1);

        cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(150, 20, 100, 20);
        add(cajaTexto1);

        // Segundo numero
        etiqueta2 = new JLabel("Ingresa numero 2:");
        etiqueta2.setBounds(20, 50, 150, 20);
        add(etiqueta2);

        cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(150, 50, 100, 20);
        add(cajaTexto2);

        // --- BOTON ---
        botonCalcular = new JButton("DIVIDIR");
        botonCalcular.setBounds(100, 90, 120, 40);
        add(botonCalcular);

        // --- RESULTADOS (Puestos uno por uno manualmente) ---

        // BYTE
        JLabel lByte = new JLabel("En Byte:");
        lByte.setBounds(20, 150, 80, 20);
        add(lByte);
        
        resultadoByte = new JLabel();
        resultadoByte.setBounds(100, 150, 200, 20);
        add(resultadoByte);

        // SHORT
        JLabel lShort = new JLabel("En Short:");
        lShort.setBounds(20, 180, 80, 20);
        add(lShort);

        resultadoShort = new JLabel();
        resultadoShort.setBounds(100, 180, 200, 20);
        add(resultadoShort);

        // INT
        JLabel lInt = new JLabel("En Int:");
        lInt.setBounds(20, 210, 80, 20);
        add(lInt);

        resultadoInt = new JLabel();
        resultadoInt.setBounds(100, 210, 200, 20);
        add(resultadoInt);

        // LONG
        JLabel lLong = new JLabel("En Long:");
        lLong.setBounds(20, 240, 80, 20);
        add(lLong);

        resultadoLong = new JLabel();
        resultadoLong.setBounds(100, 240, 200, 20);
        add(resultadoLong);

        // FLOAT
        JLabel lFloat = new JLabel("En Float:");
        lFloat.setBounds(20, 270, 80, 20);
        add(lFloat);

        resultadoFloat = new JLabel();
        resultadoFloat.setBounds(100, 270, 200, 20);
        add(resultadoFloat);

        // DOUBLE
        JLabel lDouble = new JLabel("En Double:");
        lDouble.setBounds(20, 300, 80, 20);
        add(lDouble);

        resultadoDouble = new JLabel();
        resultadoDouble.setBounds(100, 300, 200, 20);
        add(resultadoDouble);


        // --- ACCION DEL BOTON ---
        ActionListener AL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui hago las operaciones
                try {
                    // Tomo el texto y lo convierto a double para no perder decimales al principio
                    String texto1 = cajaTexto1.getText();
                    String texto2 = cajaTexto2.getText();

                    double n1 = Double.parseDouble(texto1);
                    double n2 = Double.parseDouble(texto2);

                    double division = n1 / n2;

                    // Aqui convierto (casteo) a cada tipo de dato
                    byte rByte = (byte) division;
                    short rShort = (short) division;
                    int rInt = (int) division;
                    long rLong = (long) division;
                    float rFloat = (float) division;
                    double rDouble = division;

                    // Pongo el texto en las etiquetas
                    resultadoByte.setText("" + rByte);
                    resultadoShort.setText("" + rShort);
                    resultadoInt.setText("" + rInt);
                    resultadoLong.setText("" + rLong);
                    resultadoFloat.setText("" + rFloat);
                    resultadoDouble.setText("" + rDouble);

                } catch (Exception error) {
                    // Si falló algo pongo error en todos
                    resultadoByte.setText("Error");
                    resultadoDouble.setText("Revisa los números");
                }
            }
        };

        botonCalcular.addActionListener(AL);
    }

    public static void main(String[] args) {
        CalculadoraPrecision ventana = new CalculadoraPrecision();
        ventana.setVisible(true);
    }
}
