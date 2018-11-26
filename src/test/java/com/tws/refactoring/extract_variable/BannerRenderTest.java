package com.tws.refactoring.extract_variable;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BannerRenderTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    // given platform is "MAC" and browser is "IE"
    // when render banner
    // then it should print "Banner"
    @Test
    public void should_render_banner_if_platform_is_MAC_and_browser_is_IE() {
        new BannerRender().renderBanner("MAC", "IE");
        assertEquals("Banner", outContent.toString());
    }

    // given platform is "mac" and browser is "ie"
    // when render banner
    // then it should print "Banner"
    @Test
    public void should_render_banner_if_platform_is_mac_and_browser_is_ie() {
        new BannerRender().renderBanner("mac", "ie");
        assertEquals("Banner", outContent.toString());
    }

    // given platform is "windows" and browser is "ie"
    // when render banner
    // then it should not print "Banner"
    @Test
    public void should_not_render_banner_if_platform_is_windows_and_browser_is_ie() {
        new BannerRender().renderBanner("windows", "ie");
        assertEquals("", outContent.toString());
    }

    // given platform is "mac" and browser is "firefox"
    // when render banner
    // then it should not print "Banner"
    @Test
    public void should_not_render_banner_if_platform_is_mac_and_browser_is_firefox() {
        new BannerRender().renderBanner("mac", "firefox");
        assertEquals("", outContent.toString());
    }

    // given platform is "windows" and browser is "firefox"
    // when render banner
    // then it should not print "Banner"
    @Test
    public void should_not_render_banner_if_platform_is_windows_and_browser_is_firefox() {
        new BannerRender().renderBanner("windows", "firefox");
        assertEquals("", outContent.toString());
    }
}