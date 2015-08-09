package us.pawgames.hub.events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import us.pawgames.hub.inventory.PlayerInventory;
import us.pawgames.hub.pvp.EquipPvPGear;

public class HubEventHandler implements Listener{
	private Plugin plugin;
	
	public HubEventHandler(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	private void inventoryClick(InventoryClickEvent event) {
		if(event.getWhoClicked() instanceof Player) {
			Player player = (Player) event.getWhoClicked();
			if(event.getClickedInventory() == player.getInventory()) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	private void playerDropItem(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	private void playerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		EquipPvPGear equipment = new EquipPvPGear(player);
		Inventory inventory = player.getInventory();
		if(inventory.getItem(event.getNewSlot()).getType() == Material.DIAMOND_SWORD) {
			equipment.diamondGear();
		} else {
			equipment.unequip();
		}
	}
	
	@EventHandler
	private void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setGameMode(GameMode.ADVENTURE);
		String joinMessage = ChatColor.LIGHT_PURPLE + "Welcome "
							+ player.getDisplayName() + ChatColor.LIGHT_PURPLE
							+ " to PAWGames";
		player.sendMessage(joinMessage);
		new PlayerInventory(player).setPlayerInventory();
	}
	
	@EventHandler
	private void playerPickupItem(PlayerPickupItemEvent event) {
		event.setCancelled(true);
	}
	
	@EventHandler
	private void weatherChange(WeatherChangeEvent event){
		event.setCancelled(true);
	}
}
