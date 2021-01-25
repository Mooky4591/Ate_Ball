package com.example.ate_ball;


import java.util.List;

public class parseJson {

    /**
     * results : [{"name":"Subway","photos":[{"height":616,"photo_reference":"ATtYBwKInH4FpIVhGQI5rgbr0iZeHjbk7YLf6uYMMq2c1NeKrH14cRheJT2MyJiN8aYtO-KbAbSxajJtsGEG60ZkBzIjkUeG_BWGaMtAj5en2zljDrplarcdwtqpJI4UMwk7VW-j0ZYRL7KXAlFnEXK1IbJYNHWBv4omTRyJfQ5jqmBNixLe","width":989}],"price_level":1,"rating":3.7,"vicinity":"2886 E 3rd Street Room Vc01, Bloomington"}]
     * status : OK
     */

    private String status;
    /**
     * name : Subway
     * photos : [{"height":616,"photo_reference":"ATtYBwKInH4FpIVhGQI5rgbr0iZeHjbk7YLf6uYMMq2c1NeKrH14cRheJT2MyJiN8aYtO-KbAbSxajJtsGEG60ZkBzIjkUeG_BWGaMtAj5en2zljDrplarcdwtqpJI4UMwk7VW-j0ZYRL7KXAlFnEXK1IbJYNHWBv4omTRyJfQ5jqmBNixLe","width":989}]
     * price_level : 1
     * rating : 3.7
     * vicinity : 2886 E 3rd Street Room Vc01, Bloomington
     */

    private List<ResultsBean> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String name;
        private int price_level;
        private double rating;
        private String vicinity;
        /**
         * height : 616
         * photo_reference : ATtYBwKInH4FpIVhGQI5rgbr0iZeHjbk7YLf6uYMMq2c1NeKrH14cRheJT2MyJiN8aYtO-KbAbSxajJtsGEG60ZkBzIjkUeG_BWGaMtAj5en2zljDrplarcdwtqpJI4UMwk7VW-j0ZYRL7KXAlFnEXK1IbJYNHWBv4omTRyJfQ5jqmBNixLe
         * width : 989
         */

        private List<PhotosBean> photos;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice_level() {
            return price_level;
        }

        public void setPrice_level(int price_level) {
            this.price_level = price_level;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public String getVicinity() {
            return vicinity;
        }

        public void setVicinity(String vicinity) {
            this.vicinity = vicinity;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public static class PhotosBean {
            private int height;
            private String photo_reference;
            private int width;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public String getPhoto_reference() {
                return photo_reference;
            }

            public void setPhoto_reference(String photo_reference) {
                this.photo_reference = photo_reference;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }
        }
    }
}




