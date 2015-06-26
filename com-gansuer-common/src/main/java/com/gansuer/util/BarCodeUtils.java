package com.gansuer.util;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Random;

/**
 * Used to generate the 1D/2D bar code
 * Based on zxing
 * github : https://github.com/zxing/zxing
 *
 * Created by Frank on 6/26/15.
 */
public class BarCodeUtils {

    public static BarCodeConfig config = new BarCodeConfig();

    /**
     * make the parameters be configurable
     */
    static class BarCodeConfig{
        protected String CHARSET = "utf-8";
        protected String FORMAT_NAME = "JPG";

        protected int QRCODE_SIZE = 300;
        // logo width
        protected int WIDTH = 60;
        // logo height
        protected int HEIGHT = 60;

        public BarCodeConfig() {
        }

        public BarCodeConfig(String CHARSET, String FORMAT_NAME, int QRCODE_SIZE, int WIDTH, int HEIGHT) {
            this.CHARSET = CHARSET;
            this.FORMAT_NAME = FORMAT_NAME;
            this.QRCODE_SIZE = QRCODE_SIZE;
            if (WIDTH > QRCODE_SIZE || HEIGHT > QRCODE_SIZE){
                throw new IllegalArgumentException("Logo width or height should be less than QRCodeSize !");
            }
            this.WIDTH = WIDTH;
            this.HEIGHT = HEIGHT;
        }
    }
    /**
     *
     * @param content  content indicated by the generated QRCode
     * @param imgPath  Logo image path
     * @param needCompress If true , need to compress the logo file
     * @return
     * @throws Exception
     */
    private static BufferedImage createImage(String content ,String imgPath, boolean needCompress) throws Exception {

        Hashtable<EncodeHintType , Object> hints = new Hashtable<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET , config.CHARSET);
        hints.put(EncodeHintType.MARGIN , 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE,config.QRCODE_SIZE,config.QRCODE_SIZE,hints);

        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width ; x++){
            for (int y = 0; y < height ; y++){
                image.setRGB(x,y,bitMatrix.get(x, y) ? 0XFF000000 : 0xFFFFFFFF);
            }
        }

        if (imgPath == null || imgPath.equals("")){
            return image;
        }

        // insert image
        BarCodeUtils.insertImage(image, imgPath, needCompress);
        return image;

    }

    /**
     * insert Logo
     *
     * @param source  QRImage
     * @param imgPath Logo image path
     * @param needCompress If true , Need to Compress the logo file
     */
    private static void insertImage(BufferedImage source, String imgPath, boolean needCompress) throws Exception{
        File file = new File(imgPath);
        if (!file.exists()){
            System.err.println(" '" + imgPath + "' : the logo file doesn't exist !");
            return;
        }

        Image src = ImageIO.read(file);
        int width = src.getWidth(null);
        int height = src.getHeight(null);

        // Need to compress this logo file ?
        if (needCompress) {
            if (width > config.WIDTH){
                width = config.WIDTH;
            }
            if (height > config.HEIGHT){
                height = config.HEIGHT ;
            }
            Image image = src.getScaledInstance(width,height,Image.SCALE_SMOOTH);

            BufferedImage tag = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

            Graphics graphics = tag.getGraphics();
            graphics.drawImage(image, 0 , 0 , null); // create the compressed image
            graphics.dispose();
            src = image;
        }
        //insert this logo
        Graphics2D graphics2D = source.createGraphics();
        int x = (config.QRCODE_SIZE - width) / 2;
        int y = (config.QRCODE_SIZE - height) / 2;
        graphics2D.drawImage(src, x, y, width, height, null);

        Shape shape = new RoundRectangle2D.Float(x,y,width,width, 6,6);
        graphics2D.setStroke(new BasicStroke(3f));
        graphics2D.draw(shape);
        graphics2D.dispose();

    }

    /**
     * Generate the QRCode embedded logo
     * @param content qrcode content
     * @param name  the image file's name
     * @param imgPath Logo file path
     * @param destPath the directory path used to place the QRCode file
     * @param needCompress If true , Need to Compress the logo file
     * @throws Exception
     */
    public static void encode(String content,String name, String imgPath , String destPath, boolean needCompress) throws Exception{

        BufferedImage image = BarCodeUtils.createImage(content,imgPath,needCompress);
        mkdir(destPath);
        name = StringUtils.isNotEmpty(name) ? name : String.valueOf(new Random().nextInt(999999999));
        String file = name +"." + config.FORMAT_NAME;
        ImageIO.write(image,config.FORMAT_NAME,new File(destPath + File.separator + file));
    }

    private static void mkdir(String path){
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()){
            file.mkdirs();
        }
    }
    /**
     * Generate the QRCode embedded logo
     * @param content qrcode content
     * @param imgPath Logo file path
     * @param destPath the directory path used to place the QRCode file
     * @throws Exception
     */
    public static void encode(String content, String imgPath, String destPath) throws Exception{
        BarCodeUtils.encode(content,null,imgPath,destPath,true);
    }
    /**
     * Generate the QRCode embedded logo
     * @param content qrcode content
     * @param name file name
     * @param imgPath Logo file path
     * @param destPath the directory path used to place the QRCode file
     * @throws Exception
     */
    public static void encode(String content, String name, String imgPath, String destPath) throws Exception{
        BarCodeUtils.encode(content,name,imgPath,destPath,true);
    }

    /**
     * Generate the QRCode
     * @param content qrcode content
     * @param destPath the directory path used to place the QRCode file
     * @throws Exception
     */
    public static void encodeNotLogo(String content, String destPath) throws Exception{
        BarCodeUtils.encode(content, null, null ,destPath , true);
    }

    /**
     * Generate the QRCode
     * @param content qrcode content
     * @param name file name
     * @param destPath the directory path used to place the QRCode file
     * @throws Exception
     */
    public static void encodeNotLogo(String content, String name, String destPath) throws Exception{
        BarCodeUtils.encode(content, name, null ,destPath , true);
    }

    /**
     * Generate QRCode embedded logo , then write it into the outputStream
     * @param content qrcode content
     * @param imgPath  Logo file path
     * @param output output Stream
     * @param needCompress  If true , Need to Compress the logo file
     * @throws Exception
     */
    public static void encode(String content, String imgPath, OutputStream output, boolean needCompress) throws Exception{
        BufferedImage image = BarCodeUtils.createImage(content, imgPath, needCompress);
        ImageIO.write(image,config.FORMAT_NAME,output);
    }


    /**
     * Generate QRCode
     * @param content qrcode content
     * @param output output Stream
     * @throws Exception
     */
    public static void encode(String content, OutputStream output) throws Exception {
        BarCodeUtils.encode(content,null,output,true);
    }

    public static String decode(File file) throws Exception{
        BufferedImage image = null;
        image = ImageIO.read(file);
        if (image == null){
            return null;
        }

        BufferedImageSource source = new BufferedImageSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, config.CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    public static String decode(String filePath) throws Exception{
        File file = new File(filePath);
        if (!file.exists()){
            throw new IllegalArgumentException("the specified file does not exist !");
        }
        BufferedImage image = null;
        image = ImageIO.read(file);
        if (image == null){
            return null;
        }

        BufferedImageSource source = new BufferedImageSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, config.CHARSET);
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }

    private static class BufferedImageSource extends LuminanceSource{

        private final BufferedImage image;
        private final int left;
        private final int top;

        public BufferedImageSource(BufferedImage image) {
            this(image, 0, 0, image.getWidth(), image.getHeight());
        }

        public BufferedImageSource(BufferedImage image, int left, int top, int width , int height){
            super(width,height);

            int sourceWidth = image.getWidth();
            int sourceHeight = image.getHeight();

            if (left + width > sourceHeight || top + height > sourceHeight) {
                throw new IllegalArgumentException("Crop rectangle does not fit within image data .");
            }

            for (int y = top ; y < top + height ; y++){
                for (int x =left ; x < left + width; x++){
                    if ((image.getRGB(x,y) & 0xFF000000) == 0){
                        image.setRGB(x,y,0xFFFFFFFF);  // = white
                    }
                }
            }

            this.image = new BufferedImage(sourceWidth, sourceHeight, BufferedImage.TYPE_BYTE_GRAY);
            this.image.getGraphics().drawImage(image,0,0,null);
            this.left = left;
            this.top = top;

        }
        /**
         * Fetches one row of luminance data from the underlying platform's bitmap. Values range from
         * 0 (black) to 255 (white). Because Java does not have an unsigned byte type, callers will have
         * to bitwise and with 0xff for each value. It is preferable for implementations of this method
         * to only fetch this row rather than the whole image, since no 2D Readers may be installed and
         * getMatrix() may never be called.
         *
         * @param y   The row to fetch, which must be in [0,getHeight())
         * @param row An optional preallocated array. If null or too small, it will be ignored.
         *            Always use the returned object, and ignore the .length of the array.
         * @return An array containing the luminance data.
         */
        @Override
        public byte[] getRow(int y, byte[] row) {
            if (y < 0 || y >=getHeight()){
                throw new IllegalArgumentException("Requested row is outside the image :" + y);
            }
            int width = getWidth();
            if (row == null || row.length < width){
                row = new byte[width];
            }
            image.getRaster().getDataElements(left, top+y, width, 1, row);
            return row;
        }

        /**
         * Fetches luminance data for the underlying bitmap. Values should be fetched using:
         * {@code int luminance = array[y * width + x] & 0xff}
         *
         * @return A row-major 2D array of luminance values. Do not use result.length as it may be
         * larger than width * height bytes on some platforms. Do not modify the contents
         * of the result.
         */
        @Override
        public byte[] getMatrix() {
            int width = getWidth();
            int height = getHeight();
            int area = width * height;
            byte[] matrix = new byte[area];
            image.getRaster().getDataElements(left, top, width, height, matrix);
            return matrix;
        }

        /**
         * @return Whether this subclass supports cropping.
         */
        @Override
        public boolean isCropSupported() {
            return true;
        }

        /**
         * Returns a new object with cropped image data. Implementations may keep a reference to the
         * original data rather than a copy. Only callable if isCropSupported() is true.
         *
         * @param left   The left coordinate, which must be in [0,getWidth())
         * @param top    The top coordinate, which must be in [0,getHeight())
         * @param width  The width of the rectangle to crop.
         * @param height The height of the rectangle to crop.
         * @return A cropped version of this object.
         */
        @Override
        public LuminanceSource crop(int left, int top, int width, int height) {
            return new BufferedImageSource(image, this.left+left, this.top+top, width, height);
        }

        /**
         * @return Whether this subclass supports counter-clockwise rotation.
         */
        @Override
        public boolean isRotateSupported() {
            return true;
        }

        /**
         * Returns a new object with rotated image data by 90 degrees counterclockwise.
         * Only callable if {@link #isRotateSupported()} is true.
         *
         * @return A rotated version of this object.
         */
        @Override
        public LuminanceSource rotateCounterClockwise() {
            int sourceWidth = image.getWidth();
            int sourceHeight = image.getHeight();
            AffineTransform transform = new AffineTransform(0.0, -1.0, 1.0, 0.0, 0.0, sourceWidth);
            BufferedImage rotatedImage = new BufferedImage(sourceHeight, sourceWidth, BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D graphics2D = rotatedImage.createGraphics();
            graphics2D.drawImage(image,transform, null);
            graphics2D.dispose();
            int width = getWidth();
            return new BufferedImageSource(rotatedImage, top, sourceWidth - (left + width) , getHeight(), width);
        }
    }
}