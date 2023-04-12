package pt.danielduarte.ChatGPT.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

class ConfigParserTest {

    @Test
    void testParseSimpleConfig() throws IOException {
        Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("simple_config.properties"));

        System.out.println(config.get("token"));

        assertNotNull(config, "config cannot be null");
        assertEquals("HelloWorld!" , config.get("token"));
        assertEquals("ChatGPTClient", config.get("applicationName"));
        assertEquals(2, config.size());
        assertNull(config.get("Batatas"),"non existing config value should not have a map enconter");
    }
    @Test
    void testParseEmptyValue() throws IOException {
        Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("empty_value.properties"));
        assertNotNull(config, "config cannot be null");
        assertEquals("", config.get("token"));
        assertEquals("ChatGPTClient", config.get("applicationName"));
        assertEquals(2, config.size());
    }

    @Test
    void testNoSeprarator() throws IOException {
        Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("no_separator.properties"));
        assertNotNull(config, "config cannot be null");
        assertEquals("HelloWorld!" , config.get("token"));
        assertEquals("Daniel", config.get("username"));
        assertNull(config.get("applicationName"));
        assertEquals(2, config.size());
    }

    @Test
    void testIgnoreCommentedAndEmptyLines() throws IOException {
        Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("with_comments.properties"));
        assertNotNull(config, "config cannot be null");
        assertEquals(3, config.size());
        assertEquals("HelloWorld!", config.get("token"));
        assertEquals("ChatGPTClient", config.get("applicationName"));
        assertEquals("noreply@localhost", config.get("emailAddress"));
    }

    @Test
    void testEmptyFile() throws IOException {
        Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("empty.properties"));

        assertNotNull(config, "config cannot be null");
        assertEquals(0 , config.size());
    }

    @Test
    void testFileNotFound() throws IOException{
        assertThrows(FileNotFoundException.class,() ->{
            Map<String, String> config = ConfigParser.parse(getTestResourcesConfigFilePath("nonexistent.properties"));
        });
    }
    private String getTestResourcesConfigFilePath(String fileName){
        Path resourcesDirectory = Paths.get("src","test","resources",fileName);
        return resourcesDirectory.toFile().getAbsolutePath();
    }
}