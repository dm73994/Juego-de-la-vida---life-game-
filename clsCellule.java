public class clsCellule {
    private Boolean living ;

    public clsCellule() {
    }

    public clsCellule(Boolean living ) {
        this.living  = living ;
    }

    //#region GETTERES && SETTERS
    public Boolean getLiving() {  return this.living ;  }

    public void setLiving(Boolean living ) {  this.living  = living ;  }

    //#endregion

    @Override
    public String toString() {
        return "{" +
            " vive='" + getLiving() + "'" +
            "}";
    }
}
