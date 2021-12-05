/*
 * Copyright (c) 2020 ww23(https://github.com/ww23/BlindWatermark).
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.demo.blindwatermark.dencoder;

import cn.com.demo.blindwatermark.converter.Converter;
import cn.com.demo.blindwatermark.util.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Rect;

import java.util.ArrayList;
import java.util.List;

import static org.opencv.core.Core.merge;
import static org.opencv.core.Core.split;
import static org.opencv.core.CvType.*;
import static org.opencv.imgcodecs.Imgcodecs.*;

/**
 * @author ww23
 */
public abstract class Encoder {

    Converter converter;

    Encoder(Converter converter) {
        this.converter = converter;
    }

    public Converter getConverter() {
        return converter;
    }

    public void setConverter(Converter converter) {
        this.converter = converter;
    }

    public void encode(String image, String watermark, String output) {
        Mat src = Utils.read(image,IMREAD_UNCHANGED);

        List<Mat> channel = new ArrayList<>(4);
        List<Mat> newChannel = new ArrayList<>(4);
        split(src, channel);

        for (int i = 0; i < 4; i++) {
            Mat com = this.converter.start(channel.get(i)).clone();
            this.addWatermark(com, watermark);
            this.converter.inverse(com);

            newChannel.add(i, com);
        }

        Mat res = new Mat();
        merge(newChannel, res);

        if (res.rows() != src.rows() || res.cols() != src.cols()) {
            res = new Mat(res, new Rect(0, 0, src.width(), src.height()));
        }


        imwrite(output, res);
    }

    public abstract void addWatermark(Mat com, String watermark);
}
