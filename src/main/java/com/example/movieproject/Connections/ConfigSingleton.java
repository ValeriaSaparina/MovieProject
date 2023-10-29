package com.example.movieproject.Connections;

import freemarker.template.Configuration;

import javax.servlet.ServletContext;

public class ConfigSingleton {

    private static Configuration cfg;
    private static ServletContext sc;

    public static void setServletContext(ServletContext servletContext) {
        sc = servletContext;
    }

    public static Configuration getConfig() {
        if (cfg == null) {
            cfg = new Configuration(Configuration.VERSION_2_3_32);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setServletContextForTemplateLoading(sc, "/WEB-INF/templates/");
        }
        return cfg;
    }
}
