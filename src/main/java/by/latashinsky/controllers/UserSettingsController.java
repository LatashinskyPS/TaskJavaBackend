package by.latashinsky.controllers;

import by.latashinsky.entities.User;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.fix.FixInput;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.repositories.UserRepository;
import by.latashinsky.utils.Confirms;

import java.util.Scanner;

public class UserSettingsController extends BaseSettingsController<User> {
    private static UserSettingsController userSettingsController;
    protected MyRepository<User> myRepository = (MyRepository<User>) new RepositoryFactory().getRepository(User.class);

    private UserSettingsController() {
    }

    public static UserSettingsController getInstance() {
        if (userSettingsController == null) {
            userSettingsController = new UserSettingsController();
        }
        return userSettingsController;
    }

    @Override
    public void update(User user) {
        FixInput in = FixInput.getInstance();
        String str;
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                user.editName();
                break;
            }
            System.out.println("Invalid input!");
            return;
        }
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                user.editUserType();
                break;
            }
            System.out.println("Invalid input!");
            return;
        }
        myRepository.save(user);
    }

    @Override
    public boolean delete(User user) {

        System.out.println(user);
        if (Confirms.confirm()) {
            myRepository.delete(user);
            return true;
        }
        return false;
    }
}
