package org.szakdoli.addmember;
/** Localizable strings for {@link org.szakdoli.addmember}. */
class Bundle {
    /**
     * @return <i>addmember</i>
     * @see addmemberTopComponent
     */
    static String CTL_addmemberAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_addmemberAction");
    }
    /**
     * @return <i>addmember Window</i>
     * @see addmemberTopComponent
     */
    static String CTL_addmemberTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_addmemberTopComponent");
    }
    /**
     * @return <i>This is a addmember window</i>
     * @see addmemberTopComponent
     */
    static String HINT_addmemberTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_addmemberTopComponent");
    }
    private Bundle() {}
}
