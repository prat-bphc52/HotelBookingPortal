package bits.oops.project;

public class User {
    String Name;
    String Emailid;
    String Username;
    String password;
    String Contact;
    String Address;
    public User(){

    }
    public User(String username,String name,String email,String contact,String address,String pwd){
        this.Name=name;
        this.Emailid=email;
        this.Username=username;
        this.password=pwd;
        this.Contact=contact;
        this.Address=address;
    }

    public String getAddress() {
        return Address;
    }

    public String getContact() {
        return Contact;
    }

    public String getEmailid() {
        return Emailid;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public String getUsername() {
        return Username;
    }

    public void setEmailid(String emailid) {
        Emailid = emailid;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
