 package cf.heavin.picklock;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class StartLockPicking {
	
	public StartLockPicking(Player player) {
		Inventory gui = Bukkit.createInventory(null, 54, ChatColor.BLACK + "LockPick Puzzle");
		
		/*
		 *  FILLER
		 */
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS, 1);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.setDisplayName(ChatColor.BLACK + "  ");
		for (int i = 0; i <gui.getSize(); i++) {
			if (gui.getItem(i) == null) {
			fillerMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			filler.setItemMeta(fillerMeta);
			gui.setItem(i, filler);
			}
		}
		
		
		
		player.openInventory(gui);
	}
	

}
