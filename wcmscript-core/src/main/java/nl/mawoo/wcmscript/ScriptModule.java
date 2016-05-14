package nl.mawoo.wcmscript;

import com.google.inject.Module;

/**
 * This interface represents a module that can be loaded into WCMScript.
 * It is the entry-point of the plugin system.
 *
 * @author Thomas Biesaart
 */
public interface ScriptModule extends Module {
    /**
     * Get the name of this module. This name will be used to load and identify the module.
     *
     * @return the name
     */
    String getName();

    /**
     * Get the name of the variable mapping for this module.
     * <p>
     * This will be the name of the entry-point in the scripting language.
     *
     * @return the code name
     */
    String getCodeIdentifier();
}
