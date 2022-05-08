package org.szakdoli.bigbuttons;
/** Localizable strings for {@link org.szakdoli.bigbuttons}. */
class Bundle {
    /**
     * @return <i>menufele</i>
     * @see menufeleTopComponent
     */
    static String CTL_menufeleAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_menufeleAction");
    }
    /**
     * @return <i>menufele Window</i>
     * @see menufeleTopComponent
     */
    static String CTL_menufeleTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_menufeleTopComponent");
    }
    /**
     * @return <i>This is a menufele window</i>
     * @see menufeleTopComponent
     */
    static String HINT_menufeleTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_menufeleTopComponent");
    }
    private Bundle() {}
}
