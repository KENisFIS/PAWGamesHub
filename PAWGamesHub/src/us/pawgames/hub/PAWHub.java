package us.pawgames.hub;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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

public class PAWHub extends JavaPlugin implements Listener {
	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		super.onEnable();
		
		getServer().getPluginManager().registerEvents(this, this);
		
		for(World world: getServer().getWorlds()) {
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
		
		ArrayList<String> compassLore = new ArrayList<String>();
			compassLore.add(ChatColor.AQUA + "Plan to have all available servers");
			compassLore.add(ChatColor.AQUA + "listed with online status");
		PAWInventoryUtility.createDisplay(Material.COMPASS, playerInventory, 0, "Select a Server", compassLore);
			
		ArrayList<String> pvpSwordLore = new ArrayList<String>();
			pvpSwordLore.add(ChatColor.DARK_RED + "PVP Sword is still in developement");
			pvpSwordLore.add(ChatColor.DARK_RED + "and is still not working");
			pvpSwordLore.add(ChatColor.RED + "Equip this sword to enable PvP");
			pvpSwordLore.add(ChatColor.RED + "Unequip this sword to disable PvP");
		PAWInventoryUtility.createDisplay(Material.DIAMOND_SWORD, playerInventory, 1, "PVP Toggle", pvpSwordLore);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage("onCommand");
		if(label.equalsIgnoreCase("pawtest") || command.getName().equalsIgnoreCase("pawtest") && sender.hasPermission(command.getPermission())) {
			sender.sendMessage("passed if statement");
			
			
		}
		return true;
	}
}
