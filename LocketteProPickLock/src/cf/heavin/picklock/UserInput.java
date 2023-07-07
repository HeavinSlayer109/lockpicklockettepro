package cf.heavin.picklock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UserInput {
	
	public UserInput(Player player, int slot, int rand) {
		if (PickLock.slotsPicked.containsKey(player)) {
			PickLock.slotsPicked.replace(player, PickLock.slotsPicked.get(player) + "," + slot);
		} else if (!(PickLock.slotsPicked.containsKey(player))) {
			PickLock.slotsPicked.put(player, String.valueOf(slot));
		}
		
		Inventory gui = Bukkit.createInventory(null, 54, ChatColor.BLACK + "LockPick Puzzle " + rand);
		
		ItemStack picked = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
		ItemMeta pickedMeta = picked.getItemMeta();
		pickedMeta.setDisplayName(ChatColor.GREEN + "Picked!");
		picked.setItemMeta(pickedMeta);
		
		String[] eyy = PickLock.slotsPicked.get(player).split(",");
		for (int x = 0; x < eyy.length; x++) {
			gui.setItem(Integer.valueOf(eyy[x]), picked);
		}
		
		
		/*
		 *  FILLER
		 */
		ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
		ItemMeta fillerMeta = filler.getItemMeta();
		fillerMeta.setDisplayName(ChatColor.BLACK + "  ");
		
		ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
		ItemMeta whiteMeta = white.getItemMeta();
		whiteMeta.setDisplayName(ChatColor.BLACK + "  ");
		
		ItemStack blue = new ItemStack(Material.BLUE_STAINED_GLASS_PANE, 1);
		ItemMeta blueMeta = white.getItemMeta();
		whiteMeta.setDisplayName(ChatColor.BLACK + "  ");
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
