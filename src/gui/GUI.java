package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.InputContext;
import static java.lang.Integer.parseInt;
import javax.swing.*;

public class GUI implements ActionListener{
    private String Figura;
    private double lato;
   
    private JLabel labelLato;
    private JLabel labelBase;
    private JLabel labelAltezza;
    private JLabel labelRaggio;
   
    private JTextField textFieldLato;
    private JTextField textFieldBase;
    private JTextField textFieldAltezza;
    private JTextField textFieldRaggio;

    private JLabel labelFigura;
    private JLabel labelPerimetro;
    private JLabel labelArea;
    //sus test
    private JFrame frame;
   
    private JButton selezionaQuadrato;
    private JButton selezionaRettangolo;
    private JButton selezionaTriangolo;
    private JButton selezionaCerchio;
    private JButton calcoloPerimetro;
    private JButton calcoloArea;
   
    private GridBagConstraints c;
   
    public GUI(){
        frame = new JFrame();
        textFieldLato = new JTextField(10);
        textFieldBase = new JTextField(10);
        textFieldAltezza = new JTextField(10);
        textFieldRaggio = new JTextField(10);
       
        c = new GridBagConstraints();
       
        selezionaRettangolo = new JButton("Rettangolo");
        selezionaRettangolo.addActionListener(this);
       
        selezionaCerchio = new JButton("Cerchio");
        selezionaCerchio.addActionListener(this);
       
        selezionaQuadrato = new JButton("Quadrato");
        selezionaQuadrato.addActionListener(this);
       
        selezionaTriangolo = new JButton("Triangolo");
        selezionaTriangolo.addActionListener(this);
       
        calcoloPerimetro = new JButton("Calcola Perimetro");
        calcoloPerimetro.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        double perimetro;
                        double lato = Double.parseDouble(textFieldLato.getText());
                        double base = Double.parseDouble(textFieldBase.getText());
                        double altezza = Double.parseDouble(textFieldAltezza.getText());
                        double raggio = Double.parseDouble(textFieldRaggio.getText());
                       
                        switch(Figura){
                            case "Quadrato":
                                perimetro = lato*4;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                            case "Rettangolo":
                                perimetro = (base+altezza)*2;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                            case "Triangolo":
                                perimetro = lato*3;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                            case "Cerchio":
                                perimetro = raggio*(2*3.14);
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                        }
                    }
                });
       
        calcoloArea = new JButton("Calcola Area");
        calcoloArea.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        double area;
 
                        switch(Figura){
                            case "Quadrato":
                                double lato = Double.parseDouble(textFieldLato.getText());
                                area = lato*lato;
                                labelArea.setText("Area: " + area);
                            break;
                            case "Rettangolo":
                                double base = Double.parseDouble(textFieldBase.getText());
                                double altezza = Double.parseDouble(textFieldAltezza.getText());
                                area = base*altezza;
                                labelArea.setText("Area: " + area);
                            break;
                            case "Triangolo":
                                double lato2 = Double.parseDouble(textFieldLato.getText());
                                double p = (lato2*3)/2;
                                area = Math.sqrt(p*(p-lato2)*(p-lato2)*(p-lato2));
                                labelArea.setText("Area: " + area);
                            break;
                            case "Cerchio":
                                double raggio = Double.parseDouble(textFieldRaggio.getText());
                                area = (raggio*raggio)*3.14;
                                labelArea.setText("Area: " + area);
                            break;
                        }
                    }
                }
        );
       
        labelLato = new JLabel("Lato:");
        labelBase = new JLabel("Base:");
        labelAltezza = new JLabel("Altezza:");
        labelRaggio = new JLabel("Raggio:");
       
        labelFigura = new JLabel("Figura: null");
        labelPerimetro = new JLabel("Perimetro: null");
        labelArea = new JLabel("Area: null");
       
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        panel.setLayout(new GridLayout(0,1));

        panel.add(selezionaQuadrato);
        panel.add(selezionaRettangolo);
        panel.add(selezionaCerchio);
        panel.add(selezionaTriangolo);
       
        panel.add(labelFigura);
        panel.add(labelPerimetro);
        panel.add(labelArea);
       
        panel.add(calcoloPerimetro);
        panel.add(calcoloArea);
       
        panel.add(labelLato);
        panel.add(textFieldLato);
        panel.add(labelBase);
        panel.add(textFieldBase);
        panel.add(labelAltezza);
        panel.add(textFieldAltezza);
        panel.add(labelRaggio);
        panel.add(textFieldRaggio);
       
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Figure Joemetriche");
        frame.pack();
        frame.setVisible(true);
    }
   
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent a) {
        labelFigura.setText("Figura: " + a.getActionCommand());
        Figura = a.getActionCommand();
    }
}