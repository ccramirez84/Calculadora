package app;


import app.controller.OperacionController;
import app.model.CalculadoraModel;
import app.view.CalculadoraView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraModel model = new CalculadoraModel();
            CalculadoraView view = new CalculadoraView();
            new OperacionController(view, model);
            view.setVisible(true);
        });
    }
}

