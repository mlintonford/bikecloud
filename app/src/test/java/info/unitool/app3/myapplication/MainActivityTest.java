package info.unitool.app3.myapplication;

/**
 * Created by Matthew on 25/12/2017.
 */

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( { GameManager.class })
public class MainActivityTest {

    @Test
    public void testOnCreate() throws Exception {
        GameManager gameManager = PowerMock.createMock(GameManager.class);
        PowerMock.expectNew(GameManager.class).andReturn(gameManager);

    }
}
