package view;

import model.IAlbumModel;
import model.Snapshot;

import javax.swing.*;
import java.awt.*;

/**
 * graphical view.
 */

public class GraphicalView extends JFrame implements IView{

    private String title;
    private IAlbumModel model;
    private Snapshot currentSnapshot;
    private JLabel label;
    private JLabel snapshotLabel;
    //private JLabel snapshotText;
    JFrame frame;
    JPanel panel;
    private GraphicalDesign graphicPanel;

    public GraphicalView(String title, int maxX, int maxY) {
        //super(title);
        //JPanel controlPanel = controlPanel();
        //this.add(controlPanel, BorderLayout.CENTER);
        //JFrame frame = new JFrame();
        //JPanel panel = new JPanel();
        frame = new JFrame();
        panel = new JPanel();
        //snapshotText = new JLabel();
        //frame.add(snapshotText);
        panel.setBounds(0, 0, maxX, maxY);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.PINK);
        //panel.add(label);

        JPanel buttonPanel = new JPanel();// buttons is not covered by snapshot now!!!!!!
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);

        frame.add(panel, BorderLayout.CENTER);

        JButton previous = new JButton("--Previous--");
        previous.addActionListener(e -> previousAction());
        buttonPanel.add(previous);

        JButton nextB = new JButton("--Next--");
        nextB.addActionListener(e -> nextAction());
        buttonPanel.add(nextB);

        JButton select = new JButton("--Select--");
        select.addActionListener(e -> setCurrentSnapshot(select()));
        buttonPanel.add(select);

        JButton quitB = new JButton("--QUIT--");
        quitB.addActionListener(e -> System.exit(1));
        buttonPanel.add(quitB);
        //render(model);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * load model to this view.
     */
    public void render(IAlbumModel model) {
        this.model = model;
        this.currentSnapshot = this.model.getSnapshotsList().get
                (this.model.getSnapshotsList().size() - 1); //retrieve snapshot using index

        this.snapshotLabel =  createLabel(currentSnapshot); // set label
        //panel.add(snapshotLabel);
        //size issue, button not fully showed!!!!!!!!!!
        this.snapshotLabel.setPreferredSize(new Dimension(getWidth(), 40));
        frame.add(snapshotLabel, BorderLayout.SOUTH); // fixed

        this.graphicPanel = new GraphicalDesign(currentSnapshot);
        this.graphicPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
        // need fix layout, 图会被盖住555
        frame.add(graphicPanel, BorderLayout.EAST);//fixed
        frame.add(new JScrollPane(graphicPanel), BorderLayout.CENTER); //fixed
        frame.setVisible(true);
    }
    /**
     * set up function of previous button.
     */
    public void previousAction() {
        int countofSnapshot = this.model.getSnapshotIDList().indexOf
                (currentSnapshot.getID());
        if (countofSnapshot <= 0) {
            JOptionPane.showMessageDialog(this,
                    "You've reached top of this page");
            setCurrentSnapshot(this.model.getSnapshotsList().get(0));
            return;
        }
        setCurrentSnapshot(this.model.getSnapshotsList().get(countofSnapshot - 1));
    }
    /**
     * set up function of next button.
     */
    public void nextAction() {
        int currentSnapshotIndex = this.model.getSnapshotIDList().indexOf
                (currentSnapshot.getID());
        if (currentSnapshotIndex >= this.model.getSnapshotsList().size() - 1) {
            JOptionPane.showMessageDialog(this,
                    "You've reached end of this page");
            setCurrentSnapshot(this.model.getSnapshotsList().get(this.model.getSnapshotsList().size() - 1));
            return;
        }
        setCurrentSnapshot(this.model.getSnapshotsList().get(currentSnapshotIndex + 1));
    }
    /**
     * set up function of select button.
     */
    public Snapshot select() {
        String[] snapshotArray = this.model.getSnapshotIDList().toArray(new String[0]);
        int selection = this.model.getSnapshotsList().indexOf(currentSnapshot);
        String selectSnapshot = (String) JOptionPane.showInputDialog(null,
                "Please select the snapshot you'd like to display", "Select Snapshot",
                JOptionPane.QUESTION_MESSAGE, null, snapshotArray,
                snapshotArray[selection]);
        return this.model.getSnapshot(selectSnapshot);
    }


    public void setCurrentSnapshot(Snapshot snapshot) {
        this.currentSnapshot = snapshot;
        //updateAlbum();
    }

    public javax.swing.JLabel createLabel(Snapshot currentSnapshot) {
        label = new JLabel();
        label.setText("<html><u><b>Snapshot ID:</u> " + currentSnapshot.getID() + "<br>"
                + "<u><b>Description:</u> " + currentSnapshot.getDescription());
        return label;
    }


    /*public void updatePanel(Snapshot snapshot) {
        //this.currentSnapshot = currentSnapshot;
        snapshotText.setText("<html><u><b>Snapshot ID:</u> " + currentSnapshot.getID() + "<br>"
        + "<u><b>Description:</u> " + currentSnapshot.getDescription());
    }

    public void updateAlbum() {
        snapshotLabel.updatePanel(currentSnapshot);
        snapshotLabel.repaint();
        graphicPanel.updatePanel(currentSnapshot);
        graphicPanel.repaint();
    }

     */



}