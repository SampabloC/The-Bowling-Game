package bolos;

import java.util.Random;

public class Bolos {

    Random rand = new Random();
    int suma = 0;

    public static void main(String[] args) {
        Bolos bol = new Bolos();
        bol.initialRound();
        System.out.println("Total: " + bol.suma);
    }

    public int initialRound() {    //inicio del juego
        int tiro1 = tiroUno();
        int tiro2 = tiroDos(tiro1);
        int total = tiro1 + tiro2;
        return suma = suma + total + generalRounds(tiro1, total, 1);
    }

    public int generalRounds(int tiro, int puntajeAnterior, int n) {    //obtener puntaje de la ronda 2  a la 9
        if (n == 9) {  
            return lastRound();
        } else {
            n++;
            int tiro1 = tiroUno(), bonus;
            int tiro2 = tiroDos(tiro1);
            int totalRound = tiro1 + tiro2;
            if (puntajeAnterior == 10) {
                if (tiro == 10) {  //Strike
                    bonus = ((tiro1 + tiro2));
                } else {   //Spare
                    bonus = tiro1;
                }
            } else {    //suma de puntaje normal
                return totalRound + generalRounds(tiro1, totalRound, n);
            }
            return bonus + totalRound + generalRounds(tiro1, totalRound, n);  //suma de puntaje con bonus de ronda
        }
    }

    public int lastRound() {   //puntaje de la decima ronda
        int tiro1 = tiroUno();
        int tiro2 = tiroDos(tiro1);
        int bonus = 0;
        int totalRound = tiro1 + tiro2;
        if (totalRound == 10) {   //caso especial por si hace spare o strike
            bonus = rand.nextInt(11);
        }
        return totalRound + bonus;
    }

    public int tiroUno() { //se obtiene un valor de 0 a 10 para el tiro 1 de cada ronda
        int tiro1 = rand.nextInt(11);
        return tiro1;
    }

    public int tiroDos(int tiro) {  //se obtiene un valor de 0 a (10-tiro1) para el segundo tiro de cada ronda
        int tiro2 = rand.nextInt(11 - tiro);
        return tiro2;
    }
}
