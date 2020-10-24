public class App {
    public static void main(String[] args) throws Exception {
        clsBoard tablero = new clsBoard(20,20);

        clsGame juego = new clsGame(tablero);
        System.out.println(juego.getBoard());
        System.out.println(juego.nextGeneration());
        System.out.println(juego.nextGeneration());
    }
}
