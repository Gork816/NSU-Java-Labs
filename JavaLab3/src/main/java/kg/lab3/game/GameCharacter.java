package kg.lab3.game;

import java.util.List;
import java.util.ArrayList;

public class GameCharacter {
    private int id;

    private int maxHP;
    private int maxMP;
    private int physDEF;
    private int magDEF;
    private int speed;
    private List<Skill> skills = new ArrayList<>();

    private float currentHP;
    private float currentMP;
    private List<Effect> activeEffects = new ArrayList<>();
    private CharTeam team;


    public int GetSpeed() {
        return speed;
    }
}
