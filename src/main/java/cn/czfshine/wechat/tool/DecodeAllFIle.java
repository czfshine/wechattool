package cn.czfshine.wechat.tool;

import cn.czfshine.wechat.audio.decoder.SlikDecoder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DecodeAllFIle {

    static SlikDecoder slikDecoder = new SlikDecoder("./wechat-dump/third-party/silk/decoder", "/usr/bin/ffmpeg");

    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get("../wechat/data/voice/"))
                .filter(Files::isRegularFile)
                .filter(DecodeAllFIle::filterAMRfile)
                .forEach(DecodeAllFIle::decode);
    }
    static int a=0;
    private static void decode(Path path) {
        a++;
        System.out.println(a);
        String fileName = path.getFileName().toString();
        String outfilename=path.getParent().toAbsolutePath().toString()
                +File.separator+
                fileName.substring(0,fileName.length()-4)+".mp3";
        String infile= path.toAbsolutePath().toString();
        slikDecoder.decode(infile,outfilename);

    }

    private static boolean filterAMRfile(Path path) {
       return  path.toString().endsWith(".amr");
    }
}
