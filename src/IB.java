

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


public class IB extends JDialog implements ActionListener {

  JPanel panel1 = new JPanel();
  JPanel panel2 = new JPanel();
  JPanel insetsPanel1 = new JPanel();
  JPanel insetsPanel2 = new JPanel();
  JPanel insetsPanel3 = new JPanel();
  JButton button1 = new JButton();
  TextField Res = new TextField();
  JLabel label1 = new JLabel();
  BorderLayout borderLayout1 = new BorderLayout();
  BorderLayout borderLayout2 = new BorderLayout();
  FlowLayout flowLayout1 = new FlowLayout();
  GridLayout gridLayout1 = new GridLayout();
  //String product = "Monopoly Simplifi\u00e9";
  String Question;


  public IB(Frame parent, String Var) {

    super(parent);

    this.Question=Var;

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    pack();
  }
  //Initialiser le composant
  private void jbInit() throws Exception  {
    //imageLabel.setIcon(new ImageIcon(Principal_AboutBox.class.getResource("[Votre image]")));
    this.setTitle("Question ?");
    setResizable(false);
    panel1.setLayout(borderLayout1);
    panel2.setLayout(borderLayout2);
    insetsPanel1.setLayout(flowLayout1);
    insetsPanel2.setLayout(flowLayout1);
    insetsPanel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    gridLayout1.setRows(3);
    gridLayout1.setColumns(1);
    label1.setText(Question);
    insetsPanel3.setLayout(gridLayout1);
    insetsPanel3.setBorder(BorderFactory.createEmptyBorder(10, 60, 10, 10));


    panel1.add(Res,null);
    button1.setText("Ok");
    button1.addActionListener(this);
    insetsPanel2.add(label1, null);
    panel2.add(insetsPanel2, BorderLayout.WEST);
    this.getContentPane().add(panel1, null);
    panel2.add(insetsPanel3, BorderLayout.CENTER);
    insetsPanel1.add(button1, null);
    panel1.add(insetsPanel1, BorderLayout.SOUTH);
    panel1.add(panel2, BorderLayout.NORTH);

  }
  //Remplacé, ainsi nous pouvons sortir quand la fenêtre est fermée
  protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      //cancel();
    }
    super.processWindowEvent(e);
  }
  //Fermer le dialogue
  void cancel() {
    dispose();
  }
  //Fermer le dialogue sur un événement bouton
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button1) {

      cancel();

    }
  }


}