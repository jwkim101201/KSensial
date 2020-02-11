package ksensial.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class VanishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(sender.getName() + ", only players can execute this command!");
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("ksensial.vanish")) {
                if (p.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                    p.sendMessage("��e����� ����ȭ ���°� Ǯ�Ƚ��ϴ�.");
                } else {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999999, 1));
                    p.sendMessage("��e����� ���� �����鿡�� ������ �ʽ��ϴ�.");
                }
            }
        }
        return true;
    }
}
