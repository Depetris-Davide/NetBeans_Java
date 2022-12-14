package gui;

import java.awt.*;
import java.awt.event.*;
import java.awt.im.InputContext;
import static java.lang.Integer.parseInt;
import javax.swing.*;

public class GUI{
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
   
    private JFrame frame;
   
    private JButton selezionaQuadrato;
    private JButton selezionaRettangolo;
    private JButton selezionaTriangolo;
    private JButton selezionaCerchio;
    private JButton calcoloPerimetro;
    private JButton calcoloArea;
    private JButton tornaIndietro;
   
    GUI(){
        frame = new JFrame();
        textFieldLato = new JTextField(10);
        textFieldLato.setEnabled(false);
        textFieldBase = new JTextField(10);
        textFieldBase.setEnabled(false);
        textFieldAltezza = new JTextField(10);
        textFieldAltezza.setEnabled(false);
        textFieldRaggio = new JTextField(10);
        textFieldRaggio.setEnabled(false);
        
        
        selezionaRettangolo = new JButton("Rettangolo");
        selezionaRettangolo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calcoloArea.setEnabled(true);
                calcoloPerimetro.setEnabled(true);
                tornaIndietro.setEnabled(true);
                        
                labelFigura.setText("Figura: " + e.getActionCommand());
                Figura = e.getActionCommand();
                
                selezionaQuadrato.setEnabled(false);
                selezionaCerchio.setEnabled(false);
                selezionaTriangolo.setEnabled(false);
                
                labelBase.setEnabled(true);
                labelAltezza.setEnabled(true);
                
                textFieldBase.setEnabled(true);
                textFieldAltezza.setEnabled(true);
            }
        });
        
        tornaIndietro = new JButton("Torna Al Menu");
        tornaIndietro.setEnabled(false);
        tornaIndietro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calcoloArea.setEnabled(false);
                calcoloPerimetro.setEnabled(false);
                tornaIndietro.setEnabled(false);
                
                selezionaQuadrato.setEnabled(true);
                selezionaRettangolo.setEnabled(true);
                selezionaCerchio.setEnabled(true);
                selezionaTriangolo.setEnabled(true);
                
                labelBase.setEnabled(false);
                labelAltezza.setEnabled(false);
                labelRaggio.setEnabled(false);
                labelLato.setEnabled(false);
                        
                textFieldLato.setEnabled(false);
                textFieldRaggio.setEnabled(false);
                textFieldBase.setEnabled(false);
                textFieldAltezza.setEnabled(false);
                
                textFieldLato.setText("");
                textFieldRaggio.setText("");
                textFieldBase.setText("");
                textFieldAltezza.setText("");
                        
                labelLato.setText("Lato:");
                labelBase.setText("Base:");
                labelAltezza.setText("Altezza:");
                labelRaggio.setText("Raggio:");
                labelFigura.setText("Figura:");
                labelPerimetro.setText("Perimetro:");
                labelArea.setText("Area:");
            }
        });
        
        selezionaCerchio = new JButton("Cerchio");
        selezionaCerchio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calcoloArea.setEnabled(true);
                calcoloPerimetro.setEnabled(true);
                tornaIndietro.setEnabled(true);
                        
                labelFigura.setText("Figura: " + e.getActionCommand());
                Figura = e.getActionCommand();
                
                selezionaQuadrato.setEnabled(false);
                selezionaRettangolo.setEnabled(false);
                selezionaTriangolo.setEnabled(false);
                
                labelRaggio.setEnabled(true);
                textFieldRaggio.setEnabled(true);
                
            }
        });
       
        selezionaQuadrato = new JButton("Quadrato");
        selezionaQuadrato.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calcoloArea.setEnabled(true);
                calcoloPerimetro.setEnabled(true);
                tornaIndietro.setEnabled(true);
                labelLato.setEnabled(true);
                textFieldLato.setEnabled(true);
                
                labelFigura.setText("Figura: " + e.getActionCommand());
                Figura = e.getActionCommand();
                
                selezionaRettangolo.setEnabled(false);
                selezionaCerchio.setEnabled(false);
                selezionaTriangolo.setEnabled(false);
                
                labelBase.setEnabled(false);
                labelAltezza.setEnabled(false);
                labelRaggio.setEnabled(false);
                
                textFieldBase.setEnabled(false);
                textFieldAltezza.setEnabled(false);
                textFieldRaggio.setEnabled(false);
            }
        });
       
        selezionaTriangolo = new JButton("Triangolo");
        selezionaTriangolo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                calcoloArea.setEnabled(true);
                calcoloPerimetro.setEnabled(true);
                tornaIndietro.setEnabled(true);
                        
                labelFigura.setText("Figura: " + e.getActionCommand());
                Figura = e.getActionCommand();
                
                selezionaQuadrato.setEnabled(false);
                selezionaCerchio.setEnabled(false);
                selezionaRettangolo.setEnabled(false);
                
                labelLato.setEnabled(true);
                labelBase.setEnabled(true);
                labelAltezza.setEnabled(true);
                
                textFieldLato.setEnabled(true);
                textFieldBase.setEnabled(true);
                textFieldAltezza.setEnabled(true);
                
                labelLato.setText("Lato 1:");
                labelBase.setText("Lato 2:");
                labelAltezza.setText("Lato 3:");
            }
        });
       
        calcoloPerimetro = new JButton("Calcola Perimetro");
        calcoloPerimetro.setEnabled(false);
        calcoloPerimetro.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        
                        double perimetro;
                        
                        switch(Figura){
                            case "Quadrato":
                                double lato = Double.parseDouble(textFieldLato.getText());
                                perimetro = lato*4;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                            case "Rettangolo":
                                double base = Double.parseDouble(textFieldBase.getText());
                                double altezza = Double.parseDouble(textFieldAltezza.getText());
                                perimetro = (base+altezza)*2;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                            case "Triangolo":
                                double lato1 = Double.parseDouble(textFieldLato.getText());
                                double lato2 = Double.parseDouble(textFieldBase.getText());
                                double lato3 = Double.parseDouble(textFieldAltezza.getText());
                                double latoGrande = 0;
                                double latoMedio = 0;
                                double latoPiccolo = 0;
                                boolean calcola = false;
                                if(lato1<lato2 && lato1<lato3){
                                    latoPiccolo = lato1;
                                    if(lato2<lato3){
                                        latoMedio = lato2;
                                        latoGrande = lato3;
                                    }else{
                                        latoMedio = lato3;
                                        latoGrande = lato2;
                                    }
                                }else if(lato2<lato1 && lato2<lato3){
                                    latoPiccolo = lato2;
                                    if(lato1<lato3){
                                        latoMedio = lato1;
                                        latoGrande = lato3;
                                    }else{
                                        latoMedio = lato3;
                                        latoGrande = lato1;
                                    }
                                }else{
                                    latoPiccolo = lato3;
                                    if(lato1<lato2){
                                        latoMedio = lato1;
                                        latoGrande = lato2;
                                    }else{
                                        latoMedio = lato2;
                                        latoGrande = lato1;
                                    }
                                }
                                
                                if(latoPiccolo + latoMedio >= latoGrande){
                                    calcola = true;
                                }else{
                                    calcola = false;
                                }
                                
                                if(!calcola){
                                    labelPerimetro.setText("Perimetro: ERRORE");
                                }else{
                                    double p = lato1 + lato2 + lato3;

                                    labelPerimetro.setText("Perimetro: " + p);
                                }
                                
                            break;
                            
                            case "Cerchio":
                                double raggio = Double.parseDouble(textFieldRaggio.getText());
                                perimetro = (raggio*2)*3.14;
                                labelPerimetro.setText("Perimetro: " + perimetro);
                            break;
                        }
                    }
                });
       /*
         perimetro = lato+base+altezza;
        
        */
        calcoloArea = new JButton("Calcola Area");
        calcoloArea.setEnabled(false);
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
                                double lato1 = Double.parseDouble(textFieldLato.getText());
                                double lato2 = Double.parseDouble(textFieldBase.getText());
                                double lato3 = Double.parseDouble(textFieldAltezza.getText());
                                double latoGrande = 0;
                                double latoPiccolo = 0;
                                double latoMedio = 0;
                                boolean calcola = false;
                                if(lato1<lato2 && lato1<lato3){
                                    latoPiccolo = lato1;
                                    if(lato2<lato3){
                                        latoMedio = lato2;
                                        latoGrande = lato3;
                                    }else{
                                        latoMedio = lato3;
                                        latoGrande = lato2;
                                    }
                                }else if(lato2<lato1 && lato2<lato3){
                                    latoPiccolo = lato2;
                                    if(lato1<lato3){
                                        latoMedio = lato1;
                                        latoGrande = lato3;
                                    }else{
                                        latoMedio = lato3;
                                        latoGrande = lato1;
                                    }
                                }else{
                                    latoPiccolo = lato3;
                                    if(lato1<lato2){
                                        latoMedio = lato1;
                                        latoGrande = lato2;
                                    }else{
                                        latoMedio = lato2;
                                        latoGrande = lato1;
                                    }
                                }
                                
                                if(latoPiccolo + latoMedio >= latoGrande){
                                    calcola = true;
                                }else{
                                    calcola = false;
                                }
                                
                                if(!calcola){
                                    labelArea.setText("Area: ERRORE");
                                }else{
                                    double p = lato1 + lato2 + lato3;
                                
                                    area = Math.sqrt(p*(p-lato1)*(p-lato2)*(p-lato3));
                                    labelArea.setText("Area: " + (float)area);
                                }
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
        labelLato.setEnabled(false);
        labelBase = new JLabel("Base:");
        labelBase.setEnabled(false);
        labelAltezza = new JLabel("Altezza:");
        labelAltezza.setEnabled(false);
        labelRaggio = new JLabel("Raggio:");
        labelRaggio.setEnabled(false);
        
        labelFigura = new JLabel("Figura:");
        labelPerimetro = new JLabel("Perimetro:");
        labelArea = new JLabel("Area:");
        
       
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
        panel.add(tornaIndietro);
        
       
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Figure Joemetriche");
        frame.pack();
        frame.setVisible(true);
    }
   
    public static void main(String[] args) {
        new GUI();
    }
}