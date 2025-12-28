package app.view;

import javax.swing.*;
import java.awt.*;

public class CalculadoraView extends JFrame {

    private final JTextField txtA = new JTextField();
    private final JTextField txtB = new JTextField();

    private final JButton btnSumar = new JButton("Sumar");
    private final JButton btnRestar = new JButton("Restar");
    private final JButton btnMultiplicar = new JButton("Multiplicar");
    private final JButton btnDividir = new JButton("Dividir");

    private final JLabel lblResultado = new JLabel("Resultado: ", SwingConstants.CENTER);

    public CalculadoraView() {
        setTitle("Calculadora MVC - Prototipo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 320);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Entrada
        JPanel panelEntrada = new JPanel(new GridLayout(2, 2, 10, 10));
        panelEntrada.add(new JLabel("Valor A:"));
        panelEntrada.add(txtA);
        panelEntrada.add(new JLabel("Valor B:"));
        panelEntrada.add(txtB);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 10, 10));
        panelBotones.add(btnSumar);
        panelBotones.add(btnRestar);
        panelBotones.add(btnMultiplicar);
        panelBotones.add(btnDividir);

        // Resultado
        lblResultado.setFont(new Font("Arial", Font.BOLD, 16));
        lblResultado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(panelEntrada, BorderLayout.NORTH);
        panel.add(panelBotones, BorderLayout.CENTER);
        panel.add(lblResultado, BorderLayout.SOUTH);

        setContentPane(panel);
    }

    // Getters para el controlador
    public String getValorA() { return txtA.getText(); }
    public String getValorB() { return txtB.getText(); }

    public JButton getBtnSumar() { return btnSumar; }
    public JButton getBtnRestar() { return btnRestar; }
    public JButton getBtnMultiplicar() { return btnMultiplicar; }
    public JButton getBtnDividir() { return btnDividir; }

    public void mostrarResultado(String mensaje) {
        lblResultado.setText("Resultado: " + mensaje);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Validación", JOptionPane.WARNING_MESSAGE);
    }
}

