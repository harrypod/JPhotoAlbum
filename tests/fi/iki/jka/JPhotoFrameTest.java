package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JPhotoFrameTest {
    @Test
    public void showsImage() throws Exception {
        String files[]= new String[2];
        files[0] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum.jpg";
        files[1] = "/home/APE/ape11/JPhotoAlbum/web/JPhotoAlbum2.jpg";
        JPhotoFrame jPhotoFrame = new JPhotoFrame(null, files);
        jPhotoFrame.actionPerformed(new ActionEvent(jPhotoFrame, 0, JPhotoMenu.A_SLIDESHOW));
        assertEquals(jPhotoFrame.showsImage, true);
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
        Thread.sleep(500);
        String secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertNotEquals(secondFile,files[1]);
        Thread.sleep(4500);
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
        Thread.sleep(50);
        String secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertNotEquals(secondFile,files[1]);
        Thread.sleep(450);
        secondFile = jPhotoFrame.show.panel.getPhoto().getFullOriginalName();
        assertEquals(secondFile, files[1]);
    }
}