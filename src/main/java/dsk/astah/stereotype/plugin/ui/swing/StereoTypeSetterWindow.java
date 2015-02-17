package dsk.astah.stereotype.plugin.ui.swing;

import com.change_vision.jude.api.inf.AstahAPI;
import com.change_vision.jude.api.inf.editor.TransactionManager;
import com.change_vision.jude.api.inf.exception.InvalidEditingException;
import com.change_vision.jude.api.inf.exception.InvalidUsingException;
import com.change_vision.jude.api.inf.view.IDiagramViewManager;
import java.awt.EventQueue;
import java.util.Arrays;
import javax.swing.JFrame;

public class StereoTypeSetterWindow extends JFrame {

    public StereoTypeSetterWindow() {
        initComponents();
        this.getRootPane().setDefaultButton(this.addButton);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label = new javax.swing.JLabel();
        inputStereotype = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        setResizable(false);

        label.setText("図上でモデルを選択し、追加、削除を押下してください。");

        inputStereotype.setText("stereotype");

        deleteButton.setText("削除");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        addButton.setText("追加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputStereotype, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputStereotype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        this.removeStereotype(this.inputStereotype.getText());
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        this.addStereotype(this.inputStereotype.getText());
    }//GEN-LAST:event_addButtonActionPerformed

    private void addStereotype(String name) {
        TransactionManager.beginTransaction();
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                try {
                    element.addStereotype(this.inputStereotype.getText());
                } catch (InvalidEditingException e) {
                    e.printStackTrace();
                }
            });
            TransactionManager.endTransaction();
        } catch (InvalidUsingException | ClassNotFoundException e) {
            TransactionManager.abortTransaction();
            e.printStackTrace();
        }
    }

    private void removeStereotype(String name) {
        TransactionManager.beginTransaction();
        try {
            IDiagramViewManager diagramViewManager = AstahAPI.getAstahAPI().getViewManager().getDiagramViewManager();
            Arrays.stream(diagramViewManager.getSelectedElements()).forEach(element -> {
                try {
                    element.removeStereotype(this.inputStereotype.getText());
                } catch (InvalidEditingException e) {
                    e.printStackTrace();
                }
            });
            TransactionManager.endTransaction();
        } catch (InvalidUsingException | ClassNotFoundException e) {
            TransactionManager.abortTransaction();
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new StereoTypeSetterWindow().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField inputStereotype;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
