   import java.lang.Math.*;
   import java.util.*;
   import java.io.*;
   public class Compagnie extends CaseTerrain
   {

      public Compagnie(int p, int l, Joueur j, Groupe g, String nom, int num)
      { super(p,l,j,g,nom,num);
      }

      public int calculerLoyer()
      {int de=(int)(12*Math.random());
         int pay;
         if (nomGroupe.uniqueProprietaire(proprio) )
         {pay=de*1000;
         }
         else{pay=de*400;
         }
         return (pay);
      }

       }