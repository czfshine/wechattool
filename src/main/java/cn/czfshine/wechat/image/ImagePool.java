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

    ///优先级如下

    //SvrId->Image
    private Map<String,Image> Svridpool=new HashMap<>();
    //ThumbnailImageName ->Image
    private Map<String,Image> Thumbpool=new HashMap<>();
    //BigImgName->Image
    private Map<String,Image> Bigpool=new HashMap<>();
    //md5->Image
    private Map<String,Image> pool=new HashMap<>();


    //图片数据目录//todo
    private String[] imagerootpath={"/home/czfshine/workplace/wechat/data/image"
            //, "/media/czfshine/9C746533746510F6/wc/data/image"
    };

    //缺失的文件
    private Set<String> losefile=new HashSet<>();
    //缺失的预览图
    private Set<String> losethumbnailfile=new HashSet<>();

    Logger logger=LoggerFactory.getLogger("impool");


    /**
     * 在数据目录下搜索相应的图片，并将图片加入图片池里
     * @param obj 可以是BigImage 或者md5的字符串
     */

    public void addImage(String svrid, Image image){
        if(Svridpool.containsKey(svrid)){
            return;
        }
        if(Bigpool.containsKey(image.getBigImgName())){
            return;
        }
        if(Thumbpool.containsKey(image.getThumbImgName())){
            return;
        }

        //1.找大图
        if(image.getBigImgName()!=null){
            try {

                String path=findImageFiles(image.getBigImgName());
                if(path!=null){
                    image.setBigImgPath(path);
                    Bigpool.put(image.getBigImgName(),image);
                    Svridpool.put(svrid,image);

                }else{
                    losefile.add(image.getBigImgName());
                }
            } catch (ImageFileLoseException e) {
                losefile.add(image.getBigImgName());
            }
        }

        //2.找预览图
        if(image.getThumbImgName()!=null){
            try {

                String path=findImageFiles(image.getThumbImgName());
                if(path!=null){
                    image.setThumbImgPath(path);
                    Thumbpool.put(image.getThumbImgName(),image);
                    if(!Svridpool.containsKey(svrid))Svridpool.put(svrid,image);
                }else{
                    losethumbnailfile.add(image.getBigImgName());
                }
            } catch (ImageFileLoseException e) {
                losethumbnailfile.add(image.getBigImgName());
            }
        }
    }


    /**
     * @param md5 图片的md5码
     * @return 实际路径
     * @throws ImageFileLoseException 图片丢失
     */
    private String findImageFiles(String md5) throws ImageFileLoseException {
        String path;

        if(md5.startsWith("THUMBNAIL_DIRPATH://")){
            md5=md5.substring(23);
        }

        if((path=checkFile(md5))!=null){
            return path;
        }else{
            //logger.info("can't find {} ",md5);
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


    public Image getThumbnaImageByMd5(String md5){
        return Thumbpool.getOrDefault("th_"+md5,null);
    }
    public int getBigImgCount(){
        return Bigpool.size();
    }
    public int getThumbImgCount(){
        return Thumbpool.size();
    }

    public Image getImageBySrvId(String id){
        return Svridpool.getOrDefault(id,null);
    }
    public Image getImageBySrvId(long id){
        return getImageBySrvId(((Long)id).toString());
    }

    public Image getImageByThumbPath(String path){
        return Thumbpool.getOrDefault(path,null);
    }
}
