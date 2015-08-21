package us.pawgames.hub.perks;


import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;


import net.minecraft.server.v1_8_R1.EntityInsentient;

public abstract class Pathfinding implements Plugin {
    public void followPlayer(Player player, LivingEntity entity, double d) {
        final LivingEntity e = entity;
        final Player p = player;
        final float f = (float) d;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                ((EntityInsentient) ((CraftEntity) e).getHandle()).getNavigation().a(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ(), f);
            }
        }, 0 * 20, 2 * 20);
    }
}