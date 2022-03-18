package versao1;
import java.util.Scanner;

public class Main {
	
  public static boolean verificaPosicao(int mapa[][], int posX, int posY) {
    if (mapa[posX][posY] == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static int contaBarcos(int mapa[][]) {
    int contadorBarcos = 0;

    for (int linha = 0; linha < mapa.length; linha++) {
      for (int coluna = 0; coluna < mapa[0].length; coluna++) {
        if (mapa[linha][coluna] == 1) {
          contadorBarcos++;
        }
      }
    }
    return contadorBarcos;
  }

  public static void imprimeMapa(int mapa[][]) {
    System.out.println("  0 1 2 3 4 5 6 7 8 9");
    for (int linha = 0; linha < mapa.length; linha++) {
      System.out.print(+linha + " ");
      for (int coluna = 0; coluna < mapa[0].length; coluna++) {
        if (mapa[linha][coluna] == 1 || mapa[linha][coluna] == 0) {
          System.out.print("~ ");
        } else if (mapa[linha][coluna] == -1) {
          System.out.print("x ");
        }
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    int mapa[][] = new int[10][10];
    int coordX, coordY, contadorBarcos = 5;
    int contadorTiro = 0;
    String nome;
    boolean resultado;

    Scanner n = new Scanner(System.in);

    for (int linha = 0; linha < mapa.length; linha++) {
      for (int coluna = 0; coluna < mapa[0].length; coluna++) {
        mapa[linha][coluna] = 0;
      }
    }
    mapa[7][0] = 1;
    mapa[6][2] = 1;
    mapa[2][4] = 1;
    mapa[8][6] = 1;
    mapa[4][9] = 1;

    System.out.print("Insira seu nome: ");
    nome = n.nextLine();
    while (nome.length() < 5) {
      System.out.print("Erro. O nome precisa ter no minimo 5 caracteres, insira novamente seu nome: ");
      nome = n.nextLine();
    }

    while (contadorBarcos > 0) {
      System.out.print("Insira a coordenada X do tiro: ");
      coordX = n.nextInt();
      while (coordX > 9 || coordX < 0) {
        System.out.println("Fora dos limites do tabuleiro!");
        System.out.print("Insira a coordenada X do tiro: ");
        coordX = n.nextInt();
      }

      System.out.print("Insira a coordenada Y do tiro: ");
      coordY = n.nextInt();
      while (coordY > 9 || coordY < 0) {
        System.out.println("Fora dos limites do tabuleiro!");
        System.out.print("Insira a coordenada Y do tiro: ");
        coordY = n.nextInt();
      }

      System.out.println("");

      resultado = verificaPosicao(mapa, coordX, coordY);
      if (resultado == true) {
        System.out.println("Parabens, voce acertou um barco!");
      } else {
        System.out.println("Agua!");
      }
      mapa[coordX][coordY] = -1;
      System.out.println("");
      imprimeMapa(mapa);
      System.out.println("");

      contadorBarcos = contaBarcos(mapa);
      System.out.println("Voce ainda precisa abater " + contadorBarcos + " barcos.");
      contadorTiro++;
      System.out.println("------------------------------------------------------------");
    }
  
    System.out.println("");
    System.out.println("Parabens "+nome+", voce conseguiu abater os barcos em "+contadorTiro+" tiros!");

  }
}