package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JPhotoFrameTest {
    int intervalUsed = 0;

    @Test
    public void showsImage() throws Exception {
        String files[]= new String[2];
        files[0] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum.jpg";
        files[1] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum2.jpg";
        JPhotoFrame jPhotoFrame = new JPhotoFrame(null, files){
            @Override
            public void slideShow(int interval) {
                intervalUsed = interval;
            }
        };
        jPhotoFrame.actionPerformed(new ActionEvent(jPhotoFrame, 0, JPhotoMenu.A_SLIDESHOW));
        assertEquals(5000, intervalUsed);
        assertEquals(jPhotoFrame.photos.getSize(), 2);
    }


    @Test
    public void showsOtherImageAfterInterval() throws Exception {
        String files[]= new String[2];
        files[0] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum.jpg";
        files[1] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum2.jpg";
        JPhotoFrame jPhotoFrame = new JPhotoFrame(null, files);
        jPhotoFrame.actionPerformed(new ActionEvent(jPhotoFrame, 0, JPhotoMenu.A_SLIDESHOW));
        String firstFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertEquals(firstFile, files[0]);
        int firstSleep = jPhotoFrame.INTERVAL / 10;
        int secondSleep = jPhotoFrame.INTERVAL - firstSleep;
        Thread.sleep(firstSleep);
        String secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertNotEquals(secondFile,files[1]);
        Thread.sleep(secondSleep);
        secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertEquals(secondFile, files[1]);
    }


    @Test
    public void showsOtherImageAfterQuickInterval() throws Exception {
        String files[]= new String[2];
        files[0] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum.jpg";
        files[1] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum2.jpg";
        JPhotoFrame jPhotoFrame = new JPhotoFrame(null, files);
        jPhotoFrame.actionPerformed(new ActionEvent(jPhotoFrame, 0, JPhotoMenu.A_QUICK_SLIDESHOW));
        String firstFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertEquals(firstFile, files[0]);
        int firstSleep = jPhotoFrame.QUICK_INTERVAL / 10;
        int secondSleep = jPhotoFrame.QUICK_INTERVAL - firstSleep;
        Thread.sleep(firstSleep);
        String secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertNotEquals(secondFile,files[1]);
        Thread.sleep(secondSleep);
        secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertEquals(secondFile, files[1]);
    }
}