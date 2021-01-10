package au.usyd.elec5619.service;

import java.io.Serializable;
import java.util.List;

import au.usyd.elec5619.domain.User;

public interface UserManager extends Serializable{
    
    public void addNewUser(User user);
    
    public User getUserByEmail(String email);
    
    public List<User> getUsers();
    
}