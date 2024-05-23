package com.mycompany.jogo_da_velha;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Jogo_da_velha extends JFrame {

    JButton[] bt = new JButton[9];
    JLabel placar = new JLabel("placar");
    JLabel px = new JLabel("X 0");
    JLabel po = new JLabel("O 0");
    JButton novoJogo = new JButton("Novo jogo.");
    JButton zerar = new JButton("Zerar placar.");
    int PX = 0;
    int PO = 0;
    boolean xo = false;
    boolean[] click = new boolean[9];

    public Jogo_da_velha() {
        setVisible(true);
        setTitle("Jogo da Velha");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setBounds(250, 100, 700, 500);
        add(placar);
        add(px);
        add(po);
        add(novoJogo);
        add(zerar);
        placar.setBounds(425, 50, 100, 30);
        px.setBounds(400, 75, 100, 30);
        po.setBounds(450, 75, 100, 30);
        novoJogo.setBounds(410, 130, 140, 30);
        zerar.setBounds(410, 180, 140, 30);

        novoJogo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });

        zerar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PX = 0;
                PO = 0;
                atualizar();
            }
        });

        int cont = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                bt[cont] = new JButton();
                add(bt[cont]);
                bt[cont].setBounds((100 * i) + 50, (100 * j) + 50, 95, 95);
                bt[cont].setFont(new Font("Arial", Font.BOLD, 40));
                cont++;
            }
        }

        for (int i = 0; i < 9; i++) {
            click[i] = false;
        }

        for (int i = 0; i < 9; i++) {
            final int index = i;
            bt[i].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!click[index]) {
                        click[index] = true;
                        mudar(bt[index]);
                    }
                }
            });
        }
    }

    public void mudar(JButton btn) {
        if (xo) {
            btn.setText("O");
            xo = false;
        } else {
            btn.setText("X");
            xo = true;
        }
        ganhou();
    }

    public void atualizar() {
        px.setText("X " + PX);
        po.setText("O " + PO);
    }

    public void ganhou() {
        int cont = 0;
        for (int i = 0; i < 9; i++) {
            if (click[i]) {
                cont++;
            }
        }

        if ((bt[0].getText().equals("X") && bt[1].getText().equals("X") && bt[2].getText().equals("X"))
                || (bt[3].getText().equals("X") && bt[4].getText().equals("X") && bt[5].getText().equals("X"))
                || (bt[6].getText().equals("X") && bt[7].getText().equals("X") && bt[8].getText().equals("X"))
                || (bt[0].getText().equals("X") && bt[3].getText().equals("X") && bt[6].getText().equals("X"))
                || (bt[1].getText().equals("X") && bt[4].getText().equals("X") && bt[7].getText().equals("X"))
                || (bt[2].getText().equals("X") && bt[5].getText().equals("X") && bt[8].getText().equals("X"))
                || (bt[0].getText().equals("X") && bt[4].getText().equals("X") && bt[8].getText().equals("X"))
                || (bt[2].getText().equals("X") && bt[4].getText().equals("X") && bt[6].getText().equals("X"))) {

            JOptionPane.showMessageDialog(null, "X ganhou");
            PX++;
            atualizar();
            limpar();
        } else if ((bt[0].getText().equals("O") && bt[1].getText().equals("O") && bt[2].getText().equals("O"))
                || (bt[3].getText().equals("O") && bt[4].getText().equals("O") && bt[5].getText().equals("O"))
                || (bt[6].getText().equals("O") && bt[7].getText().equals("O") && bt[8].getText().equals("O"))
                || (bt[0].getText().equals("O") && bt[3].getText().equals("O") && bt[6].getText().equals("O"))
                || (bt[1].getText().equals("O") && bt[4].getText().equals("O") && bt[7].getText().equals("O"))
                || (bt[2].getText().equals("O") && bt[5].getText().equals("O") && bt[8].getText().equals("O"))
                || (bt[0].getText().equals("O") && bt[4].getText().equals("O") && bt[8].getText().equals("O"))
                || (bt[2].getText().equals("O") && bt[4].getText().equals("O") && bt[6].getText().equals("O"))) {

            JOptionPane.showMessageDialog(null, "O ganhou");
            PO++;
            atualizar();
            limpar();
        } else if (cont == 9) {
            JOptionPane.showMessageDialog(null, "Empate");
            limpar();
        }
    }

    public void limpar() {
        for (int i = 0; i < 9; i++) {
            bt[i].setText("");
            click[i] = false;
            xo = false;
        }
    }

    public static void main(String[] args) {
        new Jogo_da_velha();
    }
}
