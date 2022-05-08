package org.szakdoli.addbook;
/** Localizable strings for {@link org.szakdoli.addbook}. */
class Bundle {
    /**
     * @return <i>addbooks</i>
     * @see addbooksTopComponent
     */
    static String CTL_addbooksAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_addbooksAction");
    }
    /**
     * @return <i>addbooks Window</i>
     * @see addbooksTopComponent
     */
    static String CTL_addbooksTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_addbooksTopComponent");
    }
    /**
     * @return <i>This is a addbooks window</i>
     * @see addbooksTopComponent
     */
    static String HINT_addbooksTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_addbooksTopComponent");
    }
    private Bundle() {}
}
