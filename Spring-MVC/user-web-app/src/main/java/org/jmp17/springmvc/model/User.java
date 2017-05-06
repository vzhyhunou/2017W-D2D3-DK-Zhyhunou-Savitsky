package org.jmp17.springmvc.model;

/**
 * Created by asavitsky on 3/17/17.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private long salary;
    private String address;
    private String company;
    private String aboutMe;
    private boolean modifiable;

    public User( int id, String firstName, String lastName, String nickName,
      String email, long salary, String address, String company, String aboutMe, boolean modifiable )
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.email = email;
        this.salary = salary;
        this.address = address;
        this.company = company;
        this.aboutMe = aboutMe;
        this.modifiable = modifiable;
    }

    public User()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName( String nickName )
    {
        this.nickName = nickName;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public long getSalary()
    {
        return salary;
    }

    public void setSalary( long salary )
    {
        this.salary = salary;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany( String company )
    {
        this.company = company;
    }

    public String getAboutMe()
    {
        return aboutMe;
    }

    public void setAboutMe( String aboutMe )
    {
        this.aboutMe = aboutMe;
    }

    public boolean isModifiable()
    {
        return modifiable;
    }

    public void setModifiable( boolean modifiable )
    {
        this.modifiable = modifiable;
    }
}
