package us.pawgames.hub.events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import us.pawgames.hub.PAWInventoryUtility;

public class HubEventHandler {
	private Plugin plugin;
	
	public HubEventHandler(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void weatherChange(WeatherChangeEvent event){
		event.setCancelled(true);
	}
	
	@EventHandler
	public void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setGameMode(GameMode.ADVENTURE);
		String joinMessage = ChatColor.LIGHT_PURPLE + "Welcome "
							+ player.getDisplayName() + ChatColor.LIGHT_PURPLE
							+ " to PAWGames";
		player.sendMessage(joinMessage);
		//setPlayerInventory(player);
	}
	
	@EventHandler
	public void playerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		Inventory inventory = player.getInventory();
		String swordName = "PVP Toggle";
		PAWInventoryUtility.createDisplay(Material.DIAMOND_SWORD, inventory, inventory.firstEmpty(), swordName, null);
		if(inventory.getItem(event.getNewSlot()).getItemMeta().getDisplayName().equals(swordName)) {
			
		}
	}
	
	@EventHandler
	private void playerDropItem(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	private void playerPickupItem(PlayerPickupItemEvent event) {
		event.setCancelled(true);
	}

}
