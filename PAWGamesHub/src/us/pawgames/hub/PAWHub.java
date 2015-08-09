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
		// TODO Auto-generated method stub
		super.onEnable();

		getServer().getPluginManager().registerEvents(new HubEventHandler(this), this);

		for (World world : getServer().getWorlds()) {
			world.setWeatherDuration(0);
			world.setStorm(false);
		}

	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			sender.sendMessage("onCommand");
			if (label.equalsIgnoreCase("pet")) {
				sender.sendMessage("passed if statement");
				new Pet(player, EntityType.COW);
			}
		}
		return true;
	}
}
