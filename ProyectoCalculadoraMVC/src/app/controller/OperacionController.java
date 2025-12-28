package app.controller;

import app.model.CalculadoraModel;
import app.view.CalculadoraView;

public class OperacionController {

    private final CalculadoraView view;
    private final CalculadoraModel model;

    public OperacionController(CalculadoraView view, CalculadoraModel model) {
        this.view = view;
        this.model = model;

        // Enlazar eventos (la vista no calcula; solo dispara acciones)
        view.getBtnSumar().addActionListener(e -> operar("+"));
        view.getBtnRestar().addActionListener(e -> operar("-"));
        view.getBtnMultiplicar().addActionListener(e -> operar("*"));
        view.getBtnDividir().addActionListener(e -> operar("/"));
    }

    private void operar(String tipo) {
        Double a = parseNumero(view.getValorA(), "A");
        if (a == null) return;

        Double b = parseNumero(view.getValorB(), "B");
        if (b == null) return;

        // Validación específica
        if (tipo.equals("/") && b == 0.0) {
            view.mostrarError("No es posible dividir por cero. Por favor ingrese un valor B diferente de 0.");
            return;
        }

        double resultado;
        switch (tipo) {
            case "+" -> resultado = model.sumar(a, b);
            case "-" -> resultado = model.restar(a, b);
            case "*" -> resultado = model.multiplicar(a, b);
            case "/" -> resultado = model.dividir(a, b);
            default -> {
                view.mostrarError("Operación no reconocida.");
                return;
            }
        }

        // Formato simple (evita mostrar 5.0000000)
        view.mostrarResultado(formatear(resultado));
    }

    private Double parseNumero(String texto, String campo) {
        if (texto == null || texto.trim().isEmpty()) {
            view.mostrarError("El campo " + campo + " está vacío. Ingrese un número.");
            return null;
        }
        try {
            return Double.parseDouble(texto.trim().replace(",", "."));
        } catch (NumberFormatException ex) {
            view.mostrarError("El campo " + campo + " no es numérico. Ejemplo válido: 12.5");
            return null;
        }
    }

    private String formatear(double valor) {
        // Si es entero, muéstralo como entero.
        if (valor == (long) valor) return String.valueOf((long) valor);
        // Si no, corta a 4 decimales como máximo.
        return String.format(java.util.Locale.US, "%.4f", valor).replaceAll("0+$", "").replaceAll("\\.$", "");
    }
}
