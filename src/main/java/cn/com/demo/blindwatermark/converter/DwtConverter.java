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

package cn.com.demo.blindwatermark.converter;

import org.opencv.core.Mat;

//TODO
public class DwtConverter implements Converter {
    @Override
    public Mat start(Mat src) {
        return null;
    }

    @Override
    public void inverse(Mat com) {

    }

    @Override
    public void addTextWatermark(Mat com, String watermark) {

    }

    @Override
    public void addImageWatermark(Mat com, Mat watermark) {

    }

    @Override
    public Mat showWatermark(Mat src) {
        return null;
    }
}
