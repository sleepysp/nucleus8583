package org.nucleus8583.core;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;

import org.junit.Test;

public class PublicTest {

    @Test
    public void case1() throws Exception {
        Iso8583Message msg = new Iso8583Message();
        msg.setMti("0330");
        msg.set(2, "suka2 ");
        msg.set(4, "89");

        Iso8583MessageSerializer serializer = Iso8583MessageSerializer
                .create("file:src/test/resources/META-INF/public/iso-1.xml");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        serializer.write(msg, out);

        assertEquals("0330500000000000000006suka2 000000000089", new String(out.toByteArray()));
    }
}