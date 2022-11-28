package io.github.hammynl.powerfulpunishments.utils;

import io.github.hammynl.powerfulpunishments.PowerfulPunishments;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class StorageUtil {

    private FileConfiguration languageConfig = new YamlConfiguration();
    private static StorageUtil instance;

    private StorageUtil() {}

    public static StorageUtil getInstance() {
        if(instance == null) {
            instance = new StorageUtil();
        }
        return instance;
    }

    public FileConfiguration getLanguage() {
        return languageConfig;
    }

    public void setup(PowerfulPunishments plugin) {
        try
        {
            File languageFile = new File(plugin.getDataFolder(), "language.yml");
            if (!languageFile.exists()) {
                languageFile.getParentFile().mkdirs();
                plugin.saveResource("language.yml", false);

            }
            languageConfig.load(languageFile);
        } catch (IOException | InvalidConfigurationException exception) {
            exception.printStackTrace();
        }

    }

}
