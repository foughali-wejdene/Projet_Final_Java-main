

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics.*;

/**
 * <p>Titre : Monopoly Simplifié</p>
 * <p>Description : </p>
 * <p>Copyright : Copyright (c) 2002</p>
 * <p>Société : </p>
 * @author MAVROMATIS Christos, MONTEIL Sébastien
 * @version 1.0
 */

public class Principal extends JFrame {
  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenuItem jMenuFileNew = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();

  GridLayout gridLayout1 = new GridLayout();
  JPanel jPanelGauche = new JPanel();
  JPanel jPanelDroit = new JPanel();
  Panel panel1 = new Panel();
  GridLayout gridLayout2 = new GridLayout();
  GridLayout gridLayout3 = new GridLayout();
  JPanel jPanelNomJ = new JPanel();
  JPanel jPanelCasePrec = new JPanel();
  JLabel jLabelindicJ = new JLabel();
  JLabel jLabelNJ = new JLabel();
  JLabel jLabelCaseWere = new JLabel();
  JPanel jPanelDes = new JPanel();
  JLabel jLabelLD = new JLabel();
  JLabel jLabelLDR = new JLabel();
  JPanel jPanelNC = new JPanel();
  JLabel jLabelWere = new JLabel();
  FlowLayout flowLayout1 = new FlowLayout();
  JPanel jPanelAch = new JPanel();
  JButton jButtonBuy = new JButton();
  JLabel jLabelLNC = new JLabel();
  JLabel jLabelRNC = new JLabel();
  JPanel jPanelTourSuiv = new JPanel();
  JButton jButtonTourSuiv = new JButton();
  JLabel jLabelPlateau = new JLabel();
  GridLayout gridLayout4 = new GridLayout();
  JPanel jPanelInutile = new JPanel();
  JPanel jPanelInutile2 = new JPanel();
  JPanel jPanelSolde = new JPanel();
  JPanel jPanel4 = new JPanel();
  JLabel jLabelBourse = new JLabel();
  JLabel jLabelRSolde = new JLabel();
  JPanel jPanelInfoCase = new JPanel();
  GridLayout gridLayout5 = new GridLayout();
  JPanel jPanelProp = new JPanel();
  JLabel jLabelProp = new JLabel();
  JLabel jLabelPropNom = new JLabel();
  JPanel jPanelPrixCase = new JPanel();
  JLabel jLabelCase = new JLabel();
  JLabel jLabelPrixCase = new JLabel();
  Graphics g;
  JPanel jPanelLoyer = new JPanel();
  JLabel jLabelIndicLoyer = new JLabel();
  JLabel jLabelLoyer = new JLabel();
  JPanel jPanelGroupe = new JPanel();
  JLabel jLabelIndicGroupe = new JLabel();
  JLabel jLabelGroupe = new JLabel();

  //Construire le cadre
  public Principal() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Initialiser le composant
  private void jbInit() throws Exception  {

    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(gridLayout1);
    this.setResizable(false);
    this.setSize(new Dimension(600, 480));
    this.setTitle("Monpoly simplifié Java");
    jMenuFile.setText("Fichier");
    jMenuFileExit.setText("Quitter");
    jMenuFileNew.setText("Nouvelle Partie");

    jMenuFileExit.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        jMenuFileExit_actionPerformed(e);
      }
    });
        jMenuFileNew.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        jMenuFileNew_actionPerformed(e);

      }
    });
    jMenuHelp.setText("Aide");
    jMenuHelpAbout.setText("A propos");
    jMenuHelpAbout.addActionListener(new ActionListener()  {
      public void actionPerformed(ActionEvent e) {
        jMenuHelpAbout_actionPerformed(e);
      }
    });

    gridLayout1.setColumns(2);
    contentPane.setEnabled(true);
    panel1.setLayout(gridLayout2);
    jPanelGauche.setLayout(gridLayout3);
    gridLayout3.setColumns(2);
    gridLayout3.setRows(10);
    jLabelindicJ.setText("Nom du joueur courant :");
    jPanelCasePrec.setLayout(flowLayout1);
    jLabelLD.setText("Vous avez Tiré un :");
    jLabelWere.setText("Vous étiez à la :");
    jButtonBuy.setPreferredSize(new Dimension(103, 20));
    jButtonBuy.setText("Acheter");


    jLabelLNC.setText("Vous êtes desormais à :");
    jButtonTourSuiv.setPreferredSize(new Dimension(103, 20));
    jButtonTourSuiv.setText("Tour Suivant");

    jLabelPlateau.setToolTipText("Plateau d'indication");
    jLabelPlateau.setDisabledIcon(new ImageIcon(Principal.class.getResource("mono.jpg")));
    jLabelPlateau.setDisplayedMnemonic('0');
    jLabelPlateau.setHorizontalAlignment(SwingConstants.CENTER);//Alignement
    jLabelPlateau.setHorizontalTextPosition(SwingConstants.CENTER);
    jLabelPlateau.setIcon(new ImageIcon(Principal.class.getResource("mono.jpg")));//image
    jPanelDroit.setLayout(gridLayout4);
    gridLayout4.setColumns(1);
    gridLayout4.setRows(2);
    jLabelBourse.setText("Solde :");
    jPanelSolde.setBorder(BorderFactory.createLineBorder(Color.black));
    jPanelInfoCase.setLayout(gridLayout5);
    gridLayout5.setColumns(1);
    gridLayout5.setRows(8);
    jLabelProp.setText("Propriétaire :");
    jPanelInfoCase.setBorder(BorderFactory.createEtchedBorder());
    jLabelCase.setText("Prix :");
    jLabelNJ.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelPropNom.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelPrixCase.setFont(new java.awt.Font("Dialog", 1, 12));
    jLabelIndicLoyer.setText("Loyer :");
    jLabelLoyer.setFont(new java.awt.Font("Dialog", 3, 12));
    jLabelLoyer.setBorder(BorderFactory.createLineBorder(Color.black));
    jLabelIndicGroupe.setText("Groupe : ");
    jMenuFile.add(jMenuFileNew);
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
    contentPane.add(jPanelGauche, null);
    jPanelGauche.add(jPanelNomJ, null);
    jPanelGauche.add(jPanelCasePrec, null);
    jPanelCasePrec.add(jLabelWere, null);
    jPanelCasePrec.add(jLabelCaseWere, null);
    jPanelGauche.add(jPanelDes, null);
    jPanelDes.add(jLabelLD, null);
    jPanelDes.add(jLabelLDR, null);
    contentPane.add(jPanelDroit, null);
    jPanelNomJ.add(jLabelindicJ, null);
    jPanelNomJ.add(jLabelNJ, null);
    jPanelGauche.add(jPanelNC, null);
    jPanelGauche.add(jPanelAch, null);
    jPanelAch.add(jButtonBuy, null);
    jPanelGauche.add(jPanelTourSuiv, null);
    jPanelTourSuiv.add(jButtonTourSuiv, null);
    jPanelGauche.add(jPanelInutile, null);
    jPanelGauche.add(jPanelInutile2, null);
    jPanelGauche.add(jPanelSolde, null);
    jPanelGauche.add(jPanel4, null);
    jPanelNC.add(jLabelLNC, null);
    jPanelNC.add(jLabelRNC, null);
    jPanelDroit.add(jLabelPlateau, null);
    jPanelDroit.add(jPanelInfoCase, null);
    jPanelSolde.add(jLabelBourse, null);
    jPanelSolde.add(jLabelRSolde, null);
    jPanelInfoCase.add(jPanelProp, null);
    jPanelProp.add(jLabelProp, null);
    jPanelProp.add(jLabelPropNom, null);
    jPanelInfoCase.add(jPanelPrixCase, null);
    jPanelPrixCase.add(jLabelCase, null);
    jPanelPrixCase.add(jLabelPrixCase, null);
    jPanelInfoCase.add(jPanelLoyer, null);
    jPanelLoyer.add(jLabelIndicLoyer, null);
    jPanelLoyer.add(jLabelLoyer, null);
    jPanelInfoCase.add(jPanelGroupe, null);
    jPanelGroupe.add(jLabelIndicGroupe, null);
    jPanelGroupe.add(jLabelGroupe, null);
    this.setJMenuBar(jMenuBar1);

     }
  //Opération Fichier | Quitter effectuée
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //Nouvelle partie
    public void jMenuFileNew_actionPerformed(ActionEvent e) {
  //
    this.dispose();
    new monopoly();

  }


  //Opération Aide | A propos effectuée
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
    Principal_AboutBox dlg = new Principal_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.show();
  }


  //Remplacé, ainsi nous pouvons sortir quand la fenêtre est fermée
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      jMenuFileExit_actionPerformed(null);
    }
  }






}


