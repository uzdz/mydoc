package com.eliteams.mydoc.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

/**
 * 功能：支付宝MD5签名处理核心文件，不需要修改 版本：3.3 修改日期：2012-08-17 说明：
 * 以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。 该代码仅供学习和研究支付宝接口使用，只是提供一个
 */

public class MD5 {

    /**
     * 签名字符串
     *
     * @param origin        需要签名的字符串
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static String sign(String origin, String input_charset) {
        return DigestUtils.md5Hex(getContentBytes(origin, input_charset));
    }

    public static String sign(String origin) {
        return DigestUtils.md5Hex(getContentBytes(origin, "UTF-8"));
    }

    public static String sign16(String origin) {
        String md32 = DigestUtils.md5Hex(getContentBytes(origin, "UTF-8"));
        return md32.substring(8, 25).toUpperCase();
    }

    /**
     * 签名字符串
     *
     * @param origin        需要签名的字符串
     * @param sign          签名结果
     * @param input_charset 编码格式
     * @return 签名结果
     */
    public static boolean verify(String origin, String sign, String input_charset) {
        String mysign = DigestUtils.md5Hex(getContentBytes(origin, input_charset));
        if (mysign.equals(sign)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    public static void main(String[] args) {
        System.out.print(sign("shanghu"));
    }
}

