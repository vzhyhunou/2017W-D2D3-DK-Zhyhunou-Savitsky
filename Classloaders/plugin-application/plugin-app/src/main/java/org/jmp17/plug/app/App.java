package org.jmp17.plug.app;

import org.apache.log4j.*;
import org.jmp17.plug.api.Param;
import org.jmp17.plug.api.PluginApi;
import org.jmp17.plug.api.Result;

import java.io.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * Created by antonsavitsky on 2/26/17.
 */
public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);
    static {
        ConsoleAppender console = new ConsoleAppender();
        String PATTERN = "%d [%p|%c] %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.INFO);
        console.activateOptions();
        LOGGER.addAppender(console);
    }

    private static final String PLUGIN_CLASS_NAME_ATTR = "Plugin-Class-Name";
    private static final String PLUGIN_RESULT_CLASS_NAME_ATTR = "Plugin-Result-Class-Name";
    private static final String PLUGIN_PARAM_CLASS_NAME_ATTR = "Plugin-Param-Class-Name";

    public static void main(String[] args) throws IOException {
        System.out.println("---------Simple Plugin App----------");
        if (args.length == 0) {
            System.out.println("Wrong location argument. Exiting...");
            return;
        }
        String pluginsLocation = args[0];
        System.out.println("Plugins location: " + pluginsLocation);
        System.out.println("Plugins available:");
        File file = new File(pluginsLocation);
        Arrays.asList( file.list((dir, name) -> name.endsWith(".jar")) )
                .stream().forEach(System.out::println);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a name of plugin you want to execute: ");
            String jarNameToLoad = scanner.nextLine();
            if ("q".equals(jarNameToLoad)) {
                System.out.println("Exit!");
                break;
            }
            File jarToLoad = new File(pluginsLocation + File.separator + jarNameToLoad);
            JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarToLoad));
            Manifest manifest = jarInputStream.getManifest();
            String pluginClassName = manifest.getMainAttributes().getValue(PLUGIN_CLASS_NAME_ATTR);
            String pluginParamClassName = manifest.getMainAttributes().getValue(PLUGIN_PARAM_CLASS_NAME_ATTR);
            String pluginResultClassName = manifest.getMainAttributes().getValue(PLUGIN_RESULT_CLASS_NAME_ATTR);

            URL[] jarUrl = new URL[]{jarToLoad.toURI().toURL()};
            URLClassLoader classLoader = new URLClassLoader(jarUrl);

            PluginApi plugin1 = null;
            Param param = null;
            try {
                Class clazz = classLoader.loadClass(pluginClassName);
                plugin1 = (PluginApi) clazz.getConstructor().newInstance();
                Class clazzParam = classLoader.loadClass(pluginParamClassName);
                param = (Param) clazzParam.getConstructor().newInstance();
                Class clazzResult = classLoader.loadClass(pluginResultClassName);
                Result result = (Result) clazzResult.getConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            LOGGER.info(plugin1.manual());
            LOGGER.info("Result:\n:" + plugin1.run(param).toString());
            System.out.println("-----------\n");

        }
        scanner.close();
        System.out.println();
    }
}
