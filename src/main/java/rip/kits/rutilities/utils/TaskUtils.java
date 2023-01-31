package rip.kits.rutilities.utils;

import rip.kits.rutilities.rUtilities;

public class TaskUtils {
    /**
     *
     * @param runnable
     */
    public static void run(Runnable runnable) {
        rUtilities.getInstance().getServer().getScheduler().runTask(rUtilities.getInstance(), runnable);
    }

    /**
     *
     * @param runnable
     */
    public static void runAsync(Runnable runnable) {
        rUtilities.getInstance().getServer().getScheduler().runTaskAsynchronously(rUtilities.getInstance(), runnable);
    }
}
