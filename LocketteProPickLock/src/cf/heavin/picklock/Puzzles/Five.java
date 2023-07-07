package cf.heavin.picklock.Puzzles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import cf.heavin.picklock.PickLock;

public class Five {
	public Five(Player player) {
		PickLock.lockPicking.put(player, 5);
Inventory gui = Bukkit.createInventory(null, 54, ChatColor.BLACK + "Memorize the puzzle 5");
		
		ItemStack picked = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
		ItemMeta pickedMeta = picked.getItemMeta();
		pickedMeta.setDisplayName(ChatColor.GREEN + "Memorize the green tiles!");
		picked.setItemMeta(pickedMeta);
		gui.setItem(22, picked);
		gui.setItem(24, picked);
		gui.setItem(29, picked);
		gui.setItem(30, picked);
		gui.setItem(33, picked);
		
		/*
		 *  FILLER
		 */
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.setDisplayName(ChatColor.GREEN + "Memorize the green tiles!");
		
		ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
		ItemMeta whiteMeta = white.getItemMeta();
		whiteMeta.setDisplayName(ChatColor.GREEN + "Memorize the green tiles!");
		
		ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
		ItemMeta blueMeta = white.getItemMeta();
		whiteMeta.setDisplayName(ChatColor.GREEN + "Memorize the green tiles!");
		white.setItemMeta(whiteMeta);
		gui.setItem(19, white);
		gui.setItem(28, white);
		gui.setItem(25, white);
		gui.setItem(34, white);
		for (int i = 10; i <17; i++) {
			if (gui.getItem(i) == null) {
			whiteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			white.setItemMeta(whiteMeta);
			gui.setItem(i, white);
			}
		}
		for (int i = 37; i <44; i++) {
			if (gui.getItem(i) == null) {
			whiteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			white.setItemMeta(whiteMeta);
			gui.setItem(i, white);
			}
		}
		for (int i = 20; i <25; i++) {
			if (gui.getItem(i) == null) {
			blueMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			blue.setItemMeta(blueMeta);
			gui.setItem(i, blue);
			}
		}
		for (int i = 29; i <34; i++) {
			if (gui.getItem(i) == null) {
			blueMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', " "));
			blue.setItemMeta(blueMeta);
			gui.setItem(i, blue);
			}
		}
		
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
