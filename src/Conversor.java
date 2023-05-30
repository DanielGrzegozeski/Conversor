import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Conversor extends JFrame {

    private JLabel Valor;
    private JTextField textValor;
    private JComboBox<String> moeda;
    private JTextField textResultado;

    private double taxaDoDolar = 5;
    private double taxaDoEuro = 7;
    private double taxaDaIene = 0.04;

    public Conversor() {
        setTitle("Conversor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        Valor = new JLabel("Valor em Real:");
        textValor = new JTextField(10);


        moeda = new JComboBox<>();
        moeda.addItem("Dolar");
        moeda.addItem("Euro");
        moeda.addItem("Iene");

        textResultado = new JTextField(10);
        textResultado.setEditable(false);

        JButton buttonConverter = new JButton("Converter");
        buttonConverter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                converterMoeda();
            }
        });

        add(Valor);
        add(textValor);
        add(moeda);
        add(buttonConverter);
        add(new JLabel("Resultado:"));
        add(textResultado);

        pack();
        setVisible(true);
    }

    private void converterMoeda() {
        String valorString = textValor.getText();
        if (valorString.isEmpty()) {
            textResultado.setText("");
            return;
        }

        double valorReais = Double.parseDouble(valorString);
        String moedaSelecionada = (String) moeda.getSelectedItem();
        double valorConvertido = 0;

        switch (moedaSelecionada) {
            case "Dólar":
                valorConvertido = valorReais / taxaDoDolar;
                break;

            case "Euro":
                valorConvertido = valorReais / taxaDoEuro;
                break;

            case "Iene":
                valorConvertido = valorReais / taxaDaIene;
                break;
        }


        textResultado.setText(String.format("%.2f %s", valorConvertido, moedaSelecionada));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Conversor();
            }
        });
    }
}