package module9.theory.warriors;

import java.util.ArrayList;
import java.util.List;

public class WarriorsManager {
    public static void main(String[] args) {

        Warrior boromir = new Fighter(100);
        Fighter aragorn = new Fighter(500);

        Warrior gendalf = new Sorcerer(1000);
        Sorcerer saruman = new Sorcerer(1100);

        List<Fighter> teamA = new ArrayList<>();
        List<Warrior> teamB = new ArrayList<>();

        teamA.add(aragorn);
        teamA.add(aragorn);

        teamB.add(gendalf);

        System.out.println("fight(boromir, gendalf) = " + fight(boromir, gendalf));
        System.out.println("fight(teamB, teamB) = " + fight(teamA, teamB));


    }

    private static boolean fight(Warrior firstWarrior,
                                 Warrior secondWarrior) {
        return firstWarrior.power > secondWarrior.power;
    }

//    private static boolean fight(List<Warrior> firstWarriors,
//                                 List<Warrior> secondWarriors) {
//
//        int firstPowerTotal = 0;
//        int secondPowerTotal = 0;
//
//        for (Warrior warrior : firstWarriors) {
//            firstPowerTotal += warrior.power;
//        }
//
//        for (Warrior warrior : secondWarriors) {
//            secondPowerTotal += warrior.power;
//        }
//
//        return firstPowerTotal > secondPowerTotal;
//    }

    private static boolean fight(List<? extends Warrior> firstWarriors,
                                 List<? extends Warrior> secondWarriors) {

        int firstPowerTotal = 0;
        int secondPowerTotal = 0;

        for (Warrior warrior : firstWarriors) {
            firstPowerTotal += warrior.power;
        }

        for (Warrior warrior : secondWarriors) {
            secondPowerTotal += warrior.power;
        }

        return firstPowerTotal > secondPowerTotal;
    }
}
