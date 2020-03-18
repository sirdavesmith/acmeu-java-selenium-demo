package utils;

import pages.PageAbstract;

public class Log {
    public static void pageLoaded (PageAbstract page){
        System.out.println(page.getPageName() + " loaded using this url: " + page.getURL());
    }

    public static void logMessage(String message){
        System.out.println(message);
    }
}
