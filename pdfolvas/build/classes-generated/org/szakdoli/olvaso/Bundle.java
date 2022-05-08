package org.szakdoli.olvaso;
/** Localizable strings for {@link org.szakdoli.olvaso}. */
class Bundle {
    /**
     * @return <i>pdfolvaso</i>
     * @see pdfolvasoTopComponent
     */
    static String CTL_pdfolvasoAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_pdfolvasoAction");
    }
    /**
     * @return <i>pdfolvaso Window</i>
     * @see pdfolvasoTopComponent
     */
    static String CTL_pdfolvasoTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_pdfolvasoTopComponent");
    }
    /**
     * @return <i>This is a pdfolvaso window</i>
     * @see pdfolvasoTopComponent
     */
    static String HINT_pdfolvasoTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_pdfolvasoTopComponent");
    }
    private Bundle() {}
}
