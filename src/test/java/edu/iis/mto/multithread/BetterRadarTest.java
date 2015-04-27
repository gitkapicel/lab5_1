package edu.iis.mto.multithread;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.concurrent.Executor;

import org.junit.Test;

public class BetterRadarTest {

	@Test
	public void launchPatriotOnceWhenNoticesAScudMissle() {
		PatriotBattery batteryMock = mock(PatriotBattery.class);
		BetterRadar radar = new BetterRadar(batteryMock);
		radar.setExecutor( new Executor() {
			@Override
			public void execute(Runnable command) {
				command.run();		
			}
		} );
		radar.notice(new Scud());
		verify(batteryMock).launchPatriot();
	}

}
