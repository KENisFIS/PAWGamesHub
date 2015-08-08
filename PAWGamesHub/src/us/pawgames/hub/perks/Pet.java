package us.pawgames.hub.perks;

import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Pet {
	
	public Pet(Player player, EntityType type) {
		// Pet types: Blaze, CaveSpider, Chicken, Cow, Creeper, Enderman, Endermite,
		//            Giant, Golem, Guardian, Horse, IronGolem, MushroomCow, Ocelot,
		//            Pig, PigZombie, Rabbit, Sheep, Silverfish, Skeleton, Snowman,
		//            Spider, Villager, Witch, Wither, Wolf, Zombie
		
		Creature pet = (Creature) player.getWorld().spawnEntity(player.getLocation(), type);
		pet.setTarget(player);
		String originalName = pet.getName();
		pet.setCustomName(player.getName() + "'s " +  originalName);
	}
}
