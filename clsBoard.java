import java.util.ArrayList;
import java.util.Random;

public class clsBoard {
    //#region ATRIBUTOS
    private Integer Rows;
    private Integer Colums;
    private ArrayList<clsCell> cells;
    //#endregion

    //#region BUILDERS
    public clsBoard() {
        this.Rows = 10;
        this.Colums = 10;
        this.cells = new ArrayList<clsCell>(10*10);
        firstGeneration();
    }

    public clsBoard(Integer Rows, Integer Colums) {
        this.Rows = Rows;
        this.Colums = Colums;
        this.cells = new ArrayList<clsCell>(Rows*Colums);
        firstGeneration();
    }
    //#endregion

    //#region METHODS
    public void firstGeneration(){
        Random r = new Random();
        Double ctr = 0.2;
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Colums; j++) {
                clsPosition p = new clsPosition(i, j);
                Double rnd = r.nextDouble();
                if (rnd < ctr) {
                    clsCellule cell = new clsCellule(true);
                    clsCell celd = new clsCell(cell, p);
                    cells.add(celd);
                } else {
                    clsCellule cell = new clsCellule(false);
                    clsCell c = new clsCell(cell, p);
                    cells.add(c);
                }
            }
        }
    }

    public int neighborsCells(Integer x, Integer y){
        int existingNeighbors  = 0;
        clsCell cd = new clsCell();
        for(int i = 0; i < cells.size(); i++){
            if(cells.get(i).getPosition().getX()==x &&  cells.get(i).getPosition().getY()==y)  {    
                cd.setCellule(cells.get(i).getCellule());
                cd.setPosition(cells.get(i).getPosition());   
                break;
            }
        }

        for(int i = 0; i < 8; i++){
            if(searchNeighbor(cd.getPosition().getX(), cd.getPosition().getY(), i).getCellule().getLiving()==true){
                existingNeighbors++;
            }
        }
        return existingNeighbors;
    }

    public clsCell searchNeighbor(int x, int y,int posicionVecino){
        clsPosition pos = new clsPosition(x,y);
        clsCellule cell = new clsCellule(false);
        clsCell celd = new clsCell(cell, null);
        switch(posicionVecino){
            case 0://venico derecho
                    y=y+1;
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
                    
            case 1://vecino ezquierdo
                    y=y-1;
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 2://vecino arriba
                    x=x-1;
                    pos.setX(x);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 3://vecino abajo
                    x=x+1;
                    pos.setX(x);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 4://vecino diagona superior derecho
                    x=x-1;
                    y=y+1;
                    pos.setX(x);
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 5://vecino diagonal superior izquierdo
                    x=x-1;
                    y=y-1;
                    pos.setX(x);
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 6://vecino diagonal inferior derecho
                    x=x+1;
                    y=y+1;
                    pos.setX(x);
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            case 7://vecino diagonal inferior izquierdo
                    x=x+1;
                    y=y-1;
                    pos.setX(x);
                    pos.setY(y);
                    for(int i = 0; i < cells.size(); i++){
                        if(cells.get(i).getPosition().getX()==pos.getX() &&  cells.get(i).getPosition().getY()==pos.getY())  {    
                            return cells.get(i);   
                        }
                        if(pos.getX()<0 || pos.getY() < 0){
                            return celd;
                        }
                    }
                    break;
            default: break;
        }
        return celd;
    }

    @Override
    public String toString() {
        String celds = "";
        int count = 0;
        for (int i = 0; i < cells.size(); i++) {
            if(cells.get(i).getCellule().getLiving()==false){
                celds+="  ~  ";
                count++;
            }else{
                celds+="  0  ";
                count++;
            }
            if(count==Rows){
                count=0;
                celds+="\n";
            }
        }
        return "{" +
            " Rows='" + getRows() + "'" +
            ", Colums='" + getColums() + "'" +
            "}\n"+
            "board\n" + celds;
    }
    //#endregion

    //#region GETTERS && SETTERS 
    public Integer getRows() {  return this.Rows;  }

    public void setRows(Integer Rows) {  this.Rows = Rows;  }

    public Integer getColums() {  return this.Colums;  }

    public void setColums(Integer Colums) {  this.Colums = Colums;  }

    public ArrayList<clsCell> getCells(){
        ArrayList<clsCell> copiaCeladas = (ArrayList<clsCell>) this.cells.clone();
        return copiaCeladas;
    }


    //#endregion
}
