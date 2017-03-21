package com.mikalai.cucumber.test.account.support;

/**
 * Created by Mikalai_Churakou on 3/22/2017.
 */
public class AtmInterfaceFactory {
    private static boolean bypassTellerUI = false;
    public static void reset() {
        bypassTellerUI = false;
    }
    public static void bypassTellerUI() {
        bypassTellerUI = true;
    }
    public static AtmInterface createAtmInterface() {
        if (bypassTellerUI) {
            return new AtmProgrammaticInterface();
        } else {
            return new AtmUserInterface();
        }
    }
}
