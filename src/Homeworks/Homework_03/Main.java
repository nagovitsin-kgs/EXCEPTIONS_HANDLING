package Homeworks.Homework_03;

import Homeworks.Homework_03.Presenter.Presenter;
import Homeworks.Homework_03.View.ConsoleView;
import Homeworks.Homework_03.View.View;

public class Main {
    public static void main(String[] args) {
        Presenter<View> prog = new Presenter<View>(new ConsoleView());
        prog.start();
    }
}
