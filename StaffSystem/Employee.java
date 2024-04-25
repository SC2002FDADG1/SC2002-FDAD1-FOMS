package StaffSystem;

import StaffSystem.Gender ;
import StaffSystem.Role ;

class Employee 
{
    protected String name ;
    protected int age ;
    protected Gender gender ;
    protected Role role ;
    
    public Employee(){}
    
    public Employee( String name,  Role role, Gender gender, int age )
    {
        this.name = name ;
        this.role = role ;
        this.gender = gender ;
        this.age = age ;
    }
    
    public void setName( String name )
    {
        this.name = name ;
    }
    
    public String getName()
    {
        return this.name ;
    }
    
    public void setRole( Role role )
    {
        this.role = role ;
    }
    
    public Role getRole()
    {
        return this.role ;
    }
    
    public void setGender( Gender gender )
    {
        this.gender = gender ;
    }
    
    public Gender getGender()
    {
        return this.gender ;
    }
    
    public void setAge( int age )
    {
        this.age = age ;
    }
    
    public int getAge()
    {
        return this.age ;
    }
    
    @Override
    public String toString() 
    {
        return "Employee{name='" + this.name + "', role='" + this.role + "', gender='" + this.gender + "', age=" + this.age + "}";
    }

    
    
}
