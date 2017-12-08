package kz.apps.projectapp;

import com.zomato.photofilters.geometry.Point;
import com.zomato.photofilters.imageprocessors.Filter;
import com.zomato.photofilters.imageprocessors.subfilters.BrightnessSubfilter;
import com.zomato.photofilters.imageprocessors.subfilters.ContrastSubfilter;
import com.zomato.photofilters.imageprocessors.subfilters.ToneCurveSubfilter;

/**
 * Created by t-zhanar-a on 08.12.17.
 */

public final class CustomFilters {

    private CustomFilters() {
    }

    public static Filter getFirstFilter() {
        Point[] rgbKnots;
        rgbKnots = new Point[3];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(127, 127);
        rgbKnots[2] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, null, null, null));
        filter.addSubFilter(new BrightnessSubfilter(57));
        filter.addSubFilter(new ContrastSubfilter(3f));
        return filter;
    }

    public static Filter getSecondFilter() {
        Point[] rgbKnots;
        Point[] greenKnots;
        Point[] blueKnots;

        rgbKnots = new Point[3];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(255, 255);

        greenKnots = new Point[5];
        greenKnots[0] = new Point(0, 0);
        greenKnots[1] = new Point(67, 67);
        greenKnots[2] = new Point(103, 130);
        greenKnots[3] = new Point(167, 192);
        greenKnots[4] = new Point(255, 255);


        blueKnots = new Point[2];
        blueKnots[0] = new Point(0, 0);
        blueKnots[1] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, null, greenKnots, blueKnots));
        filter.addSubFilter(new BrightnessSubfilter(12));
        return filter;
    }

    public static Filter getThirdFilter() {
        Point[] rgbKnots;
        Point[] redKnots;

        rgbKnots = new Point[5];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(149, 102);
        rgbKnots[3] = new Point(201, 173);
        rgbKnots[4] = new Point(255, 255);

        redKnots = new Point[5];
        redKnots[0] = new Point(0, 0);
        redKnots[1] = new Point(100, 100);
        redKnots[2] = new Point(130, 130);
        redKnots[3] = new Point(160, 160);
        redKnots[4] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, redKnots, null, null));
        filter.addSubFilter(new ContrastSubfilter(10f));
        return filter;
    }

    public static Filter getFifthFilter() {

        Filter filter = new Filter();
        filter.addSubFilter(new ContrastSubfilter(8f));
        filter.addSubFilter(new BrightnessSubfilter(70));
        return filter;
    }

    public static Filter getSixthFilter() {
        Point[] rgbKnots;
        Point[] greenKnots;

        rgbKnots = new Point[5];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(149, 102);
        rgbKnots[3] = new Point(201, 173);
        rgbKnots[4] = new Point(255, 255);

        greenKnots = new Point[6];
        greenKnots[0] = new Point(0, 0);
        greenKnots[1] = new Point(57, 76);
        greenKnots[2] = new Point(103, 130);
        greenKnots[3] = new Point(167, 192);
        greenKnots[4] = new Point(211, 229);
        greenKnots[5] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, null, greenKnots, null));
        filter.addSubFilter(new BrightnessSubfilter(10));
        return filter;
    }

    public static Filter getSeventhFilter() {
        Point[] rgbKnots;
        Point[] redKnots;
        Point[] greenKnots;
        Point[] blueKnots;

        rgbKnots = new Point[5];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(149, 102);
        rgbKnots[3] = new Point(201, 173);
        rgbKnots[4] = new Point(255, 255);

        redKnots = new Point[5];
        redKnots[0] = new Point(0, 0);
        redKnots[1] = new Point(125, 147);
        redKnots[2] = new Point(177, 199);
        redKnots[3] = new Point(213, 228);
        redKnots[4] = new Point(255, 255);


        greenKnots = new Point[6];
        greenKnots[0] = new Point(0, 0);
        greenKnots[1] = new Point(57, 76);
        greenKnots[2] = new Point(103, 130);
        greenKnots[3] = new Point(167, 192);
        greenKnots[4] = new Point(211, 229);
        greenKnots[5] = new Point(255, 255);


        blueKnots = new Point[7];
        blueKnots[0] = new Point(0, 0);
        blueKnots[1] = new Point(38, 62);
        blueKnots[2] = new Point(75, 112);
        blueKnots[3] = new Point(116, 158);
        blueKnots[4] = new Point(171, 204);
        blueKnots[5] = new Point(212, 233);
        blueKnots[6] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, redKnots, greenKnots, blueKnots));
        filter.addSubFilter(new BrightnessSubfilter(15));
        filter.addSubFilter(new ContrastSubfilter(13f));
        return filter;
    }

    public static Filter getEigthFilter() {
        Point[] rgbKnots;
        Point[] redKnots;
        Point[] greenKnots;

        rgbKnots = new Point[10];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(100, 102);
        rgbKnots[3] = new Point(120, 120);
        rgbKnots[4] = new Point(140, 140);
        rgbKnots[5] = new Point(160, 160);
        rgbKnots[6] = new Point(170, 173);
        rgbKnots[7] = new Point(180, 183);
        rgbKnots[8] = new Point(220, 223);
        rgbKnots[9] = new Point(255, 255);

        redKnots = new Point[5];
        redKnots[0] = new Point(0, 0);
        redKnots[1] = new Point(125, 147);
        redKnots[2] = new Point(177, 199);
        redKnots[3] = new Point(213, 228);
        redKnots[4] = new Point(255, 255);


        greenKnots = new Point[6];
        greenKnots[0] = new Point(0, 0);
        greenKnots[1] = new Point(57, 76);
        greenKnots[2] = new Point(103, 130);
        greenKnots[3] = new Point(167, 192);
        greenKnots[4] = new Point(211, 229);
        greenKnots[5] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, redKnots, greenKnots, null));
        filter.addSubFilter(new BrightnessSubfilter(7));
        return filter;
    }

    public static Filter getNinethFilter() {
        Point[] rgbKnots;

        rgbKnots = new Point[10];
        rgbKnots[0] = new Point(0, 0);
        rgbKnots[1] = new Point(80, 43);
        rgbKnots[2] = new Point(100, 102);
        rgbKnots[3] = new Point(120, 120);
        rgbKnots[4] = new Point(140, 140);
        rgbKnots[5] = new Point(160, 160);
        rgbKnots[6] = new Point(170, 173);
        rgbKnots[7] = new Point(180, 183);
        rgbKnots[8] = new Point(220, 223);
        rgbKnots[9] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(rgbKnots, null, null, null));
        return filter;
    }

    public static Filter getTenthFilter() {
        Point[] blueKnots;

        blueKnots = new Point[2];
        blueKnots[0] = new Point(0, 0);
        blueKnots[1] = new Point(255, 255);

        Filter filter = new Filter();
        filter.addSubFilter(new ToneCurveSubfilter(null, null, null, blueKnots));
        filter.addSubFilter(new BrightnessSubfilter(17));
        filter.addSubFilter(new ContrastSubfilter(13f));
        return filter;
    }
}
