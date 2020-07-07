package br.com.cca.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * User: Leandro Antonelli
 * Date: 19/06/20
 */
@ConfigurationProperties(prefix = "ccaconfig")
public class ConfigurationForCcaConfig {

    public Security getSecurity() {
        return security;
    }

    private final Security security = new Security();

    public static class Security {
        private boolean enableHttps;
        private String[] allowOrigin;
        private boolean enableAnyOrigin;

        public void setEnableHttps(boolean enableHttps) {
            this.enableHttps = enableHttps;
        }

        public void setAllowOrigin(String[] allowOrigin) {
            this.allowOrigin = allowOrigin;
        }

        public void setEnableAnyOrigin(boolean enableAnyOrigin) {
            this.enableAnyOrigin = enableAnyOrigin;
        }

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public String[] getAllowOrigin() {
            return allowOrigin;
        }

        public boolean isEnableAnyOrigin() {
            return enableAnyOrigin;
        }
    }
}
