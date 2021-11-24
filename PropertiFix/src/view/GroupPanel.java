/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupPanel extends JPanel {

    private JLabel label1 = new JLabel("Provinsi :");
    private JLabel label2 = new JLabel("Kota :");
    private JLabel label3 = new JLabel("Deskripsi :");

    public GroupPanel(int n,JLabel labelProvinsi,JLabel labelKota,JLabel labelDeskripsi,JButton btnDelete) {
        this.setBackground(new Color(201, 248, 201));
        this.setBorder(BorderFactory.createTitledBorder("Wilayah ke-" + (n+1)));
        GroupLayout layout = new GroupLayout(this);          
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(label1)
                .addComponent(label2)
                .addComponent(label3))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelProvinsi)
                .addComponent(labelKota)
                .addComponent(labelDeskripsi)
                .addComponent(btnDelete))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label1)
                .addComponent(labelProvinsi))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label2)
                .addComponent(labelKota))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label3)
                .addComponent(labelDeskripsi))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnDelete))
        );
    }
    
    public GroupPanel(int n,JLabel labelProvinsi,JLabel labelKota,JLabel labelDeskripsi) {
        this.setBackground(new Color(201, 248, 201));
        this.setBorder(BorderFactory.createTitledBorder("Wilayah ke-" + (n+1)));
        GroupLayout layout = new GroupLayout(this);          
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(label1)
                .addComponent(label2)
                .addComponent(label3))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelProvinsi)
                .addComponent(labelKota)
                .addComponent(labelDeskripsi))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label1)
                .addComponent(labelProvinsi))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label2)
                .addComponent(labelKota))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label3)
                .addComponent(labelDeskripsi))
        );
    }
}
