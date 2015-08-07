package us.pawgames.hub.inventory;

import org.bukkit.entity.Player;

public class PlayerInventory {
	private Player player;
	
	public PlayerInventory(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
