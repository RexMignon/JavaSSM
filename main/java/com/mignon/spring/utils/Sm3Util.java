package com.mignon.spring.utils;


import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.Security; // 用于添加 Bouncy Castle 提供者

/**
 * @author WWenHai
 * @desc:
 * @date: 2025-07-10 15:04
 **/
public class Sm3Util {
    static {
        // 注册 Bouncy Castle 安全提供者
        // 这一步确保 JVM 能够识别并使用 Bouncy Castle 提供的加密算法
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        }
    }

    /**
     * 使用 SM3 算法对传入的多个参数拼接后的字符串进行哈希。
     * 参数会按顺序拼接成一个字符串，然后进行哈希。
     *
     * @param args 需要进行哈希的参数，可以是任意类型，会被转换为字符串并拼接。
     * @return 拼接并哈希后的 SM3 字符串（十六进制）。
     */
    public static String hash(Object... args) {
        if (args == null || args.length == 0) {
            return null; // 或者抛出 IllegalArgumentException
        }

        // 1. 拼接所有参数
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                sb.append(arg.toString());
            }
        }
        String combinedString = sb.toString();

        // 2. 进行 SM3 哈希计算
        SM3Digest sm3Digest = new SM3Digest();
        // 将字符串转换为字节数组，通常使用 UTF-8 编码
        byte[] inputBytes = combinedString.getBytes(StandardCharsets.UTF_8);
        sm3Digest.update(inputBytes, 0, inputBytes.length);

        // 3. 获取哈希结果
        byte[] hashBytes = new byte[sm3Digest.getDigestSize()];
        sm3Digest.doFinal(hashBytes, 0);

        // 4. 将字节数组转换为十六进制字符串
        return Hex.toHexString(hashBytes);
    }


}
