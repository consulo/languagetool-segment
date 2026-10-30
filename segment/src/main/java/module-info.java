module net.loomchild.segment {
    requires transitive java.xml;
    requires transitive jakarta.xml.bind;
    requires org.slf4j;

    exports net.loomchild.segment;
    exports net.loomchild.segment.srx;
    exports net.loomchild.segment.srx.io;
    exports net.loomchild.segment.srx.legacy;
    exports net.loomchild.segment.util;
    exports net.loomchild.segment.srx.io.bind;

    opens net.loomchild.segment.srx.io.bind to jakarta.xml.bind;
    // ClassLoader resource lookups must also work across module boundaries.
    opens net.loomchild.segment.res.xml;
}
