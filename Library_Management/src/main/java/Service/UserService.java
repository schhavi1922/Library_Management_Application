package Service;

import Entity.User;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService {

    static Scanner sc = new Scanner(System.in);

    public List<User> addUser(List<User> userList){
        Date date = new Date();
        User user = new User();
        user.setId(date.getTime());
        System.out.print("Please enter the user's name : ");
        user.setName(sc.next());
        userList.add(user);
        printUsers(userList);
        return userList;
    }

    public void printUsers(List<User> userList){
        System.out.println("Id          Name");
        for (User user : userList) {
            System.out.println(user.getId()+"          "+user.getName());
        }
    }

}
