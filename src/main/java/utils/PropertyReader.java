package utils;


import common.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is a helper class for reading property from .properties file.
 */
public class PropertyReader {

    /**
     * This method reads propertyName from "config.properties" file.
     * returns the value of the given key.
     *
     * @param propertyName the property to read from.
     * @return the property string value.
     */
    public static String readConfigItem(String propertyName) {
        return readItemFromFile(Constants.CONFIG_PATH, propertyName);
    }

    /**
     * This method reads propertyName from "elementsRepo.properties" file.
     * returns the value of the given key.
     *
     * @param propertyName the property to read from.
     * @return the property string value.
     */
    public static String readElementsRepoItem(String propertyName) {
        return readItemFromFile(Constants.ELEMENT_REPO_PATH, propertyName);
    }

    /**
     * This method loads the properties file using given path and return the value of the given key.
     *
     * @param path         the properties file path.
     * @param propertyName the property to read from.
     * @return the property string value.
     */
    public static String readItemFromFile(String path, String propertyName) {
        Properties p = new Properties();
        try {
            FileInputStream inputFile = new FileInputStream(path);
            p.load(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return p.getProperty(propertyName);
    }
}
