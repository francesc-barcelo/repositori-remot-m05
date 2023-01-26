import java.util.Objects;
import java.util.Scanner;

public class BarcelóFrancesc_Bitllet
{
    /**
     * -- MAIN --
     * En aquesta part del programa podem trobar les declaracions de variables final i la de les variables
     * del programa en si. També tenim un do-while on es crida el mètode llegirOpcioMenuPrincipal.
     * Dintre del switch-case hi ha codi especific segons l'opció del menú escollida, segons cada opció de
     * switch-case s'assigna un preu i un nom de bitllet a les variables preuBitllet i tipusBitllet.
     * Si l'opció del menú és igual a 4321 la màquina s'apaga.
     *
     * @author Francesc Barceló Castellet
     */
    public static void main(String[] args)
    {
        final String TITOL = "\n"
                + "||||||||||| MÀQUINA BITLLETS FGC |||||||||||";
        final String MENU_ESCOLLIR_BITLLET = TITOL
                + "\n"
                + " 1. Bitllet senzill"
                + "\n"
                + " 2. T-Casual"
                + "\n"
                + " 3. T-Usual"
                + "\n"
                + " 4. T-Familiar"
                + "\n"
                + " 5. T-Jove";
        final String SEPARADOR = "--------------------------------------------";
        
        final float BITLLET_SENZILL = 2.40f, TCASUAL = 11.35f, TUSUAL = 40.00f, TFAMILIAR = 10.00f, TJOVE = 80.00f;
        final float PREU_2_ZONES = 1.3125f, PREU_3_ZONES = 1.8443f;

        String[][] numBitlletsComprats = new String[3][3];

        String tipusBitllet, seguirComprant = null;
        boolean programa = true;
        int opcioMenuPrincipal = 0, numZona = 0;
        float preuFinal = 0.00f, preuBitllet = 0.00f, preuBitlletZona = 0.00f;

        do
        {
            opcioMenuPrincipal = llegirOpcioMenuPrincipal(MENU_ESCOLLIR_BITLLET, opcioMenuPrincipal, 1, 5);

            switch (opcioMenuPrincipal)
            {
                case 1: /* BITLLETSENZILL */
                    preuBitllet = BITLLET_SENZILL;
                    tipusBitllet = "bitllet senzill";

                    preuFinal = accionsPrincipals(numBitlletsComprats, PREU_2_ZONES, PREU_3_ZONES, SEPARADOR, numZona, preuBitllet, preuFinal, preuBitlletZona, seguirComprant, tipusBitllet);
                    break;
                case 2: /* T-CASUAL */
                    preuBitllet = TCASUAL;
                    tipusBitllet = "T-Casual";

                    preuFinal = accionsPrincipals(numBitlletsComprats, PREU_2_ZONES, PREU_3_ZONES, SEPARADOR, numZona, preuBitllet, preuFinal, preuBitlletZona, seguirComprant, tipusBitllet);
                    break;
                case 3: /* T-USUAL */
                    preuBitllet = TUSUAL;
                    tipusBitllet = "T-Usual";

                    preuFinal = accionsPrincipals(numBitlletsComprats, PREU_2_ZONES, PREU_3_ZONES, SEPARADOR, numZona, preuBitllet, preuFinal, preuBitlletZona, seguirComprant, tipusBitllet);
                    break;
                case 4: /* T-FAMILIAR */
                    preuBitllet = TFAMILIAR;
                    tipusBitllet = "T-Familiar";

                    preuFinal = accionsPrincipals(numBitlletsComprats, PREU_2_ZONES, PREU_3_ZONES, SEPARADOR, numZona, preuBitllet, preuFinal, preuBitlletZona, seguirComprant, tipusBitllet);
                    break;
                case 5: /* T-JOVE */
                    preuBitllet = TJOVE;
                    tipusBitllet = "T-Jove";

                    preuFinal = accionsPrincipals(numBitlletsComprats, PREU_2_ZONES, PREU_3_ZONES, SEPARADOR, numZona, preuBitllet, preuFinal, preuBitlletZona, seguirComprant, tipusBitllet);
                    break;
                case 4321:
                    System.out.println("\nApagant màquina...");
                    break;
            }
        } while (opcioMenuPrincipal != 4321);
    }

    /**
     * -- llegirOpcioMenuPrincipal --
     * En aquest mètode es demana a l'usuari que esculli una opció del menú principal.
     * El mètode inclou un control d'errors que en cas què el número no estigui entre els paràmetres
     * mostri un error per pantalla, es mostrin les opcions del menú i què es torni a preguntar a
     * l'usuari una opció a escollir.
     * Els valors que es busquen són números enters entre 1-5 i també es pot introduir el valor 4321.
     *
     * @param MENU_ESCOLLIR_BITLLET --> variable final String amb el format del menú d'opcions
     * @param opcioMenuPrincipal --> variable int on es guardarà l'opció escollida per l'usuari
     * @param min --> valor mínim (1) de la variable opcioMenuPrincipal
     * @param max --> valor màx (5) de la variable opcioMenuPrincipal
     *
     * @return l'opció escollida per l'usuari dintre dels paràmetres que necessitem
     */
    public static int llegirOpcioMenuPrincipal(final String MENU_ESCOLLIR_BITLLET, int opcioMenuPrincipal, int min, int max)
    {
        Scanner input = new Scanner(System.in);

        final String ERROR = " ERROR: Opció de menú no vàlida";

        boolean controlErrors = false;

        do
        {
            System.out.println(MENU_ESCOLLIR_BITLLET);
            System.out.print("Escull una opció: ");
            controlErrors = input.hasNextInt();

            if (!controlErrors)
            {
                System.out.println(ERROR);
            }
            else
            {
                opcioMenuPrincipal = input.nextInt();

                if (opcioMenuPrincipal < min || opcioMenuPrincipal > max && opcioMenuPrincipal != 4321)
                {
                    System.out.println(ERROR);

                    controlErrors = false;
                }
            }

            input.nextLine();
        } while (!controlErrors);

        return opcioMenuPrincipal;
    }

    /**
     * -- accionsPrincipals --
     * Aquí s'agrupen la majoria de mètodes utilitzats en el programa, com que procès del sistema és idèntic
     * en la majoria d'opcions del menú s'ha decidit incorporar-ho aquí
     *
     * @param numBitlletsComprats --> Matriu on és guarda el tipus de bitllet, num de zones i el seu preu
     * @param PREU_2_ZONES --> variable final float amb el increment de preu per 2 zones
     * @param PREU_3_ZONES --> variable final float amb l'increment de preu per 3 zones
     * @param SEPARADOR --> variable final String per millorar el estil del programa
     * @param numZona --> variable int que fa referencia a la zona del bitllet (1-3)
     * @param preuBitllet --> variable float que té el preu estàndard segons el tipus de bitllet
     * @param preuFinal --> variable float amb el preu final de la compra
     * @param preuBitlletZona --> variable float amb el preu del bitllet segons la zona
     * @param seguirComprant --> variable String (retorna Si/No/C) per saber si l'usuari vol seguir amb la compra o no
     * @param tipusBitllet --> variable final String on és troben els tipus de monedes i bitllets
     * @return preuFinal de la compra
     */
    public static float accionsPrincipals(String[][] numBitlletsComprats, final float PREU_2_ZONES, final float PREU_3_ZONES, final String SEPARADOR, int numZona, float preuBitllet, float preuFinal, float preuBitlletZona, String seguirComprant, String tipusBitllet)
    {
        float mostrarPreuFinal = 0.00f;

        numZona = demanarZona(numZona, 1, 3);

        System.out.println(SEPARADOR);

        preuBitlletZona = calcularPreuZona(PREU_2_ZONES, PREU_3_ZONES, numZona, preuBitllet, preuBitlletZona);
        numBitlletsComprats(numBitlletsComprats, preuBitlletZona, numZona, tipusBitllet);

        preuFinal += preuBitlletZona;

        mostrarBitllet(numBitlletsComprats);

        mostrarPreuFinal = preuFinal;

        System.out.printf("Preu final de la compra: %.2f€ \n", preuFinal);
        System.out.println(SEPARADOR);

        if (numBitlletsComprats[2][0] == null)
        {
            seguirComprant = seguirComprant(seguirComprant);
        }
        else
        {
            System.out.println("Has arribat al màxim de bitllets que pots comprar");

            seguirComprant = "No";
        }

        System.out.println(SEPARADOR);

        if (Objects.equals(seguirComprant, "No") || Objects.equals(seguirComprant, "C"))
        {
            if (Objects.equals(seguirComprant, "No"))
            {
                pagar(numBitlletsComprats, preuFinal, mostrarPreuFinal);
            }
            else
            {
                System.out.println("Cancelant compra...");
            }

            preuFinal = 0;

            netejarNumBitlletsComprats(numBitlletsComprats);
        }

        return preuFinal;
    }

    /**
     * -- demanarZona --
     * Aquest mètode permet introduir el número de zones que l'usuari vols.
     * Inclou un control d'errors en el que només permet introduir valors entre 1-3 i en cas
     * que no siguin correctes mostra un missatge d'error i demanar a l'usuari que ho torni
     * a introduir.
     *
     * @param numZona --> variable int que només pot tenir valors entre 1-3
     * @param min -->  valor mínim (1) de la variable numZona
     * @param max --> valor màxim (3) de la variable numZona
     * @return número de zona escollida per l'usuari
     */
    public static int demanarZona(int numZona, int min, int max)
    {
        Scanner input = new Scanner(System.in);

        String ERROR = " ERROR: zona no vàlida";

        boolean controlErrors = false;

        do
        {
            System.out.print("Escull la zona a viatjar (1-3): ");
            controlErrors = input.hasNextInt();

            if (!controlErrors)
            {
                System.out.println(ERROR);
            }
            else
            {
                numZona = input.nextInt();

                if (numZona < min || numZona > max)
                {
                    System.out.println(ERROR);

                    controlErrors = false;
                }
            }

            input.nextLine();
        } while (!controlErrors);

        return numZona;
    }

    /**
     * -- calcularPreuZona --
     * Aquest mètode calcular el preu del bitllet segons la zona depenen del resultat de
     * la variable demanada en el mètode demanarZona.
     *
     * @param PREU_2_ZONES --> variable final float amb l'increment de preu per 2 zones
     * @param PREU_3_ZONES --> variable final float amb l'increment de preu per 3 zones
     * @param numZona --> variable int amb el número de zones que ha escollit l'usuari
     * @param preuBitllet --> variable float amb el preu estàndard que té el tipus de bitllet
     * @param preuBitlletZona --> variable float amb el preu del bitllet segons la zona
     * @return el preu d'un bitllet amb l'increment que se li apliqui
     */
    public static float calcularPreuZona(final float PREU_2_ZONES, final float PREU_3_ZONES, int numZona, float preuBitllet, float preuBitlletZona)
    {
        preuBitlletZona = 0.00f;

        if (numZona == 2)
        {
            preuBitlletZona = preuBitllet * PREU_2_ZONES;
        }
        else if (numZona == 3)
        {
            preuBitlletZona = preuBitllet * PREU_3_ZONES;
        }
        else
        {
            preuBitlletZona = preuBitllet;
        }

        return preuBitlletZona;
    }

    /**
     * -- numBitlletsComprats --
     * En aquest mètode omple la matriu numBitlletsComprats amb el seu tipus de bitllet, num de zones
     * i el seu preu segons la zona.
     * Només es poden guardar 3 bitllets.
     *
     * @param numBitlletsComprats --> matriu [3][3] de tipus String on és guarden les dades
     * @param preuBitlletZona --> variable float amb el preu del bitllet segons la zona
     * @param numZona --> variable int amb el número de zones escollides per l'usuari
     * @param tipusBitllet --> variable String amb el tipus de bitllet
     */
    public static void numBitlletsComprats(String[][] numBitlletsComprats, float preuBitlletZona, int numZona, String tipusBitllet)
    {
        for (int i = 0; i < numBitlletsComprats.length; i++)
        {
            if (numBitlletsComprats[i][0] == null)
            {
                numBitlletsComprats[i][0] = tipusBitllet;
                numBitlletsComprats[i][1] = String.valueOf(numZona);
                numBitlletsComprats[i][2] = String.valueOf(preuBitlletZona);

                break;
            }
        }
    }

    /**
     * -- mostrarBitllet --
     * Aquí s'imprimeix per pantalla el bitllet escollit, el num de zones
     * i el seu preu.
     *
     * @param numBitlletsComprats --> matriu [3][3] de tipus String amb les dades de la compra
     */
    public static void mostrarBitllet(String[][] numBitlletsComprats)
    {
        float mostrarPreuBitllet = 0.00f;

        for (int i = 0; i < numBitlletsComprats.length; i++)
        {
            if (numBitlletsComprats[i][0] != null)
            {
                mostrarPreuBitllet = Float.parseFloat(numBitlletsComprats[i][2]);

                if (Objects.equals(numBitlletsComprats[i][1], "1"))
                {
                    System.out.printf("Has escollit un %s de %s zona, preu: %.2f€ \n", numBitlletsComprats[i][0], numBitlletsComprats[i][1], mostrarPreuBitllet);
                }
                else
                {
                    System.out.printf("Has escollit un %s de %s zones, preu: %.2f€ \n", numBitlletsComprats[i][0], numBitlletsComprats[i][1], mostrarPreuBitllet);
                }
            }
        }
    }

    /**
     * -- seguirComprant --
     * Aquest mètode serveix per preguntar a l'usuari si vol seguir comprant o no o si vols cancelar
     * la compra.
     * El mètode inclou un control d'errors per controlar que els valors que introdueix l'usuari siguin
     * els que el programa necessiti.
     *
     * @param seguirComprant --> variable String amb l'opció escollida per l'usuaro
     * @return l'opció escollida per l'usuari dintre dels valors necessaris
     */
    public static String seguirComprant(String seguirComprant)
    {
        Scanner input = new Scanner(System.in);

        final String ERROR = " ERROR: Opció no vàlida";

        do
        {
            System.out.print("Vols seguir comprant? (Si/No/C cancelar compra) ");
            seguirComprant = input.nextLine();

            if (!Objects.equals(seguirComprant, "Si") && !Objects.equals(seguirComprant, "No") && !Objects.equals(seguirComprant, "C"))
            {
                System.out.println(ERROR);
            }
        } while (!Objects.equals(seguirComprant, "Si") && !Objects.equals(seguirComprant, "No") && !Objects.equals(seguirComprant, "C"));

        return seguirComprant;
    }

    /**
     * -- pagar --
     * En aquest mètode hi ha dos controls d'errors en els quals es controla que l'usuari
     * ha pagat correctament el preu de la compra.
     * El primer control d'errors (pagamentCorrecte) es controla que la compra està pagada i en el segon
     * (controlErrors) és mira que l'usuari només introdueixi valors tipus float.
     *
     * @param numBitlletsComprats --> matriu [3][3] amb les dades de la compra (no s'utilitza en aquest mètode)
     * @param preuFinal --> variable float amb el preu final de la compra
     * @param mostrarPreuFinal --> variable float per mostrar el preu final de la compra (no s'utilitza en aquests mètode)
     */
    public static void pagar(String[][] numBitlletsComprats, float preuFinal , float mostrarPreuFinal)
    {
        Scanner input = new Scanner(System.in);

        final float[] DINERS = {0.01f, 0.02f, 0.05f, 0.10f, 0.20f, 0.50f, 1.0f, 2.0f, 5.0f, 10.0f, 20.0f, 50.0f};
        final String ERROR = " ERROR: Això no és una moneda/bitllet";
        final String ERROR_MONEDES = " ERROR: Aquesta moneda/bitllet no existeix";

        boolean pagamentCorrecte = false, controlErrors = false, comprobarMoneda = false, tiquet = false;
        float importClient = 0, canvi = 0, importTotal = 0.00f;

        do
        {
            do
            {
                System.out.printf("Quantitat a pagar: %.2f€ \n", preuFinal);
                System.out.print("Introdueix les monedes/bitllets (màx. 50€): ");
                controlErrors = input.hasNextFloat();

                if (!controlErrors)
                {
                    System.out.println(ERROR);
                }
                else
                {
                    importClient = input.nextFloat();

                    comprobarMoneda = comprobarMoneda(DINERS, importClient, comprobarMoneda);

                    if (comprobarMoneda)
                    {
                        if (preuFinal > 0.00f)
                        {
                            if (importClient > preuFinal || (importClient - preuFinal) == 0)
                            {
                                importTotal += importClient;

                                canvi = importClient - preuFinal;

                                System.out.printf("Pagament correcte, no oblidi el canvi de %.2f€ \n", canvi);
                                pagamentCorrecte = true;

                                tiquet = demanarTiquet(tiquet);

                                if (tiquet)
                                {
                                    mostrarTiquet(numBitlletsComprats, mostrarPreuFinal, canvi, importTotal);
                                }

                                break;
                            }
                            else
                            {
                                preuFinal -= importClient;

                                importTotal += importClient;
                            }
                        }
                    }
                    else
                    {
                        System.out.println(ERROR_MONEDES);
                        controlErrors = false;
                    }
                }

                input.nextLine();
            } while (!controlErrors);
        } while (!pagamentCorrecte);
    }

    /**
     * -- comprobarMoneda --
     * Mètode amb control d'errors per verificar que les monedes/bitllets
     * que introdueix l'usuari són correctes.
     *
     * @param diners --> vector float amb el tipus de monedes
     * @param importClient --> variable float amb la quantitat de diners introduïda
     * @param comprobarMoneda --> variable booelan que retorna si els diners introduits són correctes
     * @return una variable boolean segons si la quantitat de diners és correcta o no
     */
    public static boolean comprobarMoneda(final float[] diners, float importClient, boolean comprobarMoneda)
    {
        comprobarMoneda = false;

        for (int i = 0; i < diners.length; i++)
        {
            if (importClient == diners[i])
            {
                comprobarMoneda = true;

                break;
            }
        }

        return comprobarMoneda;
    }

    /**
     * -- demanarTique --
     * Mètode amb control d'error on és pregunta a l'usuari si vol tiquet o no.
     *
     * @param tiquet --> variable boolean amb la resposta del client
     * @return variables boolean --> true (si vol tiquet) // false (no vol tiquet)
     */
    public static boolean demanarTiquet(boolean tiquet)
    {
        Scanner input = new Scanner(System.in);

        final String ERROR = " ERROR: Opció no vàlida";

        String siNo;

        do
        {
            System.out.print("Vols tiquet? (Si/No) ");
            siNo = input.nextLine();

            if (Objects.equals(siNo, "Si"))
            {
                tiquet = true;
            }
            else if (Objects.equals(siNo, "No"))
            {
                tiquet = false;
            }
            else
            {
                System.out.println(ERROR);
            }
        } while (!Objects.equals(siNo, "Si") && !Objects.equals(siNo, "No"));

        return tiquet;
    }

    /**
     * -- mostrarTiquet --
     * Aquest mètode mostra el tiquet en cas que l'usuari ho vulgui (és comprova en el mètode
     * demanarTiquet).
     *
     * @param numBitlletsComprats --> matriu [3][3] amb les dades de la compra
     * @param preuFinal --> variable float amb el preu final dela compra
     * @param canvi --> variable float amb el canvi donat en el pagament
     * @param importTotal --> variable float amb l'import total que ha donat el client
     */
    public static void mostrarTiquet(String[][] numBitlletsComprats, float preuFinal, float canvi, float importTotal)
    {
        final String GUIO = "|-----------------------------------|";
        final String TITOL = "|\t\t\t\tTIQUET\t\t\t\t|";
        final String ESPAI_BUIT = "|                                   |";

        float mostrarFloat = 0.00f;

        System.out.println();
        System.out.println(GUIO);
        System.out.println(TITOL);
        System.out.println(GUIO);
        System.out.println("|\tBITLLETS:\t\t\t\t\t\t|");

        for (int i = 0; i < numBitlletsComprats.length; i++)
        {
            if (numBitlletsComprats[i][0] != null)
            {
                mostrarFloat = Float.parseFloat(numBitlletsComprats[i][2]);

                if (Objects.equals(numBitlletsComprats[i][0], "bitllet senzill"))
                {
                    System.out.printf("|\t Bitllet senzill %s zona: %.2f€\t|\n", numBitlletsComprats[i][1], mostrarFloat);
                }
                else if (Objects.equals(numBitlletsComprats[i][0], "T-Familiar"))
                {
                    System.out.printf("|\t %s %s zona: %.2f€\t\t|\n", numBitlletsComprats[i][0], numBitlletsComprats[i][1], mostrarFloat);
                }
                else if (Objects.equals(numBitlletsComprats[i][0], "T-Casual"))
                {
                    System.out.printf("|\t %s %s zona: %.2f€\t\t|\n", numBitlletsComprats[i][0], numBitlletsComprats[i][1], mostrarFloat);
                }
                else
                {
                    System.out.printf("|\t %s %s zona: %.2f€\t\t\t|\n", numBitlletsComprats[i][0], numBitlletsComprats[i][1], mostrarFloat);
                }
            }
        }

        System.out.println(GUIO);

        System.out.printf("|\tTOTAL.................. %.2f€\t|\n", preuFinal);
        System.out.printf("|\tIMPORT................. %.2f€\t|\n", importTotal);
        System.out.printf("|\tCANVI.................. %.2f€\t|\n", canvi);

        System.out.println(GUIO);
    }

    /**
     * -- netejarNumBitlletsComprats --
     * Aquest mètode permet que quan s'acaba/cancela una compra és netegi la
     * matriu numBitlletsComprats.
     * Totes les dades de numBitlletsComprats passen a ser null.
     *
     * @param numBitlletsComprats --> matriu [3][3] amb les dades de la compra
     */
    public static void netejarNumBitlletsComprats(String[][] numBitlletsComprats)
    {
        for (int i = 0; i < numBitlletsComprats.length; i++)
        {
            numBitlletsComprats[i][0] = null;
            numBitlletsComprats[i][1] = null;
            numBitlletsComprats[i][2] = null;
        }
    }
}