package nl.mawoo.migratejs.input;

/**
 * This class is responsible for the file extention check.
 * A little security feature so you can't throw any file into the engine.
 *
 * @author Bob van der Valk
 */
public class InputHandler {

    /**
     * Check if a file has the .js Extention
     * @param file Path you want to run into the engine.
     * @return boolean
     */
    public static boolean jsExtention(String file) {
        String[] array = file.split(".");
        int lenght = array.length - 1;

        return array[lenght].equals("js") || array[lenght].equals("JS");
    }

    /**
     * Check if a file has the .io Extention
     * @param file Path you want to run into the engine.
     * @return boolean
     */
    public static boolean ioExtention(String file) {
        String[] array = file.split(".");
        int lenght = array.length - 1;

        return array[lenght].equals("io") || array[lenght].equals("IO");
    }

}
