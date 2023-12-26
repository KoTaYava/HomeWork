import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Scanner;


public class Main {

    private static void checkLogin(String login) throws WrongLoginException {
        if (login.length() >= 20) {
            throw new WrongLoginException("Ошибка! Превышена длина логина.");
        }
        CharacterIterator it = new StringCharacterIterator(login);
        while (it.current() != CharacterIterator.DONE) {
            if (!login.matches("^[a-zA-Z0-9_]{1,20}$")) {

                throw new WrongLoginException();

            }
            it.next();
        }

    }
    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException {

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ошибка! Пароли не одинаковые.");
        }

        if (password.length() >= 20) {
            throw new WrongPasswordException("Ошибка! Превышена длина логина.");
        }
        CharacterIterator it = new StringCharacterIterator(password);
        while (it.current() != CharacterIterator.DONE) {
            if (!password.matches("^[a-zA-Z0-9_]{1,20}$")) {

                throw new WrongPasswordException();

            }
        }
    }
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите логин: ");
        String login = scanner.next();
        try {
            checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Введите пароль: ");
        String password = scanner.next();
        System.out.println("Повторите пароль: ");
        String confirmPassword = scanner.next();
        try {
            checkPasswords(password, confirmPassword);
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage());
        }



    }



        }

