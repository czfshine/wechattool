package cn.czfshine.wechat.emoji;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.security.*;

/**
 * 一些小脚本,解密微信的表情文件
 * 只能解决一部分
 */
public class DecryptTools {


    /**
     * 恢复png文件头
     * 微信把某些png的文件头改了,
     * 本来是89 50 4E 47 0D 0A 1A 0A
     * 文件是89 50 4E 47 0A 1A 0A
     * 补个0d就行.
     *
     * 适用于:
     * emoji文件夹下的各个
     *  ` com.tencent.xin.emoticon.person.stiker_xxxx` 文件夹下的
     *      `[某个md5]_cover`文件
     *
     *  解密后当然是静态的png图,对应的gif还没找到办法,不过至少能看到表情长什么样
     * @param infile
     * @param outfile
     * @throws IOException
     */
    public static void resumePngFile(String infile,String outfile) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(infile)));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(outfile)));
        byte [] head=new byte[4];

        bufferedInputStream.read(head,0,4);
        bufferedOutputStream.write(head);
        bufferedOutputStream.write(0x0d);
        bufferedOutputStream.write(bufferedInputStream.readAllBytes());
    }

    public static Key getKey(String keySeed) {
        if (keySeed == null) {
            keySeed = System.getenv("AES_SYS_KEY");
        }
        if (keySeed == null) {
            keySeed = System.getProperty("AES_SYS_KEY");
        }
        if (keySeed == null || keySeed.trim().length() == 0) {
            keySeed = "abcd1234!@#$";// 默认种子
        }
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(keySeed.getBytes());
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(secureRandom);
            return generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte getnum(byte b){
        if((b>='a') && (b<='z')){
            return (byte) ((byte) (b-'a')+10);
        }else if(b>='0' && b<='9'){
            return (byte) (b-'0');
        }else{
            return 0;
        }
    }
    private static byte[] get(String str){
        byte[] bytes = str.getBytes();
        int len=bytes.length;
        byte[] bytes1 =new byte[len/2];

        for(int i=0;i<len/2;i++){
            byte f = (byte) (getnum(bytes[i*2]));
            byte s = (byte) (getnum(bytes[i*2+1]));
            bytes1[i]= (byte) (f*16+s);
        }
        return bytes1;
    }
    public static final String decrypt(String filename,byte xor) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, InvalidAlgorithmParameterException {

        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        byte[] bytes = fileInputStream.readAllBytes();

        byte[] inb =new byte[0x400];
        for(int i=0;i<inb.length;i++){
            inb[i]= bytes[i];
        }
        Security.addProvider(new BouncyCastleProvider());

        byte[] keyBytes = get("3a1f12ef91839f1e3745d4368dae3de2");
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        byte[] encoded = keySpec.getEncoded();

        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding","BC");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(encoded));
        byte[] result = cipher.doFinal(inb);
        for(int i=0;i<result.length;i++){
            result[i]= (byte) (result[i] ^ xor);
        }
        String plainText = new String(result);
        System.out.println(xor+"==========");
        System.out.println(plainText.substring(0x300,0xff));

        FileOutputStream outputStream=new FileOutputStream(new File("./"+xor+"abc"));
        outputStream.write(result);
        for(int i=0x400;i<bytes.length;i++){
            outputStream.write(bytes[i]);
        }
        outputStream.close();
        return plainText;
    }

    private static void xor1(String filename,byte xor) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filename));
        byte[] bytes = fileInputStream.readAllBytes();

        byte[] inb =new byte[0x400];
        for(int i=0;i<inb.length;i++){
            inb[i]= (byte) (bytes[i]^xor);
        }

        String plainText = new String(inb);
        System.out.println(xor+"==========");
        System.out.println(plainText.substring(0,100));


    }
    public static void main(String[] args) throws IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException, InvalidAlgorithmParameterException {
        //decrypt("/home/czfshine/workplace/wechat/emoji/ase/be84756566d7d91c67380e6a9e208a55", (byte) 0);
        for(char b=0;b<=255;b++){
            xor1("/home/czfshine/workplace/wechat/emoji/705d52f59a1b72b37e65ce3e0eb0463c", (byte) b);
        }
        //DecryptTools.resumePngFile("/home/czfshine/workplace/wechat/emoji/ase/be84756566d7d91c67380e6a9e208a55_cover",
        //        "/home/czfshine/workplace/wechat/emoji/ase/be84756566d7d91c67380e6a9e208a55_cover.png");
    }
}
