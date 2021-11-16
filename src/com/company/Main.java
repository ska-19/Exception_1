package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String login = sc.next();
        String password = sc.next();
        String confirmPassword = sc.next();
        try {
            System.out.println(login(login, password, confirmPassword));
        }
        catch (WrongLoginException e){
            System.out.println("This is WrongLoginException");
        }
        catch (WrongPasswordException e){
            System.out.println("This is WrongPasswordException");
        }


    }

    public static class WrongLoginException extends Exception {
        public WrongLoginException(){
            super();
        }
        public WrongLoginException(String descry){
            super(descry);
        }
    }
    public static class WrongPasswordException extends Exception {
        public WrongPasswordException(){
            super();
        }
        public WrongPasswordException(String descry){
            super(descry);
        }
    }

    public static boolean login(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if(login.length()>19){
            throw new WrongLoginException();
        }else{
            char[] xArr = login.toCharArray();
            for (char x:xArr){
                int i = (int) x;
                if(x>122||x<48){throw new WrongLoginException();}
                if (57<x&&x<65){throw new WrongLoginException();}
                if (90<x&&x<97&&x!=95){throw new WrongLoginException();}
            }
        }

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException();
        }
        char[] xArr = password.toCharArray();
        for (char x:xArr){
            int i = (int) x;
            if(x>122||x<48){throw new WrongPasswordException();}
            if (57<x&&x<65){throw new WrongPasswordException();}
            if (90<x&&x<97&&x!=95){throw new WrongPasswordException();}
        }
        return true;
    }

}
