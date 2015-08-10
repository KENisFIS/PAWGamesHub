package us.pawgames.hub.events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.plugin.Plugin;

import us.pawgames.hub.effects.Particle;
import us.pawgames.hub.inventory.PlayerHubInventory;
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
			if(player.getGameMode() != GameMode.CREATIVE) {
				if(event.getClickedInventory() == player.getInventory()) {
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
	private void playerDropItem(PlayerDropItemEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	private void playerItemHeld(PlayerItemHeldEvent event) {
		Player player = event.getPlayer();
		EquipPvPGear equipment = new EquipPvPGear(player);
		if(event.getNewSlot() == 1) {
			equipment.diamondGear();
		} else if(event.getNewSlot() != 1){
			equipment.unequip();
		}
	}
	
	@EventHandler
	private void playerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		player.setGameMode(GameMode.ADVENTURE);
		new PlayerHubInventory(player).setPlayerInventory();
		if(player.hasPermission("particle.special")) {
			new Particle(plugin).createPart(player);
		}

	}
	
	@EventHandler
	private void playerPickupItem(PlayerPickupItemEvent event) {
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	private void weatherChange(WeatherChangeEvent event){
		event.setCancelled(true);
	}
}