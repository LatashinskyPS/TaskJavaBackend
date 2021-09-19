package by.latashinsky.entities;

import by.latashinsky.fix.FixInput;
import by.latashinsky.models.Constants;
import by.latashinsky.models.MyListConverter;
import by.latashinsky.user.interfaces.BankSettingsUI;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    private UserTypes userType;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    private List<Account> accounts;

    @Override
    public String toString() {
        return String.format("%s)%s\nUser type:%s\nAccounts:\n%s",
                id, name, userType.getValue(), MyListConverter.convert(accounts));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserTypes getUserType() {
        return userType;
    }

    public void setUserType(UserTypes userType) {
        this.userType = userType;
    }

    public boolean editName() {
        FixInput in = FixInput.getInstance();
        while (true) {
            String str = in.next();
            if (str.length() <= 45 && str.length() >= 3) {
                this.setName(str);
                return true;
            } else {
                System.out.println("Invalid input.");
                return false;
            }
        }
    }

    public boolean editUserType() {
        FixInput in = FixInput.getInstance();
        while (true) {
            String str = in.next();
            if (Pattern.matches(Constants.PATTERN_INT, str)) {
                int index = Integer.parseInt(str);
                if (index == 1) {
                    this.setUserType(UserTypes.LEGAL);
                    return true;
                }
                if(index==2){
                    this.setUserType(UserTypes.USUAL);
                    return true;
                }
            }
            System.out.println("Invalid input!");
            return false;
        }
    }
}
