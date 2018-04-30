package com.henmory.test.glidetest.bean;

import java.util.List;

/**
 * author: henmory
 * time:  4/16/18
 * function:
 * description:
 */
public class BookBean {


    private int count;
    private int start;
    private int total;
    private List<Book> books;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static class Book {

        private String pubdate;
        private String origin_title;
        private String pages;
        private ImagesBean images;
        private String publisher;
        private String title;
        private String url;
        private String author_intro;
        private String summary;
        private String price;
        private List<String> author;



        public String getPubdate() {
            return pubdate;
        }

        public void setPubdate(String pubdate) {
            this.pubdate = pubdate;
        }

        public String getOrigin_title() {
            return origin_title;
        }

        public void setOrigin_title(String origin_title) {
            this.origin_title = origin_title;
        }




        public String getPages() {
            return pages;
        }

        public void setPages(String pages) {
            this.pages = pages;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }


        public String getPublisher() {
            return publisher;
        }

        public void setPublisher(String publisher) {
            this.publisher = publisher;
        }


        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


        public String getAuthor_intro() {
            return author_intro;
        }

        public void setAuthor_intro(String author_intro) {
            this.author_intro = author_intro;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }



        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public List<String> getAuthor() {
            return author;
        }

        public void setAuthor(List<String> author) {
            this.author = author;
        }


        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/subject/s/public/s1727290.jpg
             * large : https://img3.doubanio.com/lpic/s1727290.jpg
             * medium : https://img3.doubanio.com/view/subject/m/public/s1727290.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            @Override
            public String toString() {
                return "ImagesBean{" +
                        "small='" + small + '\'' +
                        ", large='" + large + '\'' +
                        ", medium='" + medium + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Book{" +
                    "pubdate='" + pubdate + '\'' +
                    ", origin_title='" + origin_title + '\'' +
                    ", pages='" + pages + '\'' +
                    ", images=" + images +
                    ", publisher='" + publisher + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", author_intro='" + author_intro + '\'' +
                    ", summary='" + summary + '\'' +
                    ", price='" + price + '\'' +
                    ", author=" + author +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
