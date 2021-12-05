package cn.com.demo.blindwatermark;

import java.io.IOException;
import java.util.Arrays;

import org.bytedeco.javacpp.Loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.bytedeco.opencv.opencv_java;
/**
 * @author Aaron
 */
@SpringBootApplication
public class BlindWatermarkApplication {

  private static Logger logger = LoggerFactory.getLogger(BlindWatermarkApplication.class);


  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(BlindWatermarkApplication.class, args);
    Loader.load(opencv_java.class);
  }

//  public static void loadOpenCvTest() {
//    opencv_core.Mat mat = Mat.eye(3, 3, CvType.CV_8UC1).asMat();
//    byte[] bts = new byte[mat.channels() * mat.cols() * mat.rows()];
//    mat.data().get(bts);
//    logger.info("====== opencv load success : " + Arrays.toString(bts));
//  }
}
