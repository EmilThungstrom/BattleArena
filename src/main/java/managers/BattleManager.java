package managers;

import data.Hero;
import data.Person;

import java.util.ArrayList;
import java.util.List;

public class BattleManager {

    private RandomManager random;
    public List<String> fightEvents;

    public boolean fight(RandomManager random, Hero hero){

        this.random = random;
        fightEvents = new ArrayList<String>();
        Person opponent = new Person(random);
        int roundNumber = 0;

        while(true)
        {
            roundNumber++;
            fightEvents.add("<<< Round " + Integer.valueOf(roundNumber) + " >>>");
            fightEvents.add("Hero has " + Integer.valueOf(hero.health) + " health left");
            fightEvents.add("Opponent has " + Integer.valueOf(opponent.health) + " health left");

            fightEvents.add("Hero attacks!");
            attack(hero, opponent);
            if(opponent.health <= 0){
                fightEvents.add("The Opponent falls!");
                return true;
            }

            fightEvents.add("Opponent attacks!");
            attack(opponent, hero);
            if(hero.health <= 0){
                fightEvents.add("The Hero falls!");
                return false;
            }
        }
    }

    private void attack(Person attacker, Person defender){

        int tempA = random.nextInt(5) + 1;
        int tempD = random.nextInt(5) + 1;

        fightEvents.add
                ("Attacker attacks for " + Integer.valueOf(attacker.attack) + " + " + Integer.valueOf(tempA) +
                " Defender tries to avoid for " + Integer.valueOf(defender.defence) + " + " + Integer.valueOf(tempD));

        if(attacker.attack + tempA > defender.defence + tempD){
            defender.health--;
            fightEvents.add("Attacker hits!");
        }
        else{
            fightEvents.add("Attacker misses!");
        }
    }
}
