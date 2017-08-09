package com.iris.study.springboot.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件处理工具实现
 * Copyright: Copyright (c) 2017
 * Company:
 * URL: http://blog.csdn.net/zy408710468/article/details/26365045
 *
 * @author: hants
 * @created: 2017/5/23 12:33
 */

public class FileOperateUtil {

    private static final String UPLOADDIR = "/bh/update/";// 上传后放在哪个位置(linux)

    /**
     * 将上传的文件进行重命名
     *
     * @author caohaicheng
     * @date 2014-3-20 上午11:56:35
     * @param name
     * @return
     */
    private static String rename(String name) {

        Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date()));
        Long random = (long) (Math.random() * now);
        String fileName = now + "" + random;

        if (name.indexOf(".") != -1) {
            fileName += name.substring(name.lastIndexOf("."));
        }

        return fileName;
    }

    /**
     * 压缩后的文件名
     *
     * @author caohaicheng
     * @date 2014-3-20 上午11:56:35
     * @param name
     * @return
     */
    private static String zipName(String name) {
        String prefix = "";
        if (name.indexOf(".") != -1) {
            prefix = name.substring(0, name.lastIndexOf("."));
        } else {
            prefix = name;
        }
        return prefix + ".zip";
    }

    /**
     * 上传文件
     *
     * @author caohaicheng
     * @date 2014-3-20 上午11:56:35
     * @param request
     * @param params
     * @param values
     * @return
     * @throws Exception
     */
//    public static FileUploadBean upload(HttpServletRequest request) throws Exception {
//
//        FileUploadBean fup  = new FileUploadBean();
//
//        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
//        Map<String, MultipartFile> fileMap = mRequest.getFileMap();
//
//        //String uploadDir = request.getSession().getServletContext().getRealPath("/")+ FileOperateUtil.UPLOADDIR;   //上传至相对路径
//        String uploadDir =  FileOperateUtil.UPLOADDIR;  //上传至绝对路径
//        String uploadDir1 =  FileOperateUtil.UPLOADDIR1;    //上传至绝对路径,这个是备份文件夹
//
//        File file = new File(uploadDir);
//        File file1 = new File(uploadDir1);
//
//        //如果不存在该路径就创建
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        if (!file1.exists()) {
//            file1.mkdir();
//        }
//
//        delAllFile(uploadDir); //删除完里面所有内容
//
//        String fileName = null;
//        int i = 0;
//        for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()
//                .iterator(); it.hasNext(); i++) {
//
//            Map.Entry<String, MultipartFile> entry = it.next();
//            MultipartFile mFile = entry.getValue();
//
//            fileName = mFile.getOriginalFilename();//获得文件名字
//
//            //String storeName = rename(fileName);//对文件进行重命名
//
//            String noZipName = uploadDir + fileName;//文件路径
//            String noZipName1 = uploadDir1 + fileName;
//
//            File uploadFile = new File(noZipName);
//            File uploadFile1 = new File(noZipName1);
//
//            //String zipName = zipName(noZipName);//获得压缩后的文件名字
//
//            // 上传成为压缩文件
//            /*
//                ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(noZipName)));
//                outputStream.putNextEntry(new ZipEntry(fileName));
//                outputStream.setEncoding("GBK");
//                FileCopyUtils.copy(mFile.getInputStream(), outputStream);
//             */
//            try {
//                FileCopyUtils.copy(mFile.getBytes(), uploadFile);
//            } catch (Exception e) {
//                fup.setReturnDesc("升级文件上传失败");
//                fup.setReturnFlag(false);
//                e.printStackTrace();
//                return fup;
//            }
//
//            try {
//                FileCopyUtils.copy(mFile.getBytes(), uploadFile1);
//            } catch (Exception e) {
//                fup.setReturnDesc("升级文件备份失败");
//                fup.setReturnFlag(false);
//                e.printStackTrace();
//                return fup;
//            }
//            fup.setReturnFlag(true);
//            fup.setFileName(fileName);
//            fup.setFileCreateDate(DateTimeUtil.nowToString());
//            fup.setFileSize( new File(noZipName).length());
//        }
//        return fup;
//    }

    /**
     * 下载
     *
     * @author caohaicheng
     * @date 2014-3-20 上午11:56:35
     * @param request
     * @param response
     * @param storeName
     * @param contentType
     * @param realName
     * @throws Exception
     */
    public static void download(HttpServletRequest request,
                                HttpServletResponse response, String storeName, String contentType,
                                String realName) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        String ctxPath = request.getSession().getServletContext()
                .getRealPath("/")
                + FileOperateUtil.UPLOADDIR;
        String downLoadPath = ctxPath + "download/" + storeName;

        long fileLength = new File(downLoadPath).length();

        response.setContentType(contentType);
        response.setHeader("Content-disposition", "attachment; filename="
                + new String(realName.getBytes("utf-8"), "ISO8859-1"));
        response.setHeader("Content-Length", String.valueOf(fileLength));

        bis = new BufferedInputStream(new FileInputStream(downLoadPath));
        bos = new BufferedOutputStream(response.getOutputStream());
        byte[] buff = new byte[2048];
        int bytesRead;
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            bos.write(buff, 0, bytesRead);
        }
        bis.close();
        bos.close();
    }

    //删除指定文件夹下所有文件
    //param path 文件夹完整绝对路径
    public static boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                flag = true;
            }
        }
        return flag;
    }
}