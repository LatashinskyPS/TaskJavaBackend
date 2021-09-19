package by.latashinsky.controllers;

import by.latashinsky.repositories.MyRepository;

import java.util.Locale;

public abstract class BaseShowAndCreateController<T> implements Controller {

    public boolean attemptToExecuteTheCommand(String s) {
        if (s == null) {
            s = "help";
        }
        switch (s.toLowerCase(Locale.ROOT)) {
            case "show" -> {
                show();
                return true;
            }
            case "exit" -> {
                return true;
            }
            case "create" -> {
                create();
                return true;
            }
            case "read" -> {
                read();
                return true;
            }
            case "help" -> {
                help();
                return true;
            }
            default -> {
                System.out.println("Unknown command! Try help.");
                return true;
            }
        }
    }

    @Override
    public void help() {
        System.out.println(
                """
                        show - вывести список сущностей
                        exit - перейти к предыдущему меню
                        create - создать новую сущность
                        read - вывести краткий список сущностей,выбрать\s
                        нужную для изучения и последующей настройки
                        help - вывести данное меню"""
        );
    }

    abstract void show();

    abstract void create();

    abstract void read();
}
