/*
 * Copyright (C) 2015-2018 Daniel Saukel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.erethon.itemsxl.config;

import de.erethon.commons.config.Message;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * @author Daniel Saukel
 */
public enum IMessage implements Message {

    ERROR_NO_OBJECT("error.noObject", "&cThis &v1 does not exist."),
    ERROR_NO_PERMISSION("error.noPermission", "&cYou do not have permission to use the command &o&v1&r&c."),
    ERROR_NO_CONSOLE_COMMAND("error.noConsoleCommand", "&cThe command &o&v1&r&c is not a console command!"),
    ERROR_NO_ITEM_BOX("error.noItemBox", "&cThis is not a valid item box."),
    ERROR_NO_PLAYER_COMMAND("error.noPlayerCommand", "&cThe command &o&v1&r&c is not a player command!"),
    ERROR_COORDS_NOT_NUMERIC("error.coordsNotNumeric", "&4Coordinates must be numeric."),
    COMMAND_GIVE_SUCCESS("command.give.success", "&7You gave &o&v1x &v2&7 to &o&v3&7."),
    COMMAND_MAIN_WELCOME("command.main.welcome", "&7Welcome to &4Items&fXL"),
    COMMAND_MAIN_LOADED("command.main.loaded", "&eItems loaded: &o[&v1] (custom) &e| &o[&v2] (vanilla)"),// &eRecipes loaded: &o[&v2]"),
    COMMAND_MAIN_COMPATIBILITY("command.main.compatibility", "&eInternals: &o[&v1]"),
    COMMAND_MAIN_HELP("command.main.help", "&7Type in &o/ixl help&r&7 for further information."),
    COMMAND_OPEN_SUCCESS("command.open.success", "&7You opened the box. You found the item &o&v1&7!"),
    COMMAND_RELOAD_SUCCESS("command.reload.success", "&7Successfully reloaded ItemsXL."),
    COMMAND_SERIALIZE_SUCCESS("command.serialize.success", "&7Successfully serialized item. Have a look at the &oItemsXL/serialized.yml&r&7 file."),
    HELP_GIVE("help.give", "&7Give an item to a player. Usage: &o/ixl give [player=you] [id] ([amount=1]) (box)"),
    HELP_HELP("help.help", "&7Show command help. Usage: &o/ixl help [page]"),
    HELP_INFO("help.info", "&7Show information about an item. Usage: &o/ixl info [item]"),
    HELP_LIST("help.list", "&7List all custom items. Usage: &o/ixl list [page]"),
    HELP_MAIN("help.main", "&7General status information."),
    HELP_OPEN("help.open", "&7Open the item box in your hand."),
    HELP_RELOAD("help.reload", "&7Reload all configs and data. Usage: &o/ixl reload"),
    HELP_SERIALIZE("help.serialize", "&7Serialize the item stack in your hand. Usage: &o/ixl serialize ([bukkit|caliburn])"),
    HELP_SUMMON("help.summon", "&7Summons a mob. Usage: &o: /ixl summon [mob] ([world x y z yaw pitch])"),
    OBJECT_PLAYER("object.player", "player"),
    OBJECT_ITEM("object.item", "item"),
    OBJECT_MOB("object.mob", "mob"),
    OBJECT_WORLD("object.world", "world");

    private String identifier;
    private String message;

    IMessage(String identifier, String message) {
        this.identifier = identifier;
        this.message = message;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getRaw() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    /* Statics */
    /**
     * @param identifier the identifier to set
     */
    public static Message getByIdentifier(String identifier) {
        for (Message message : values()) {
            if (message.getIdentifier().equals(identifier)) {
                return message;
            }
        }
        return null;
    }

    /**
     * @return a FileConfiguration containing all messages
     */
    public static FileConfiguration toConfig() {
        FileConfiguration config = new YamlConfiguration();
        for (IMessage message : values()) {
            config.set(message.getIdentifier(), message.message);
        }
        return config;
    }

}
