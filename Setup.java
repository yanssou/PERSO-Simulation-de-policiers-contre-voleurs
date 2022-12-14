import java.util.Scanner;

public class Setup{

  public static final String DEFAULT = "\u001B[0m";
  public static final String BLACK = "\u001B[30m";
  public static final String RED = "\u001B[31m";
  public static final String GREEN = "\u001B[32m";
  public static final String YELLOW = "\u001B[33m";
  public static final String BLUE = "\u001B[34m";
  public static final String PURPLE = "\u001B[35m";
  public static final String CYAN = "\u001B[36m";
  public static final String WHITE = "\u001B[37m";
  public static final int TWAIT_INIT = 1000;
  public static final int TWAIT_MSG = 1000;
  public static final int TWAIT_TRANSIT= 3000;
  public static final int TWAIT_UPDATE = 4000;

    // Constructeur
    private Setup(){}                                                            // instanciations impossible


    // Methodes
    public static final void INTRO()
    {
      System.out.println(DEFAULT+"\n-----------------------------------------------------------------------------------------------------------\n");
      System.out.println(DEFAULT+"\nNous vous recommandons d'avoir votre terminal en plein ecran et sur fond noir.");
      Sleep.sleep(TWAIT_TRANSIT);
      System.out.println("\n\n                                            "+RED+"L"+WHITE+"A "+RED+"C"+WHITE+"A"+RED+"S"+WHITE+"A "+RED+"D"+WHITE+"E "+RED+"P"+WHITE+"I"+RED+"X"+WHITE+"E"+RED+"L"+DEFAULT+"\n\n");
      Sleep.sleep(2000);
    }

    public static final void INIT_TERRAIN(){
      System.out.println(DEFAULT+"\n-----------------------------------------------------------------------------------------------------------\n");
      Sleep.sleep(500);
      System.out.println(YELLOW+"\n                                     INITIALISATION DU TERRAIN EN COURS                                    \n"+WHITE);
      Sleep.sleep(TWAIT_INIT);
      System.out.println("\n                                                     .                                                     \n");
      Sleep.sleep(TWAIT_INIT);
      System.out.println("                                                   .   .                                                   \n");
      Sleep.sleep(TWAIT_INIT);
      System.out.println("                                                 .   .   .                                                 \n");
      Sleep.sleep(TWAIT_INIT);
      System.out.println("                                               .   .   .   .                                               \n"+DEFAULT);
      Sleep.sleep(TWAIT_INIT);
      System.out.println(WHITE+"\n-----------------------------------------------------------------------------------------------------------\n");
      System.out.println(YELLOW+"\n                                            AFFICHAGE DU TERRAIN                                   \n\n"+WHITE);
      Sleep.sleep(TWAIT_MSG);

    }

    public static final void OTAGE()
    {
      System.out.println(WHITE+"Les "+PURPLE+"Otages"+WHITE+" : ces derniers seront concentr??s au m??me endroit dans la banque plus pr??cisement, sur le coin inf??rieur de la carte.\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Un "+PURPLE+"otage "+WHITE+"peut ??tre liber?? par un "+BLUE+"policier"+WHITE+" si ce dernier se retrouve sur le coin inf??rieur droit avant de se retrouver de nouveau ?? l'entr??e de la banque...");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Si la banque est liber??e de tout ses "+PURPLE+"otages"+WHITE+", les "+RED+"braqueurs"+WHITE+" n'ont plus aucun moyen de pressions et les forces de l'ordre peuvent d??ployer toutes leurs forces."+DEFAULT);
      Sleep.sleep(TWAIT_TRANSIT);
      System.out.print(WHITE+"Veuillez saisir le nombre d'"+PURPLE+"otages"+WHITE+" souhait??s : "+DEFAULT);
      Sleep.sleep(TWAIT_MSG);
    }

    public static final void BRAQUEUR()
    {
      System.out.println(WHITE+"Les "+RED+"braqueurs"+WHITE+" : se d??placent al??atoirement dans la banque et ramassent de l'"+GREEN+"argent"+WHITE+" au fur et ?? mesure qu'avance la simulation.\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Leur rencontre avec un "+BLUE+"policier"+WHITE+" entraine une fusillade dont l'issue reste ?? d??couvrir.." );
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Si les "+RED+"braqueurs"+WHITE+" arrivent ?? r??cuperer tout l'argent disponible dans la banque ils auront m??rit?? de s'enfuire avec leurs gains. ");
      Sleep.sleep(TWAIT_TRANSIT);
      System.out.print(WHITE+"Veuillez saisir le nombre de "+RED+"braqueurs"+WHITE+" souhait??s : "+DEFAULT);
      Sleep.sleep(TWAIT_MSG);
    }

    public static final void POLICIER()
    {
      System.out.println(WHITE+"Les "+BLUE+"policiers"+WHITE+" : ces derniers sont plac??s au tout d??but de la simulation ?? l'entr??e de la banque et se d??placent de fa??on al??atoire dans la banque au fur et ?? mesure qu'avance la simulation.\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Leur rencontre avec un "+RED+"braqueur"+WHITE+" entraine une fusillade dont l'issus reste ?? d??couvrir.." );
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Si les "+BLUE+"policiers"+WHITE+" arrivent ?? ??liminer tous les braqueurs la simulation s'arr??te et justice est rendue.");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("Si les "+BLUE+"policiers"+WHITE+" arrivent ?? sauver tous les otages, les forces de l'ordre peuvent alors d??ployer tout leur potentiel.");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("le nombre de "+BLUE+"policiers"+WHITE+" n'est pas un facteur d'arr??t de la simulation, des unit??s sp??ciales sont toujours ?? disposition afin d'intervenir en cas d'??chec de la pr??c??dente.");
      Sleep.sleep(TWAIT_TRANSIT);
      System.out.print(WHITE+"Veuillez saisir le nombre de "+BLUE+"policiers"+WHITE+" souhait??s dans chaque unit?? : "+DEFAULT);
      Sleep.sleep(TWAIT_MSG);
    }

    public static final void START()
    {
      Sleep.sleep(TWAIT_MSG);
      System.out.println("----------------------------------------------------"+WHITE+"3-----------------------------------------------------\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("----------------------------------------------------"+WHITE+"2-----------------------------------------------------\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("----------------------------------------------------"+WHITE+"1-----------------------------------------------------\n");
      Sleep.sleep(TWAIT_MSG);
      System.out.println("--------------------------------------------------"+YELLOW+"START---------------------------------------------------\n\n");
      Sleep.sleep(1000);
    }

    // choix de l'utilisateur
    //----------------------------------------------------------------------------
    public static int init_Somme(int maxx_maxy )
    {
      Scanner scan = new Scanner(System.in);
      int total=0;
      total = scan.nextInt();    // pour stocker la somme voulu par l'utilisateur

          while( total < (TestSimulation.LIASSE) || total > TestSimulation.LIASSE*maxx_maxy )   // on fixe une limite inferieur de LIASSE et sup??rieur representant la LIASSE*taille du terrain-1 (case otage)
          {
              System.out.println(RED+"\nLa somme n'est pas accept??e :/ \n");
              System.out.println(WHITE+"\nVeuillez en saisir une nouvelle, sup??rieur ?? "+GREEN+TestSimulation.LIASSE+" et inf??rieur ?? "+GREEN+TestSimulation.LIASSE*maxx_maxy+WHITE+" !! \n");
              System.out.print(WHITE+"Veuillez saisir une nouvelle somme d'argent qui sera disponible dans la banque  : "+DEFAULT);
              total= scan.nextInt();
            }

      if(total < (TestSimulation.LIASSE) || total > TestSimulation.LIASSE*maxx_maxy ) {
        init_Somme(maxx_maxy);
      }

      return total;


    }

    public static int init_otages()
    {
      Scanner scan = new Scanner(System.in);
      int nb_otage = 0;
      nb_otage = scan.nextInt();
      while( nb_otage <= 0)
      {
        System.out.println(RED+"\nVeuillez en inclure au moins 1 voyons !!\n"+DEFAULT);
        System.out.print(WHITE+"Veuillez saisir ?? nouveau le nombre d'"+PURPLE+"otages"+WHITE+" : "+DEFAULT);
        nb_otage = scan.nextInt();
      }
      if(nb_otage <= 0)
      {
        init_otages();
      }
      return nb_otage;
    }

    public static int init_braqueur()
    {
      Scanner scan = new Scanner(System.in);
      int nb_braqueur = 0;
      nb_braqueur = scan.nextInt();
      while( nb_braqueur <= 0)
      {
        System.out.println(RED+"\nVeuillez inclure en inclure au moins 1 voyons  !!\n");
        System.out.print(WHITE+"Veuillez saisir ?? nouveau le nombre de "+RED+"braqueurs"+WHITE+" : "+DEFAULT);
        nb_braqueur = scan.nextInt();
      }
      if(nb_braqueur<= 0)
      {
        init_braqueur();
      }
      return nb_braqueur;

    }

    public static int init_policier(int nb_braqueur)
    {
      Scanner scan = new Scanner(System.in);
      int nb_policier = 0;
      nb_policier = scan.nextInt();

      while ( nb_policier < nb_braqueur )
      {
          System.out.println(RED+"\nIl faut plus de "+BLUE+" policiers"+RED+" !! \n");
          System.out.print(WHITE+"Veuillez saisir ?? nouveau le nombre de "+BLUE+"policiers"+WHITE+" par unit??s souhait?? : "+DEFAULT);
          nb_policier = scan.nextInt();
      }
      if(nb_policier < nb_braqueur)
      {
          init_policier(nb_braqueur);
      }

      return nb_policier;
    }

    public static int init_Iteration()
    {
      System.out.print(WHITE+"Veuillez chosir le nombre d'it??rations de la simulation : "+DEFAULT);
      Scanner scan = new Scanner(System.in);
      int iter = 0;
      iter = scan.nextInt();
      while( iter <= 0 )
      {
      System.out.print(WHITE+"Veuillez chosir le nombre d'it??rations de la simulation : "+DEFAULT);
      iter = scan.nextInt();
      }

      if(iter <= 0)
        {
          init_Iteration();
        }
      return iter;
    }
}
