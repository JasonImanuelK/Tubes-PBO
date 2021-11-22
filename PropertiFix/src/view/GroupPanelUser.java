/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GroupPanelUser extends JPanel {

    private JLabel label1 = new JLabel("Nama :");
    private JLabel label2 = new JLabel("Nomor Telepon :");
    private JLabel label3 = new JLabel("E-mail :");
    private JLabel label4 = new JLabel("Member :");

    public GroupPanelUser(int n,JLabel labelNama,JLabel labelNoTelp,JLabel labelEmail,JLabel labelMember, JButton btnDelete,JButton btnUpgrade) {
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
                .addComponent(label3)
                .addComponent(label4)
                .addComponent(btnDelete))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(labelNama)
                .addComponent(labelNoTelp)
                .addComponent(labelEmail)
                .addComponent(labelMember)
                .addComponent(btnUpgrade))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label1)
                .addComponent(labelNama))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label2)
                .addComponent(labelNoTelp))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label3)
                .addComponent(labelEmail))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label4)
                .addComponent(labelMember))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnUpgrade)
                .addComponent(btnDelete))
        );
    }
}
