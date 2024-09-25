package com.example.filmonerisitem.model;

// BannerMovies sınıfı, bir banner filmi öğesini temsil eder.

public class BannerMovies {

    // Banner filmi öğesinin kimlik numarası
    Integer id;

    // Banner filmi öğesinin adı
    String movieName;

    // Banner filmi öğesinin resim URL'si
    String imageUrl;

    // Banner filmi öğesinin video veya dosya URL'si
    String fileUrl;

    // BannerMovies sınıfının yapıcı metodu
    public BannerMovies(Integer id, String movieName, String imageUrl, String fileUrl  ) {
        // Yapıcı metot, özelliklere başlangıç değerleri atar
        this.id = id;
        this.movieName = movieName;
        this.imageUrl = imageUrl;
        this.fileUrl = fileUrl;
    }

    // id özelliğine erişim sağlayan get metodu
    public Integer getId() {
        return id;
    }

    // id özelliğine değer atayan set metodu
    public void setId(Integer id) {
        this.id = id;
    }

    // movieName özelliğine erişim sağlayan get metodu
    public String getMovieName() {
        return movieName;
    }

    // movieName özelliğine değer atayan set metodu
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    // imageUrl özelliğine erişim sağlayan get metodu
    public String getImageUrl() {
        return imageUrl;
    }

    // imageUrl özelliğine değer atayan set metodu
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // fileUrl özelliğine erişim sağlayan get metodu
    public String getFileUrl() {
        return fileUrl;
    }

    // fileUrl özelliğine değer atayan set metodu
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
