package cn.czfshine.wechat.image;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.Serializable;
import java.util.*;

/**
 * 图片池，包括所有聊天记录的图片
 * @author:czfshine
 * @date:2018/2/22 21:38
 */

public class ImagePool  implements Serializable {

    private static final long serialVersionUID = -6992428681849691079L;
    private static ImagePool thepool;
    static {
        thepool=new ImagePool();
    }
    public static void loadPool(ImagePool pool){
        thepool=pool;
    }

    public static ImagePool getThepool(){
        return thepool;
    }
    private Map<String,Image> pool=new HashMap<>();

    private Map<Long,Image> bigimagepool=new HashMap<>();

    private String[] imagerootpath={"data/image"};

    private Set<String> losefile=new HashSet<>();

    private Set<String> losethumbnailfile=new HashSet<>();

    Logger logger=LoggerFactory.getLogger("impool");


    /**
     * 在数据目录下搜索相应的图片，并将图片加入图片池里
     * @param obj 可以是BigImage 或者md5的字符串
     */
    public void add(Object obj){

        if(obj instanceof BigImage){
            BigImage bigimage =(BigImage) obj;
            if(pool.containsKey(bigimage.getFilename())) {
                return;
            }
            try {

                findImageFiles(bigimage);
                bigimagepool.put(bigimage.getMsgid(),bigimage);
            } catch (BigImageFileLoseException e) {


                if(! losefile.contains(e.getFilename())){
                    //logger.warn("图片{}文件丢失",e.getFilename());
                }
                losefile.add(e.getFilename());

            }

        }else if (obj instanceof String){
            String md5=(String) obj;

            try {
                String imageFile = findImageFiles(md5);
                pool.put("th_"+md5,new Image(md5,imageFile));
            } catch (ImageFileLoseException e) {

                if(!losethumbnailfile.contains(e.getMd5())){
                    //logger.warn("图片{}文件丢失",e.getMd5());
                }
                losethumbnailfile.add(e.getMd5());


            }

        }
    }



    private void findImageFiles(BigImage bigImage) throws BigImageFileLoseException {

        String filename=bigImage.getFilename();
        String path;
        if((path=checkFile(filename))!=null){
            bigImage.setPath(path);
            return ;
        }else{
            throw new BigImageFileLoseException(bigImage);
        }


    }


    /**
     * @param md5 图片的md5码
     * @return 实际路径
     * @throws ImageFileLoseException 图片丢失
     */
    private String findImageFiles(String md5) throws ImageFileLoseException {
        String path;
        if((path=checkFile(md5))!=null){
            return path;
        }else{
            throw new ImageFileLoseException(md5);
        }
    }

    /**
     * 检查对应的图片是否在图片目录下
     * @param filename 待找寻的文件名
     * @return 实际路径或null
     */
    private String checkFile(String filename){
        String level1=filename.substring(0,2);
        String level2=filename.substring(2,4);
        for(String path:imagerootpath){
            File root = new File(path);
            File[] files = root.listFiles(File::isDirectory);
            if(files==null){
                continue;
            }
            for(File imageroot :files ){

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

    public  int getThumbnailFileCount(){
        return pool.size();
    }
    public  int getLoseThumbnailFileCount(){
        return losethumbnailfile.size();
    }
    public BigImage getBigImageFromMsgid(long msgid){
        return (BigImage) bigimagepool.getOrDefault(msgid,null);
    }

    public Image getThumbnaImageByMd5(String md5){
        return pool.getOrDefault("th_"+md5,null);
    }
}
