package net.bikashmod.firstmod.event;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PlayerEvents {

    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        AttributeInstance speed = player.getAttribute(Attributes.MOVEMENT_SPEED);
        if (speed != null) {
            speed.setBaseValue(0.15);
        }


        AttributeInstance health = player.getAttribute(Attributes.MAX_HEALTH);
        if (health != null) {
            health.setBaseValue(40);
            player.setHealth(40.0F);
        }

        AttributeInstance attack = player.getAttribute(Attributes.ATTACK_DAMAGE);
        if (attack != null) {
            attack.setBaseValue(8.0);
        }
        AttributeInstance fall = player.getAttribute(Attributes.SAFE_FALL_DISTANCE);
        if (attack != null) {
            attack.setBaseValue(110);
        }
    }
}