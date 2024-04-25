public class BranchInfo{
    private String branchName;
    private Availability branchAvailability=Availability.OPEN;

    public BranchInfo(String branchName){
        this.branchName=branchName;
        this.branchAvailability=Availability.OPEN;
    }

    public BranchInfo(String branchName,Availability A){
        this.branchName=branchName;
        this.branchAvailability=A;
    }

    public String getBranchName(){
        return this.branchName;
    }

    public void setBranchName(String branchName){
        this.branchName=branchName;
    }

    public Availability getAvailable(){
        return this.branchAvailability;
    }

    public void setOpen(){
        this.branchAvailability = Availability.OPEN;
    }

    public void setClose(){
        this.branchAvailability = Availability.CLOSE;
    }


}