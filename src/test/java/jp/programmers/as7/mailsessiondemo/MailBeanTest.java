package jp.programmers.as7.mailsessiondemo;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MailBeanTest {
    @Inject
    MailBean mailBean;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar")
            .addClasses(MailBean.class)
            .addAsResource(EmptyAsset.INSTANCE, "META-INF/beans.xml");
    }

    @Test
    public void callSendTestMessage() throws Exception {
        mailBean.sendTestMessage();
        assertTrue(true); // ok, no exception
    }
}
