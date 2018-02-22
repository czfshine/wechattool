package cn.czfshine.wechat.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * @author:czfshine
 * @date:2018/2/22 21:38
 */

public class ImagePool {

    private static ImagePool thepool;
    static {
        thepool=new ImagePool();
    }
    public static ImagePool getThepool(){
        return thepool;
    }
    private Map<String,Image> pool=new HashMap<>();

    private String[] imagerootpath={"data/image"};

    private Set<String> losefile=new HashSet<>();

    Logger logger=LoggerFactory.getLogger("impool");
    public void add(Object obj){

        if(obj instanceof BigImage){
            BigImage bigimage =(BigImage) obj;
            if(pool.containsKey(bigimage.getFilename())) {
                return;
            }
            try {

                String path=findImageFiles(bigimage);

                pool.put(bigimage.getFilename(), bigimage);
            } catch (BigImageFileLoseException e) {


                if(! losefile.contains(e.getFilename())){
                    logger.warn("图片{}文件丢失",e.getFilename());
                }
                losefile.add(e.getFilename());

            }

        }else if (obj instanceof String){
            String md5=(String) obj;

            try {
                String imageFile = findImageFiles(md5);
                pool.put("th_"+md5,new Image(md5,imageFile));
            } catch (ImageFileLoseException e) {

                if(!losefile.contains(e.getMd5())){
                    logger.warn("图片{}文件丢失",e.getMd5());
                }
                losefile.add(e.getMd5());


            }

        }
    }

    private String findImageFiles(BigImage bigImage) throws BigImageFileLoseException {

        String filename=bigImage.getFilename();
        String path;
        if((path=checkFile(filename))!=null){
            bigImage.setPath(path);
            return path;
        }else{
            throw new BigImageFileLoseException(bigImage);
        }


    }

    private String findImageFiles(String md5) throws ImageFileLoseException {
        String path;
        if((path=checkFile(md5))!=null){
            return path;
        }else{
            throw new ImageFileLoseException(md5);
        }
    }
    private String checkFile(String filename){
        String level1=filename.substring(0,2);
        String level2=filename.substring(2,4);
        for(String path:imagerootpath){
            File root = new File(path);
            for(File imageroot : root.listFiles(File::isDirectory)){

                //todo
                String imagefilepath=imageroot.getPath() + File.separator +
                        level1 + File.separator+
                        level2 + File.separator+
                        filename;
                File imagefile = new File(imagefilepath);
                if(imagefile.exists()){
                    return imagefilepath;
                }

                imagefilepath=imageroot.getPath() + File.separator +
                        level1 + File.separator+
                        level2 + File.separator+
                        "th_"+ filename;
                imagefile = new File(imagefilepath);
                if(imagefile.exists()){
                    return imagefilepath;
                }

                imagefilepath=imageroot.getPath() + File.separator +
                        level1 + File.separator+
                        level2 + File.separator+
                        filename+".jpg";
                imagefile = new File(imagefilepath);
                if(imagefile.exists()){
                    return imagefilepath;
                }


            }

        }
        return null;
    }

    public static  void main(String[] args){
        System.out.println("烦烦烦");
    }
}
