public class clsGame {
    private clsBoard board;

    public clsGame() {
    }

    public clsGame(clsBoard board) {
        this.board = board;
    }

    public String nextGeneration(){
        clsBoard t = new clsBoard(board.getRows(), board.getColums());
        for(int i = 0; i < t.getCells().size(); i++){
            t.getCells().get(i).getCellule().setLiving(false);
        }
        for(int i = 0; i < t.getCells().size(); i++){
            t.getCells().get(i).getCellule().setLiving(board.getCells().get(i).getCellule().getLiving());
        }
        for(int i = 0; i < t.getRows(); i++){
            for(int j = 0; j < t.getColums(); j++){
                if(t.neighborsCells(i, j) == 3){
                    cellDispose(i, j);
                }
                else if(t.neighborsCells(i, j) > 3 || t.neighborsCells(i, j) < 2){
                    cellIndispose(i, j);
                }
                else{
                    continue;
                }
            }
        }
        return board.toString();
    }

    public void cellDispose (int x, int y){ // disponer celda
        for (int i = 0; i < board.getCells().size(); i++) {
            if(board.getCells().get(i).getPosition().getX()==x && board.getCells().get(i).getPosition().getY()==y && board.getCells().get(i).getCellule().getLiving()==false){
                board.getCells().get(i).getCellule().setLiving(true);break;
            }
        }
    }
    
    public void cellIndispose(int x, int y){ //indisponer celda
        for (int i = 0; i < board.getCells().size(); i++) {
            if(board.getCells().get(i).getPosition().getX()==x && board.getCells().get(i).getPosition().getY()==y && board.getCells().get(i).getCellule().getLiving()==true){
                board.getCells().get(i).getCellule().setLiving(false);break;
            }
        }
    }

    //#region GETTERS && SETTERS
    public clsBoard getBoard() {  return this.board;  }

    public void setBoard(clsBoard board) {  this.board = board;  }
    //#endregion


    @Override
    public String toString() {
        return "{" +
            " Board='" + getBoard() + "'" +
            "}";
    }


}

