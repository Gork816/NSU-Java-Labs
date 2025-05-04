package kg.lab3.game;

import java.util.Map;

//TODO: Maybe should rework speed system cuz planned speed buffs/debuffs
public class SpeedProfile {
    private int id;
    private int speed;

    private int speed_points = 0;

    public SpeedProfile(Map<Integer, GameCharacter> chars, int id) {
        this.id = id;
        this.speed = chars.get(id).GetSpeed();
    }

    public void SpeedTurn() {
        speed_points += speed;
    }

    public int GetSpeedPoints() {
        return speed_points;
    }

    public void CharTurn() {
        speed_points -= 100;
    }
}
