package com.share.auth.config;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.rsa.crypto.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * @author xq-cloud
 * @version 1.0.0
 * @description:
 * @date 2026/3/7 16:11
 */
@Configuration
@EnableConfigurationProperties(KeyProperties.class)
public class AuthConfig {

    /**
     * 秘钥配置
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "encrypt")
    public KeyProperties keyProperties(){
        return new KeyProperties();
    }

    /**
     * 秘钥对
     * @param keyProperties
     * @return
     */
    @Bean
    public KeyPair keyPair(KeyProperties keyProperties){
        // 获取秘钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(
                        keyProperties.getKeyStore().getLocation(),
                        keyProperties.getKeyStore().getPassword().toCharArray());
        //读取钥匙对
        return keyStoreKeyFactory.getKeyPair(
                keyProperties.getKeyStore().getAlias(),
                keyProperties.getKeyStore().getSecret().toCharArray());
    }

    /**
     * 设置cookie处理器
     * @return
     */
    @Bean
    public TomcatContextCustomizer cookieTomcatContextCustomizer(){
        return context -> context.setCookieProcessor(new LegacyCookieProcessor());
    }
}
