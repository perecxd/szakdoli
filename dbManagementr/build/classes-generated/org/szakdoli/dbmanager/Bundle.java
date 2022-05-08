package org.szakdoli.dbmanager;
/** Localizable strings for {@link org.szakdoli.dbmanager}. */
class Bundle {
    /**
     * @return <i>Manager</i>
     * @see ManagerTopComponent
     */
    static String CTL_ManagerAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_ManagerAction");
    }
    /**
     * @return <i>Manager Window</i>
     * @see ManagerTopComponent
     */
    static String CTL_ManagerTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_ManagerTopComponent");
    }
    /**
     * @return <i>This is a Manager window</i>
     * @see ManagerTopComponent
     */
    static String HINT_ManagerTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_ManagerTopComponent");
    }
    private Bundle() {}
}
