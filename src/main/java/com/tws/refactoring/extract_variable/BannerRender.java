package com.tws.refactoring.extract_variable;

public class BannerRender {
    void renderBanner(String platform, String browser) {
        if (checkStringExist(platform,"MAC")  &&
                checkStringExist(browser,"IE")) {
            // do something
            System.out.print("Banner");
        }
    }
    private boolean checkStringExist(String string, String substring) {
        return (string.toUpperCase().indexOf(substring) > -1);
    }
}
