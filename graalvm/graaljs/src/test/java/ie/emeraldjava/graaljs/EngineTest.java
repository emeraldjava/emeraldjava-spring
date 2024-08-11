package ie.emeraldjava.graaljs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * https://stackoverflow.com/questions/78494484/scriptengine-javascript-in-springboot-with-java-17
 */
@Slf4j
@SpringBootTest
public class EngineTest {

    @Test
    void factoryTest(){
        ScriptEngineManager manager = new ScriptEngineManager();
        assertFalse(manager.getEngineFactories().isEmpty());
    }

    @Test
    void test1(){
        assertNotNull(getScriptEngineByName("js"));
    }

    @Test
    void test2(){
        assertNotNull(getScriptEngineByName("Javascript"));
    }

    @Test
    void test3(){
        assertNotNull(getScriptEngineByName("JavaScript"));
    }

    @Test
    void test4(){
        assertNotNull(getScriptEngineByName("graal.js"));
    }

    @Test
    void test5(){
        assertNotNull(getScriptEngineByExtension("js"));
    }

    @Test
    void test6(){
        assertNotNull(getScriptEngineByExtension("Javascript"));
    }

    @Test
    void test7(){
        assertNotNull(getScriptEngineByExtension("JavaScript"));
    }

    @Test
    void test8(){
        assertNotNull(getScriptEngineByExtension("graal.js"));
    }

    private ScriptEngine getScriptEngineByName(String name) {
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByName(name);
    }

    private ScriptEngine getScriptEngineByExtension(String extension){
        ScriptEngineManager manager = new ScriptEngineManager();
        return manager.getEngineByExtension(extension);
    }
}
