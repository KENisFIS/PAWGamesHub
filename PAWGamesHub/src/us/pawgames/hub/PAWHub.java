package us.pawgames.hub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import us.pawgames.hub.inventory.CustomItem;
import us.pawgames.hub.perks.Pet;

public class PAWHub extends JavaPlugin implements Listener {

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();

		getServer().getPluginManager().registerEvents(this, this);

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

	public void setPlayerInventory(Player player) {
		Inventory playerInventory = player.getInventory();
		player.getInventory().clear();
		
		CustomItem compass = new CustomItem(Material.COMPASS, 1);
		compass.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Select a Game");
		ArrayList<String> compassLore = new ArrayList<String>();
		compassLore.add(ChatColor.AQUA + "Plan to have all available servers");
		compassLore.add(ChatColor.AQUA + "listed with online status");
		compass.setLore(compassLore);
		playerInventory.setItem(0, compass);
		
		CustomItem pvpSword = new CustomItem(Material.DIAMOND_SWORD, 1);
		pvpSword.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "PAW");
		ArrayList<String> pvpSwordLore = new ArrayList<String>();
		pvpSwordLore.add(ChatColor.AQUA + "You can use /sword [swordname]");
		pvpSwordLore.add(ChatColor.AQUA + "to create your own custom sword.");
		pvpSword.setLore(pvpSwordLore);
		playerInventory.setItem(1, pvpSword);
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
