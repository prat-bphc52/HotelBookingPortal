/*
 * Created by JFormDesigner on Sun Nov 11 16:09:44 IST 2018
 */

package bits.oops.project;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Prateek Agarwal
 */
public class DateChooser extends JDialog {
    public DateChooser(Frame owner) {
        super(owner);
        initComponents();
    }

    public DateChooser(Dialog owner) {
        super(owner);
        initComponents();
    }

    private void customize() {
        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2019", "2020", "2021" }));
        String dayLabels[]={"Su","Mo","Tu","We","Th","Fr","Sa"};
        for(int i=0;i<7;i++){
            JLabel day = new JLabel();
            day.setText(dayLabels[i]);
            daysGrid.add(day, new GridBagConstraints(i, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 5), 0, 0));
        }
        daysButtons = new JButton[35];
        for(int i=0;i<35;i++) {
            final int x=i;
            daysButtons[i] = new JButton();
            daysButtons[i].setPreferredSize(new Dimension(30,30));
            daysButtons[i].setBorder(null);
            daysGrid.add(daysButtons[i], new GridBagConstraints(i%7, i/7+1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(5, 0, 0, 5), 0, 0));
            daysButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dateOnClick(x);
                }
            });
        }
        setupdays();
    }
    private void dateOnClick(int pos){
        int m = month.getSelectedIndex();
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt((String)year.getSelectedItem()),m,1);
        int start = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(last!=null)
            last.setBorder(null);
        last = daysButtons[pos];
        daysButtons[pos].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        date = ((pos-start+1)<10?"0"+(pos-start+1):(pos-start+1))+"/"+(((m+1)<10)?"0"+(m+1):(m+1))+"/"+((String) year.getSelectedItem()).substring(2);
        System.out.print("\n Clicked "+date);
    }

    private void setupdays(){
        if(last!=null)
            last.setBorder(null);
        last = null;
        date="";//resets the date if new month or year is selected
        int m = month.getSelectedIndex();
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt((String)year.getSelectedItem()),m,1);
        int start = cal.get(Calendar.DAY_OF_WEEK) - 1;
        int end;
        switch (m){
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11: end = start + 30;
            break;
            case 1: if(Integer.parseInt((String)year.getSelectedItem())%4==0) end = start + 28;
                    else end = start + 27;
                    break;
            default: end = start + 29;
        }
        for(int x=0;x<35;x++) {
            final int i = x;
            daysButtons[i].removeAll();
            if (i < start || i > end) daysButtons[i].setVisible(false);
            else {
                daysButtons[i].setVisible(true);
                daysButtons[i].setText("" + (i - start + 1));
            }
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        date="";
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Prateek Agarwal
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        month = new JComboBox();
        year = new JComboBox();
        daysGrid = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- month ----
                month.addItemListener(e -> setupdays());

                //---- year ----
                year.addItemListener(e -> setupdays());

                //======== daysGrid ========
                {
                    daysGrid.setLayout(new GridBagLayout());
                    ((GridBagLayout)daysGrid.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)daysGrid.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)daysGrid.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)daysGrid.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(month, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(daysGrid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 97, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(daysGrid, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        customize();
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Prateek Agarwal
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JComboBox month;
    private JComboBox year;
    private JPanel daysGrid;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JButton daysButtons[];
    String date;
    private JButton last;
}
