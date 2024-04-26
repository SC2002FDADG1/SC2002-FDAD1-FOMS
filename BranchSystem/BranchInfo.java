package BranchSystem ;

import BranchSystem.BranchAvailability ;

public class BranchInfo
{
    private String branchName ;
    private BranchAvailability branchAvailability = BranchAvailability.OPEN ;

    public BranchInfo(String branchName)
    {
        this.branchName = branchName;
        this.branchAvailability = BranchAvailability.OPEN ;
    }
    
    public BranchInfo( String branchName , BranchAvailability branchAvailability )
    {
        this.branchName = branchName;
        this.branchAvailability = branchAvailability ;
    }

    public String getBranchName()
    {
        return this.branchName ;
    }

    public void setBranchName(String branchName)
    {
        this.branchName=branchName;
    }

    public BranchAvailability getAvailable()
    {
        return this.branchAvailability;
    }

    public void setOpen()
    {
        this.branchAvailability = BranchAvailability.OPEN;
    }

    public void setClose()
    {
        this.branchAvailability = BranchAvailability.CLOSE;
    }


}
