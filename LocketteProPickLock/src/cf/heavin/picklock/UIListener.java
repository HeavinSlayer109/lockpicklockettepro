	package cf.heavin.picklock;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;

public class UIListener implements Listener{
	public static HashMap<Player, Integer> picklockNum = new HashMap<Player, Integer>();
	public HashMap<Player, Integer> playerSlot = new HashMap<Player, Integer>();
	int i1 = 0;
	int i2 = 0;
	int i3 = 0;
	int i4 = 0;
	int i5 = 0;
	int i6 = 0;
	@EventHandler
	public void onGuiInteract(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
	    if (e.getCurrentItem() == null) return;
		if (e.getView().getTitle().contains(ChatColor.BLACK +"LockPick Puzzle")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.BLUE_STAINED_GLASS_PANE) {	 
				int slot = e.getSlot();
				playerSlot.put(player, slot);
				String str = e.getView().getTitle(); 
				new UserInput(player, slot, Integer.valueOf(str.substring(str.length() - 1)));
				if (e.getView().getTitle().contains("1")) {
					if (picklockNum.containsKey(player)) {
						Integer i = picklockNum.get(player);
						picklockNum.replace(player, i++);
					} else if (!(picklockNum.containsKey(player))) {
						picklockNum.put(player, 1);
					}
					if (picklockNum.get(player) == 7) {
						picklockNum.remove(player);
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (playerSlot.get(player) == 22) {
						
				}}
				
				
				
				
				if (e.getView().getTitle().contains("1")) {
					
					i1++;
					if (i1 == 7) {
						i1 = 0;
						
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 22 || slot == 24 || slot == 30) {
						PickLock.reset(player);
					}
					
				} else if (e.getView().getTitle().contains("2")) {
					i2++;
					if (i2 == 5) {
						i2 = 0;
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 20 || slot == 22 || slot == 23 || slot == 30 || slot == 31) {
						PickLock.reset(player);
					}
				} else if (e.getView().getTitle().contains("3")) {
					i3++;
					if (i3 == 6) {
						i3 = 0;
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 23 || slot == 30 || slot == 32 || slot == 33) {
						PickLock.reset(player);
					}
				} else if (e.getView().getTitle().contains("4")) {
					i4++;
					if (i4 == 5) {
						i4 = 0;
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 21 || slot == 23 || slot == 24 || slot == 29 || slot == 32) {
						PickLock.reset(player);
					}
				} else if (e.getView().getTitle().contains("5")) {
					i5++;
					if (i5 == 5) {
						i5 = 0;
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 20 || slot == 21 || slot == 23 || slot == 31 || slot == 32) {
						PickLock.reset(player);
					}
				} else if (e.getView().getTitle().contains("6")) {
					i6++;
					if (i6 == 6) {
						i6 = 0;
						PickLock.finish(player, PickLock.getBlockLoc(player));
					}
					if (slot == 22 || slot == 29 || slot == 32 || slot == 33) {
						PickLock.reset(player);
					}
				}
				
			}
		}
	}



}
