package com.example.services;

/**
 * Contiene las constantes de las acciones de los servicios y sus parámetros
 */
public class Constants {
    /**
     * Constantes para {@link MemoryService}
     */
    public static final String ACTION_RUN_SERVICE = "com.example.services.action.RUN_SERVICE";
    public static final String ACTION_MEMORY_EXIT = "com.example.services.action.MEMORY_EXIT";

    public static final String EXTRA_MEMORY = "com.example.services.extra.MEMORY";

    /**
     * Constantes para ProgressIntentService
     */
    public static final String ACTION_RUN_ISERVICE = "com.example.services.action.RUN_INTENT_SERVICE";
    public static final String ACTION_PROGRESS_EXIT = "com.example.services.action.PROGRESS_EXIT";

    public static final String EXTRA_PROGRESS = "com.example.services.extra.PROGRESS";

}
