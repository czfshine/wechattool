package cn.czfshine.wechat.audio.decoder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SlikDecoderTest {

    SlikDecoder slikDecoder;
    @Before
    public void setUp() throws Exception {
        slikDecoder=new SlikDecoder("./wechat-dump/third-party/silk/decoder","/usr/bin/ffmpeg");
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void decode() {
        slikDecoder.decode("/home/czfshine/workplace/wechattool/../wechat/data/voice/voice20190209/b0/c7/msg_16160805271850bf14dafd7105.amr"
                ,"./testdata/test.mp3");
    }
}