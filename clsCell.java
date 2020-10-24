public class clsCell {
    private clsCellule cellule;
    private clsPosition position;

    public clsCell() {
        this.cellule = null;
        this.position = null;  
    }

    public clsCell(clsCellule cellule, clsPosition position) {
        this.cellule = cellule;
        this.position = position;  
    }

    //#region GETTERS && SETTERS 
    public clsCellule getCellule() {  return this.cellule;  }

    public void setCellule(clsCellule celula) {  this.cellule = celula;  }

    public clsPosition getPosition() {  return this.position;  }

    public void setPosition(clsPosition position) {  this.position = position;  }
    //#endregion


    @Override
    public String toString() {
        return "{" +
            " cellule='" + getCellule() + "'" +
            ", position='" + getPosition() + "'" +
            "}";
    }
}
