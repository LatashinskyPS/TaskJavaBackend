package by.latashinsky.controllers;

import by.latashinsky.entities.User;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.models.MyListConverter;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.user.interfaces.UserSettingsUI;
import by.latashinsky.utils.SelectHelpUtil;

public class UserController extends BaseShowAndCreateController<User> {
    private static UserController userController;
    MyRepository<User> userRepository = (MyRepository<User>) new RepositoryFactory().getRepository(User.class);

    private UserController() {
    }

    public static UserController getInstance() {
        if (userController == null) {
            userController = new UserController();
        }
        return userController;
    }

    @Override
    void show() {
        System.out.print(MyListConverter.convert(userRepository.findAll()));
    }

    @Override
    public void create() {
        User user = new User();
        if (user.editName() &&
                user.editUserType()) {
            userRepository.save(user);
        } else {
            System.out.println("Invalid input!(name usertype(1-to legal.2-to usual)");
        }
    }

    @Override
    void read() {
        User user = SelectHelpUtil.selectUser();
        if (user != null) UserSettingsUI.run(user);
    }
}
