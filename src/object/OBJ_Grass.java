package object;

import javafx.scene.image.Image;
import main.GamePanel;
import java.util.Random;

public class OBJ_Grass extends SuperObject {

    public OBJ_Grass() {
        name = "Grass";
        description = "[" + name + "]";
        try {
            image = new Image("file:res/zeldaobjects/Grass.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        collision = true;
    }

    @Override
    public boolean interact(GamePanel gPanel) {
        if (gPanel.player.inventory.containsItem("Sword") && gPanel.player.inputHandler.isAttackPressed()) {
            // Logique pour gérer la coupe de l'herbe
            Random rand = new Random();
            int chance = rand.nextInt(100);
            if (chance < 20) { // 20% de chance de drop un rubis
                gPanel.player.addRuby(1);
            } else if (chance < 70) { // 50% de chance de drop un coeur
                gPanel.player.addHeart(1);
            }
            return true; // Indiquer que l'herbe a été coupée
        }
        return false;
    }
}
