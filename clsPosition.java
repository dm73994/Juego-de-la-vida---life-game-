public class clsPosition{
    private Integer x;
    private Integer y;

    public clsPosition() {
    }

    public clsPosition(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    //#region GETTERS && SETTERS 
    public Integer getX() {  return this.x;  }

    public void setX(int x) {  this.x = x;  }

    public Integer getY() {  return this.y;  }

    public void setY(int y) {  this.y = y;  }
    //#endregion


    @Override
    public String toString() {
        return "{" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            "}";
    }
}