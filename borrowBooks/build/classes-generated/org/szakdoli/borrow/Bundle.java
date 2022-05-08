package org.szakdoli.borrow;
/** Localizable strings for {@link org.szakdoli.borrow}. */
class Bundle {
    /**
     * @return <i>borrowBooks</i>
     * @see borrowBooksTopComponent
     */
    static String CTL_borrowBooksAction() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_borrowBooksAction");
    }
    /**
     * @return <i>borrowBooks Window</i>
     * @see borrowBooksTopComponent
     */
    static String CTL_borrowBooksTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "CTL_borrowBooksTopComponent");
    }
    /**
     * @return <i>This is a borrowBooks window</i>
     * @see borrowBooksTopComponent
     */
    static String HINT_borrowBooksTopComponent() {
        return org.openide.util.NbBundle.getMessage(Bundle.class, "HINT_borrowBooksTopComponent");
    }
    private Bundle() {}
}
