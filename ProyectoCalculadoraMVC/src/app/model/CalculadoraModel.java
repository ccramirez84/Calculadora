package app.model;



public class CalculadoraModel {

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        // La validación de división por cero se hace en el controlador para poder mostrar mensaje.
        return a / b;
    }
}

