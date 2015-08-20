//Created by KENisFIS & Voxel
//Do not redistribute this or modify it.
package us.pawgames.hub;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import us.pawgames.hub.events.HubEventHandler;
import us.pawgames.hub.perks.Pet;

public class PAWHub extends JavaPlugin {

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new HubEventHandler(this), this);

		for (World world : getServer().getWorlds()) {
			world.setWeatherDuration(0);
			world.setStorm(false);
		}

	} 

	@Override
	public void onDisable() {
		
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("pet")) {
				new Pet(player, EntityType.RABBIT);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
    }