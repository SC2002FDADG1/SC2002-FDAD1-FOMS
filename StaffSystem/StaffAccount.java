package StaffSystem;

public class StaffAccount 
{
    private String loginID , password, staffname ;
    
    public StaffAccount(){}
    
    public StaffAccount( String loginID , String password , String name )
    {
        this.loginID = loginID ;
        this.password = password ;
        this.staffname = name ;
    }
    
    public StaffAccount( String loginID, String name )
    {
        this.loginID = loginID ;
        this.password = "password" ;
        this.staffname = name ;
    }
    
    public String getLoginID()
    {
        return this.loginID ;
    }
    
    void setLoginID( String setLoginID )
    {
        this.loginID = setLoginID ;
    }
    
    public String getPassword()
    {
        return this.password ;
    }
    
    void setPassword( String password )
    {
        this.password = password ;
    }
    
    public String getName()
    {
        return this.staffname ;
    }
    
}
