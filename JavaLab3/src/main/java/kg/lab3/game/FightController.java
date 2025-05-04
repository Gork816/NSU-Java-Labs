package kg.lab3.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FightController {
    private Map<Integer, GameCharacter> chars = new HashMap<>();
    private List<SpeedProfile> speedList = new ArrayList<>();

    public void GameTick() {
        for (SpeedProfile chr : speedList) {
            chr.SpeedTurn();
        }
        speedList.sort((a,b) -> Integer.compare(b.GetSpeedPoints(), a.GetSpeedPoints()));
        for (SpeedProfile chr : speedList) {
            if (chr.GetSpeedPoints() >= 100) {
                chr.CharTurn();
                //TODO: Add here code to call action menu for character when it will be done
            } else {
                break;
            }
        }
    }
}
