

  import java.awt.*;
  import java.awt.event.*;

public class Msgbox extends Dialog implements ActionListener {
         boolean id=false;  //permet de connaître le bouton utilisé
         Button ok,can;
	 Msgbox(Frame fr, String msg, boolean okcan) {
          //constructeur hérité
          super(fr, "Message", true);
          //gestionnaire de positionnement
          setLayout(new BorderLayout());
          //ligne de message
          add(BorderLayout.CENTER,new Label(msg,Label.CENTER));
          //boutons
          Panel p=new Panel();
          p.setLayout(new FlowLayout());
          ok=new Button(" OK ");
          p.add(ok);
          ok.addActionListener(this);
          if (okcan) {
           can=new Button("Annule");
           p.add(can);
           can.addActionListener(this);
          }
          add(BorderLayout.SOUTH,p);
          //dimensions et positionnement
          pack();
          Dimension d=getToolkit().getScreenSize();
          setLocation(d.width/3,d.height/3);
          //affichage
          setVisible(true);
         }
 public void actionPerformed(ActionEvent e) {
          if(e.getSource()==ok) {
           id=true;
           setVisible(false);
          }
          else if(e.getSource()==can) {
           id=false;
           setVisible(false);
          }
         }
public static void affMsg(Frame fr, String msg) {
          Msgbox message=new Msgbox(fr, msg, false);
          message.dispose();
         }

         public static boolean affQuest(Frame fr, String msg) {
          Msgbox message=new Msgbox(fr, msg,true);
          boolean rep=message.id;
          message.dispose();
          return rep;
         }


}